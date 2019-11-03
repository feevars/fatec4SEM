package view;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.ParseException;

import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FormConvidado extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6302842264749013613L;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;

	public FormConvidado() {
		setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3), new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Adicionar Convidado", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
		setPreferredSize(new Dimension(400, 720));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 275, 0};
		gridBagLayout.rowHeights = new int[]{40, 40, 40, 40, 40, 40, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNome = new JLabel("<html><p align=\"right\">Nome:</p></html>");
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
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 3;
		add(lblTelefone, gbc_lblTelefone);
		
		JComboBox<String> comboDocumento = new JComboBox();
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
		gbc_comboDocumento.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_comboDocumento.gridx = 0;
		gbc_comboDocumento.gridy = 4;
		add(comboDocumento, gbc_comboDocumento);
		
		JFormattedTextField txtDocumento = new JFormattedTextField();
		GridBagConstraints gbc_txtDocumento = new GridBagConstraints();
		gbc_txtDocumento.insets = new Insets(0, 0, 5, 0);
		gbc_txtDocumento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDocumento.gridx = 1;
		gbc_txtDocumento.gridy = 4;
		add(txtDocumento, gbc_txtDocumento);
		
		try {
			MaskFormatter maskRg = new MaskFormatter("##.###.###-##");
			maskRg.install(txtDocumento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		comboDocumento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch ((String) comboDocumento.getSelectedItem()){
				
				case "RG":
					try {
						MaskFormatter maskRg = new MaskFormatter("##.###.###-##");
						maskRg.install(txtDocumento);
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
					break;
				case "CPF":
					try {
						txtDocumento.removeAll();
						MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
						maskCpf.install(txtDocumento);
					} catch (ParseException ex) {
						ex.printStackTrace();
					}
					break;
				}
				
				
			}
		});
	}

}
