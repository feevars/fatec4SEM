package controller;

import java.util.Calendar;
import java.util.TimeZone;

import model.Convidado;
import model.Evento;

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

			} else if (esquerda[iEsquerda].getNomeSobrenome()
					.compareToIgnoreCase(direita[iDireita].getNomeSobrenome()) < 0) {
				vetorConvidados[i] = esquerda[iEsquerda];
				iEsquerda++;
			} else {
				vetorConvidados[i] = direita[iDireita];
				iDireita++;
			}
		}
	}

	public static boolean isAniversariante(Evento evento, Convidado convidado) {
		if (convidado.getNascimento() == null) {
			return false;
		} else {
			Calendar calEvento = Calendar.getInstance(TimeZone.getTimeZone("South America/Brazil"));
			calEvento.setTime(evento.getDataEvento());
			Calendar calConvidado = Calendar.getInstance(TimeZone.getTimeZone("South America/Brazil"));
			calConvidado.setTime(convidado.getNascimento());
			if (calEvento.get(Calendar.MONTH) == calConvidado.get(Calendar.MONTH))
				return true;
			else
				return false;
		}
	}

	public static double mediaIdadePublico(Evento evento) {

		double media = 0;
		int totalIdades = 0;

		while (evento.getListaConvidados().getContador() != null) {
			if (evento.getListaConvidados().getContador().getConteudo().getIdade() != -1) {
				media += evento.getListaConvidados().getContador().getConteudo().getIdade();
				totalIdades++;
			}
			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());

		media = media / totalIdades;

		return media;
	}

	public static int[] qtdConvidadoLote(Evento evento) {

		int[] convidadoLote = new int[4];

		while (evento.getListaConvidados().getContador() != null) {
			if (evento.getListaConvidados().getContador().getConteudo().getLote() == 0) {
				convidadoLote[0]++;
			} else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 1) {
				convidadoLote[1]++;
			} else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 2) {
				convidadoLote[2]++;
			} else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 3) {
				convidadoLote[3]++;
			}
			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());
		return convidadoLote;
	}

	public static double[] arrecadacaoLote(Evento evento) {

		double[] arrecadacaoLote = new double[4];

		double valor = 0;

		while (evento.getListaConvidados().getContador() != null) {
			if (!evento.getListaConvidados().getContador().getConteudo().isVip()) {

				if (isAniversariante(evento, evento.getListaConvidados().getContador().getConteudo())) {
					valor = (100 - evento.getDescontoAniversariante()) * 0.01;
				}

				if (evento.getListaConvidados().getContador().getConteudo().getLote() == 0)
					arrecadacaoLote[0] += evento.getValorPortaria() * valor;
				else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 1)
					arrecadacaoLote[1] += evento.getValorLote1() * valor;
				else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 2)
					arrecadacaoLote[2] += evento.getValorLote2() * valor;
				else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 3)
					arrecadacaoLote[3] += evento.getValorLote3() * valor;
			}
			valor = 1;
			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());
		return arrecadacaoLote;
	}
}
