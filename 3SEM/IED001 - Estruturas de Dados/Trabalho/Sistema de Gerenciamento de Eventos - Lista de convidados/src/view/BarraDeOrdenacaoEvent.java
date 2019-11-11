package view;

import java.util.EventObject;

public class BarraDeOrdenacaoEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private String acao;
	
	public BarraDeOrdenacaoEvent(Object source, String acao) {
		super(source);
		this.acao = acao;
	}
	
	public String getAcao() {
		return acao;
	}

}
