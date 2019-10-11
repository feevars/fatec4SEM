package controller;

public class ListaDupla<T> {
	
	private No<T> primeiro;
	private No<T> ultimo;
	private int qtdNo;
	
	public ListaDupla() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNo = 0;
	}
	
	public boolean estaVazia() {
		return qtdNo == 0;
	}
	
	public int qtdNo() {
		return qtdNo;
	}
	
	public void inserirPrimeiro(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if(this.estaVazia()) {
			this.ultimo = novoNo;
		}
		novoNo.setProximo(this.primeiro);
		this.primeiro = novoNo;
		this.qtdNo++;
	}
	
	public void inserirUltimo(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia()) {
			this.primeiro = novoNo;
		} else {
			this.ultimo.setProximo(novoNo);
			novoNo.setAnterior(ultimo);
		}
		this.ultimo = novoNo;
		this.qtdNo++;
	}

	@Override
	public String toString() {
		return "ListaDupla [primeiro=" + primeiro + ", ultimo=" + ultimo + ", qtdNo=" + qtdNo + "]";
	}
	
	

}
