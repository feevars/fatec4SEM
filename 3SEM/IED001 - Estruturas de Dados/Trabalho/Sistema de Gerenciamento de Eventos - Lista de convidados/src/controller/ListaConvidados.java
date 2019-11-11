package controller;

import javax.swing.JOptionPane;

import model.Convidado;

public class ListaConvidados {
	
	private No primeiro;
	private No ultimo;
	private int qtdNo;
	// Conta id:
	private int contaId;
	// Contador auxiliar da recursão
	private No contador;
	// String de resultados
	private String listaTexto = "";
	// Contador auxiliar INTEIRO para vetores
	private int contadorInt;

	public ListaConvidados() {
		primeiro = null;
		ultimo = null;
		qtdNo = 0;
		contaId = 1;
		contador = primeiro;
		contadorInt = 0;
	}
	
	public class No{
		
		private Convidado conteudo;
		private No proximo;
		private No anterior;
		
		public No(Convidado conteudo) {
			this.conteudo = conteudo;
			this.proximo = null;
			this.anterior = null;
		}

		public Convidado getConteudo() {
			return conteudo;
		}

		public void setConteudo(Convidado conteudo) {
			this.conteudo = conteudo;
		}

		public No getProximo() {
			return proximo;
		}

		public void setProximo(No proximo) {
			this.proximo = proximo;
		}

		public No getAnterior() {
			return anterior;
		}

		public void setAnterior(No anterior) {
			this.anterior = anterior;
		}

		@Override
		public String toString() {
			return conteudo.toString();
		}
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
	
	public void setContaId(int contaId) {
		this.contaId = contaId;
	}
	
	public int getContaId() {
		return contaId;
	}

	public No getContador() {
		return contador;
	}

	public No getPrimeiro() {
		return primeiro;
	}

	public No getUltimo() {
		return ultimo;
	}

	public void setContador(No contador) {
		this.contador = contador;
	}

	// Método "está vazia?"
	public boolean estaVazia() {
		return this.qtdNo == 0;
	}

	// Método INSERE PRIMEIRO
	public void inserePrimeiro(Convidado conteudo) {
		No novoNo = new No(conteudo);
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
			primeiro = primeiro.getProximo();
			primeiro.setAnterior(null);
			contador = primeiro;
		}
		qtdNo--;
	}

	// Método INSERE ÚLTIMO
	public void insereUltimo(Convidado conteudo) {
		No novoNo = new No(conteudo);
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
	public No inserePosicao(Convidado conteudo, int posicao) {
		if (posicao == 2) {
			No novoNo = new No(conteudo);
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
	
	// Método recursivo para remover um nó que possua um determinado ID
	public void removeId(int id) {
		if (contador.getConteudo().getId() == id) {
			if (contador == primeiro) {
				removePrimeiro();
				return;
			}else if (contador == ultimo) {
				removeUltimo();
				return;
			}else {
				contador.getAnterior().setProximo(contador.getProximo());
				contador.getProximo().setAnterior(contador.getAnterior());
				contador = primeiro;				
			}
			qtdNo--;
			return;
		}else if (contador == null) {
			JOptionPane.showMessageDialog(null, "Não existe convidado com o ID solicitado nesta remoção.");
			return;
		}
		contador = contador.getProximo();
		removeId(id);
	}
	
	//m�todo para buscar um convidado pelo nome
	public Convidado[] buscarConvidado(Convidado[] vetorConvidados, String nome) {
		int cont = 0, j = 0;
		Convidado[] convidadosEncontrados = new Convidado[vetorConvidados.length];
		for (int i = 0; i < vetorConvidados.length; i++) {
			if (vetorConvidados[i].getNome().equalsIgnoreCase(nome)) {
				cont++;
				convidadosEncontrados[j] = vetorConvidados[i];
				j++;
			}
		}
		if (cont == 0) {
			JOptionPane.showMessageDialog(null, "O convidado buscado n�o foi encontrado na lista.");
			return convidadosEncontrados;
		} else {
			System.out.println(convidadosEncontrados.toString());
			return convidadosEncontrados;
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
