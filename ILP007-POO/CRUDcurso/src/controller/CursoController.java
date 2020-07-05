package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.CursoDao;
import model.dao.implementation.CursoDaoImpl;
import model.entities.Curso;

public class CursoController {
	private CursoDao cursoDao = new CursoDaoImpl();
	private ObservableList<Curso> cursosOList = FXCollections.observableArrayList();
	
	public Integer cadastrarCurso(Curso curso) {
		return cursoDao.inserir(curso);
	}
	
	public Boolean excluirCurso(String ra) {
		return cursoDao.removerRa(ra);
	}
	
	public Boolean atualizarCurso(Curso curso) {
		return cursoDao.atualizar(curso);
	}
	
	public Curso exibirCurso (String ra) {
		return cursoDao.pesquisarPorRa(ra);
	}
	
	public ObservableList<Curso> listarCursos() {
		for (Curso curso : cursoDao.listarTodosOsCursos()) {
			cursosOList.add(curso);
		}
		return cursosOList;
	}
	
}
