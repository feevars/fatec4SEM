package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AudioThread;
import java.util.function.Supplier;

public class QuadroPrincipal extends JFrame {

	private static final long serialVersionUID = 1025921259923691195L;

	private boolean deveriaGerar;
	private int wavePos;

	private final AudioThread audioThread = new AudioThread(new Supplier<short[]>() {

		@Override
		public short[] get() {
			if (!deveriaGerar) {
				return null;

			}
			short[] s = new short[AudioThread.TAMANHO_BUFFER];
			for (int i = 0; i < AudioThread.TAMANHO_BUFFER; i++) {
				s[i] = (short) (Short.MAX_VALUE * Math.sin((2 * Math.PI * 440) / AudioInfo.SAMPLE_RATE * wavePos++));
			}
			return s;
		}

	});

	private JPanel contentPane;

	public QuadroPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 360);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				deveriaGerar = false;
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (!audioThread.isRodando()) {
					deveriaGerar = true;
					audioThread.gatilhoPlayback();
				}
			}
		});

		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				audioThread.close();
			}
		});
		setVisible(true);

	}

	public static class AudioInfo {
		public static final int SAMPLE_RATE = 44100;
	}

}
