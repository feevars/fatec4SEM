package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class MenuInicial extends JFrame {

	private static final long serialVersionUID = -626919165931577521L;
	
	private JPanel contentPane;

	public MenuInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel painelBotoes = new JPanel();
		contentPane.add(painelBotoes, BorderLayout.SOUTH);
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
		
		JButton btnNovaLista = new JButton("Nova Lista");
		painelBotoes.add(btnNovaLista);
		
		
		JButton btnAbrirListaExistente = new JButton("Abrir Lista Existente");
		painelBotoes.add(btnAbrirListaExistente);
		
		JLabel lblImagemPrincipal = new JLabel("");
		lblImagemPrincipal.setIcon(new ImageIcon("/Users/bruno/Desktop/Fatec/3SEM/IED001 - Estruturas de Dados/Trabalho/Sistema de Gerenciamento de Eventos - Lista de convidados/bin/img/cu.jpg"));
		lblImagemPrincipal.setPreferredSize(new Dimension(300, 230));
		lblImagemPrincipal.setMinimumSize(new Dimension(300, 230));
		contentPane.add(lblImagemPrincipal, BorderLayout.CENTER);
		setVisible(true);
		
		btnNovaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new WizardNovoEvento();
			}
		});
		
		btnAbrirListaExistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//deve abrir o card de eventos cadastrados
				
			}
		}); 
	}

}
