package view;

import controller.Fila;
import controller.Pilha;

public class teste {

	public static void main(String[] args) {

		int capacidade = 5;

		Fila fila1 = new Fila(capacidade);
		Pilha pilha1 = new Pilha(capacidade);

		fila1.adiciona(20);
		fila1.adiciona(30);
		fila1.adiciona(40);
		fila1.adiciona(50);
		fila1.adiciona(60);

		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);

		fila1.pegaPrimeiro(pilha1);
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);

		fila1.pegaPrimeiro(pilha1);
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);

		fila1.pegaPrimeiro(pilha1);
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);

		fila1.pegaPrimeiro(pilha1);
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);

		fila1.pegaPrimeiro(pilha1);
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);

		pilha1.pegaUltimo(fila1);
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);

		pilha1.pegaUltimo(fila1);
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);

		pilha1.pegaUltimo(fila1);
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);

		pilha1.pegaUltimo(fila1);
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);

		pilha1.pegaUltimo(fila1);
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);
	}

}
