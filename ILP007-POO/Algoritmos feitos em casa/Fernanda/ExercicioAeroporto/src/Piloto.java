
public class Piloto {

	private String nome;
	private String registroDePiloto;
	private String  cidadeDoPiloto;
	private String  estadoDoPiloto;
	private String  paisDoPiloto;
	
	public Piloto(String nome, String registroDePiloto, String cidadeDoPiloto, String estadoDoPiloto,
			String paisDoPiloto) {
		this.nome = nome;
		this.registroDePiloto = registroDePiloto;
		this.cidadeDoPiloto = cidadeDoPiloto;
		this.estadoDoPiloto = estadoDoPiloto;
		this.paisDoPiloto = paisDoPiloto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegistroDePiloto() {
		return registroDePiloto;
	}

	public void setRegistroDePiloto(String registroDePiloto) {
		this.registroDePiloto = registroDePiloto;
	}

	public String getCidadeDoPiloto() {
		return cidadeDoPiloto;
	}

	public void setCidadeDoPiloto(String cidadeDoPiloto) {
		this.cidadeDoPiloto = cidadeDoPiloto;
	}

	public String getEstadoDoPiloto() {
		return estadoDoPiloto;
	}

	public void setEstadoDoPiloto(String estadoDoPiloto) {
		this.estadoDoPiloto = estadoDoPiloto;
	}

	public String getPaisDoPiloto() {
		return paisDoPiloto;
	}

	public void setPaisDoPiloto(String paisDoPiloto) {
		this.paisDoPiloto = paisDoPiloto;
	}

	public void pilotarAeronave(Aeronave aeronave) {
		System.out.println(nome + " embarcando para conduzir a aeronave");
	}
}
