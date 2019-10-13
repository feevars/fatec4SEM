package controller;

import javax.swing.JOptionPane;

public class ListaDupla<T> {

	//---Variáveis que existem na ListaDupla
	private No<T> primeiro;
	private No<T> ultimo;
	private int qtdNo;

	//---Construtor
	public ListaDupla() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNo = 0;
	}

	//--Métodos
	public boolean estaVazia() {
		return qtdNo == 0;
	}

	public void inserirPrimeiro(T conteudo) {
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
	
	
	public void inserirUltimo(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia()) {
			this.primeiro = novoNo;
		} else {
			this.ultimo.setProximo(novoNo);
		}
		novoNo.setAnterior(this.ultimo);
		this.ultimo = novoNo;
		this.qtdNo++;
	}

	
	public void inserirNaPosicao(T conteudo, int posicao) {

		long tempo = System.nanoTime();
		No<T> novoNo = new No<T>(conteudo);

		if(posicao > qtdNo) {
			JOptionPane.showMessageDialog(null, "A posição desejada é maior que o tamanho da lista."
					+ "\nO item será inserido no final.");
			this.inserirUltimo(conteudo);
		}else if(posicao == 1) {
			this.inserirPrimeiro(conteudo);
		}else if(posicao < (qtdNo / 2) + 1){
			No<T> contador = this.primeiro;
			for (int i = 1; i < (posicao - 1); i++) {
				contador = contador.getProximo();
			}
			novoNo.setAnterior(contador);
			novoNo.setProximo(contador.getProximo());
			contador.setProximo(novoNo);
			contador = novoNo.getProximo();
			contador.setAnterior(novoNo);

		}else {
			No<T> contador = this.ultimo;
			for (int i = qtdNo; i > (posicao); i--) {
				contador = contador.getAnterior();
			}
			novoNo.setProximo(contador);
			novoNo.setAnterior(contador.getAnterior());
			contador.setAnterior(novoNo);
			contador = novoNo.getAnterior();
			contador.setProximo(novoNo);
		}
		tempo = System.nanoTime() - tempo;
		JOptionPane.showMessageDialog(null, "Tempo de execução da inserção:\n"
				+ tempo + "milissegundos.");

		this.qtdNo++;
	}

	public String imprimirLista() {

		String listaImpressa = "Lista:\n";

		if (this.estaVazia()) {
			listaImpressa += "A lista está vazia.";
		}else {
			No<T> atual = this.primeiro;
			while(atual != null) {
				listaImpressa += atual.getConteudo().toString() + "\n";
				atual = atual.getProximo();
			}
		}

		return listaImpressa;
	}



}
