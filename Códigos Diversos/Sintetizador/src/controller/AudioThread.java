package controller;

import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;

import controller.utils.Utils;
import view.QuadroPrincipal;

import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALC10.*;

import java.util.function.Supplier;

public class AudioThread extends Thread {

	public static final int TAMANHO_BUFFER = 512;
	public static final int CONTAGEM_BUFFER = 8;

	private final Supplier<short[]> bufferSupplier;
	private final int[] buffers = new int[CONTAGEM_BUFFER];
	private final long dispositivo = alcOpenDevice(alcGetString(0, ALC_DEFAULT_DEVICE_SPECIFIER));
	private final long contexto = alcCreateContext(dispositivo, new int[1]);
	private final int fonte;
	private boolean fechado;
	private boolean rodando;

	private int indiceBuffer;

	public AudioThread(Supplier<short[]> bufferSupplier) {
		this.bufferSupplier = bufferSupplier;
		alcMakeContextCurrent(contexto);
		AL.createCapabilities(ALC.createCapabilities(dispositivo));
		fonte = alGenSources();

		for (int i = 0; i < CONTAGEM_BUFFER; i++) {
			bufferSamples(new short[0]);
		}
		alSourcePlay(fonte);
		catchInternalException();
		start();
	}

	public boolean isRodando() {
		return rodando;
	}

	public synchronized void run() {
		while (!fechado) {
			while (!rodando) {
				Utils.handleProcedure(this::wait, false);

			}
			int buffersProcessados = alGetSourcei(fonte, AL_BUFFERS_PROCESSED);
			for (int i = 0; i < buffersProcessados; i++) {
				// short[] samples

				short[] samples = bufferSupplier.get();
				if (samples == null) {
					rodando = false;
					break;
				}
				alDeleteBuffers(alSourceUnqueueBuffers(fonte));
				buffers[indiceBuffer] = alGenBuffers();
				bufferSamples(samples);
			}
			if (alGetSourcei(fonte, AL_SOURCE_STATE) != AL_PLAYING) {
				alSourcePlay(fonte);
			}
			catchInternalException();
		}
		alDeleteSources(fonte);
		alDeleteBuffers(buffers);
		alcDestroyContext(contexto);
		alcCloseDevice(dispositivo);
	}

	public synchronized void gatilhoPlayback() {
		rodando = true;
		notify();
	}

	public void close() {
		fechado = true;
		gatilhoPlayback();
	}

	private void bufferSamples(short[] samples) {

		int buf = buffers[indiceBuffer++];
		alBufferData(buf, AL_FORMAT_MONO16, samples, QuadroPrincipal.AudioInfo.SAMPLE_RATE);
		alSourceQueueBuffers(fonte, buf);
		indiceBuffer %= CONTAGEM_BUFFER;
	}

	private void catchInternalException() {
		int err = alcGetError(dispositivo);
		if (err != ALC_NO_ERROR) {
			throw new OpenALException(err);
		}
	}

}
