package motor.io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

public class Janela {

	private int largura, altura;
	private String titulo;
	private long janela;

	public Janela(int largura, int altura, String titulo) {
		this.largura = largura;
		this.altura = altura;
		this.titulo = titulo;
	}

	public void cria() {
		if (!GLFW.glfwInit()) {
			System.err.println("Erro: GLFW não foi inicializado.");
			return;
		}

		janela = GLFW.glfwCreateWindow(largura, altura, titulo, 0, 0);

		if (janela == 0) {
			System.err.println("Erro: a janela não foi criada.");
			return;
		}

		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(janela, (videoMode.width() - largura) / 2, (videoMode.height() - altura) / 2);
		
		GLFW.glfwShowWindow(janela);
	}
	
	public void atualiza() {
		GLFW.glfwPollEvents();
	}
	
	public void swapBuffers() {
		GLFW.glfwSwapBuffers(janela);
	}
	
}
