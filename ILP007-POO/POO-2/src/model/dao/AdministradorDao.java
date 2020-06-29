package model.dao;

import java.util.Set;
import model.entities.Administrador;
import model.entities.Curso;
import model.entities.Estudante;

public interface AdministradorDao {

	void cadastrarAdmin(Administrador administrador);
	boolean logarAdmin(String username, String password);
	public Set<Estudante> listarEstudantes();
	Set<Curso> listarCursos();
	Administrador getAdministradorPorId(Integer id);
	Administrador getAdministradorPorUsername(String username);
}
