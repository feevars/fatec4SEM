package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ListaConvidados extends JPanel {
	
	private JList lista;
	
	public ListaConvidados() {
		
		lista = new JList();
		
		DefaultListModel modeloIdade = new DefaultListModel();
		modeloIdade.addElement("Abaixo dos 18 anos.");
		modeloIdade.addElement("Entre 18 e 40.");
		modeloIdade.addElement("Entre 40 e 65.");
		modeloIdade.addElement("Mais de 65.");
		
		lista.setModel(modeloIdade);
		lista.setBorder(BorderFactory.createBevelBorder(WHEN_FOCUSED));
		
		Border margem = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder("Lista de Convidados");
		bordaTitulo.setTitleColor(new Color(255,255,255));
		setBorder(BorderFactory.createCompoundBorder(margem, bordaTitulo));
		
		setLayout(new GridLayout(0,1));
		setBackground(new Color(66,66,66));
		add(lista);
	}
}
