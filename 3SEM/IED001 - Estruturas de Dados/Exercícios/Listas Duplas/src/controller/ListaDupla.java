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
	
	public boolean estaVazia() {
		return qtdNo == 0;
	}
	
	public void adicionaPrimeiro(T conteudo) {
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
	
	public void adicionaUltimo(T conteudo) {
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
	
	public void adicionaPosicao(T conteudo, int posicao) {
		No<T> novoNo;
		No<T> auxNo;
		if (posicao > this.qtdNo) {
			JOptionPane.showMessageDialog(null, "A posição desejada é maior que o "
					+ "tamanho da lista.\nInserindo no final...");
			this.adicionaUltimo(conteudo);
			return;
		}else if(posicao < 2) {
			JOptionPane.showMessageDialog(null, "Adicionando na primeira posição.");
			this.adicionaPrimeiro(conteudo);
			return;
		}else if(posicao < this.qtdNo / 2) {
			novoNo = new No<T>(conteudo);
			auxNo = this.primeiro;
			for (int i = 1; i < (posicao - 1); i++) {
				auxNo = auxNo.getProximo();
			}
			novoNo.setAnterior(auxNo);
			novoNo.setProximo(auxNo.getProximo());
			auxNo.setProximo(novoNo);
			auxNo = novoNo.getProximo();
			auxNo.setAnterior(novoNo);
			qtdNo++;
		}else {
			novoNo = new No<T>(conteudo);
			auxNo = this.ultimo;
			for (int i = this.qtdNo; i > posicao; i--) {
				auxNo = auxNo.getAnterior();
			}
			novoNo.setProximo(auxNo);
			novoNo.setAnterior(auxNo.getAnterior());
			auxNo.setAnterior(novoNo);
			auxNo = novoNo.getAnterior();
			auxNo.setProximo(novoNo);
			qtdNo++;
		}
	}
}
