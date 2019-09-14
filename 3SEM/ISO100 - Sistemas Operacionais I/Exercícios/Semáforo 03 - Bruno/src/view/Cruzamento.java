package view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Cruzamento extends JFrame {
    public int size = 400;

    public SemaforoDesenho[] semaforos = new SemaforoDesenho[4];

    public static void main(String[] args) {
        Cruzamento c = new Cruzamento();
        c.setVisible(true);
    }

    public Cruzamento(){
    	int on = 255;
    	int off = 100;
        this.setSize(340, 220);
        this.setTitle("Cruzamento com 4 semáforos");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // usually you should use a normal layout manager, but for your task we need null
        getContentPane().setLayout(null);
        int x = 20;
        for (int i = 0; i < semaforos.length; i++) {
            int y = 20;
            semaforos[i] = new SemaforoDesenho(x, y, on, off, off);
            this.add(semaforos[i]);
            x += 80;
        }
    }
}
