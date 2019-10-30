package view;

import java.util.EventObject;

public class EventoFormDisciplina extends EventObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String listaImpressa;
	
	public EventoFormDisciplina(Object source, String listaImpressa) {
		super(source);
		this.listaImpressa = listaImpressa;
	}

	public String getListaImpressa() {
		return listaImpressa;
	}
}
