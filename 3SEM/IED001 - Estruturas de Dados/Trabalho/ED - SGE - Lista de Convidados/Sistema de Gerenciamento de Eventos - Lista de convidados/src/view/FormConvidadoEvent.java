package view;

import java.util.EventObject;

import model.Convidado;

public class FormConvidadoEvent extends EventObject {
	
	private static final long serialVersionUID = -5226641638070226545L;
	
	public FormConvidadoEvent(Object source, Convidado convidado) {
		super(source);
	}

}
