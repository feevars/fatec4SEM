package controller;

public class No<T> {
	
	private T p;
	private No prox;
	
	public No(T p){
		this.p = p;
		this.prox = null;
	}

	public T getP() {
		return p;
	}

	public void setP(T p) {
		this.p = p;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}
	
	
}
