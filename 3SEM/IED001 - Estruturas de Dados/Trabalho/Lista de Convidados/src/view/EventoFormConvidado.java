package view;

import java.util.EventObject;

import controller.ListaDupla;
import controller.No;
import model.Convidado;

public class EventoFormConvidado<T> extends EventObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String listaImpressa;
	private No<T> [] vetorNos;

	public EventoFormConvidado(Object source) {
		super(source);	
	}
//	public EventoFormConvidado(Object source, String lista) {
//		super(source);
//		this.setLista(lista);
//	}
	public EventoFormConvidado(Object source, ListaDupla<Convidado> lista) {
		super(source);
		this.setVetor(lista);
	}
	
	public No<T> [] getVetor() {
		return vetorNos;
	}
	
	private void setVetor(ListaDupla<Convidado> lista) {
		this.vetorNos = (No<T>[]) lista.vetorConteudo();
	}
	
	
	public String getListaImpressa() {
		return listaImpressa;
	}

	public void setLista(String listaImpressa) {
		this.listaImpressa = listaImpressa;
	}	
}
