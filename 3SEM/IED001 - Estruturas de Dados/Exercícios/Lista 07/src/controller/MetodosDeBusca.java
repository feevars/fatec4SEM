package controller;

import model.Aluno;
import model.Disciplina;
import model.Media;

public interface MetodosDeBusca {

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
}
