package controller;

import model.Aluno;
import model.Disciplina;
import model.Media;

public interface MetodosAdicionais {

	public static boolean checkIdAlunos(int id, ListaDupla<Aluno> listaAlunos) {
		if (listaAlunos.getQtdNo() == 0) {
			return false;
		}
		if (listaAlunos.getContador() == null) {
			listaAlunos.setContador(listaAlunos.getPrimeiro());
			return false;
		}
		if (listaAlunos.getContador().getConteudo().getId() == id) {
			listaAlunos.setContador(listaAlunos.getPrimeiro());
			return true;
		}
		listaAlunos.setContador(listaAlunos.getContador().getProximo());
		return checkIdAlunos(id, listaAlunos);
	}

	public static boolean checkIdDisciplinas(int id, ListaDupla<Disciplina> listaDisciplinas) {
		if (listaDisciplinas.getQtdNo() == 0) {
			return false;
		}
		if (listaDisciplinas.getContador() == null) {
			listaDisciplinas.setContador(listaDisciplinas.getPrimeiro());
			return false;
		}
		if (listaDisciplinas.getContador().getConteudo().getId() == id) {
			listaDisciplinas.setContador(listaDisciplinas.getPrimeiro());
			return true;
		}
		listaDisciplinas.setContador(listaDisciplinas.getContador().getProximo());
		return checkIdDisciplinas(id, listaDisciplinas);
	}

	public static boolean checkExisteMedia(int idAluno, int idDisciplina, ListaDupla<Media> listaMedias) {
		if (listaMedias.getContador() == null) {
			listaMedias.setContador(listaMedias.getPrimeiro());
			return false;
		} else if (listaMedias.getContador().getConteudo().getIdAluno() == idAluno
				&& listaMedias.getContador().getConteudo().getIdDisciplina() == idDisciplina) {
			listaMedias.setContador(listaMedias.getPrimeiro());
			return true;
		}
		listaMedias.setContador(listaMedias.getContador().getProximo());
		return checkExisteMedia(idAluno, idDisciplina, listaMedias);
	}

	public static Media[] ListaDuplaVetorMedias(ListaDupla<Media> listaMedias, Media [] vetorMedias) {

		if (listaMedias.getContador() == listaMedias.getUltimo()) {
			vetorMedias[listaMedias.getContadorInt()] = listaMedias.getUltimo().getConteudo();
			listaMedias.setContador(listaMedias.getPrimeiro());
			listaMedias.setContadorInt(0);
			return vetorMedias;
		}
		vetorMedias[listaMedias.getContadorInt()] = listaMedias.getContador().getConteudo();
		listaMedias.setContador(listaMedias.getContador().getProximo());
		listaMedias.setContadorInt(listaMedias.getContadorInt() + 1);
		return ListaDuplaVetorMedias(listaMedias, vetorMedias);
	}
	
	public static void mergeSortMedias(Media [] vetorMedias) {
		
		if (vetorMedias.length == 1) return;
		
		int metade = vetorMedias.length / 2;
		Media [] esquerda = new Media[metade];
		Media [] direita = new Media[vetorMedias.length - metade];
		
		// Este for adiciona o conteúdo às duas metades
		for (int i = 0; i < vetorMedias.length; i++) {
			if(i < metade) esquerda[i] = vetorMedias[i];
			else direita[i - metade] = vetorMedias[i];
		}
		
		// Divisão dos vetores até 1:
		mergeSortMedias(esquerda);
		mergeSortMedias(direita);
		
		// Chama a intercalação
		intercalarMedias(esquerda, direita, vetorMedias);
	}

	public static void intercalarMedias(Media[] esquerda, Media[] direita, Media[] resultado) {
		// TODO Auto-generated method stub
		int indiceEsq = 0, indiceDir = 0;
		
		for (int k = 0; k < resultado.length; k++) {
			if (indiceEsq == esquerda.length) {
				resultado[k] = direita[indiceDir];
				indiceDir++;
			}else if(indiceDir == direita.length) {
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
			}else if(esquerda[indiceEsq].getMediaFinal() < direita[indiceDir].getMediaFinal()) {
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
			}else {
				resultado[k] = direita[indiceDir];
				indiceDir++;
			}
		}
	}
	
	public static String nomeAlunoPorId(ListaDupla<Aluno> listaAlunos, int id) {
		
		if(listaAlunos.getContador() == null) {
			return "Id inexistente.";
		}else if(listaAlunos.getContador().getConteudo().getId() == id) {
			String retorno = listaAlunos.getContador().getConteudo().getNome();
			listaAlunos.setContador(listaAlunos.getPrimeiro());
			return retorno;
		}
		listaAlunos.setContador(listaAlunos.getContador().getProximo());
		return nomeAlunoPorId(listaAlunos, id);
	}
	
	public static String nomeDisciplinaPorId(ListaDupla<Disciplina> listaDisciplinas, int id) {
		
		if(listaDisciplinas.getContador() == null) {
			return "Id inexistente.";
		}else if(listaDisciplinas.getContador().getConteudo().getId() == id) {
			String retorno = listaDisciplinas.getContador().getConteudo().getNome();
			listaDisciplinas.setContador(listaDisciplinas.getPrimeiro());
			return retorno;
		}
		listaDisciplinas.setContador(listaDisciplinas.getContador().getProximo());
		return nomeDisciplinaPorId(listaDisciplinas, id);
	}
	
	public static String vetorMediasPrint(Media[] vetorMedias, ListaDupla<Aluno> listaAlunos, ListaDupla<Disciplina> listaDisciplinas) {
		
		String texto = "Vetor de médias:\n\n";
		
		for (int i = 0; i < vetorMedias.length; i++) {
			texto += "Aluno: " + nomeAlunoPorId(listaAlunos, vetorMedias[i].getIdAluno())
				  + "\t\tDisciplina: " + nomeDisciplinaPorId(listaDisciplinas, vetorMedias[i].getIdDisciplina())
				  + "\nMédia: " + vetorMedias[i].getMediaFinal() + "\n\n";
		}
		return texto;
	}
	
	public static String alunosReprovados(Media[] vetorMedias, ListaDupla<Aluno> listaAlunos, ListaDupla<Disciplina> listaDisciplinas) {
		
		String texto = "Alunos reprovados:\n\n";

		for (int i = 0; i < vetorMedias.length; i++) {
			if (vetorMedias[i].getMediaFinal() < 6) {
				texto += "Aluno: " + nomeAlunoPorId(listaAlunos, vetorMedias[i].getIdAluno())
				+ "\t\tDisciplina: " + nomeDisciplinaPorId(listaDisciplinas, vetorMedias[i].getIdDisciplina())
				+ "\nMédia: " + vetorMedias[i].getMediaFinal() + "\n\n";
			}
		}
		return texto;
	}
	
	public static String alunosAprovados(Media[] vetorMedias, ListaDupla<Aluno> listaAlunos, ListaDupla<Disciplina> listaDisciplinas) {
		
		String texto = "Alunos aprovados:\n\n";
		
		for (int i = 0; i < vetorMedias.length; i++) {
			if (vetorMedias[i].getMediaFinal() >= 6) {
				texto += "Aluno: " + nomeAlunoPorId(listaAlunos, vetorMedias[i].getIdAluno())
				+ "\t\tDisciplina: " + nomeDisciplinaPorId(listaDisciplinas, vetorMedias[i].getIdDisciplina())
				+ "\nMédia: " + vetorMedias[i].getMediaFinal() + "\n\n";
			}
		}
		return texto;
	}
}
