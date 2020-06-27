public class Passageiro {

	private String nome;
	private String documento;
	private Boolean temPassagem;
	private Boolean tembagagem;
	private Boolean suspeito;
	
	public Passageiro(String nome, String documento, Boolean temPassagem, Boolean tembagagem, Boolean suspeito) {
		this.nome = nome;
		this.documento = documento;
		this.temPassagem = temPassagem;
		this.tembagagem = tembagagem;
		this.suspeito = suspeito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Boolean getTemPassagem() {
		return temPassagem;
	}

	public void setDatanasc(Boolean temPassagem) {
		this.temPassagem = temPassagem;
	}

	public Boolean getTembagagem() {
		return tembagagem;
	}

	public void setTembagagem(Boolean tembagagem) {
		this.tembagagem = tembagagem;
	}

	public Boolean getSuspeito() {
		return suspeito;
	}

	public void setSuspeito(Boolean suspeito) {
		this.suspeito = suspeito;
	}

	public void embarcar(Aeronave aeronave) {
		System.out.println("entrando na aeronave");
	}
}
