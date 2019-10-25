package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import controller.ListaDupla;
import model.Convidado;

public class FormConvidado extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Variáveis do formulário de convidado
	private static final Color CORFUNDO = new Color(221, 205, 255);

	private JLabel labelNome;
	private JTextField campoNome;

	private JLabel labelSobrenome;
	private JTextField campoSobrenome;

	private JLabel labelEmail;
	private JTextField campoEmail;

	private JLabel labelTelefone;
	private JTextField campoTelefone;

	private JLabel labelNascimento;
	private JFormattedTextField campoNascimento;

	private JLabel labelDoc;
	private JComboBox<String> tipoDoc;
	private JTextField campoDoc;

	private JLabel labelAlimentar;
	private JCheckBox checkVegano;
	private JCheckBox checkVegetariano;
	private JCheckBox checkOnivoro;
	private JCheckBox checkOutros;

	private JCheckBox checkAcessibilidade;

	private JLabel labelObservacoes;
	private JTextArea areaObservacoes;

	private JLabel labelLote;
	private JComboBox<String> listaLote;

	private JButton btnInserePrimeiro;
	private JButton btnInsereUltimo;
	private JButton btnInserePosicao;
	private JButton btnSalvar;

	private Icon checkNao = new ImageIcon("src/assets/checknao.png");
	private Icon checkSim = new ImageIcon("src/assets/checksim.png");;

	private Font fonte = new Font("Trebuchet MS", Font.BOLD, 18);
	private Font fonteLabel = new Font("Trebuchet MS", Font.BOLD, 14);

	// Métodos para estilizar campos
	private JTextField estiloCampo(JTextField campo) {
		campo.setFont(fonte);
		campo.setBackground(Color.white);
		campo.setForeground(Color.DARK_GRAY.brighter());
		campo.setBorder(
				BorderFactory.createCompoundBorder(new CustomeBorder(), new EmptyBorder(new Insets(12, 12, 12, 12))));
		return campo;
	}

	private JTextArea estiloArea(JTextArea area) {
		area.setFont(fonte);
		area.setBackground(Color.white);
		area.setForeground(Color.DARK_GRAY.brighter());
		area.setBorder(
				BorderFactory.createCompoundBorder(new CustomeBorder(), new EmptyBorder(new Insets(12, 12, 12, 12))));
		return area;
	}

	private JLabel estiloLabel(JLabel label) {
		label.setFont(fonteLabel);
		label.setForeground(new Color(90, 90, 90));
		return label;
	}

	private JCheckBox estiloCheckBox(JCheckBox check) {

		check.setFont(fonteLabel);
		check.setForeground(new Color(90, 90, 90));
		check.setIcon(checkNao);
		check.setSelectedIcon(checkSim);
		check.setCursor(new Cursor(Cursor.HAND_CURSOR));

		return check;
	}

	private JButton estiloBotao(JButton botao) {
		botao.setFont(fonteLabel);
		botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

		return botao;
	}

	// Construtor do FormConvidado
	public FormConvidado() {

		labelNome = new JLabel("Nome:");
		estiloLabel(labelNome);
		campoNome = new JTextField(15);
		estiloCampo(campoNome);

		labelSobrenome = new JLabel("Sobrenome:");
		estiloLabel(labelSobrenome);
		campoSobrenome = new JTextField(45);
		estiloCampo(campoSobrenome);

		labelEmail = new JLabel("Email:");
		estiloLabel(labelEmail);
		campoEmail = new JTextField(45);
		estiloCampo(campoEmail);

		labelTelefone = new JLabel("Telefone:");
		estiloLabel(labelTelefone);
		campoTelefone = new JTextField(35);
		estiloCampo(campoTelefone);

		labelNascimento = new JLabel("Data de Nascimento:");
		estiloLabel(labelNascimento);
		campoNascimento = new JFormattedTextField();
		estiloCampo(campoNascimento);
		try {
			MaskFormatter maskNascimento = new MaskFormatter("##/##/####");
			maskNascimento.install(campoNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		labelDoc = new JLabel("Documento (tipo / número):");
		estiloLabel(labelDoc);
		tipoDoc = new JComboBox<String>();
		tipoDoc.addItem("RG");
		tipoDoc.addItem("CPF");
		tipoDoc.addItem("CNH");
		tipoDoc.addItem("Passaporte");
		tipoDoc.addItem("Outro");

		campoDoc = new JTextField(35);
		estiloCampo(campoDoc);

		labelAlimentar = new JLabel("Modelo alimentar:");
		estiloLabel(labelAlimentar);
		checkVegano = new JCheckBox("Vegano");
		estiloCheckBox(checkVegano);
		checkVegetariano = new JCheckBox("Vegetariano");
		estiloCheckBox(checkVegetariano);
		checkOnivoro = new JCheckBox("Onívoro");
		estiloCheckBox(checkOnivoro);
		checkOutros = new JCheckBox("Outro(s)");
		estiloCheckBox(checkOutros);

		checkAcessibilidade = new JCheckBox("Necessita de recursos de acessibilidade?");
		estiloCheckBox(checkAcessibilidade);

		labelObservacoes = new JLabel("Observações:");
		estiloLabel(labelObservacoes);
		areaObservacoes = new JTextArea();
		estiloArea(areaObservacoes);

		labelLote = new JLabel("Lote:");
		estiloLabel(labelLote);
		listaLote = new JComboBox<String>();
		listaLote.addItem("Não definido");
		listaLote.addItem("Lote Promocional");
		listaLote.addItem("1º Lote");
		listaLote.addItem("2º Lote");
		listaLote.addItem("3º Lote");
		listaLote.addItem("Outro Lote");
		listaLote.addItem("Portaria");
		listaLote.addItem("VIP");

		btnSalvar = new JButton("Salvar");
		estiloBotao(btnSalvar);
		btnSalvar.setForeground(Color.GREEN.darker());

		Border margem = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder("Adicionar Convidado");
		bordaTitulo.setTitleColor(new Color(66, 66, 66));
		bordaTitulo.setTitleFont(fonte);
		setBorder(BorderFactory.createCompoundBorder(margem, bordaTitulo));

		setBackground(CORFUNDO);
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// Linha 0: labels de nome e sobrenome
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.insets = new Insets(6, 6, 0, 6);
		gc.weighty = 0.03;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0.4;
		add(labelNome, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 0.6;
		add(labelSobrenome, gc);

		// Linha 1: campos de nome e sobrenome
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 0.4;
		add(campoNome, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 0.6;
		add(campoSobrenome, gc);

		// Linha 2: label email
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridwidth = 2;
		gc.insets = new Insets(6, 6, 0, 6);
		gc.weighty = 0.03;

		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0;
		add(labelEmail, gc);

		// Linha 3: campo email
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.weighty = 0.1;
		gc.gridy = 3;
		add(campoEmail, gc);


		gc.gridwidth = 1;
		// Linha 4: label telefone e nascimento
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.insets = new Insets(6, 6, 0, 6);
		gc.weighty = 0.03;

		gc.gridx = 0;
		gc.gridy = 4;
		add(labelTelefone, gc);

		gc.gridx = 1;
		add(labelNascimento, gc);

		// Linha 5: campo telefone e nascimento
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.weighty = 0.1;
		gc.gridy = 5;
		gc.gridx = 0;
		add(campoTelefone, gc);

		gc.gridx = 1;
		add(campoNascimento, gc);

		// Linha 6: label documento;
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.insets = new Insets(6, 6, 0, 6);
		gc.weighty = 0.03;

		gc.gridx = 0;
		gc.gridy = 6;
		add(labelDoc, gc);

		// Linha 7: tipo do documento e campo
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 7;
		add(tipoDoc, gc);

		gc.gridx = 1;
		add(campoDoc, gc);


		// Linha 8: label modelo alimentar
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.insets = new Insets(6, 6, 0, 6);
		gc.weighty = 0.03;

		gc.gridx = 0;
		gc.gridy = 8;
		add(labelAlimentar, gc);

		// Linha 9: checkboxes alimentar
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.weighty = 0.1;

		gc.gridy = 9;
		gc.gridx = 0;
		add(checkVegano, gc);

		gc.gridx = 1;
		add(checkVegetariano, gc);


		// Linha 10: mais checkboxes
		gc.gridy = 10;
		gc.gridx = 0;
		add(checkOnivoro, gc);

		gc.gridx = 1;
		add(checkOutros, gc);

		// Linha 11: label text area Observações
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridwidth = 2;
		gc.insets = new Insets(6, 6, 0, 6);
		gc.weighty = 0.03;

		gc.gridx = 0;
		gc.gridy = 11;
		add(labelObservacoes, gc);
		
		// Linha 12: textArea observações
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.BOTH;
		gc.weighty = 0.2;
		gc.gridy = 12;
		add(areaObservacoes, gc);
		
		// Linha 13: checkbox acessibilidade
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weighty = 0.1;
		gc.gridy = 13;
		add(checkAcessibilidade, gc);
		
		setPreferredSize(new Dimension(400, 720));


	}

	@SuppressWarnings("serial")
	class CustomeBorder extends AbstractBorder {
		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			super.paintBorder(c, g, x, y, width, height);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(12));
			g2d.setColor(new Color(221, 205, 255));
			g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
		}
	}
}
