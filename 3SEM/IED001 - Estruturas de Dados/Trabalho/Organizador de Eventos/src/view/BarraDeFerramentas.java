package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BarraDeFerramentas extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnNovo;
	private JButton btnAbrir;
	private JButton btnSalvar;
	
	public BarraDeFerramentas (){
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.DARK_GRAY);
		
		btnNovo = new JButton("Novo");
		btnAbrir = new JButton("Abrir");
		btnSalvar = new JButton("Salvar");
		
		GridBagConstraints gc = new GridBagConstraints();

		//Linha 0 e 1: nome e sobrenome
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.WEST;
		gc.ipady = 10;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(12,6,12,6);
		gc.gridy = 0;
		gc.gridx = 0;
		add(btnNovo, gc);
		gc.gridx = 1;
		add(btnAbrir, gc);
		gc.gridx = 2;
		add(btnSalvar, gc);
	}
	
}
