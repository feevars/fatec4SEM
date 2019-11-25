package model;

import java.util.Date;

import controller.ListaConvidados;

public class Evento {
	
	private String nome;
	private Date dataEvento;
	private int qtdConvites;
	private Date dataLote1;
	private int qtdLote1;
	private double valorLote1;
	private Date dataLote2;
	private int qtdLote2;
	private double valorLote2;
	private Date dataLote3;
	private int qtdLote3;
	private double valorLote3;
	private double valorPortaria;
	private int descontoAniversariante;
	private ListaConvidados listaConvidados;
	private String caminhoDoArquivo;
	
	public Evento(String nome, Date dataEvento, int qtdConvites, Date dataLote1, int qtdLote1, double valorLote1,
			Date dataLote2, int qtdLote2, double valorLote2, Date dataLote3, int qtdLote3, double valorLote3,
			double valorPortaria, int descontoAniversariante, ListaConvidados listaConvidados, String caminhoDoArquivo) {
		super();
		this.nome = nome;
		this.dataEvento = dataEvento;
		this.qtdConvites = qtdConvites;
		this.dataLote1 = dataLote1;
		this.qtdLote1 = qtdLote1;
		this.valorLote1 = valorLote1;
		this.dataLote2 = dataLote2;
		this.qtdLote2 = qtdLote2;
		this.valorLote2 = valorLote2;
		this.dataLote3 = dataLote3;
		this.qtdLote3 = qtdLote3;
		this.valorLote3 = valorLote3;
		this.valorPortaria = valorPortaria;
		this.descontoAniversariante = descontoAniversariante;
		this.listaConvidados = listaConvidados;
		this.caminhoDoArquivo = caminhoDoArquivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public int getQtdConvites() {
		return qtdConvites;
	}

	public void setQtdConvites(int qtdConvites) {
		this.qtdConvites = qtdConvites;
	}

	public Date getDataLote1() {
		return dataLote1;
	}

	public void setDataLote1(Date dataLote1) {
		this.dataLote1 = dataLote1;
	}

	public int getQtdLote1() {
		return qtdLote1;
	}

	public void setQtdLote1(int qtdLote1) {
		this.qtdLote1 = qtdLote1;
	}

	public double getValorLote1() {
		return valorLote1;
	}

	public void setValorLote1(double valorLote1) {
		this.valorLote1 = valorLote1;
	}

	public Date getDataLote2() {
		return dataLote2;
	}

	public void setDataLote2(Date dataLote2) {
		this.dataLote2 = dataLote2;
	}

	public int getQtdLote2() {
		return qtdLote2;
	}

	public void setQtdLote2(int qtdLote2) {
		this.qtdLote2 = qtdLote2;
	}

	public double getValorLote2() {
		return valorLote2;
	}

	public void setValorLote2(double valorLote2) {
		this.valorLote2 = valorLote2;
	}

	public Date getDataLote3() {
		return dataLote3;
	}

	public void setDataLote3(Date dateLote3) {
		this.dataLote3 = dateLote3;
	}

	public int getQtdLote3() {
		return qtdLote3;
	}

	public void setQtdLote3(int qtdLote3) {
		this.qtdLote3 = qtdLote3;
	}

	public double getValorLote3() {
		return valorLote3;
	}

	public void setValorLote3(double valorLote3) {
		this.valorLote3 = valorLote3;
	}

	public double getValorPortaria() {
		return valorPortaria;
	}

	public void setValorPortaria(double valorPortaria) {
		this.valorPortaria = valorPortaria;
	}

	public int getDescontoAniversariante() {
		return descontoAniversariante;
	}

	public void setDescontoAniversariante(int descontoAniversariante) {
		this.descontoAniversariante = descontoAniversariante;
	}

	public ListaConvidados getListaConvidados() {
		return listaConvidados;
	}

	public void setListaConvidados(ListaConvidados listaConvidados) {
		this.listaConvidados = listaConvidados;
	}
	
	public String getCaminhoDoArquivo() {
		return caminhoDoArquivo;
	}
	
	public void setCaminhoDoArquivo(String caminhoDoArquivo) {
		this.caminhoDoArquivo = caminhoDoArquivo;
	}
}
