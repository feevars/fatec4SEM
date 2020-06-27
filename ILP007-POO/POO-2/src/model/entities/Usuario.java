package model.entities;

import java.util.Date;
import java.util.Set;

public abstract class Usuario {

	protected Integer id;
	protected String username;
	protected String nome;
	protected String sobrenome;
	protected String email;
	protected String telefone;
	protected Date dataNascimento;
	protected Integer pontos;
	protected Set<Curso> cursosConcluidos;
	
	
	public Usuario(Integer id, String username, String nome, String sobrenome, String email, String telefone,
			Date dataNascimento, Integer pontos, Set<Curso> cursosConcluidos) {
		super();
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.pontos = pontos;
		this.cursosConcluidos = cursosConcluidos;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Integer getId() {
		return id;
	}


	public Integer getPontos() {
		return pontos;
	}


	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}


	public Set<Curso> getCursosConcluidos() {
		return cursosConcluidos;
	}


	public void setCursosConcluidos(Set<Curso> cursosConcluidos) {
		this.cursosConcluidos = cursosConcluidos;
	}
}
