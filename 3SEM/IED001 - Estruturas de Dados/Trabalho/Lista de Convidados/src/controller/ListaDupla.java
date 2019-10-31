package controller;

import javax.swing.JOptionPane;

import model.Convidado;

public class ListaDupla<T> {

	//Variáveis de uma lista duplamente encadeada
	private No<T> primeiro;
	private No<T> ultimo;
	private int qtdNo;
	
	//Variável que conta um id a toda adição,
	//mas não remove ao remover um item.
	//Isso permite sempre criar um ID único para item.
	private int contaId;
	
	//Construtor da lista dupla.
	//Ela é iniciada vazia, depois são adicionados os nós.
	public ListaDupla() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNo = 0;
		this.contaId = 0;
	}

	//GET - Quantidade de nó
	public int getQtdNo() {
		return qtdNo;
	}
	
	//GET do Conta ID
	public int getContaId() {
		return contaId;
	}
	
	//Método para ver se está vazia
	public boolean estaVazia() {
		return this.qtdNo == 0;
	}

	//INSERIR NA PRIMEIRA POSIÇÃO
	public void inserePrimeiro(T conteudo) {
		//Inicio um nó com o conteúdo recebido
		No<T> novoNo = new No<T>(conteudo);
		//Se a lista está vazia, o último nó é o novo nó;
		if (this.estaVazia()) {
			this.ultimo = novoNo;
		//Se não, o primeiro nó precisa definir o anterior:
		}else {
			this.primeiro.setAnterior(novoNo);
		}
		//em qualquer situaçao, o novo nó precisa definir o próximo,
		//que é o atual primeiro.
		novoNo.setProximo(this.primeiro);
		//O primeiro item da lista passa a ser o novoNo
		this.primeiro = novoNo;
		//Incrementa Quantidade de nó
		this.qtdNo++;
		//Incrementa contagem de ID
		this.contaId++;
	}

	//INSERIR NA ÚLTIMA POSIÇÃO
	public void insereUltimo(T conteudo) {
		//Novo nó recebe conteúdo
		No<T> novoNo = new No<T>(conteudo);
		//Se está vazia, o primeiro é o novo nó.
		if (this.estaVazia()) {
			this.primeiro = novoNo;
		//Se não, o último da ista precisa definir que o
		//próximo é o novo nó.
		}else {
			this.ultimo.setProximo(novoNo);
		}
		//Para qualquer caso, o novo nó precisa definir o anterior
		//que é o atual último.
		novoNo.setAnterior(this.ultimo);
		//O último da lista passa a ser o novo nó.
		this.ultimo = novoNo;
		//Incrementa a quantidade de nó
		this.qtdNo++;
		//Incrementa a contagem de id
		this.contaId++;
	}

	//INSERIR EM UMA POSIÇÃO DECLARADA
	public void inserePosicao(T conteudo, int posicao) {
		//Inicio um novo nó com o conteúdo recebido
		No<T> novoNo = new No<T>(conteudo);
		//Inicio um nó para auxiliar na contagem
		No<T> atual = this.primeiro;
		//Se a posição declarada for maior que o tamanho da lista,
		//chamo o método insere último e retorno.
		if (posicao > this.qtdNo) {
			JOptionPane.showMessageDialog(null, "A posição é maior que o tamanho da lista,\n"
					+ "inserindo na última posição...");
			this.insereUltimo(conteudo);
			return;
		//Se a posição for menor que 2, ou seja, 1 ou menos, inserimos
		//na primeira posição e retornamos.
		}else if(posicao < 2) {
			this.inserePrimeiro(conteudo);
			return;
		//Se a posição inserida for menor que a metade da lista, percorremos pelo início
		}else if(posicao < (qtdNo / 2)){
			for (int i = 1; i < (posicao - 1); i++) {
				atual = atual.getProximo();
			}
			novoNo.setAnterior(atual);
			novoNo.setProximo(atual.getProximo());
			atual.setProximo(novoNo);
			atual = novoNo.getProximo();
			atual.setAnterior(novoNo);
		//Se não, percorremos pelo final
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
		//Incrementa a quantidade de nós
		this.qtdNo++;
		//Incrementa o contador de ID
		this.contaId++;
	}
	
	public Convidado [] vetorConvidados(){
		
		if(this.qtdNo == 0) return null;
		else {
			No<T> contador = this.primeiro;
			Convidado [] vetorConteudo = new Convidado[this.qtdNo];
			int i = 0;
			while(contador != null) {
				vetorConteudo[i] = (Convidado) contador.getConteudo();
				contador = contador.getProximo();
				i++;
			};
				
			return vetorConteudo;
		}
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