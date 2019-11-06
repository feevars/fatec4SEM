package view;

import java.io.IOException;

import controller.ContArquivos;
import controller.IContArquivos;

public class Principal {

	public static void main(String[] args) {
		IContArquivos contArquivos = new ContArquivos(); // vai chamar a interface que já está impleentada nessa classe
		String pathWin = "C:\\Windows";
		String path = "D:";
		String nome = "texto.txt"; // posso criar arquivo .csv pra ir pra tabela
		try {
			//contArquivos.criaArq(path, nome); //troca a chamada do contArquivos.criaArq(path, nome);
			//contArquivos.leArquivo(path, nome);
			//contArquivos.leDir(pathWin);
			contArquivos.abreArq(path, nome);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
