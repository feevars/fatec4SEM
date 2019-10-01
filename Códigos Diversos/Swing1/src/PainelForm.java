import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PainelForm extends JPanel {
	
	private JLabel labelNome;
	private JLabel labelCargo;
	private JTextField campoNome;
	private JTextField campoCargo;
	private JButton btnOk;
	
	public PainelForm() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		labelNome = new JLabel("Nome: ");
		labelCargo = new JLabel("Cargo: ");
		
		campoNome = new JTextField(100);
		campoCargo = new JTextField(100);
		
		btnOk = new JButton("OK");
		
		Border bordaInterna = BorderFactory.createTitledBorder("Adicionar pessoa.");
		Border bordaExterna = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(bordaExterna,bordaInterna));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		//Linha 1
		gc.weightx = 0;
		gc.weighty = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(labelNome, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(campoNome, gc);
		
		//Linha 2
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(labelCargo, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(campoCargo, gc);
		
		//Linha 3
		
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(btnOk, gc);
		

	}
}
