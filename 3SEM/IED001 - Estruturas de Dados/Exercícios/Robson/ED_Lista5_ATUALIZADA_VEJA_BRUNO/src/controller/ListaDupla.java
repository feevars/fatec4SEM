package controller;

import javax.swing.JOptionPane;

public class ListaDupla<T> {
	private No<T> ultimo;
	private No<T> primeiro;
	private int qtdNo;
	
	
	public No<T> getUltimo() {
		return ultimo;
	}


	public void setUltimo(No<T> ultimo) {
		this.ultimo = ultimo;
	}


	public No<T> getPrimeiro() {
		return primeiro;
	}


	public void setPrimeiro(No<T> primeiro) {
		this.primeiro = primeiro;
	}


	public void setQtdNo(int qtdNo) {
		this.qtdNo = qtdNo;
	}


	

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


	public void inserePrimeiro (T conteudo) {
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


		if (posicao > this.qtdNo) {
			JOptionPane.showMessageDialog(null, "A lista é menor que o valor informado. Este valor será inserido na última posição");
			this.insereUltimo(conteudo);
			return;
		}
		else if(posicao==1) {
			this.inserePrimeiro(conteudo);
			return;}

		else { 
			boolean ok;
			Ponteiros<T> ponteiro1 = new Ponteiros<T>(1, conteudo, posicao);
			Ponteiros<T> ponteiro2 = new Ponteiros<T>(2, conteudo, posicao);
			ponteiro1.start();
			ponteiro2.start();

		}
		/* if posicao<this.qtdNo/2) {

			No<T> atual = this.primeiro;
			for (int i = 1; i < posicao-1; i++) {
				atual = atual.getProximo();
			}
			novoNo.setAnterior(atual);
			novoNo.setProximo(atual.getProximo());
			atual.setProximo(novoNo);
			atual = novoNo.getProximo();
			atual.setAnterior(novoNo);
			}
			else {
				atual = this.ultimo;
				for (int i = this.qtdNo; i > posicao; i--) {
					atual = atual.getAnterior();

				}
				novoNo.setProximo(atual);
				novoNo.setAnterior(atual.getAnterior());
				atual.setAnterior(novoNo);
				atual = novoNo.getAnterior();
				atual.setProximo(novoNo);
			}*/

		this.qtdNo++;
	}


	public String imprimeLista () {
		String listaImpressa = "Lista impressa:\n\n";

		if (this.estaVazia()) {
			listaImpressa += "A lista está vazia.";
		}

		No<T> atual = this.primeiro;
		while(atual != null) {
			listaImpressa += atual.getConteudo().toString() + "\n";
			atual = atual.getProximo();
		}
		return listaImpressa;
	}
}
