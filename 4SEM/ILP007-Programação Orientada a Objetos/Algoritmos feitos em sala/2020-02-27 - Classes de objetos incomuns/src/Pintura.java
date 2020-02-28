import java.util.Date;

public class Pintura extends ObraDeArte{

	String superficie;
	String tinta;
	Double altura;
	Double largura;
	
	public Pintura(String titulo, String descricao, Artista autor, Date dataCriacao, String superficie, String tinta, Double altura, Double largura) {
		super(titulo, descricao, autor, dataCriacao);
		this.superficie = superficie;
		this.tinta = tinta;
		this.altura = altura;
		this.largura = largura;
	}

	public String getSuperficie() {
		return superficie;
	}

	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}

	public String getTinta() {
		return tinta;
	}

	public void setTinta(String tinta) {
		this.tinta = tinta;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}
}
