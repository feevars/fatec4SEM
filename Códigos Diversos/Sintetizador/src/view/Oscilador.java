package view;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import controller.utils.Utils;

public class Oscilador extends JPanel {

	private static final long serialVersionUID = 7038232602006054449L;
	
	private static final double FREQUENCIA = 440;

	private FormaDaOnda formaDaOnda = FormaDaOnda.Sine;
	private int posOnda;

	public Oscilador() {
		JComboBox<FormaDaOnda> comboBox = new JComboBox<Oscilador.FormaDaOnda>(new FormaDaOnda[] { FormaDaOnda.Sine,
				FormaDaOnda.Square, FormaDaOnda.Saw, FormaDaOnda.Triangle, FormaDaOnda.Noise });
		comboBox.setSelectedItem(FormaDaOnda.Sine);
		comboBox.setBounds(10, 10, 100, 25);
		comboBox.addItemListener(l -> {
			formaDaOnda = (FormaDaOnda) l.getItem();
		});
		add(comboBox);
		setSize(279, 100);
		setBorder(Utils.WindowDesign.BORDA_LINHA);
		setLayout(null);

	}

	private enum FormaDaOnda {
		Sine, Square, Saw, Triangle, Noise
	}

	public double proximoSample() {

		switch (formaDaOnda) {
		case Sine:
			return Math.sin(Utils.Math.frequenciaParaFrequenciaAngular(FREQUENCIA) * posOnda / QuadroPrincipal.AudioInfo.SAMPLE_RATE);
			break;
		case Square:

			break;
		case Saw:

			break;
		case Triangle:

			break;
		case Noise:

			break;
		}
	}
}