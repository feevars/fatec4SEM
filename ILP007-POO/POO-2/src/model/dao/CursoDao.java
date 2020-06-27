package model.dao;

import java.util.List;
import model.entities.Curso;

public interface CursoDao {

	void cadastrar(Curso c);
	
	void excluir(Integer id);
	
	boolean editar(Curso c);
	
	List<Curso> pesquisarPorNome(String nome);
}
