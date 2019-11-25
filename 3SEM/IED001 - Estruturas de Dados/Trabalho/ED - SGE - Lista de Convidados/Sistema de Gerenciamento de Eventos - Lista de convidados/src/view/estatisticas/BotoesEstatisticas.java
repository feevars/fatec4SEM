package view.estatisticas;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class BotoesEstatisticas extends JPanel {

	private static final long serialVersionUID = -7766384107156740142L;

	private static final Color CINZA = new Color(75, 82, 103);
//	private static final Color AZUL_CLARO = new Color(72, 172, 240);
	private static final Color AZUL_ESCURO = new Color(46, 41, 78);
//	private static final Color VIOLETA = new Color(134, 97, 193);

	private BotoesEstatisticasListener botoesEstatisticasListener;

	private JButton btnDadosGerais;
	private JButton btnConvidadoPorLote;
	private JButton btnFaixaEtaria;
	private JButton btnArrecadaoPorLote;

	public BotoesEstatisticas() {
		setBackground(AZUL_ESCURO);
		setPreferredSize(new Dimension(200, 360));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		btnDadosGerais = new JButton("<html><p align=\"center\">Dados Gerais</p></html>");
		btnDadosGerais.setForeground(Color.WHITE);
		btnDadosGerais.setBackground(CINZA);
		add(btnDadosGerais);

		btnConvidadoPorLote = new JButton("<html><p align=\"center\">Convidado por lote</p></html>");
		btnConvidadoPorLote.setForeground(Color.WHITE);
		btnConvidadoPorLote.setBackground(CINZA);
		add(btnConvidadoPorLote);

		btnFaixaEtaria = new JButton("<html><p align=\"center\">Faixa etária do público</p></html>");
		btnFaixaEtaria.setForeground(Color.WHITE);
		btnFaixaEtaria.setBackground(CINZA);
		add(btnFaixaEtaria);

		btnArrecadaoPorLote = new JButton("<html><p align=\"center\">Arrecadação por lote</p></html>");
		btnArrecadaoPorLote.setForeground(Color.WHITE);
		btnArrecadaoPorLote.setBackground(CINZA);
		add(btnArrecadaoPorLote);

		btnDadosGerais.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BotoesEstatisticasEvent evConvidadoLote = new BotoesEstatisticasEvent(this, 0);
				botoesEstatisticasListener.formEventOcurred(evConvidadoLote);
			}
		});
		
		btnConvidadoPorLote.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BotoesEstatisticasEvent evConvidadoLote = new BotoesEstatisticasEvent(this, 1);
				botoesEstatisticasListener.formEventOcurred(evConvidadoLote);
			}
		});

		btnFaixaEtaria.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BotoesEstatisticasEvent evConvidadoLote = new BotoesEstatisticasEvent(this, 2);
				botoesEstatisticasListener.formEventOcurred(evConvidadoLote);
			}
		});

		btnArrecadaoPorLote.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BotoesEstatisticasEvent evConvidadoLote = new BotoesEstatisticasEvent(this, 3);
				botoesEstatisticasListener.formEventOcurred(evConvidadoLote);
			}
		});
	}

	public void setBotoesEstatisticasListener(BotoesEstatisticasListener botoesEstatisticasListener) {
		this.botoesEstatisticasListener = botoesEstatisticasListener;
	}

}
