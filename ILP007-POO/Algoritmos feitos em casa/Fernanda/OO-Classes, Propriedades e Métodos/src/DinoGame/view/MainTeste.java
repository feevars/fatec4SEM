package view;

import java.util.Scanner;

import model.Dinossauro;

public class MainTeste {

	static Scanner scan = new Scanner(System.in);

	public static String menu() {
		String menuOpcoes = "SKEEP!!!"
				+ "\n(P)ular           (C)orrer         Co(M)er\r\n"
				+ "(A)tirar           Tomar (S)ol      Ficar na S(O)mbra"
				+ "\nO que deseja fazer?";
		return menuOpcoes;
	}

	public static Character scanning() {
		String textoMaiusculo = scan.nextLine().toUpperCase();
		char letra = textoMaiusculo.charAt(0);
		return letra;
	}

	public static void main(String[] args) {

		Dinossauro skeep = new Dinossauro();

		while (true) {
			System.out.println(menu());
			switch (scanning()) {
			case 'P':
				skeep.pular();
				skeep.status();
				break;
			case 'A':
				skeep.atirar();
				skeep.status();
				break;
			case 'C':
				skeep.correr();
				skeep.status();
				break;
			case 'S':
				skeep.tomarSol();
				skeep.status();
				break;
			case 'M':
				skeep.comer();
				skeep.status();
				break;
			case 'O':
				skeep.ficarNaSombra();
				skeep.status();
				break;
			default:
				System.out.println("opcão inválida.");
				break;
			}
		}
	}
}
