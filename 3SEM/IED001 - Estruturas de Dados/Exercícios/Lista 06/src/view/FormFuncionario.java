package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Funcionario;

public class FormFuncionario extends JPanel {

	/**
	 * O tal do serial...
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

	private JButton btnSalvar;

	public FormFuncionario() {

		labelNome = new JLabel("Nome:");
		campoNome = new JTextField(20);

		labelRg = new JLabel("Rg:");
		campoRg = new JTextField(10);

		labelCpf = new JLabel("Cpf:");
		campoCpf = new JTextField(14);

		labelDepartamento = new JLabel("Departamento:");
		campoDepartamento = new JTextField(20);

		btnSalvar = new JButton("Salvar");

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Ação do botão...

			}
		});

		Border bordaInterna = BorderFactory.createTitledBorder("Adicionar funcionário");
		Border margem = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// Linha 1, coluna 1
		gc.weightx = 0.4;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(labelNome, gc);

		// Linha 1, coluna 2
		gc.weightx = 0.6;
		gc.gridx = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(campoNome, gc);
		
		//Linha 2, coluna 1
		gc.weightx = 0.4;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(labelRg, gc);

		// Linha 2, coluna 2
		gc.weightx = 0.6;
		gc.gridx = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(campoRg, gc);
	}
}
