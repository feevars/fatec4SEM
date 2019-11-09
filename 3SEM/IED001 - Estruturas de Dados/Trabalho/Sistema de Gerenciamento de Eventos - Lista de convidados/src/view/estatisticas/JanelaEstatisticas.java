package view.estatisticas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Evento;

public class JanelaEstatisticas extends JFrame {

	private static final long serialVersionUID = -8825167705725868064L;
	
	private JPanel contentPane;
	
	private GraficoConvidadoLote graficoConvidadoLote;
	private BotoesEstatisticas botoesEstatisticas;


	public JanelaEstatisticas(Evento evento) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 360);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		graficoConvidadoLote = new GraficoConvidadoLote(evento);
		botoesEstatisticas = new BotoesEstatisticas();
		contentPane.add(botoesEstatisticas, BorderLayout.WEST);
		contentPane.add(graficoConvidadoLote, BorderLayout.CENTER);
		setVisible(true);
	}

}
