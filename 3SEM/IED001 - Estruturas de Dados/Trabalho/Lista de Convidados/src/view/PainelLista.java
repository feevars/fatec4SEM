package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.ListaDupla;

public class PainelLista<T> extends JPanel{
	
	private JTextArea listaView;
	private ListaDupla<T> lista;
	
	public PainelLista() {
		
		setLayout(new GridBagLayout());
		listaView = new JTextArea();
		this.lista = null;

//		setPreferredSize(new Dimension(500,600));
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(listaView, gc);
		
		
	}

	public void setLista(ListaDupla<T> lista) {
		this.lista = lista;
	}
	
	
}
