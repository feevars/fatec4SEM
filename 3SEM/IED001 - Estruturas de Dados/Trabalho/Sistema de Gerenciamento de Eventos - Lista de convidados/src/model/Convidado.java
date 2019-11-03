package model;

import java.sql.Timestamp;
import java.util.Date;

public class Convidado {

	private int id;
	private String nome;
	private String sobreNome;
	private String email;
	private String telefone;
	private Date nascimento;
	private boolean aniversariante;
	private boolean acessibilidade;
	private String observacoes;
	private String lote;
	private Timestamp adicao;

	public Convidado(int id, String nome, String sobreNome, String email, String telefone, Date nascimento,
			boolean aniversariante, boolean acessibilidade, String observacoes, String lote) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.aniversariante = aniversariante;
		this.acessibilidade = acessibilidade;
		this.observacoes = observacoes;
		this.lote = lote;

		Date data = new Date();
		long hora = data.getTime();
		this.adicao = new Timestamp(hora);
	}

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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public boolean isAniversariante() {
		return aniversariante;
	}

	public void setAniversariante(boolean aniversariante) {
		this.aniversariante = aniversariante;
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

	@Override
	public String toString() {
		return "Convidado [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", email=" + email
				+ ", telefone=" + telefone + ", nascimento=" + nascimento + ", aniversariante=" + aniversariante
				+ ", acessibilidade=" + acessibilidade + ", observacoes=" + observacoes + ", lote=" + lote + ", adicao="
				+ adicao + "]\n";
	}
}
