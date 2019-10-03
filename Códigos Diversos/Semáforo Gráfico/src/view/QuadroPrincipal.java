package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class QuadroPrincipal extends JFrame {
	
	private JToggleButton botaoLiga;
	private PainelSemaforos painelSemaforos;
	
	private int qtdSemaforos;
	private int tempoAberto;
	
	public QuadroPrincipal() {
		super("Semáforos Gráficos");
		
		qtdSemaforos = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de semáforos\nque você deseja exibir:"));
		tempoAberto = Integer.parseInt(JOptionPane.showInputDialog("Digite, em milisegundos, o tempo\nque cada semáforo deve ficar aberto: "));

		setLayout(new BorderLayout());
		
		painelSemaforos = new PainelSemaforos(qtdSemaforos, tempoAberto);
		botaoLiga = new JToggleButton("Play / Pause");
		
			
		
		botaoLiga.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {

					painelSemaforos.ts.start();
					
			}
		});
				
		add(painelSemaforos, BorderLayout.CENTER);
		add(botaoLiga, BorderLayout.SOUTH);
		
		setSize(qtdSemaforos * 80, 230);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
