package cxpagamento;

public class PagtoCheque  extends FormaDePagamento  {

	@Override
	public String imprimePagamento(Double valor) {
		return "Pago R$" + valor + " em cheque.";	
		}

}
