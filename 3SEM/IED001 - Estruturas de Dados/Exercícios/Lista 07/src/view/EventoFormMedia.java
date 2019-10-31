package view;

import java.util.EventObject;

public class EventoFormMedia extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String listaImpressa;
	
	public EventoFormMedia(Object source, String listaImpressa) {
		super(source);
		this.listaImpressa = listaImpressa;
	}

	public String getListaImpressa() {
		return "Lista de médias:\n\n" + listaImpressa;
	}
}
