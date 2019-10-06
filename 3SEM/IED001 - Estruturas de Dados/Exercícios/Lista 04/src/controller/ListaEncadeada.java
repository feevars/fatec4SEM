package controller;

public class ListaEncadeada<T> {

	private No primeiro;
	private No ultimo;
	private int qtdNo;

	//---------- Construtor --------------

	public ListaEncadeada() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNo = 0;
	}

	//---------- Guetters & Setters ------

	public No getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(No primeiro) {
		this.primeiro = primeiro;
	}

	public No getUltimo() {
		return ultimo;
	}

	public void setUltimo(No ultimo) {
		this.ultimo = ultimo;
	}

	public int getQtdNo() {
		return qtdNo;
	}

	public void setQtdNo(int qtdNo) {
		this.qtdNo = qtdNo;
	}

	//-------------- Métodos -------------

	public boolean estaVazia() {
		return (this.primeiro == null);
	}

	public void inserirPrimeiro(T p) {
		No novoNo = new No(p);
		if(this.estaVazia()) {
			this.ultimo = novoNo;
		}
		novoNo.setProx(this.primeiro);
		this.primeiro = novoNo;
		this.qtdNo++;
	}

	public void inserirUltimo(T p) {
		No novoNo = new No(p);
		if (this.estaVazia()) {
			this.primeiro = novoNo;
		} else {
			this.ultimo.setProx(novoNo);
		}
		this.ultimo = novoNo;
		this.qtdNo++; 
	}

	public boolean removerNo(T p) {
		No atual = this.primeiro;
		No anterior = null;
		if (this.estaVazia() || this.pesquisarNo(p) == "Não encontrado.") {
			return false;
		} else {
			while((atual != null) && (!atual.getP().toString().equals(p.toString()))) {
				anterior = atual;
				atual = atual.getProx();
			}
			if(atual == this.primeiro) {
				if(this.primeiro == this.ultimo) {
					this.ultimo = null;
				}
				this.primeiro = this.primeiro.getProx();
			}else {
				if(atual == this.ultimo) {
					this.ultimo = anterior;
				}
				anterior.setProx(atual.getProx());
			}
			this.qtdNo--;
			return true;
		}
	}
	
	public String pesquisarNo(T p) {
		String msg = null;
		No atual = this.primeiro;
		while((atual != null) && (!atual.getP().toString().equals(p.toString()))) {
			atual = atual.getProx();
		}
		if (atual != null) {
			return msg = "Encontrado: " + atual.getP().toString();
		}else {
			return msg = "Não encontrado.";
		}
	}
	
	public String imprimirLista() {
		String msg = "";
		
		if (this.estaVazia()) {
			msg = "A lista está vazia...";
		}else {
			No atual = this.primeiro;
			while(atual != null) {
				msg += atual.getP().toString() + "\n";
				atual = atual.getProx();
			}
		}
		return msg;
	}




}
