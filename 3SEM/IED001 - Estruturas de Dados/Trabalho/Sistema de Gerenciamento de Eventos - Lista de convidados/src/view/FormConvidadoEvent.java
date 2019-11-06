package view;

import java.util.EventObject;

import controller.ListaDupla;
import model.Convidado;

public class FormConvidadoEvent extends EventObject {
	
	private static final long serialVersionUID = -5226641638070226545L;
	
	private String listaImpressa;
	private Convidado[] vetorNos;

	public FormConvidadoEvent(Object source) {
		super(source);	
	}
//	public EventoFormConvidado(Object source, String lista) {
//		super(source);
//		this.setLista(lista);
//	}
	
	public FormConvidadoEvent(Object source, Convidado convidado) {
		super(source);
//		this.setVetor(lista);
	}
	
//	public Convidado[] getVetor() {
//		return vetorNos;
//	}
//	
//	private void setVetor(ListaDupla<Convidado> lista) {
//		this.vetorNos = lista.vetorConvidados();
//	}
//	
//	public String getListaImpressa() {
//		return listaImpressa;
//	}
//
//	public void setLista(String listaImpressa) {
//		this.listaImpressa = listaImpressa;
//	}	
}
