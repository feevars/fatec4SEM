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

	public ListaDupla() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNo = 0;
		this.contaId = 0;
		this.contador = this.primeiro;
	}

	public int getQtdNo() {
		return qtdNo;
	}

	public int getContaId() {
		return contaId;
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

	// // Método INSERE POSIÇÃO (sem recursão)
	// public void inserePosicao(T conteudo, int posicao) {
	// if(posicao < 2) {
	// this.inserePrimeiro(conteudo);
	// return;
	// }else if(posicao > this.qtdNo) {
	// this.insereUltimo(conteudo);
	// return;
	// }else if(posicao < this.qtdNo / 2) {
	// No<T> novoNo = new No<T>(conteudo);
	// No<T> contador = this.primeiro;
	// for (int i = 1; i < posicao - 1; i++) {
	// contador = contador.getProximo();
	// }
	// novoNo.setAnterior(contador);
	// novoNo.setProximo(contador.getProximo());
	// contador.getProximo().setAnterior(novoNo);
	// contador.setProximo(novoNo);
	// }else{
	// No<T> novoNo = new No<T>(conteudo);
	// No<T> contador = this.ultimo;
	// for (int i = this.qtdNo; i > posicao; i--) {
	// contador = contador.getAnterior();
	// }
	// novoNo.setProximo(contador);
	// novoNo.setAnterior(contador.getAnterior());
	// contador.getAnterior().setProximo(novoNo);
	// contador.setAnterior(novoNo);
	// }
	// this.qtdNo++;
	// this.contaId++;
	// }

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
	
	// Método de impressão recursivo de String
	public String listaString() {
		if(this.estaVazia()) return "A lista está vazia.";
		if(this.contador == this.ultimo) {
			this.listaTexto += this.ultimo.toString();
			String listaImpressa = listaTexto;
			this.listaTexto = "";
			this.contador = this.primeiro;
			return listaImpressa;
		}
		else {
			this.listaTexto += this.contador.toString();
			this.contador = this.contador.getProximo();
			return listaString();
		}
			
	}
}
