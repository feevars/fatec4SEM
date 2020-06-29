package model.dao;

import java.util.Set;

import model.entities.Aula;
import model.entities.Curso;

public interface AdminCursoDao {

	void cadastrar(Curso c);
	
	void excluir(Integer id);
	
	boolean editar(Curso c);
	
	Curso pesquisarPorNome(String titulo);
	
	Set<Aula> listarAulasCurso(Integer id);
	Set<Aula> listarAulas();
}
