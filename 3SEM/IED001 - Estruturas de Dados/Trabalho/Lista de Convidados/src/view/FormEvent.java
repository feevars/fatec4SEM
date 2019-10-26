package view;

import java.util.EventObject;

public class FormEvent extends EventObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String listaImpressa;

	public FormEvent(Object source) {
		super(source);	
	}
	public FormEvent(Object source, String lista) {
		super(source);
		this.setLista(lista);
	}

	public String getListaImpressa() {
		return listaImpressa;
	}

	public void setLista(String listaImpressa) {
		this.listaImpressa = listaImpressa;
	}	
}
