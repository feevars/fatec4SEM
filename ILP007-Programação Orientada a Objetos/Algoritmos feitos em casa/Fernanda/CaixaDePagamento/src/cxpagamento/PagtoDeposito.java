package cxpagamento;

public class PagtoDeposito extends FormaDePagamento  {

	@Override
	public String imprimePagamento(Double valor) {
		return "Pago R$" + valor + " em depósito bancário.";		
	}
}
