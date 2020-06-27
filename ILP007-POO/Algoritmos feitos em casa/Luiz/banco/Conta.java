package banco;

import java.util.Date;

public class Conta {

	private Double saldo;
	private String numero;
	private String senha;
	private Transacao[] historico;
	
	public boolean efetuarSque(Double valor) {
		return false;
	}
	
	public boolean efetuarDeposito(Double valor){
		return false;
	}
	
	public boolean efetuarPagamento(String boleto, Double valor) {
		return false;
	}
	
	public Transacao[] extrato (Date inicio, Date fim) {
		return null;
	}
	
	
}
