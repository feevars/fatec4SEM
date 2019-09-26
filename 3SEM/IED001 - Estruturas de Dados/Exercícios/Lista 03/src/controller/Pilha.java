package controller;

public class Pilha {
	
	private int [] elementos;
	private int tamanho;
	
	public Pilha(int capacidade) {
		this.elementos = new int[capacidade];
		this.tamanho = 0;
	}
	
	public void adiciona(int elemento) {
		if(tamanho < elementos.length) {
			this.elementos[tamanho] = elemento;
			this.tamanho++;
		}else{
			System.out.println("A pilha está cheia.");
		}
	}
	
	public void pegaUltimo(Fila fila) {
		if (this.tamanho > 0) {
			fila.adiciona(this.elementos[tamanho - 1]);
			tamanho--;
		}else{
			System.out.println("A pilha está vazia.");
		}
	}
	
	@Override
	public String toString() {

		StringBuilder s = new StringBuilder();
		s.append("[");


		for (int i = 0; i < this.tamanho-1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}

		if (this.tamanho > 0) {
			s.append(this.elementos[this.tamanho-1]);
		}

		s.append("]");

		return s.toString();
	}

}
