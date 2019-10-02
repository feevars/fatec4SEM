import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String nome;
	private String cargo;

	public FormEvent(Object source) {
		super(source);	
	}
	public FormEvent(Object source, String nome, String cargo) {
		super(source);
		this.setNome(nome);
		this.setCargo(cargo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
}
