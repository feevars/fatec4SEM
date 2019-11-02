package view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelX extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	
	public PainelX() {
		
		btn1 = new JButton("Botão 1");
		btn2 = new JButton("Botão 2");
		btn3 = new JButton("Botão 3");
		btn4 = new JButton("Botão 4");
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.setPreferredSize(new Dimension(100,720));
	}

}
