package view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controller.ThreadSemaforo;
import model.Semaforo;

public class Cruzamento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Cruzamento c = new Cruzamento();
        c.setVisible(true);

	}
	
    public Cruzamento(){
        this.setSize(340, 220);
        this.setTitle("Cruzamento com 4 semáforos");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        ThreadSemaforo t1 = new ThreadSemaforo();
//		Semaforo s1 = new Semaforo("Vermelho", 20, 20);
//		Semaforo s2 = new Semaforo("Vermelho", 100, 20);
//		Semaforo s3 = new Semaforo("Verde", 180, 20);
//		Semaforo s4 = new Semaforo("Vermelho", 260, 20);
//		this.add(s1);
//		this.add(s2);
//		this.add(s3);
//		this.add(s4);
 
    }

}
