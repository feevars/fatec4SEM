package model.dao;

import java.util.List;
import model.entities.Curso;

public interface CursoDao {

	void adicionarCurso(Curso c);
	
	void excluirCurso(Curso c);
	
	void editarCurso(Curso c);
	
	List<Curso> pesquisarPorNome(String nome);
}
