package controller;

public class Pilha<T> extends EstruturaEstatica<T> {

	public Pilha() {
		super();
	}

	public Pilha(int capacidade) {
		super(capacidade);
	}

	public void push(T elemento) {
		super.adiciona(elemento);
	}

	public T topo() {
		if (this.estaVazia()) {
			return null;
		}
		return this.elementos[tamanho -1];
	}

	public T pop() {

		if (this.estaVazia()) {
			return null;
		}

		return this.elementos[--tamanho];
	}

}

