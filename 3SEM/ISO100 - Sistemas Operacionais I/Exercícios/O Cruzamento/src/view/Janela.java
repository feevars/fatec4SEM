package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame {
	
	public Janela() {
		super("TraficLights");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(3, 3);
        grid.setHgap(20);
        grid.setVgap(20);
        panel.setLayout(grid);
	}
	
}
