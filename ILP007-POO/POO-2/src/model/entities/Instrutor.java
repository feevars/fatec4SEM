package model.entities;

import java.sql.Date;
import java.util.Set;

public class Instrutor extends Estudante {

	private Set<Curso> cursosCriados;
	
	public Instrutor(Integer id, String username, String password, String nome, String sobrenome, String email,
			String telefone, Date dataNascimento, Integer pontos, Set<Curso> cursosConcluidos) {
		super(id, username, password, nome, sobrenome, email, telefone, dataNascimento, pontos, cursosConcluidos);
		// TODO Auto-generated constructor stub
	}
	
	public Instrutor(Integer id, String username, String nome, String sobrenome, String email, String telefone,
			Date dataNascimento, Integer pontos) {
		super(id, username, nome, sobrenome, email, telefone, dataNascimento, pontos);

	}

	public Set<Curso> getCursosCriados() {
		return cursosCriados;
	}

	public void setCursosCriados(Set<Curso> cursosCriados) {
		this.cursosCriados = cursosCriados;
	}
	
}
