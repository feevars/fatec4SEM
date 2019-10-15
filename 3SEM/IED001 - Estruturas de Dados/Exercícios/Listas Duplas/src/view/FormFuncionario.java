package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Funcionario;

public class FormFuncionario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labelNome;
	private JTextField campoNome;
	
	private JLabel labelRg;
	private JTextField campoRg;
	
	private JLabel labelCpf;
	private JTextField campoCpf;
	
	private JLabel labelDepartamento;
	private JTextField campoDepartamento;
	
	private JButton btnCancelar;
	private JButton btnSalvar;
	
	
	public FormFuncionario() {
		
		labelNome = new JLabel("Nome:");
		campoNome = new JTextField();
		
		labelRg = new JLabel("RG:");
		campoRg = new JTextField();
		
		labelCpf = new JLabel("CPF:");
		campoCpf = new JTextField();
		
		labelDepartamento = new JLabel();
		campoDepartamento = new JTextField();
		
		btnCancelar = new JButton("Cancelar");
		btnSalvar = new JButton("Salvar");
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.fill = GridBagConstraints.BOTH;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(labelNome, gc);
		
		gc.gridy = 1;
		add(campoNome, gc);
		
		gc.gridy = 2;
		add(labelRg, gc);
		
		gc.gridy = 3;
		add(campoRg, gc);
		
		
	}

	
	

}
