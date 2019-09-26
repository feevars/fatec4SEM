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
			t[0] = new ThreadSemaforo(semaforo[0]);
			t[0].start();
		}else {
			this.estado = false;
		}
	}
	
	public void executaThreads() {
		while(estado) {
			System.out.println("A");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		botaoOnOff();
		executaThreads();
	}

}
