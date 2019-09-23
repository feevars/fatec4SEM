import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame tela = new JFrame();
		Gameplay jogo = new Gameplay();
		
		tela.setBounds(10, 10, 905, 700);
		tela.setBackground(Color.DARK_GRAY);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.add(jogo);
		
		tela.setVisible(true);
	}

}
