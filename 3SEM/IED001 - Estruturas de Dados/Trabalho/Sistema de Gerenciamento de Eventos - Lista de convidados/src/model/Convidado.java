package model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Convidado {

	private int id;
	private String nome;
	private String sobreNome;
	private String email;
	private String telefone;
	private Date nascimento;
	private String tipoDocumento;
	private String numDocumento;
	private boolean acessibilidade;
	private boolean vip;
	private int lote;
	private Timestamp adicao;

	public Convidado(
						int id,
						String nome,
						String sobreNome,
						String email,
						String telefone,
						Date nascimento,
						String tipoDocumento,
						String numDocumento,
						boolean acessibilidade,
						boolean vip,
						int lote
					) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.tipoDocumento = tipoDocumento;
		this.numDocumento = numDocumento;
		this.acessibilidade = acessibilidade;
		this.vip = vip;
		this.lote = lote;

		Date data = new Date();
		long hora = data.getTime();
		this.adicao = new Timestamp(hora);
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
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
	
	public int getIdade() {
		
		if(getNascimento() == null) return -1;

		Date dAtual = new Date();
		LocalDate ldAtual = dAtual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate ldNascimento = nascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return Period.between(ldNascimento, ldAtual).getYears();
	}
	
	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public boolean isAcessibilidade() {
		return acessibilidade;
	}

	public void setAcessibilidade(boolean acessibilidade) {
		this.acessibilidade = acessibilidade;
	}

	public int getLote() {
		return lote;
	}

	public int getId() {
		return id;
	}
	
	public void setAdicao(Timestamp adicao) {
		this.adicao = adicao;
	}
	
	public Timestamp getAdicao() {
		return adicao;
	}

	public String getNomeSobrenome() {
		return nome + " " + sobreNome;
	}
	
	@Override
	public String toString() {
		return "convidado"
				+ "\n" + id
				+ "\n" + nome
				+ "\n" + sobreNome
				+ "\n" + email
				+ "\n" + telefone
				+ "\n" + nascimento
				+ "\n" + tipoDocumento
				+ "\n" + numDocumento
				+ "\n" + acessibilidade
				+ "\n" + vip
				+ "\n" + lote
				+ "\n" + adicao
				+ "\n";
	}
}
