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
	
	public static void recarregaLista(Convidado[] vetorConvidados) {

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

		recarregaLista(esquerda);
		recarregaLista(direita);
		intercalaLista(vetorConvidados, esquerda, direita);

	}

	public static void intercalaLista(Convidado[] vetorConvidados, Convidado[] esquerda, Convidado[] direita) {
		int iEsquerda = 0, iDireita = 0;

		for (int i = 0; i < vetorConvidados.length; i++) {
			if (iEsquerda == esquerda.length) {
				vetorConvidados[i] = direita[iDireita];
				iDireita++;
			} else if (iDireita == direita.length) {
				vetorConvidados[i] = esquerda[iEsquerda];
				iEsquerda++;
			} else if (esquerda[iEsquerda].getId() > direita[iDireita].getId()) {
				vetorConvidados[i] = esquerda[iEsquerda];
				iEsquerda++;
			} else {
				vetorConvidados[i] = direita[iDireita];
				iDireita++;
			}
		}
	}

	
	public static void mergeSortID(Convidado[] vetorConvidados) {

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

		mergeSortID(esquerda);
		mergeSortID(direita);
		intercalaID(vetorConvidados, esquerda, direita);

	}

	public static void intercalaID(Convidado[] vetorConvidados, Convidado[] esquerda, Convidado[] direita) {
		int iEsquerda = 0, iDireita = 0;

		for (int i = 0; i < vetorConvidados.length; i++) {
			if (iEsquerda == esquerda.length) {
				vetorConvidados[i] = direita[iDireita];
				iDireita++;
			} else if (iDireita == direita.length) {
				vetorConvidados[i] = esquerda[iEsquerda];
				iEsquerda++;
			} else if (esquerda[iEsquerda].getId() < direita[iDireita].getId()) {
				vetorConvidados[i] = esquerda[iEsquerda];
				iEsquerda++;
			} else {
				vetorConvidados[i] = direita[iDireita];
				iDireita++;
			}
		}
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

		double valor = 1;

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

	public static int qtdVips(Evento evento) {
		int vips = 0;
		while (evento.getListaConvidados().getContador() != null) {
			if (evento.getListaConvidados().getContador().getConteudo().isVip()) {
				vips++;
			}
			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());
		return vips;
	}

	public static double perdaVips(Evento evento) {
		double vips = 0;
		double valor = 1;

		while (evento.getListaConvidados().getContador() != null) {
			if (evento.getListaConvidados().getContador().getConteudo().isVip()) {

				if (isAniversariante(evento, evento.getListaConvidados().getContador().getConteudo())) {
					valor = (100 - evento.getDescontoAniversariante()) * 0.01;
				}

				if (evento.getListaConvidados().getContador().getConteudo().getLote() == 0)
					vips += evento.getValorPortaria() * valor;
				else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 1)
					vips += evento.getValorLote1() * valor;
				else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 2)
					vips += evento.getValorLote2() * valor;
				else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 3)
					vips += evento.getValorLote3() * valor;
			}
			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
			valor = 1;
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());
		return vips * (-1);
	}

	public static int qtdAniversariantes(Evento evento) {

		int qtdAniversariantes = 0;

		while (evento.getListaConvidados().getContador() != null) {

			if (isAniversariante(evento, evento.getListaConvidados().getContador().getConteudo())) {
				qtdAniversariantes++;
			}

			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());
		return qtdAniversariantes;
	}

	public static double perdaAniversariantes(Evento evento) {

		double perda = 0;
		double valor = evento.getDescontoAniversariante() * 0.01;

		while (evento.getListaConvidados().getContador() != null) {

			if (!evento.getListaConvidados().getContador().getConteudo().isVip()
					&& isAniversariante(evento, evento.getListaConvidados().getContador().getConteudo())) {
				if (evento.getListaConvidados().getContador().getConteudo().getLote() == 0)
					perda += evento.getValorPortaria() * valor;
				else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 1)
					perda += evento.getValorLote1() * valor;
				else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 2)
					perda += evento.getValorLote2() * valor;
				else if (evento.getListaConvidados().getContador().getConteudo().getLote() == 3)
					perda += evento.getValorLote3() * valor;
			}
			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
			valor = 1;
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());
		return perda * (-1);
	}
	
	public static void viraLote(Evento evento) {
		//if (evento.getQtdLote1())
	}
}
