import java.util.List;

public class Aeroporto {

	private String nomeAeroporto;
	private String siglaAeroporto;
	private String cidadeAeroporto;
	private List<Aeronave> aeronavesParadas;
	private Boolean aberto;
	
	public Aeroporto(String nomeAeroporto, String siglaAeroporto, String cidadeAeroporto, Boolean aberto) {
		this.nomeAeroporto = nomeAeroporto;
		this.siglaAeroporto = siglaAeroporto;
		this.cidadeAeroporto = cidadeAeroporto;
		this.aberto = aberto;
	}

	public String getNomeAeroporto() {
		return nomeAeroporto;
	}

	public void setNomeAeroporto(String nomeAeroporto) {
		this.nomeAeroporto = nomeAeroporto;
	}

	public String getSiglaAeroporto() {
		return siglaAeroporto;
	}

	public void setSiglaAeroporto(String siglaAeroporto) {
		this.siglaAeroporto = siglaAeroporto;
	}

	public String getCidadeAeroporto() {
		return cidadeAeroporto;
	}

	public void setCidadeAeroporto(String cidadeAeroporto) {
		this.cidadeAeroporto = cidadeAeroporto;
	}

	public List<Aeronave> getAeronavesParadas() {
		return aeronavesParadas;
	}

	public void setAeronavesParadas(List<Aeronave> aeronavesParadas) {
		this.aeronavesParadas = aeronavesParadas;
	}

	public Boolean getAberto() {
		return aberto;
	}

	public void setAberto(Boolean aberto) {
		this.aberto = aberto;
	}

	public void liberarVoo (Aeronave aeronave) {
		System.out.println(aeronave.getModelo() + " esta saindo do aeroporto ");
	}
}
