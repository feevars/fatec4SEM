package model.entities;

import java.util.Date;
import java.util.Set;

public class Curso {

	private Integer id;
	private String nome;
	private String descricao;
	private int totalHoras;
	Set<Aula> aulas;
//	private Date dataCriacao;
//	private Date dataAtualizacao;

	public Curso(Integer id, String nome, String descricao, int totalHoras, Date dataCriacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.totalHoras = totalHoras;
//		this.dataCriacao = dataCriacao;
//		this.setDataAtualizacao(null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(int totalHoras) {
		this.totalHoras = totalHoras;
	}
}
