package controller;

import model.Convidado;

public interface MetodosAdicionais {

	public static String nomeConvidadoPorId(ListaDupla<Convidado> listaConvidados, int id) {

		if (listaConvidados.getContador() == null) {
			return "Id inexistente.";
		} else if (listaConvidados.getContador().getConteudo().getId() == id) {
			String retorno = listaConvidados.getContador().getConteudo().getNome();
			listaConvidados.setContador(listaConvidados.getPrimeiro());
			return retorno;
		}
		listaConvidados.setContador(listaConvidados.getContador().getProximo());
		return nomeConvidadoPorId(listaConvidados, id);
	}

	public static void mergeSortConvidados(Convidado[] vetorConvidados) {

		if (vetorConvidados.length == 1)
			return;

		int metade = vetorConvidados.length / 2;
		Convidado[] esquerda = new Convidado[metade];
		Convidado[] direita = new Convidado[vetorConvidados.length - metade];

		// Este for adiciona o conteúdo às duas metades
		for (int i = 0; i < vetorConvidados.length; i++) {
			if (i < metade)
				esquerda[i] = vetorConvidados[i]; 
			else
				direita[i - metade] = vetorConvidados[i];
		}

		// Divisão dos vetores até 1:
		mergeSortConvidados(esquerda);
		mergeSortConvidados(direita);

		// Chama a intercalação
		if (checkbox.equals("ID") {
			intercalarIdConvidados(esquerda, direita, vetorConvidados);
		} else if (checkbox.equals("Nome")) {
			intercalarNomeConvidados(esquerda, direita, vetorConvidados);
		}
		
	}

	public static void intercalarIdConvidados(Convidado[] esquerda, Convidado[] direita, Convidado[] resultado) {
		// TODO Auto-generated method stub
		int indiceEsq = 0, indiceDir = 0;

		for (int k = 0; k < resultado.length; k++) {
			if (indiceEsq == esquerda.length) {
				resultado[k] = direita[indiceDir];
				indiceDir++;
			} else if (indiceDir == direita.length) {
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
			} else if (esquerda[indiceEsq].getNome()< direita[indiceDir].getNome()) {
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
			} else {
				resultado[k] = direita[indiceDir];
				indiceDir++;
			}
		}
	}
	public static void intercalarNomeConvidados(Convidado[] esquerda, Convidado[] direita, Convidado[] resultado) {
		// TODO Auto-generated method stub
		int indiceEsq = 0, indiceDir = 0;

		for (int k = 0; k < resultado.length; k++) {
			if (indiceEsq == esquerda.length) {
				resultado[k] = direita[indiceDir];
				indiceDir++;
			} else if (indiceDir == direita.length) {
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
			} else if (esquerda[indiceEsq].getId() < direita[indiceDir].getId()) {
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
			} else {
				resultado[k] = direita[indiceDir];
				indiceDir++;
			}
		}
	}

}
