
public class Aeronave {
	private String modelo;
	private Piloto piloto;
	private String companhia;
	private Passageiro passageiro;
	private Boolean voando;
	
	public Aeronave(String modelo, Piloto piloto, String companhia, Passageiro passageiro, Boolean voando) {
		this.modelo = modelo;
		this.piloto = piloto;
		this.companhia = companhia;
		this.passageiro = passageiro;
		this.voando = voando;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public String getCompanhia() {
		return companhia;
	}

	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Boolean getVoando() {
		return voando;
	}

	public void setVoando(Boolean voando) {
		this.voando = voando;
	}

	public void voar(Piloto piloto) {
		System.out.println("estou voando com o piloto " + piloto.getNome());
	}
	

}
