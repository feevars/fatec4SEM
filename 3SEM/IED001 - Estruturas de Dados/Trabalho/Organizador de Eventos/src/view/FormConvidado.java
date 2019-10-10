package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class FormConvidado extends JPanel {

	private JLabel labelNome;
	private JTextField campoNome;

	private JLabel labelSobrenome;
	private JTextField campoSobrenome;

	private JLabel labelEmail;
	private JTextField campoEmail;

	private JLabel labelTelefone;
	private JTextField campoTelefone;

	private JLabel labelNascimento;
	private JTextField campoNascimento;

	private JLabel labelAlimentar;
	private JCheckBox checkVegano;
	private JCheckBox checkVegetariano;
	private JCheckBox checkOutros;

	private JCheckBox checkAcessibilidade;

	private JLabel labelObservacoes;
	private JTextArea areaObservacoes;

	private JButton btnCancelar;
	private JButton btnSalvar;

	private Font fonte = new Font("Courier New", Font.BOLD, 14);


	private JTextField estiloCampo(JTextField campo) {
		campo.setFont(fonte);
		campo.setBackground(Color.white);
		campo.setForeground(Color.DARK_GRAY.brighter());
		campo.setBorder(BorderFactory.createCompoundBorder(
				new CustomeBorder(), 
				new EmptyBorder(new Insets(5, 10, 5, 10))));
		return campo;
	}

	public FormConvidado() {

		labelNome = new JLabel("Nome: ");
		campoNome = new JTextField(15);
		estiloCampo(campoNome);

		labelSobrenome = new JLabel("Sobrenome: ");
		campoSobrenome = new JTextField(45);
		estiloCampo(campoSobrenome);

		labelEmail = new JLabel("Email: ");
		campoEmail = new JTextField(45);
		estiloCampo(campoEmail);

		labelTelefone = new JLabel("Telefone: ");
		campoTelefone = new JTextField(35);
		estiloCampo(campoTelefone);

		labelNascimento = new JLabel("Data de Nascimento: ");
		campoNascimento = new JTextField(10);	
		estiloCampo(campoNascimento);	

		labelAlimentar = new JLabel("Modelo alimentar: ");
		checkVegano = new JCheckBox("Vegano");
		checkVegetariano = new JCheckBox("Vegetariano");
		checkOutros = new JCheckBox("Outro(s)");

		checkAcessibilidade = new JCheckBox("Necessita de recursos de acessibilidade?");

		labelObservacoes = new JLabel("Observações: ");
		areaObservacoes = new JTextArea();

		btnCancelar = new JButton("Cancelar");
		btnSalvar = new JButton("Salvar");

		Border margem = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder("Adicionar Convidado");
		bordaTitulo.setTitleColor(new Color(66,66,66));
		bordaTitulo.setTitleFont(fonte);
		setBorder(BorderFactory.createCompoundBorder(margem, bordaTitulo));

		setBackground(new Color(255,180,0));
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		//Linha 0 e 1: nome e sobrenome
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.LINE_START;
		
		gc.gridwidth = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0.5;
		gc.weighty = 0.05;
		gc.insets = new Insets(0,6,0,0);
		add(labelNome, gc);

		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.075;
		gc.insets = new Insets(0,0,0,0);
		add(campoNome, gc);
		

		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 0.5;
		gc.weighty = 0.05;
		gc.insets = new Insets(0,6,0,0);
		add(labelSobrenome, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.075;
		gc.insets = new Insets(0,0,0,0);
		add(campoSobrenome, gc);

		//Linha 2 e 3: email
		
		gc.weighty = 0.05;
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.gridwidth = 3;
		gc.insets = new Insets(0,6,0,0);
		add(labelEmail, gc);
		
		gc.weighty = 0.075;
		
		gc.weightx = 1;
		gc.gridy = 3;
		gc.insets = new Insets(0,0,0,0);
		add(campoEmail, gc);

		//Linha 4 e 5: telefone
		
		gc.weighty = 0.05;
		
		gc.gridx = 0;
		gc.gridy = 4;
		gc.insets = new Insets(0,6,0,0);
		add(labelTelefone, gc);
		
		gc.weighty = 0.075;

		gc.gridy = 5;
		gc.insets = new Insets(0,0,0,0);
		add(campoTelefone, gc);

		//Linha 6 e 7: nascimento
		
		gc.weighty = 0.05;

		gc.gridx = 0;
		gc.gridy = 6;
		gc.insets = new Insets(0,6,0,0);
		add(labelNascimento, gc);
		
		gc.weighty = 0.075;
		
		gc.gridy = 7;
		gc.insets = new Insets(0,0,0,0);
		add(campoNascimento, gc);

		//Linha 8 e 9: modelo alimentar
		
		gc.weighty = 0.05;
		
		gc.gridx = 0;
		gc.gridy = 8;
		gc.insets = new Insets(0,6,0,0);
		add(labelAlimentar, gc);
		
		gc.weighty = 0.075;
		
		gc.weightx = 0.33;
		gc.gridy = 9;
		gc.gridwidth = 1;
		gc.insets = new Insets(0,0,0,0);
		add(checkVegano, gc);

		gc.gridx = 1;
		add(checkVegetariano, gc);

		gc.gridx = 2;
		add(checkOutros, gc);

		//Linha 10: acessibilidade
		gc.weightx = 9;
		gc.gridx = 0;
		gc.gridy = 10;
		gc.gridwidth = 3;
		gc.insets = new Insets(0,0,0,0);
		add(checkAcessibilidade, gc);

		//Linha 11 e 12: observações

		gc.gridx = 0;
		gc.gridy = 11;
		gc.insets = new Insets(0,6,0,0);
		add(labelObservacoes, gc);
		
		gc.gridy = 12;
		gc.weighty = 0.3;
		gc.insets = new Insets(0,6,0,6);
		add(areaObservacoes, gc);
		
		//Linha 13: botões
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridy = 13;
		
		gc.gridwidth = 1;
		gc.gridx = 1;
		add(btnCancelar, gc);
		gc.gridx = 2;
		add(btnSalvar, gc);		

	}


}

@SuppressWarnings("serial")
class CustomeBorder extends AbstractBorder{
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y,
			int width, int height) {
		super.paintBorder(c, g, x, y, width, height);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(12));
		g2d.setColor(new Color (255,180,0));
		g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
	}   
}