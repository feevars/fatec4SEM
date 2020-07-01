package controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.EstudanteDao;
import model.dao.implementation.EstudanteDaoImpl;
import model.entities.Curso;
import model.entities.Estudante;

public class EstudanteController {
	private EstudanteDao estudanteDao = new EstudanteDaoImpl();
	private Validator validator;
	private ObservableList<Curso> olistaCursos = FXCollections.observableArrayList();;

	public EstudanteController() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public Integer cadastrarEstudante(Estudante estudante) {
		Integer valida;
		Set<ConstraintViolation<Estudante>> erros = validator.validate(estudante);
		if (erros.isEmpty()) {
			valida = estudanteDao.validaCadastroEstudante(estudante);
			if (valida != 0)
				return valida;
			estudanteDao.estudanteCadastro(estudante);
			return 0;
		} else {
			return 4;
		}
	}
	
	public Boolean estudanteEditarPerfil(Estudante estudante, Boolean eInstrutor) {
		return estudanteDao.estudanteEditarPerfil(estudante, eInstrutor);
	}
	
	public Boolean estudanteExcluirPerfil(Integer id) {
		return estudanteDao.estudanteExcluirPerfil(id);
	}

	public Boolean estudanteLogin(String username, String email, String password) {
		return estudanteDao.estudanteLogin(username, email, password);
	}

	public Estudante getEstudantePorId(Integer id) {
		return estudanteDao.getEstudantePorId(id);
	}
	
	public Estudante getEstudantePorUsername(String username) {
		return estudanteDao.getEstudantePorUsername(username);
	}
	
	public ObservableList<Curso> listarTodosCursos(Integer estudanteId) {
		Set<Curso> listaCursos = estudanteDao.listarTodosCursos(estudanteId);
		
		for (Curso curso : listaCursos) {
			curso.setPontosEstudante(estudanteDao.pontosNoCurso(estudanteId, curso.getId()));
			curso.setConcluidoPeloEstudante(estudanteDao.cursoConcluido(estudanteId, curso.getId()));
		}
		
		olistaCursos.addAll(listaCursos);
		return olistaCursos;
	}

	

}