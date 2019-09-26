package controller;

public class Fila {
	
	private int [] elementos;
	private int tamanho;
	
	public Fila(int capacidade) {
		this.elementos = new int[capacidade];
		this.tamanho = 0;
	}
	
	public void adiciona(int elemento) {
		
		if(this.tamanho < this.elementos.length) {
			this.elementos[tamanho] = elemento;
			this.tamanho++;
		}else {
			System.out.println("A fila está cheia.");
		}
	}
	
	public void pegaPrimeiro(Pilha pilha) {
				
		if(this.tamanho > 0) {
			pilha.adiciona(this.elementos[0]);
			for (int i = 0; i < tamanho - 1; i++) {
				this.elementos[i] = this.elementos[i + 1];
			}
			this.tamanho--;
		}else{
			System.out.println("A fila está vazia.");
		}

	}
	
	public int getTamanho() {
		return tamanho;
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
