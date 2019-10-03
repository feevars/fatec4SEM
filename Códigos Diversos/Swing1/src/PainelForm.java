import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PainelForm extends JPanel {
	
	private JLabel labelNome;
	private JLabel labelCargo;
	private JTextField campoNome;
	private JTextField campoCargo;
	private JButton btnOk;
	private FormListener formListener;
	private JList listaIdade;
	
	public PainelForm() {
		
		labelNome = new JLabel("Nome: ");
		labelCargo = new JLabel("Cargo: ");
		
		campoNome = new JTextField(15);
		campoCargo = new JTextField(15);
		
		
		
		listaIdade = new JList();
		
		DefaultListModel modeloIdade = new DefaultListModel();
		modeloIdade.addElement("Abaixo dos 18 anos.");
		modeloIdade.addElement("Entre 18 e 40.");
		modeloIdade.addElement("Entre 40 e 65.");
		modeloIdade.addElement("Mais de 65.");
		
		listaIdade.setModel(modeloIdade);
		
		listaIdade.setPreferredSize(new Dimension(110, 66));
		listaIdade.setBorder(BorderFactory.createEtchedBorder());
		listaIdade.setSelectedIndex(1);
		
		btnOk = new JButton("OK");
		
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = campoNome.getText();
				String cargo = campoCargo.getText();
				String categoriaIdade = (String) listaIdade.getSelectedValue();
				
				System.out.println(categoriaIdade);
				
				FormEvent ev = new FormEvent(this, nome, cargo);
				
				if (formListener != null) {
					formListener.formEventOcurred(ev);
				}
			}
		});
		
		Border bordaInterna = BorderFactory.createTitledBorder("Adicionar pessoa.");
		Border bordaExterna = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(bordaExterna,bordaInterna));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		//Linha 1
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(labelNome, gc);
		
		gc.weightx = 2;
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
		
		gc.weightx = 2;
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
		add(listaIdade, gc);
		
		//Linha 4
		
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(btnOk, gc);
		

	}
	
	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}
}
