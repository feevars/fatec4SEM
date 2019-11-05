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
		primeiro = null;
		ultimo = null;
		qtdNo = 0;
		contaId = 1;
		contador = primeiro;
		contadorInt = 0;
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
		if (estaVazia())
			ultimo = novoNo;
		else
			primeiro.setAnterior(novoNo);
		novoNo.setProximo(primeiro);
		primeiro = novoNo;
		contador = primeiro;
		qtdNo++;
		contaId++;
	}

	// Método REMOVE PRIMEIRO
	public void removePrimeiro() {
		if (qtdNo == 1) {
			primeiro = null;
			ultimo = null;
			contador = this.primeiro;
		} else {
			contador = primeiro;
			primeiro = (No<T>) primeiro.getProximo();
			primeiro.setAnterior(null);
			contador = primeiro;
		}
		qtdNo--;
	}

	// Método INSERE ÚLTIMO
	public void insereUltimo(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (estaVazia())
			primeiro = novoNo;
		else
			ultimo.setProximo(novoNo);
		novoNo.setAnterior(ultimo);
		ultimo = novoNo;
		contador = primeiro;
		qtdNo++;
		contaId++;
	}

	// Método Remove Último
	public void removeUltimo() {
		if (qtdNo == 1) {
			primeiro = null;
			ultimo = null;
			contador = primeiro;
		} else {
			contador = ultimo;
			ultimo = ultimo.getAnterior();
			ultimo.setProximo(null);
			contador = primeiro;
		}
		qtdNo--;
	}

	// Método INSERE POSIÇÃO (recursivo)
	public No<T> inserePosicao(T conteudo, int posicao) {
		if (posicao == 2) {
			No<T> novoNo = new No<T>(conteudo);
			novoNo.setAnterior(contador);
			novoNo.setProximo(contador.getProximo());
			contador.getProximo().setAnterior(novoNo);
			contador.setProximo(novoNo);
			qtdNo++;
			contaId++;
			contador = primeiro;
			return novoNo;
		} else {
			// Recursividade
			contador = contador.getProximo();
			return inserePosicao(conteudo, posicao - 1);
		}
	}

	// Método recursivo para remover posicao
	public void removePosicao(int posicao) {
		if (posicao == 1) {
			contador.getAnterior().setProximo(contador.getProximo());
			contador.getProximo().setAnterior(contador.getAnterior());
			contador = primeiro;
			qtdNo--;
		} else {
			contador = contador.getProximo();
			removePosicao(posicao - 1);
		}
	}

	// Método de impressão recursivo de String
	public String listaString() {
		if (estaVazia())
			return "A lista está vazia.";
		if (contador == ultimo) {
			listaTexto += ultimo.toString();
			String listaImpressa = listaTexto;
			listaTexto = "";
			contador = primeiro;
			return listaImpressa;
		} else {
			listaTexto += contador.toString();
			contador = contador.getProximo();
			return listaString();
		}
	}
}
