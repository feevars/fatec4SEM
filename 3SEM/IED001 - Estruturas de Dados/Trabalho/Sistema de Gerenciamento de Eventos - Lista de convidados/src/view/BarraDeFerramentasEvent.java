package view;

import java.util.EventObject;

import model.Convidado;

public class BarraDeFerramentasEvent extends EventObject {
	
	private static final long serialVersionUID = 5747359313303500451L;

	public BarraDeFerramentasEvent(Object source, Convidado convidado) {
		super(source);
	}

}
