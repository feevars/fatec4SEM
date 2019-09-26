package view;

import controller.Fila;
import controller.Pilha;

public class teste {

	public static void main(String[] args) {

		int capacidade = 5;

		Fila fila1 = new Fila(capacidade);
		Pilha pilha1 = new Pilha(capacidade);

		fila1.enqueue(20);
		fila1.enqueue(10);
		fila1.enqueue(75);
		fila1.enqueue(130);
		fila1.enqueue(32);

		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);
		
		pilha1.push(fila1.dequeue());
		pilha1.push(fila1.dequeue());
		pilha1.push(fila1.dequeue());
		pilha1.push(fila1.dequeue());
		pilha1.push(fila1.dequeue());
		
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);
		
		fila1.enqueue(pilha1.pop());
		fila1.enqueue(pilha1.pop());
		fila1.enqueue(pilha1.pop());
		fila1.enqueue(pilha1.pop());
		fila1.enqueue(pilha1.pop());
		
		System.out.println("\nFila:\n" + fila1 + "\nPilha:\n" + pilha1);
	}

}
