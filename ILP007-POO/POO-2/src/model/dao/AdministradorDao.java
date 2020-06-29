package model.dao;

import java.util.List;
import model.entities.Administrador;
import model.entities.Curso;
import model.entities.Estudante;

public interface AdministradorDao {

	void cadastrarAdmin(Administrador administrador);
	boolean logarAdmin(String username, String password);
	public List<Estudante> listarEstudantes();
	List<Curso> listarCursos();
	Administrador getAdministradorPorId(Integer id);
	Administrador getAdministradorPorUsername(String username);
}
