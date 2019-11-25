package view.estatisticas;

import java.util.EventObject;

public class BotoesEstatisticasEvent extends EventObject {
	
	private static final long serialVersionUID = -5226641638070226545L;
	
	private int painel;
	
	public BotoesEstatisticasEvent(Object source, int painel) {
		super(source);
		this.painel = painel;
	}
	
	public int getPainel() {
		return painel;
	}
}