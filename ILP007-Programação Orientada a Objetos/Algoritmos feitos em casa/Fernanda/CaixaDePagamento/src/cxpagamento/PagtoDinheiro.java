package cxpagamento;

public class PagtoDinheiro extends FormaDePagamento {

	@Override
	public String imprimePagamento(Double valor) {
		return "Pago R$" + valor + " foram pagos em dinheiro.";
	}
}
