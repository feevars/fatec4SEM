package controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.dao.AdminExercicioDao;
import model.dao.implementation.AdminExercicioDaoImpl;
import model.entities.Exercicio;

public class ExercicioController {
	

	private AdminExercicioDao administradorExercicioDao = new AdminExercicioDaoImpl();

	private Validator validator;
	
	public ExercicioController(){
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
	
	public void cadastrarExercicio(Exercicio exercicio){
		Set<ConstraintViolation<Exercicio>> erros = validator.validate(exercicio);
		if(erros.isEmpty()){

			administradorExercicioDao.cadastrarExercicio(exercicio);

			alert(AlertType.INFORMATION, " FreeTech ", null, " Exercicio cadastrado com sucesso!");
		}
		else {
			String msgErros = "Erros: \n";
			for (ConstraintViolation<Exercicio> erro: erros) {
				msgErros+= erro.getPropertyPath() + " - " + erro.getMessage() + "\n";
			}
			alert(AlertType.ERROR,"FreeTech", "Não foi possivel cadastrar Administrador", msgErros);
		}
	}
	
	public Boolean excluirExercicio(Integer idExercicio){

		if(administradorExercicioDao.excluirExercicio(idExercicio)) { 

			return true;
		}
		return false;
	}
	
	public Boolean editarExercicio(Exercicio exercicio) {
		return administradorExercicioDao.editarExercicio(exercicio);
	}
	
	//falta fazer o método na DAO
	public void carregaListaExerciciosAula (Integer idAula) {
		administradorExercicioDao.getListaExercicios(idAula);
	}
	
	public ObservableList<Exercicio> listarExerciciosAula(Integer idAula){
		carregaListaExerciciosAula(idAula);
		return null;
	}
	
	public Exercicio getExercicioPorId(Integer id) {
		return administradorExercicioDao.getExercicioPorId(id);
	}
}
