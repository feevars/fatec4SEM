package controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import model.dao.EstudanteDao;
import model.dao.implementation.EstudanteDaoImpl;
import model.entities.Estudante;

public class EstudanteController {

	private EstudanteDao estudanteDao = new EstudanteDaoImpl();
	private Validator validator;

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

	public boolean estudanteLogin(String username, String email, String password) {
		return estudanteDao.estudanteLogin(username, email, password);
	}

	public Estudante getEstudantePorId(Integer id) {
		return estudanteDao.getEstudantePorId(id);
	}
	
	public Estudante getEstudantePorUsername(String username) {
		return estudanteDao.getEstudantePorUsername(username);
	}
	

}