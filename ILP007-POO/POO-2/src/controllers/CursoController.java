package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.AdminAulaDao;
import model.dao.AdminCursoDao;
import model.dao.implementation.AdminAulaDaoImpl;
import model.dao.implementation.AdminCursoDaoImpl;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Instrutor;

public class CursoController {

	private AdminCursoDao adminCursoDao = new AdminCursoDaoImpl();
	private AdminAulaDao adminAulaDao = new AdminAulaDaoImpl();
	private ObservableList<Aula> listaAulas = FXCollections.observableArrayList();
	
		
	
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
	
	public Boolean cadastrarCurso(Curso curso, Integer[] idsInstrutores){
		Integer idNovoCurso = adminCursoDao.cadastrarCurso(curso);
			if(idNovoCurso != 0){
				System.out.println("Id do curso criado: " + idNovoCurso);
				for (Integer idInstrutor : idsInstrutores) {
					System.out.println("Id curso: " + idNovoCurso + " - Id Instrutor: " + idInstrutor);
					adminCursoDao.cadastrarInstrutorCurso(idNovoCurso, idInstrutor);	
				}
				return true;
			}else {
				System.out.println("Não foi possivel cadastrar Curso!");
			}
		return false;
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
	
	public Boolean cadastrarCursoEPrimeiraAula(Curso curso, Aula aula) {
		Integer cursoId = adminCursoDao.cadastrarCurso(curso);
		System.out.println("curso id :" + cursoId);
		for (Instrutor instrutor : curso.getInstrutores()) {
			System.out.println(adminCursoDao.cadastrarInstrutorCurso(instrutor.getId(), cursoId));
		}

		aula.setCursoId(cursoId);
		adminAulaDao.cadastrarAula(aula, curso.getId());
		return false;
	}
	
	public Boolean adicionarInstrutorCurso(Integer instrutorId, Integer cursoId) {
		Boolean instrutorAdicionado = adminCursoDao.adicionarInstrutorCurso(instrutorId, cursoId);
		if(instrutorAdicionado){
			return true;
		}
		return false;
	}
	
	
	
}
