package controller;

public class No<T>{
	
	private T conteudo;
	private No proximo;
	private No anterior;
	
	public No(T conteudo) {
		this.conteudo = conteudo;
		this.proximo = null;
		this.anterior = null;
	}

	public T getConteudo() {
		return conteudo;
	}

	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}

	@Override
	public String toString() {
		return "No [conteudo=" + conteudo + ", proximo=" + proximo + ", anterior=" + anterior + "]";
	}
	
	
	
}