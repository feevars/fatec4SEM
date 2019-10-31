package view;

import java.util.EventObject;

public class EventoBarraDeFerramentas extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String listaImpressa;
	
	public EventoBarraDeFerramentas(Object source, String listaImpressa) {
		super(source);
		this.listaImpressa = listaImpressa;
	}

	public String getListaImpressa() {
		return listaImpressa;
	}
}
