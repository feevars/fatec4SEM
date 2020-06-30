package model.entities;

import java.sql.Date;
import java.util.Set;

public class Instrutor extends Estudante {

	private Boolean autor;
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
	
	public Instrutor(Integer id) {
		super(id);
	};

	public Instrutor(int id, String username, String nome, String sobrenome, Set<Curso> cursosCriados) {
		super(id, username, nome, sobrenome);
		this.cursosCriados = cursosCriados;
	}

	public Instrutor(int id, String username, String nome, String sobrenome) {
		super(id, username, nome, sobrenome);
	}

	public Set<Curso> getCursosCriados() {
		return cursosCriados;
	}

	public void setCursosCriados(Set<Curso> cursosCriados) {
		this.cursosCriados = cursosCriados;
	}
	
	public String getNomeDoObjeto() {
		return "Instrutor";
	}

	public Boolean isAutor() {
		return autor;
	}

	public void setAutor(Boolean autor) {
		this.autor = autor;
	}
	
	
	
}
