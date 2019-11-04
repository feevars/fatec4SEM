package view;

import javax.swing.JPanel;

import model.Evento;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DadosDoEvento extends JPanel {

	private static final long serialVersionUID = -2864491403838154066L;

	public DadosDoEvento(Evento evento) {
		setPreferredSize(new Dimension(720, 60));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{569, 200, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNomedoevento = new JLabel();
		lblNomedoevento.setText(evento.getNome());
		GridBagConstraints gbc_lblNomedoevento = new GridBagConstraints();
		gbc_lblNomedoevento.anchor = GridBagConstraints.WEST;
		gbc_lblNomedoevento.insets = new Insets(0, 0, 0, 5);
		gbc_lblNomedoevento.gridx = 0;
		gbc_lblNomedoevento.gridy = 0;
		add(lblNomedoevento, gbc_lblNomedoevento);
		
		JLabel lblDataDoEvento = new JLabel();
		lblDataDoEvento.setText(evento.getDataEvento().toString());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblDataDoEvento, gbc_lblNewLabel);

	}

}
