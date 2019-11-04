package controller;

public class ListaDupla<T> {
	
	private No<T> primeiro;
	private No<T> ultimo;
	private int qtdNo;
	// Conta id:
	private int contaId;
	// Contador auxiliar da recursão
	private No<T> contador;
	// String de resultados
	private String listaTexto = "";
	// Contador auxiliar INTEIRO para vetores
	private int contadorInt;

	public ListaDupla() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNo = 0;
		this.contaId = 0;
		this.contador = this.primeiro;
		this.contadorInt = 0;
	}

	public int getContadorInt() {
		return contadorInt;
	}

	public void setContadorInt(int contadorInt) {
		this.contadorInt = contadorInt;
	}

	public int getQtdNo() {
		return qtdNo;
	}

	public int getContaId() {
		return contaId;
	}

	public No<T> getContador() {
		return contador;
	}

	public No<T> getPrimeiro() {
		return primeiro;
	}

	public No<T> getUltimo() {
		return ultimo;
	}

	public void setContador(No<T> contador) {
		this.contador = contador;
	}

	// Método "está vazia?"
	public boolean estaVazia() {
		return this.qtdNo == 0;
	}

	// Método INSERE PRIMEIRO
	public void inserePrimeiro(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia())
			this.ultimo = novoNo;
		else
			this.primeiro.setAnterior(novoNo);
		novoNo.setProximo(this.primeiro);
		this.primeiro = novoNo;
		this.contador = this.primeiro;
		this.qtdNo++;
		this.contaId++;
	}

	// Método REMOVE PRIMEIRO
	public void removePrimeiro() {
		if (qtdNo == 1) {
			this.primeiro = null;
			this.ultimo = null;
			this.contador = this.primeiro;
		} else {
			this.contador = this.primeiro;
			this.primeiro = this.primeiro.getProximo();
			this.primeiro.setAnterior(null);
			this.contador = this.primeiro;
		}
		this.qtdNo--;
	}

	// Método INSERE ÚLTIMO
	public void insereUltimo(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia())
			this.primeiro = novoNo;
		else
			this.ultimo.setProximo(novoNo);
		novoNo.setAnterior(this.ultimo);
		this.ultimo = novoNo;
		this.contador = this.primeiro;
		this.qtdNo++;
		this.contaId++;
	}

	// Método Remove Último
	public void removeUltimo() {
		if (qtdNo == 1) {
			this.primeiro = null;
			this.ultimo = null;
			this.contador = this.primeiro;
		} else {
			this.contador = this.ultimo;
			this.ultimo = this.ultimo.getAnterior();
			this.ultimo.setProximo(null);
			this.contador = this.primeiro;
		}
		this.qtdNo--;
	}

	// Método INSERE POSIÇÃO (recursivo)
	public No<T> inserePosicao(T conteudo, int posicao) {
		if (posicao == 2) {
			// Retorno a inserção - ponto de parada
			No<T> novoNo = new No<T>(conteudo);
			novoNo.setAnterior(this.contador);
			novoNo.setProximo(this.contador.getProximo());
			this.contador.getProximo().setAnterior(novoNo);
			this.contador.setProximo(novoNo);
			this.qtdNo++;
			this.contaId++;
			this.contador = this.primeiro;
			return novoNo;
		} else {
			// Recursividade
			this.contador = this.contador.getProximo();
			return inserePosicao(conteudo, posicao - 1);
		}
	}

	// Método recursivo para remover posicao
	public void removePosicao(int posicao) {
		if (posicao == 1) {
			this.contador.getAnterior().setProximo(this.contador.getProximo());
			this.contador.getProximo().setAnterior(this.contador.getAnterior());
			this.contador = this.primeiro;
			this.qtdNo--;
		} else {
			this.contador = this.contador.getProximo();
			removePosicao(posicao - 1);
		}
	}

	// Método de impressão recursivo de String
	public String listaString() {
		if (this.estaVazia())
			return "A lista está vazia.";
		if (this.contador == this.ultimo) {
			this.listaTexto += this.ultimo.toString();
			String listaImpressa = listaTexto;
			this.listaTexto = "";
			this.contador = this.primeiro;
			return listaImpressa;
		} else {
			this.listaTexto += this.contador.toString();
			this.contador = this.contador.getProximo();
			return listaString();
		}
	}

	

}
