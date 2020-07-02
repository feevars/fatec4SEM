package controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		
		Set<ConstraintViolation<Estudante>> erros = validator.validate(estudante);
		if (erros.isEmpty()) {
			estudanteDao.estudanteCadastro(estudante);
			alert(AlertType.INFORMATION, " FreeTech ", null,
					" Estudante " + estudante.getUsername() + " Cadastrado com sucesso!");
			return 0;
		} else {
			String msgErros = "Erros: \n";
			for (ConstraintViolation<Estudante> erro : erros) {
				msgErros += erro.getPropertyPath() + " - " + erro.getMessage() + "\n";
			}
			alert(AlertType.ERROR, "FreeTech", "Não foi possivel cadastrar Estudante", msgErros);
			return 4;
		}
	
	}
	
	private void alert(AlertType tipo, String title, String header, String content) {
		Alert alert = new Alert(tipo);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
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

	public Curso getCursoPorId(Integer cursoId) {
		return estudanteDao.getCursoPorId(cursoId);
	}

}