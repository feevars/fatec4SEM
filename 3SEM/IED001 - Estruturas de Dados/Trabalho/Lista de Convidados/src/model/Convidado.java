package model;

import java.sql.Timestamp;
import java.util.Date;

public class Convidado {

	//Variáveis de um Convidado
	private int id;
	private String nome;
	private String sobreNome;
	private String email;
	private String telefone;
	private String docTipo;
	private String docNum;
	private Date nascimento;
	private boolean vegano;
	private boolean vegetariano;
	private boolean onivoro;
	private boolean outros;
	private boolean acessibilidade;
	private String observacoes;
	private String lote;
	private Timestamp adicao;

	//Construtor do Convidado
	public Convidado(int id,
			String nome,
			String sobreNome,
			String email,
			String telefone,
			String docTipo,
			String docNum,
			Date nascimento,
			boolean vegano,
			boolean vegetariano,
			boolean onivoro,
			boolean outros,
			boolean acessibilidade,
			String observacoes,
			String lote) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.telefone = telefone;
		this.docTipo = docTipo;
		this.docNum = docNum;
		this.nascimento = nascimento;
		this.vegano = vegano;
		this.vegetariano = vegetariano;
		this.onivoro = onivoro;
		this.outros = outros;
		this.acessibilidade = acessibilidade;
		this.observacoes = observacoes;
		this.lote = lote;

		//O momento de adição é automático
		Date data= new Date();
		long hora = data.getTime();
		this.adicao = new Timestamp(hora);
	}

	//GETTERS & SETTERS – Bastante, não?
	//Só não tem método SET para ID e para data de Adição

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
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

	public String getDocTipo() {
		return docTipo;
	}

	public void setDocTipo(String docTipo) {
		this.docTipo = docTipo;
	}

	public String getDocNum() {
		return docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	public boolean isVegetariano() {
		return vegetariano;
	}

	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}

	public boolean isOnivoro() {
		return onivoro;
	}

	public void setOnivoro(boolean onivoro) {
		this.onivoro = onivoro;
	}

	public boolean isOutros() {
		return outros;
	}

	public void setOutros(boolean outros) {
		this.outros = outros;
	}

	public boolean isAcessibilidade() {
		return acessibilidade;
	}

	public void setAcessibilidade(boolean acessibilidade) {
		this.acessibilidade = acessibilidade;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public int getId() {
		return id;
	}

	public Timestamp getAdicao() {
		return adicao;
	}
	
	public String simNao(boolean alt) {
		if(alt) return "S";
		else return "N";
	}

	@Override
	public String toString() {
		return "ID: " + id +
				"\nNome: " + nome +
				"\nSobrenome: " + sobreNome +
				"\nEmail: " + email +
				"\nTelefone: " + telefone +
				"\nTipo de documento: " + docTipo +
				"\nNúmero do documento: " + docNum +
				"\nData de nascimento: " + nascimento +
				"\nModelo alimentar:" +
				"\nVegano: " + simNao(vegano) +
				"   Vegetariano: " + simNao(vegetariano) +
				"   Onívoro: " + simNao(onivoro) +
				"   Outros: " + simNao(outros) +
				"\nObservacoes: " + observacoes +
				"\nNecessita de recursos de acessibilidade: " + simNao(acessibilidade) +
				"\nLote: " + lote +
				"\nAdicionado em: " + adicao + "\n";
	}
	
	
	
}
