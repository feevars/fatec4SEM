package controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	
	private void alert(AlertType tipo, String title, String header, String content) {
		Alert alert = new Alert(tipo);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	public void cadastrar(Estudante usuario){
		Set<ConstraintViolation<Estudante>> erros = validator.validate(usuario);
		if(erros.isEmpty()){
			usuarioDao.estudanteCadastro(usuario);;
			alert(AlertType.INFORMATION, " FreeTech ", null, " Usuario " + usuario.getUsername() + " Cadastrado com sucesso!");
		}
		else {
			String msgErros = "Erros: \n";
			for (ConstraintViolation<Estudante> erro: erros) {
				msgErros+= erro.getPropertyPath() + " - " + erro.getMessage() + "\n";
			}
			alert(AlertType.ERROR,"FreeTech", "Não foi possivel cadastrar Usuario", msgErros);
		}
	}
	
	
}
