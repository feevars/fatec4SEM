package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QuadroPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PainelX painelX;
	private JTextArea textArea;
	private JScrollPane scroll;
	private JButton botaoX;

	public QuadroPrincipal() {

		this.painelX = new PainelX();
		this.textArea = new JTextArea();
		this.botaoX = new JButton("Botão X");
		this.scroll = new JScrollPane(textArea);
		
		this.botaoX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append("Lobosco só semana que vem...\n");
				
			}
		});
		
		this.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		this.setLayout(new BorderLayout());
		this.setSize(500, 500);
		this.add(botaoX, BorderLayout.SOUTH);
		this.add(painelX, BorderLayout.EAST);
		this.add(scroll, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}
