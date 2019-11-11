package controller;

import model.Convidado;

public interface MetodosLista {

	public static Convidado[] vetorLista(ListaConvidados listaConvidados) {

		Convidado[] vetorConvidados = new Convidado[listaConvidados.getQtdNo()];

		for (int i = 0; i < vetorConvidados.length; i++) {
			vetorConvidados[i] = listaConvidados.getContador().getConteudo();
			listaConvidados.setContador(listaConvidados.getContador().getProximo());
		}
		listaConvidados.setContador(listaConvidados.getPrimeiro());

		return vetorConvidados;
	}

	public static void mergeSortIdade(Convidado[] vetorConvidados) {

		if (vetorConvidados.length == 1)
			return;

		int metade = vetorConvidados.length / 2;

		Convidado[] esquerda = new Convidado[metade];
		Convidado[] direita = new Convidado[vetorConvidados.length - metade];

		for (int i = 0; i < vetorConvidados.length; i++) {
			if (i < metade)
				esquerda[i] = vetorConvidados[i];
			else
				direita[i - metade] = vetorConvidados[i];
		}

		mergeSortIdade(esquerda);
		mergeSortIdade(direita);
		intercalaIdade(vetorConvidados, esquerda, direita);

	}

	public static void intercalaIdade(Convidado[] vetorConvidados, Convidado[] esquerda, Convidado[] direita) {
		int iEsquerda = 0, iDireita = 0;

		for (int i = 0; i < vetorConvidados.length; i++) {
			if (iEsquerda == esquerda.length) {
				vetorConvidados[i] = direita[iDireita];
				iDireita++;
			} else if (iDireita == direita.length) {
				vetorConvidados[i] = esquerda[iEsquerda];
				iEsquerda++;
			} else if (esquerda[iEsquerda].getIdade() > direita[iDireita].getIdade()) {
				vetorConvidados[i] = esquerda[iEsquerda];
				iEsquerda++;
			} else {
				vetorConvidados[i] = direita[iDireita];
				iDireita++;
			}
		}
	}
	
	public static void mergeSortNome(Convidado[] vetorConvidados) {

		if (vetorConvidados.length == 1)
			return;

		int metade = vetorConvidados.length / 2;

		Convidado[] esquerda = new Convidado[metade];
		Convidado[] direita = new Convidado[vetorConvidados.length - metade];

		for (int i = 0; i < vetorConvidados.length; i++) {
			if (i < metade)
				esquerda[i] = vetorConvidados[i];
			else
				direita[i - metade] = vetorConvidados[i];
		}

		mergeSortNome(esquerda);
		mergeSortNome(direita);
		intercalaNome(vetorConvidados, esquerda, direita);

		for (int i = 0; i < vetorConvidados.length; i++) {
			System.out.println(vetorConvidados.toString());
		}

	}

	public static void intercalaNome(Convidado[] vetorConvidados, Convidado[] esquerda, Convidado[] direita) {
		int iEsquerda = 0, iDireita = 0;

		for (int i = 0; i < vetorConvidados.length; i++) {
			if (iEsquerda == esquerda.length) {
				vetorConvidados[i] = direita[iDireita];
				iDireita++;
			} else if (iDireita == direita.length) {
				vetorConvidados[i] = esquerda[iEsquerda];
				iEsquerda++;

			} else if (esquerda[iEsquerda].getNome().compareToIgnoreCase(direita[iDireita].getNome()) < 0) {
				vetorConvidados[i] = esquerda[iEsquerda];
				iEsquerda++;
			} else {
				vetorConvidados[i] = direita[iDireita];
				iDireita++;
			}
		}
	}

}
