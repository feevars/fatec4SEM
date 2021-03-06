package controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.bind.Validator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.dao.AdminEstudanteDao;
import model.dao.AdministradorDao;
import model.dao.CursoDao;
import model.dao.implementation.AdminEstudanteDaoImpl;
import model.dao.implementation.AdminstradorDaoImpl;
import model.dao.implementation.CursoDaoImpl;
import model.entities.Administrador;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Estudante;
import model.entities.Instrutor;

public class AdministradorController {

	private AdministradorDao administradorDao = new AdminstradorDaoImpl();
	private AdminEstudanteDao adminEstudanteDao = new AdminEstudanteDaoImpl();
	private CursoDao adminCursoDao = new CursoDaoImpl();
	private ObservableList<Estudante> listaUsuarios = FXCollections.observableArrayList();
	private ObservableList<Instrutor> listaTodosInstrutores = FXCollections.observableArrayList();
	private ObservableList<Instrutor> autoresCurso = FXCollections.observableArrayList();
	private ObservableList<Aula> listaAulasCurso = FXCollections.observableArrayList();
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
	
	public void carregaListaInstrutoreCurso(Integer cursoId) {
		
	}
	

	public ObservableList<Instrutor> listarTodosInstrutores() {
		listaTodosInstrutores.addAll(adminCursoDao.listarInstrutores());
		return listaTodosInstrutores;
	}

	public ObservableList<Instrutor> listaInstrutoresCurso(Integer cursoId) {
		listaTodosInstrutores.addAll(adminCursoDao.listarInstrutores());
		listaTodosInstrutores.setAll(adminCursoDao.listarInstrutoresPorCurso(cursoId));
		return autoresCurso;
	}
	
	public Set<Instrutor> getListInstrutorCurso(Integer cursoId){
		return adminCursoDao.listarInstrutoresPorCurso(cursoId);
	}
	
	public Boolean autorDoCurso(Integer instrutorId, Integer cursoId) {
		return adminCursoDao.verificaAutoria(instrutorId, cursoId);
	}
	
	public void carregaListaAulasCurso(Integer cursoId) {
		this.listaAulasCurso.addAll(adminCursoDao.listarAulasCurso(cursoId));
	}
	
	public ObservableList<Aula> listarAulasCurso(Integer cursoId){
		carregaListaAulasCurso(cursoId);
		return listaAulasCurso;
	}


}