package controller;

public class Fila<T> extends EstruturaEstatica<T> {
	
	public Fila() {
		super();
	}
	
	public Fila(int capacidade) {
		super(capacidade);
	}
	
	public void enqueue(T elemento) {
		super.adiciona(elemento);
	}
	
	public T dequeue() {
		
		if(this.tamanho > 0) {
			
			T primeiro = (T) this.elementos[0];
			for (int i = 0; i < tamanho - 1; i++) {
				this.elementos[i] = this.elementos[i + 1];
			}
			this.tamanho--;
			return primeiro;
		}

			System.out.println("A fila está vazia.");
			return null;
	}
}
