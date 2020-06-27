package caixaDePagamento;

public class FormaDePagamentoDinheiro extends FormaDePagamento {

	@Override
	public String imprimePagamento(Double pagamento) {
		return "R$" + pagamento + " FORAM PAGOS EM DINHEIRO";
	}
}
