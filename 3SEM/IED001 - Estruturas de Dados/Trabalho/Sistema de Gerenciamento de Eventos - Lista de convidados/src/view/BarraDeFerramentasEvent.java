package view;

import java.util.EventObject;

import model.Convidado;

public class BarraDeFerramentasEvent extends EventObject {
	
	private static final long serialVersionUID = 5747359313303500451L;
	private String acao;
	
	public BarraDeFerramentasEvent(Object source, String acao) {
		super(source);
		this.acao = acao;
	}
	
	public String getAcao() {
		return acao;
	}
}
