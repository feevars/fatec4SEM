package Funcionario;

import java.util.Date;

public class Funcionario {

	//Propriedades ------------------
	private long	id;
	private String	nome;
	private String	matricula;
	private Date	admissao;
	private Date	demissao;
	private float   salario;
	private String	horario;
	
	
	//METODOS -----------------------
	
	//Metodo construtor
	public Funcionario(int id, String nome, String matricula, Date admiissao, Date demissao, float salario, String horario) {
		this.setId(id);
		this.setNome(nome);
		this.setMatricula(matricula);
		this.setAdmissao(demissao);
		this.setDemissao(demissao);
		this.setSalario(salario);
		this.setHorario(horario);
	}
	
	
	//Getters and Setters -----------
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public Date getAdmissao() {
		return admissao;
	}
	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}
	
	public Date getDemissao() {
		return demissao;
	}
	public void setDemissao(Date demissao) {
		this.demissao = demissao;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	public void exibir() {
		System.out.println(
				"ID: " + this.getId() +  "\nNOME: " + this.getNome() + "\nMATRICULA: " + this.getMatricula() + 
				"\nADMINISSAO: " + this.getAdmissao() + "\nDEMISSAO: " + this.getDemissao() + "\nSALARIO: " + this.getSalario() + 
				"\nHORARIO: " + this.getHorario());
	}
	
	
	
}
