package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTable;

public class TabelaConvidados extends JPanel {
	
	private String [] colunas = {"Nome", "Sobrenome", "E-mail", "Telefone", "Data de Nascimento", "Vegano", "Vegetariano", "Outro(s)", "Acessibilidade", "Observações", "Lote"};
	private JTable tabelaConvidados;
	
	public TabelaConvidados() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.DARK_GRAY);
		
		tabelaConvidados  = new JTable();
		
		GridBagConstraints gc = new GridBagConstraints();

		//Linha 0 e 1: nome e sobrenome
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.LINE_START;
		add(tabelaConvidados, gc);
	}

}
