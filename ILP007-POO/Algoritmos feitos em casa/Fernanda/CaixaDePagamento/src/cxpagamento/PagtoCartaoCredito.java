package cxpagamento;

public class PagtoCartaoCredito extends FormaDePagamento {

	@Override
	public String imprimePagamento(Double valor) {
		return "Foi utilizado R$" + valor + " do limite cartão de crédito.";	
		}

}
