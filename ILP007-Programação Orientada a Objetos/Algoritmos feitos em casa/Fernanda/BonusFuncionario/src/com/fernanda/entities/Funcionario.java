package com.fernanda.entities;

public class Funcionario {
	
	private Long id;
	
	private String name;
	private String matricula;
	private Double salario;
	private Integer faltasNoAno;
	private Float ultimaNotaAvaliacao;
	private Integer qtdPremiosRecebidosAno;
	private Boolean graduado;
	private String nomeFaculdade;
	private String nomeCurso;
	private Double bonus;
	
	public Funcionario(Long id, String name, String matricula, Double salario, Integer faltasNoAno, Float ultimaNotaAvaliacao,
			Integer qtdPremiosRecebidosAno, Boolean graduado, String nomeFaculdade, String nomeCurso) {
		this.id = id;
		this.name = name;
		this.matricula = matricula;
		this.salario = salario;
		this.faltasNoAno = faltasNoAno;
		this.ultimaNotaAvaliacao = ultimaNotaAvaliacao;
		this.qtdPremiosRecebidosAno = qtdPremiosRecebidosAno;
		this.graduado = graduado;
		this.nomeFaculdade = nomeFaculdade;
		this.nomeCurso = nomeCurso;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getFaltasNoAno() {
		return faltasNoAno;
	}

	public void setFaltasNoAno(Integer faltasNoAno) {
		this.faltasNoAno = faltasNoAno;
	}

	public Float getUltimaNotaAvaliacao() {
		return ultimaNotaAvaliacao;
	}

	public void setUltimaNotaAvaliacao(Float ultimaNotaAvaliacao) {
		this.ultimaNotaAvaliacao = ultimaNotaAvaliacao;
	}

	public Integer getQtdPremiosRecebidosAno() {
		return qtdPremiosRecebidosAno;
	}

	public void setQtdPremiosRecebidosAno(Integer qtdPremiosRecebidosAno) {
		this.qtdPremiosRecebidosAno = qtdPremiosRecebidosAno;
	}

	public Boolean getGraduado() {
		return graduado;
	}

	public void setGraduado(Boolean graduado) {
		this.graduado = graduado;
	}

	public String getNomeFaculdade() {
		return nomeFaculdade;
	}

	public void setNomeFaculdade(String nomeFaculdade) {
		this.nomeFaculdade = nomeFaculdade;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Funcionario { \nid=" + id + "\n, name=" + name + "\n, matricula=" + matricula + "\n, salario=" + salario
				+ "\n, faltasNoAno=" + faltasNoAno + "\n, ultimaNotaAvaliacao=" + ultimaNotaAvaliacao
				+ "\n, qtdPremiosRecebidosAno=" + qtdPremiosRecebidosAno + "\n, graduado=" + graduado + "\n, nomeFaculdade="
				+ nomeFaculdade + "\n, nomeCurso=" + nomeCurso + "\n, bonus=" + bonus + "\n}";
	}
	
	
}
