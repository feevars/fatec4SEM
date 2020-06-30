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

	private EstudanteDao usuarioDao = new EstudanteDaoImpl();
	private Validator validator;
	
	public EstudanteController(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
		
	public Integer cadastrarEstudante(Estudante estudante){
		Integer valida;
		Set<ConstraintViolation<Estudante>> erros = validator.validate(estudante);
		if(erros.isEmpty()){
			valida = usuarioDao.validaCadastroEstudante(estudante);
			if(valida != 0) return valida;
			usuarioDao.estudanteCadastro(estudante);
			return 0;
		}else {
			return 4;
		}
	}	
}