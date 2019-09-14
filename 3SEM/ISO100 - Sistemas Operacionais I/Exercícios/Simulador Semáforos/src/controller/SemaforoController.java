package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.SemaforoDesenho;

public class SemaforoController implements ActionListener {
	
	
	private JButton btnIniciar;
	public SemaforoController(JButton btnIniciar) {
		this.btnIniciar = btnIniciar;
	}
	private void botaoLigar(){
		ThreadSemaforo t1 = new ThreadSemaforo(btnIniciar);
		t1.ligarSemaforo();

		for(int i = 0; i<10 ;i++) {
			new SemaforoDesenho(10,20,(t1.getCor().toString()));
			System.out.println(t1.getCor());
			t1.esperaCorMudar();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		botaoLigar();
	}

}
