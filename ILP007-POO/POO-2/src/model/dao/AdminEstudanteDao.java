package model.dao;

import model.entities.Estudante;

public interface AdminEstudanteDao {

	public void cadastrarEstudante(Estudante usuario);
	public Boolean editarEstudante(Estudante usuario);
	public Boolean excluirEstudante(Integer id);
	public Integer validaCadastroEstudante(Estudante usuario);
}
