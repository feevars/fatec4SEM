package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.AdminCursoDao;
import model.dao.EstudanteDao;
import model.dao.implementation.AdminCursoDaoImpl;
import model.dao.implementation.EstudanteDaoImpl;
import model.entities.Aula;
import model.entities.Curso;

public class CursoController {

	private AdminCursoDao adminCursoDao = new AdminCursoDaoImpl();
	private EstudanteDao estudanteDao = new EstudanteDaoImpl();
	private ObservableList<Aula> listaAulas = FXCollections.observableArrayList();
	
			//adminCursoDao e estudanteCursoDao têm o mesmo método, mas 
			//de maneira diferente: ao clicar, o adm consegue editar a aula
			//ao clicar, o estudante consegue assistir a aula
	
	public ObservableList<Aula> carregarListaAulasAdmin() {
		//this.listaAulas.addAll(adminCursoDao.listarAulasCurso(id));
		//return (ObservableList<Aula>) adminCursoDao.listarAulasCurso();
		return null;
	}
	
	public ObservableList<Aula> carregarListaAulasEstudante(Integer idCurso) {
		//return (ObservableList<Aula>) estudanteDao.estudanteVerCurso(idCurso);	
		return null;
	}
	
	public ObservableList<Curso> getLista(){
		return null;
	}
	
	public Boolean excluirCurso(Integer idCurso){
		if(adminCursoDao.excluirCurso(idCurso)) { 
			return true;
		}
		return false;
	}
	
	public Boolean editarCurso(Curso curso){
		if(adminCursoDao.editarCurso(curso)) { 
			return true;
		}
		return false;
	}
	
}
