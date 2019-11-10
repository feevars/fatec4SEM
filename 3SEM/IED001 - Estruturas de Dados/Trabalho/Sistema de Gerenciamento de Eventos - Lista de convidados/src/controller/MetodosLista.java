package controller;

import model.Convidado;

public class MetodosLista {
	
	public static Convidado[] vetorNome(ListaConvidados listaConvidados, Convidado[] vetorConvidados) {
		if (listaConvidados.getContador() == listaConvidados.getUltimo()) {
			vetorConvidados[listaConvidados.getContadorInt()] = listaConvidados.getUltimo().getConteudo();
			listaConvidados.setContador(listaConvidados.getPrimeiro());
			listaConvidados.setContadorInt(0);
			return vetorConvidados; 
		} else {
			vetorConvidados[listaConvidados.getContadorInt()] = listaConvidados.getContador().getConteudo();
			listaConvidados.setContador(listaConvidados.getContador().getProximo());
			listaConvidados.setContadorInt(listaConvidados.getContadorInt()+1);
			return vetorNome(listaConvidados, vetorConvidados);
		}
		
				
	}
	
	public void ordenarNomes() {
		mergeSort(vetor, auxiliar, 0, vetor.length-1);
	}
	public static void mergeSort(Convidado conteudo) {
		
	}
	public static void intercala(Convidado conteudo) {
		
	}
	
	public static void intercalarMedia(Media[] esquerda, Media[] direita, Media[] resultado) {
		int indiceEsq = 0, indiceDir = 0;

		for (int k = 0; k < resultado.length; k++) {
			if (indiceEsq == esquerda.length) {
				resultado[k] = direita[indiceDir];
				indiceDir++;
			} else if (indiceDir == direita.length) {
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
			} else if (esquerda[indiceEsq].getMediaFinal() < direita[indiceDir].getMediaFinal()) {
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
			} else {
				resultado[k] = direita[indiceDir];
				indiceDir++;
			}
		}
	

	}
}
