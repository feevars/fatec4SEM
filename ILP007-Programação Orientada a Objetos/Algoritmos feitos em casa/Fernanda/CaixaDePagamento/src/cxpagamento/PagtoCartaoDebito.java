package cxpagamento;

public class PagtoCartaoDebito extends FormaDePagamento {

	@Override
	public String imprimePagamento(Double valor) {
		return "Pago R$" + valor + " em cartão de débito.";	
		}

}
