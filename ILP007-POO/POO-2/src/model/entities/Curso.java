package model.entities;

import java.util.Date;
import java.util.Set;

import org.hibernate.validator.constraints.NotBlank;

public class Curso {

	private Integer id;
	private String nome;
	private String descricao;
	private int totalHoras;
	Set<Aula> aulas;
	private Date dataCriacao;
	private Date dataAtualizacao;

	public Curso() {
		super();
	}

	@NotBlank
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotBlank
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotBlank
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotBlank
	public int getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(int totalHoras) {
		this.totalHoras = totalHoras;
	}

	@NotBlank
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@NotBlank
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	
}
