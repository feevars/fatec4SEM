import java.util.Date;

public class Funcionario {
	long id;
	
	String nome;
	String matricula;
	Date admissao;
	Date demissao;
	Float salario;
	String horario;
	
	public void oId(long id) {
		Integer idLong = (int) id;
		this.id = idLong;
	}
	
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", admissao=" + admissao
				+ ", demissao=" + demissao + ", salario=" + salario + ", horario=" + horario + "]";
	}
}
