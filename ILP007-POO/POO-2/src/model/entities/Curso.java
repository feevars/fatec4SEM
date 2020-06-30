package model.entities;

import java.sql.Date;
import java.util.Set;

public class Curso {

	private Integer id;
	private String titulo;
	private String descricao;
	Set<Instrutor> instrutores;
	Set<Aula> aulas;
	private Date dataCriacao;
	private Date dataAtualizacao;

	public Curso() {

	}
	
	public Curso(Integer id, String titulo, String descricao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public Curso(Integer id, String titulo, String descricao, Set<Instrutor> instrutores, Set<Aula> aulas,
			Date dataCriacao, Date dataAtualizacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.instrutores = instrutores;
		this.aulas = aulas;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
