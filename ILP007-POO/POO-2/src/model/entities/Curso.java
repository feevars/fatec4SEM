package model.entities;

import java.util.Set;

public class Curso {

	private Integer id;
	private String titulo;
	private String descricao;
	Set<Instrutor> instrutores;
	Set<Aula> aulas;
	
	public Curso() {
		
	}
	
	public Curso(Integer id, String titulo, String descricao, Set<Instrutor> instrutores, Set<Aula> aulas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.instrutores = instrutores;
		this.aulas = aulas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Instrutor> getInstrutores() {
		return instrutores;
	}

	public void setInstrutores(Set<Instrutor> instrutores) {
		this.instrutores = instrutores;
	}

	public Set<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(Set<Aula> aulas) {
		this.aulas = aulas;
	}

	public Integer getId() {
		return id;
	}
	
}
