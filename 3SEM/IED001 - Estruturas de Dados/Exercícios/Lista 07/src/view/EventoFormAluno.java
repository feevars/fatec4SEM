package view;

import java.util.EventObject;

public class EventoFormAluno extends EventObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String listaImpressa;
	
	public EventoFormAluno(Object source, String listaImpressa) {
		super(source);
		this.listaImpressa = listaImpressa;
	}

	public String getListaImpressa() {
		return "Lista de alunos:\n\n" + listaImpressa;
	}
}
