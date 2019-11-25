package view;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import model.Convidado;
import model.Evento;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FormConvidado extends JPanel {

	private static final long serialVersionUID = -6302842264749013613L;

//	private static final Color CINZA = new Color(75, 82, 103);
	private static final Color AZUL_ESCURO = new Color(46, 41, 78);
	private static final Color VIOLETA = new Color(134, 97, 193);

	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtDocumento;
	private JComboBox<String> comboDocumento;
	private JDateChooser escolhaDataNascimento;
	private JCheckBox checkVip;
	private JCheckBox chckbxAcessibilidade;
	private Date dataAtual;
	private int loteAtual;

	private Evento evento;

	private FormConvidadoListener formListener;

	public FormConvidado(Evento evento) throws ParseException {
		setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3),
				new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, Color.WHITE, VIOLETA), "Adicionar Convidado",
						TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE)));
		setPreferredSize(new Dimension(320, 560));
		setBackground(AZUL_ESCURO);
		setForeground(Color.WHITE);

		dataAtual = new Date();

		this.evento = evento;

		defineLote();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 275, 0 };
		gridBagLayout.rowHeights = new int[] { 40, 40, 40, 40, 40, 40, 50, 60, 181, 40, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNome = new JLabel("<html><p align=\"right\">Nome:</p></html>");
		lblNome.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.fill = GridBagConstraints.BOTH;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 0;
		add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("<html><p align=\"right\">Sobrenome:</p></html>");
		lblSobrenome.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblSobrenome = new GridBagConstraints();
		gbc_lblSobrenome.anchor = GridBagConstraints.EAST;
		gbc_lblSobrenome.insets = new Insets(0, 0, 5, 5);
		gbc_lblSobrenome.gridx = 0;
		gbc_lblSobrenome.gridy = 1;
		add(lblSobrenome, gbc_lblSobrenome);

		txtSobrenome = new JTextField();
		GridBagConstraints gbc_txtSobrenome = new GridBagConstraints();
		gbc_txtSobrenome.insets = new Insets(0, 0, 5, 0);
		gbc_txtSobrenome.fill = GridBagConstraints.BOTH;
		gbc_txtSobrenome.gridx = 1;
		gbc_txtSobrenome.gridy = 1;
		add(txtSobrenome, gbc_txtSobrenome);
		txtSobrenome.setColumns(10);

		JLabel lblEmail = new JLabel("<html><p align=\"right\">Email:</p></html>");
		lblEmail.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.fill = GridBagConstraints.BOTH;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 2;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("<html><p align=\"right\">Telefone:</p></html>");
		lblTelefone.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 3;
		add(lblTelefone, gbc_lblTelefone);

		comboDocumento = new JComboBox<String>();
		comboDocumento.setAlignmentX(Component.RIGHT_ALIGNMENT);
		comboDocumento.addItem("RG");
		comboDocumento.addItem("CPF");
		comboDocumento.addItem("CNH");
		comboDocumento.addItem("Passaporte");
		comboDocumento.addItem("Outro");

		txtTelefone = new JFormattedTextField();
		GridBagConstraints gbc_txtTelefone = new GridBagConstraints();
		try {
			MaskFormatter maskTelefone = new MaskFormatter("(##) #####-####");
			maskTelefone.install(txtTelefone);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		gbc_txtTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_txtTelefone.fill = GridBagConstraints.BOTH;
		gbc_txtTelefone.gridx = 1;
		gbc_txtTelefone.gridy = 3;
		add(txtTelefone, gbc_txtTelefone);
		GridBagConstraints gbc_comboDocumento = new GridBagConstraints();
		gbc_comboDocumento.anchor = GridBagConstraints.WEST;
		gbc_comboDocumento.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_comboDocumento.gridx = 0;
		gbc_comboDocumento.gridy = 4;
		add(comboDocumento, gbc_comboDocumento);

		txtDocumento = new JFormattedTextField();
		GridBagConstraints gbc_txtDocumento = new GridBagConstraints();
		gbc_txtDocumento.insets = new Insets(0, 0, 5, 0);
		gbc_txtDocumento.fill = GridBagConstraints.BOTH;
		gbc_txtDocumento.gridx = 1;
		gbc_txtDocumento.gridy = 4;
		add(txtDocumento, gbc_txtDocumento);

		MaskFormatter maskRg = new MaskFormatter("##.###.###-#");
		txtDocumento.setFormatterFactory(new DefaultFormatterFactory(maskRg));

		JLabel lblDataDeNascimento = new JLabel("<html><p align=\"right\">Data de nascimento:</p></html>");
		lblDataDeNascimento.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDataDeNascimento = new GridBagConstraints();
		gbc_lblDataDeNascimento.fill = GridBagConstraints.VERTICAL;
		gbc_lblDataDeNascimento.anchor = GridBagConstraints.EAST;
		gbc_lblDataDeNascimento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataDeNascimento.gridx = 0;
		gbc_lblDataDeNascimento.gridy = 5;
		add(lblDataDeNascimento, gbc_lblDataDeNascimento);

		escolhaDataNascimento = new JDateChooser();
		escolhaDataNascimento.setBackground(AZUL_ESCURO);
		escolhaDataNascimento.setForeground(Color.WHITE);
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 5;
		add(escolhaDataNascimento, gbc_dateChooser);

		checkVip = new JCheckBox("<html><p align=\"right\">VIP:</p></html>");
		checkVip.setIcon(new ImageIcon(FormConvidado.class.getResource("/assets/checknao.png")));
		checkVip.setSelectedIcon(new ImageIcon(FormConvidado.class.getResource("/assets/checksim.png")));
		checkVip.setForeground(Color.WHITE);
		checkVip.setHorizontalTextPosition(SwingConstants.LEFT);
		checkVip.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_checkVip = new GridBagConstraints();
		gbc_checkVip.anchor = GridBagConstraints.EAST;
		gbc_checkVip.insets = new Insets(0, 0, 5, 5);
		gbc_checkVip.gridx = 0;
		gbc_checkVip.gridy = 6;
		add(checkVip, gbc_checkVip);

		chckbxAcessibilidade = new JCheckBox(
				"<html><p align=\"right\">Necessita de recursos de acessibilidade:</p></html>");
		chckbxAcessibilidade.setSelectedIcon(new ImageIcon(FormConvidado.class.getResource("/assets/checksim.png")));
		chckbxAcessibilidade.setIcon(new ImageIcon(FormConvidado.class.getResource("/assets/checknao.png")));
		chckbxAcessibilidade.setForeground(Color.WHITE);
		chckbxAcessibilidade.setHorizontalTextPosition(SwingConstants.LEFT);
		chckbxAcessibilidade.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_chckbxAcessibilidade = new GridBagConstraints();
		gbc_chckbxAcessibilidade.fill = GridBagConstraints.BOTH;
		gbc_chckbxAcessibilidade.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxAcessibilidade.gridx = 1;
		gbc_chckbxAcessibilidade.gridy = 6;
		add(chckbxAcessibilidade, gbc_chckbxAcessibilidade);

		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(AZUL_ESCURO);
		GridBagConstraints gbc_painelBotoes = new GridBagConstraints();
		gbc_painelBotoes.anchor = GridBagConstraints.NORTH;
		gbc_painelBotoes.insets = new Insets(0, 0, 5, 0);
		gbc_painelBotoes.fill = GridBagConstraints.BOTH;
		gbc_painelBotoes.gridx = 1;
		gbc_painelBotoes.gridy = 7;
		add(painelBotoes, gbc_painelBotoes);
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));

		JButton btnLimparCampos = new JButton("<html><p align=\"center\">Limpar Campos</p></html>");
		btnLimparCampos.setMaximumSize(new Dimension(300, 60));
		btnLimparCampos.setPreferredSize(new Dimension(142, 60));
		btnLimparCampos.setMinimumSize(new Dimension(95, 60));
		painelBotoes.add(btnLimparCampos);

		JButton btnAdicionarConvidado = new JButton("<html><p align=\"center\">Adicionar Convidado</p></html>");
		btnAdicionarConvidado.setMaximumSize(new Dimension(300, 60));
		btnAdicionarConvidado.setMinimumSize(new Dimension(111, 60));
		btnAdicionarConvidado.setPreferredSize(new Dimension(175, 60));
		painelBotoes.add(btnAdicionarConvidado);

		JLabel lblLote = new JLabel();
		if (loteAtual == 0) {
			lblLote.setText("Portaria");
		} else {
			lblLote.setText(loteAtual + "o Lote");
		}
		lblLote.setForeground(VIOLETA);
		lblLote.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		GridBagConstraints gbc_lblLote = new GridBagConstraints();
		gbc_lblLote.anchor = GridBagConstraints.WEST;
		gbc_lblLote.gridx = 1;
		gbc_lblLote.gridy = 9;
		add(lblLote, gbc_lblLote);

		JLabel lblconvitesRestantes = new JLabel();
		lblconvitesRestantes.setText(evento.getQtdConvites() - evento.getListaConvidados().getQtdNo() 
				+ " convites restantes");
		
		lblconvitesRestantes.setForeground(VIOLETA);
		lblconvitesRestantes.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		GridBagConstraints gbc_convitesRestantes = new GridBagConstraints();
		gbc_convitesRestantes.anchor = GridBagConstraints.WEST;
		gbc_convitesRestantes.gridx = 1;
		gbc_convitesRestantes.gridy = 10;
		add(lblconvitesRestantes, gbc_convitesRestantes);
		
		
		comboDocumento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch ((String) comboDocumento.getSelectedItem()) {

				case "RG":
					try {
						txtDocumento.setValue(null);
						MaskFormatter maskRg = new MaskFormatter("##.###.###-#");
						maskRg.setPlaceholderCharacter(' ');
						txtDocumento.setFormatterFactory(new DefaultFormatterFactory(maskRg));
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
					break;
				case "CPF":
					try {
						txtDocumento.setValue(null);
						txtDocumento.setText("");
						MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
						maskCpf.setPlaceholderCharacter(' ');
						txtDocumento.setFormatterFactory(new DefaultFormatterFactory(maskCpf));
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
					break;
				case "CNH":
					try {
						txtDocumento.setValue(null);
						txtDocumento.setText("");
						MaskFormatter maskCpf = new MaskFormatter("###########");
						maskCpf.setPlaceholderCharacter(' ');
						txtDocumento.setFormatterFactory(new DefaultFormatterFactory(maskCpf));
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
					break;
				case "Passaporte":
					txtDocumento.setValue(null);
					txtDocumento.setText("");
					txtDocumento.setFormatterFactory(new DefaultFormatterFactory(null));
					break;
				case "Outro":
					txtDocumento.setValue(null);
					txtDocumento.setText("");
					txtDocumento.setFormatterFactory(new DefaultFormatterFactory(null));
					break;
				}
			}
		});

		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});

		btnAdicionarConvidado.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (evento.getQtdConvites() <= evento.getListaConvidados().getQtdNo()) {
					JOptionPane.showMessageDialog(null,
							"Seu evento ja esta lotado.\n" + "Impossivel adicionar novo convidado.");
				} else {
					Convidado novoConvidado = new Convidado(evento.getListaConvidados().getContaId(), txtNome.getText(),
							txtSobrenome.getText(), txtEmail.getText(), txtTelefone.getText(),
							escolhaDataNascimento.getDate(), comboDocumento.getSelectedItem().toString(),
							txtDocumento.getText(), chckbxAcessibilidade.isSelected(), checkVip.isSelected(),
							loteAtual);
					evento.getListaConvidados().inserePrimeiro(novoConvidado);
					switch (loteAtual) {
					case 1:
						evento.setQtdLote1(evento.getQtdLote1() - 1);
						break;
					case 2:
						evento.setQtdLote2(evento.getQtdLote2() - 1);
						break;
					case 3:
						evento.setQtdLote3(evento.getQtdLote3() - 1);
						break;
					}

					FormConvidadoEvent ev = new FormConvidadoEvent(this,
							evento.getListaConvidados().getPrimeiro().getConteudo());
					formListener.formEventOcurred(ev);
					double porcentagemRestante = ((double) (evento.getQtdConvites()
							- evento.getListaConvidados().getQtdNo()) * 100) / (double) evento.getQtdConvites();
					JOptionPane.showMessageDialog(null,
							"Convidado adicionado.\n" + "Restam " + porcentagemRestante + "% da lista.");
					limparCampos();
					defineLote();
					if (loteAtual == 0) {
						lblLote.setText("Portaria");
					} else {
						lblLote.setText(loteAtual + "º Lote");
					}
					lblconvitesRestantes.setText(evento.getQtdConvites() - evento.getListaConvidados().getQtdNo() 
							+ " convites restantes");

				}
			}
		});
	}

	public void defineLote() {
		if (dataAtual.before(evento.getDataLote1()) && evento.getQtdLote1() > 0) {
			loteAtual = 1;
		} else if (dataAtual.before(evento.getDataLote2()) && evento.getQtdLote2() > 0) {
			loteAtual = 2;
		} else if (dataAtual.before(evento.getDataLote3()) && evento.getQtdLote3() > 0) {
			loteAtual = 3;
		} else {
			loteAtual = 0; // Portaria
		}
	}
	

	public void limparCampos() {
		txtNome.setText("");
		txtSobrenome.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		escolhaDataNascimento.setDate(null);
		comboDocumento.setSelectedIndex(0);
		checkVip.setSelected(false);
		chckbxAcessibilidade.setSelected(false);
		txtDocumento.setText("");
	}

	public void setFormListener(FormConvidadoListener listener) {
		this.formListener = listener;
	}

}
