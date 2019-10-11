package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
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

public class FormConvidado<T> extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Color CORFUNDO = new Color(255,180,0);
	
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

	private JLabel labelAlimentar;
	private JCheckBox checkVegano;
	private JCheckBox checkVegetariano;
	private JCheckBox checkOutros;

	private JCheckBox checkAcessibilidade;

	private JLabel labelObservacoes;
	private JTextArea areaObservacoes;

	private JLabel labelLote;
	private JComboBox<String> listaLote;

	private JButton btnLimpar;
	private JButton btnSalvar;
		
	private Icon checkNao = new ImageIcon("src/assets/checknao.png");
	private Icon checkSim = new ImageIcon("src/assets/checksim.png");;

	private Font fonte = new Font("Trebuchet MS", Font.BOLD, 18);
	private Font fonteLabel = new Font("Trebuchet MS", Font.BOLD, 14);

	private JTextField estiloCampo(JTextField campo) {
		campo.setFont(fonte);
		campo.setBackground(Color.white);
		campo.setForeground(Color.DARK_GRAY.brighter());
		campo.setBorder(BorderFactory.createCompoundBorder(
				new CustomeBorder(), 
				new EmptyBorder(new Insets(12, 12, 12, 12))));
		return campo;
	}

	private JTextArea estiloArea(JTextArea area) {
		area.setFont(fonte);
		area.setBackground(Color.white);
		area.setForeground(Color.DARK_GRAY.brighter());
		area.setBorder(BorderFactory.createCompoundBorder(
				new CustomeBorder(), 
				new EmptyBorder(new Insets(12, 12, 12, 12))));
		return area;
	}
	
	private JLabel estiloLabel(JLabel label) {
		label.setFont(fonteLabel);
		label.setForeground(new Color(90,90,90));
		return label;
	}
	
	private JCheckBox estiloCheckBox(JCheckBox check) {
		
		check.setFont(fonteLabel);
		check.setForeground(new Color(90,90,90));
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

	public FormConvidado(ListaDupla<T> listaConvidados) {

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

		labelAlimentar = new JLabel("Modelo alimentar:");
		estiloLabel(labelAlimentar);
		checkVegano = new JCheckBox("Vegano");
		estiloCheckBox(checkVegano);
		checkVegetariano = new JCheckBox("Vegetariano");
		estiloCheckBox(checkVegetariano);
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

		btnLimpar = new JButton("Limpar Campos");
		estiloBotao(btnLimpar);
		btnLimpar.setForeground(Color.GRAY);
		btnSalvar = new JButton("Salvar");
		estiloBotao(btnSalvar);
		btnSalvar.setForeground(Color.GREEN.darker());
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listaConvidados.inserirUltimo((T) new Convidado(0, campoNome.getText(), campoSobrenome.getText(), campoEmail.getText(), campoTelefone.getText(), new Date(0), checkVegano.isSelected(), checkVegetariano.isSelected(), checkOutros.isSelected(), checkAcessibilidade.isSelected(), areaObservacoes.getText(), (String) listaLote.getSelectedItem()));
				System.out.println("Inserido um item, o segundo ainda não funciona:\n" + listaConvidados);
				
			}
		});

		Border margem = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder("Adicionar Convidado");
		bordaTitulo.setTitleColor(new Color(66,66,66));
		bordaTitulo.setTitleFont(fonte);
		setBorder(BorderFactory.createCompoundBorder(margem, bordaTitulo));

		setBackground(CORFUNDO);
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		//Linha 0 e 1: nome e sobrenome
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.LINE_START;
		
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.01;
		gc.insets = new Insets(12,6,0,0);
		add(labelNome, gc);

		gc.gridy = 1;
		gc.weighty = 0.075;
		gc.insets = new Insets(0,0,0,0);
		add(campoNome, gc);
		
		gc.gridwidth = 1;
		
		gc.gridx = 2;
		gc.gridy = 0;
		gc.weighty = 0.01;
		gc.insets = new Insets(12,6,0,0);
		add(labelSobrenome, gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		gc.weighty = 0.075;
		gc.insets = new Insets(0,0,0,0);
		add(campoSobrenome, gc);

		//Linha 2 e 3: email
		gc.weighty = 0.01;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.gridwidth = 3;
		gc.insets = new Insets(12,6,0,0);
		add(labelEmail, gc);
		
		gc.weighty = 0.075;
		
		gc.weightx = 1;
		gc.gridy = 3;
		gc.insets = new Insets(0,0,0,0);
		add(campoEmail, gc);
		
		//Linha 4 e 5: telefone e nascimento
		gc.gridwidth = 2;

		gc.weighty = 0.01;
		gc.gridx = 0;
		gc.gridy = 4;
		gc.insets = new Insets(12,6,0,0);
		add(labelTelefone, gc);
		
		gc.weighty = 0.075;

		gc.gridy = 5;
		gc.insets = new Insets(0,0,0,0);
		add(campoTelefone, gc);
		
		gc.weighty = 0.01;

		gc.gridx = 2;
		gc.gridy = 4;
		gc.insets = new Insets(12,6,0,0);
		add(labelNascimento, gc);
		
		gc.weighty = 0.075;
		
		gc.gridy = 5;
		gc.insets = new Insets(0,0,0,0);
		add(campoNascimento, gc);

		//Linha 6 e 7: modelo alimentar
		gc.weighty = 0.01;		
		gc.gridx = 0;
		gc.gridy = 6;
		gc.insets = new Insets(12,6,0,0);
		add(labelAlimentar, gc);
		
		gc.weighty = 0.075;		
		gc.gridy = 7;
		gc.gridwidth = 1;
		gc.weightx = 0;		
		gc.insets = new Insets(0,0,0,0);
		add(checkVegano, gc);

		gc.gridx = 1;
		add(checkVegetariano, gc);

		gc.gridx = 2;
		add(checkOutros, gc);

		//Linha 8: acessibilidade
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 8;
		gc.gridwidth = 3;
		gc.insets = new Insets(0,0,0,0);
		add(checkAcessibilidade, gc);

		//Linha 9 e 10: observações
		gc.gridx = 0;
		gc.gridy = 9;
		gc.insets = new Insets(12,6,0,0);
		add(labelObservacoes, gc);
		
		gc.gridy = 10;
		gc.weighty = 0.4;
		gc.insets = new Insets(0,0,0,0);
		add(areaObservacoes, gc);
		
		//Linha 11: lote
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridwidth = 1;
		gc.gridx = 1;
		gc.fill = GridBagConstraints.EAST;
		
		gc.weighty = 0.05;
		gc.gridy = 11;
		gc.insets = new Insets(0,0,0,6);
		add(labelLote, gc);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 2;
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(0,0,0,6);
		add(listaLote, gc);		
		
		//Linha 12: botões
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridy = 12;
		gc.insets = new Insets(6,6,6,6);
		gc.gridwidth = 1;
		gc.gridx = 1;
		add(btnLimpar, gc);
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