package model.dao;

import java.util.List;

import model.entities.Estudante;

public interface AdminEstudanteDao {

	public void cadastrarEstudante(Estudante usuario);
	public Boolean editarEstudante(Estudante usuario);
	public Boolean excluirEstudante(Integer id);
	public List<Estudante> listarEstudante();
	public Integer validaCadastroEstudante(Estudante usuario);
}
