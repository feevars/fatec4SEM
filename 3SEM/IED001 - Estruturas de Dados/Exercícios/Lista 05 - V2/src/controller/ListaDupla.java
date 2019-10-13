package controller;

import javax.swing.JOptionPane;

public class ListaDupla<T> {


	private No<T> primeiro;
	private No<T> ultimo;
	private int qtdNo;


	public ListaDupla() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNo = 0;
	}


	public int getQtdNo() {
		return qtdNo;
	}


	public boolean estaVazia() {
		return this.qtdNo == 0;
	}


	public void inserePrimeiro(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia()) {
			this.ultimo = novoNo;
		}else {
			this.primeiro.setAnterior(novoNo);
		}
		novoNo.setProximo(this.primeiro);
		this.primeiro = novoNo;
		this.qtdNo++;
	}


	public void insereUltimo(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia()) {
			this.primeiro = novoNo;
		}else {
			this.ultimo.setProximo(novoNo);
		}
		novoNo.setAnterior(this.ultimo);
		this.ultimo = novoNo;
		this.qtdNo++;
	}


	public void inserePosicao(T conteudo, int posicao) {
		No<T> novoNo = new No<T>(conteudo);
		No<T> atual = this.primeiro;
		if (posicao > this.qtdNo) {
			JOptionPane.showMessageDialog(null, "A posição é maior que o tamanho da lista,\n"
					+ "inserindo na última posição...");
			this.insereUltimo(conteudo);
			return;
		}else if(posicao == 1) {
			this.inserePrimeiro(conteudo);
			return;
		}else if(posicao < (qtdNo / 2)){
			for (int i = 1; i < (posicao - 1); i++) {
				atual = atual.getProximo();
			}
			novoNo.setAnterior(atual);
			novoNo.setProximo(atual.getProximo());
			atual.setProximo(novoNo);
			atual = novoNo.getProximo();
			atual.setAnterior(novoNo);
		}else {
			atual = this.ultimo;
			for (int i = qtdNo; i > posicao; i--) {
				atual = atual.getAnterior();
			}
			novoNo.setProximo(atual);
			novoNo.setAnterior(atual.getAnterior());
			atual.setAnterior(novoNo);
			atual = novoNo.getAnterior();
			atual.setProximo(novoNo);
		}
		this.qtdNo++;
	}


	public String imprimeLista() {

		String listaImpressa = "Lista impressa:\n\n";

		if (this.estaVazia()) {
			listaImpressa += "A lista está vazia.";
			return listaImpressa;
		}
		No<T> atual = this.primeiro;

		while(atual != null) {
			listaImpressa += atual.getConteudo().toString() + "\n";
			atual = atual.getProximo();
		}

		return listaImpressa;
	}
}