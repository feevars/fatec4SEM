package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class FormEditarConvidado extends JFrame {
	
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

public FormEditarConvidado throws ParseException {
	setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3),
			new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, Color.WHITE, VIOLETA), "Adicionar Convidado",
					TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE)));
	setPreferredSize(new Dimension(320, 560));
	setBackground(AZUL_ESCURO);
	setForeground(Color.WHITE);

}

}
