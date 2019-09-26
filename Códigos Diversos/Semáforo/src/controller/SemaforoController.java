package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SemaforoController implements ActionListener  {
	
	private Semaforo [] semaforo;
	private JButton botao;
	private boolean estado;
	private ThreadSemaforo [] t;
	
	public SemaforoController(JButton botao, Semaforo [] semaforo) {
		this.botao = botao;
	}
	
	public void botaoOnOff() {
		if(!this.estado) {
			this.estado = true;
			for (int i = 0; i < semaforo.length; i++) {
				t[i] = new ThreadSemaforo(semaforo[i]);
				t[i].start();
			}
			
		}else {
			this.estado = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		botaoOnOff();
	}

}
