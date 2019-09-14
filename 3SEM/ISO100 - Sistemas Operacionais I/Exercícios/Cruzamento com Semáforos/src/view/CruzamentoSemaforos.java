package view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controller.ThreadCruzamento;

public class CruzamentoSemaforos extends JFrame {

	public static void main(String[] args) {


		
        CruzamentoSemaforos c = new CruzamentoSemaforos();
        c.setVisible(true);

	}
	
    public CruzamentoSemaforos(){
    	int on = 255;
    	int off = 100;
        this.setSize(340, 220);
        this.setTitle("Cruzamento com 4 semáforos");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // usually you should use a normal layout manager, but for your task we need null
        getContentPane().setLayout(null);
		ThreadCruzamento tc = new ThreadCruzamento(4, 200);
    }

}
