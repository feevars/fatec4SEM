package model.dao;

import model.entities.Administrador;

public interface AdministradorDao {

	void cadastrar(Administrador administrador);
	boolean logar(String username, String password);
}
