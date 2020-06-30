package controllers;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Set;

import model.dao.AdminCursoDao;
import model.dao.AdminEstudanteDao;
import model.dao.AdministradorDao;
import model.dao.implementation.AdminCursoDaoImpl;
import model.dao.implementation.AdminEstudanteDaoImpl;
import model.dao.implementation.AdminstradorDaoImpl;
import model.entities.Administrador;
import model.entities.Curso;
import model.entities.Estudante;
import model.entities.Instrutor;

public class AdministradorController {

	private AdministradorDao administradorDao = new AdminstradorDaoImpl();
	private AdminEstudanteDao adminEstudanteDao = new AdminEstudanteDaoImpl();
	private AdminCursoDao adminCursoDao = new AdminCursoDaoImpl();
	private ObservableList<Estudante> listaUsuarios = FXCollections.observableArrayList();
	private ObservableList<Instrutor> listaTodosInstrutores = FXCollections.observableArrayList();
	private ObservableList<Curso> listaCursos = FXCollections.observableArrayList();
	private Validator validator;

	public AdministradorController() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		carregaListaUsuarios();
		carregaListaCursos();
	}

	private void alert(AlertType tipo, String title, String header, String content) {
		Alert alert = new Alert(tipo);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	public void cadastrar(Administrador administrador) {
		Set<ConstraintViolation<Administrador>> erros = validator.validate(administrador);
		if (erros.isEmpty()) {
			administradorDao.cadastrarAdmin(administrador);
			alert(AlertType.INFORMATION, " FreeTech ", null,
					" Administrador " + administrador.getUsername() + " Cadastrado com sucesso!");
		} else {
			String msgErros = "Erros: \n";
			for (ConstraintViolation<Administrador> erro : erros) {
				msgErros += erro.getPropertyPath() + " - " + erro.getMessage() + "\n";
			}
			alert(AlertType.ERROR, "FreeTech", "Não foi possivel cadastrar Administrador", msgErros);
		}
	}

	public Boolean editarEstudante(Estudante estudante) {
		adminEstudanteDao.editarEstudante(estudante);
		return null;
	}

	public void excluirEstudante(Integer id) {
		adminEstudanteDao.excluirEstudante(id);
	}

	public boolean logarAdmin(String username, String password) {
		if (administradorDao.logarAdmin(username, password)) {
			return true;
		}
		return false;
	}

	public Integer idAdmin(String username) {
		Administrador admin = administradorDao.getAdministradorPorUsername(username);
		return admin.getId();
	}

	public void carregaListaUsuarios() {
		this.listaUsuarios.addAll(administradorDao.listarEstudantes());
	}

	public ObservableList<Estudante> listarTodosEstudantes() {
		return listaUsuarios;
	}

	public void carregaListaCursos() {
		this.listaCursos.addAll(administradorDao.listarCursos());
	}

	public ObservableList<Curso> listarTodosCursos() {
		return listaCursos;
	}

	public ObservableList<Instrutor> listarTodosInstrutores() {
		if (!adminCursoDao.listarInstrutores().isEmpty()) this.listaTodosInstrutores.addAll(adminCursoDao.listarInstrutores());
		return listaTodosInstrutores;
	}

}