package view;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
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

import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FormConvidado extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6302842264749013613L;

	private static final Color CINZA = new Color(75, 82, 103);
	private static final Color AZUL_ESCURO = new Color(46, 41, 78);
	private static final Color VIOLETA = new Color(134, 97, 193);

	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;

	public FormConvidado() {
		setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3),
				new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, Color.WHITE, VIOLETA), "Adicionar Convidado",
						TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE)));
		setPreferredSize(new Dimension(400, 720));
		setBackground(AZUL_ESCURO);
		setForeground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 275, 0 };
		gridBagLayout.rowHeights = new int[] { 40, 40, 40, 40, 40, 40, 120, 50, 60, 181, 40, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
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

		JComboBox<String> comboDocumento = new JComboBox<String>();
		comboDocumento.setAlignmentX(Component.RIGHT_ALIGNMENT);
		comboDocumento.addItem("RG");
		comboDocumento.addItem("CPF");
		comboDocumento.addItem("CNH");
		comboDocumento.addItem("Passaporte");
		comboDocumento.addItem("Outro");

		JFormattedTextField txtTelefone = new JFormattedTextField();
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

		JFormattedTextField txtDocumento = new JFormattedTextField();
		GridBagConstraints gbc_txtDocumento = new GridBagConstraints();
		gbc_txtDocumento.insets = new Insets(0, 0, 5, 0);
		gbc_txtDocumento.fill = GridBagConstraints.BOTH;
		gbc_txtDocumento.gridx = 1;
		gbc_txtDocumento.gridy = 4;
		add(txtDocumento, gbc_txtDocumento);

		try {
			MaskFormatter maskRg = new MaskFormatter("##.###.###-##");
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

			JDateChooser escolhaDataNascimento = new JDateChooser();
			escolhaDataNascimento.setBackground(AZUL_ESCURO);
			escolhaDataNascimento.setForeground(Color.WHITE);
			GridBagConstraints gbc_dateChooser = new GridBagConstraints();
			gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
			gbc_dateChooser.fill = GridBagConstraints.BOTH;
			gbc_dateChooser.gridx = 1;
			gbc_dateChooser.gridy = 5;
			add(escolhaDataNascimento, gbc_dateChooser);

			JLabel lblObservacoes = new JLabel("<html><p align=\"right\">Observações:</p></html>");
			lblObservacoes.setForeground(Color.WHITE);
			GridBagConstraints gbc_lblObservacoes = new GridBagConstraints();
			gbc_lblObservacoes.anchor = GridBagConstraints.NORTHEAST;
			gbc_lblObservacoes.insets = new Insets(0, 0, 5, 5);
			gbc_lblObservacoes.gridx = 0;
			gbc_lblObservacoes.gridy = 6;
			add(lblObservacoes, gbc_lblObservacoes);

			JScrollPane scrollObservacoes = new JScrollPane();
			scrollObservacoes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			GridBagConstraints gbc_scrollObservacoes = new GridBagConstraints();
			gbc_scrollObservacoes.insets = new Insets(0, 0, 5, 0);
			gbc_scrollObservacoes.fill = GridBagConstraints.BOTH;
			gbc_scrollObservacoes.gridx = 1;
			gbc_scrollObservacoes.gridy = 6;
			add(scrollObservacoes, gbc_scrollObservacoes);

			JTextArea txtrObservacoes = new JTextArea();
			scrollObservacoes.setViewportView(txtrObservacoes);
			txtrObservacoes.setLineWrap(true);

			JCheckBox checkVip = new JCheckBox("<html><p align=\"right\">VIP:</p></html>");
			checkVip.setIcon(new ImageIcon(FormConvidado.class.getResource("/assets/checknao.png")));
			checkVip.setSelectedIcon(new ImageIcon(FormConvidado.class.getResource("/assets/checksim.png")));
			checkVip.setForeground(Color.WHITE);
			checkVip.setHorizontalTextPosition(SwingConstants.LEFT);
			checkVip.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_checkVip = new GridBagConstraints();
			gbc_checkVip.anchor = GridBagConstraints.EAST;
			gbc_checkVip.insets = new Insets(0, 0, 5, 5);
			gbc_checkVip.gridx = 0;
			gbc_checkVip.gridy = 7;
			add(checkVip, gbc_checkVip);

			JCheckBox chckbxAcessibilidade = new JCheckBox(
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
			gbc_chckbxAcessibilidade.gridy = 7;
			add(chckbxAcessibilidade, gbc_chckbxAcessibilidade);

			JPanel painelBotoes = new JPanel();
			painelBotoes.setBackground(AZUL_ESCURO);
			GridBagConstraints gbc_painelBotoes = new GridBagConstraints();
			gbc_painelBotoes.anchor = GridBagConstraints.NORTH;
			gbc_painelBotoes.insets = new Insets(0, 0, 5, 0);
			gbc_painelBotoes.fill = GridBagConstraints.BOTH;
			gbc_painelBotoes.gridx = 1;
			gbc_painelBotoes.gridy = 8;
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

			JLabel lblLote = new JLabel("Lote atual:");
			lblLote.setForeground(VIOLETA);
			lblLote.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			GridBagConstraints gbc_lblLote = new GridBagConstraints();
			gbc_lblLote.anchor = GridBagConstraints.WEST;
			gbc_lblLote.gridx = 1;
			gbc_lblLote.gridy = 10;
			add(lblLote, gbc_lblLote);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		comboDocumento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch ((String) comboDocumento.getSelectedItem()) {

				case "RG":
					try {
						txtDocumento.setValue(null);
						MaskFormatter maskRg = new MaskFormatter("##.###.###-##");
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
	}

}
