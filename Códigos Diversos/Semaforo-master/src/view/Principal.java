/**
 * Classe principal da aplicação, contendo o main e responsável também pela criação do JFrame.
 * @author Augusto Luiz Silva
 * @date: 10/04/18 
 */
package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import controller.ControleCarro;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Método responsável pela criação das labels e button, assim como o seu posicionamento no JPanel
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 5, 700, 720);
		setResizable(false);
		
		painel = new JPanel();
		
		setContentPane(painel);
		
		painel.setLayout(null);
		
		/*Fundo início*/
		JLabel fundoInicio = new JLabel();
		fundoInicio.setBounds(0, 0, 700, 700);
		fundoInicio.setIcon(new ImageIcon("img/fundo_inicio.png"));
		
		JButton btnInicio = new JButton();
		btnInicio.setBounds(160, 350, 410, 67);
		btnInicio.setBackground(Color.white);
		
		JLabel nomeBotao = new JLabel();
		nomeBotao.setIcon(new ImageIcon("img/start.png"));
		
		btnInicio.add(nomeBotao);
		
		painel.add(btnInicio);
		painel.add(fundoInicio);
		
		/*Semaforos Vermelho*/
		JLabel semaforoVermelho1 = new JLabel();
		semaforoVermelho1.setIcon(new ImageIcon("img/semaforos/vermelho/semaforo1.png"));
		semaforoVermelho1.setBounds(235, 185, 128, 43);
		
		painel.add(semaforoVermelho1);
		
		JLabel semaforoVermelho2 = new JLabel();
		semaforoVermelho2.setIcon(new ImageIcon("img/semaforos/vermelho/semaforo2.png"));
		semaforoVermelho2.setBounds(495, 220, 43, 128);
		
		painel.add(semaforoVermelho2);
		
		JLabel semaforoVermelho3 = new JLabel();
		semaforoVermelho3.setIcon(new ImageIcon("img/semaforos/vermelho/semaforo3.png"));
		semaforoVermelho3.setBounds(375, 485, 128, 43);
		
		painel.add(semaforoVermelho3);
		
		JLabel semaforoVermelho4 = new JLabel();
		semaforoVermelho4.setIcon(new ImageIcon("img/semaforos/vermelho/semaforo4.png"));
		semaforoVermelho4.setBounds(195, 360, 43, 128);
		
		painel.add(semaforoVermelho4);
		
		/*Semaforos Verde*/
		JLabel semaforoVerde1 = new JLabel();
		semaforoVerde1.setIcon(new ImageIcon("img/semaforos/verde/semaforo1.png"));
		semaforoVerde1.setBounds(235, 185, 128, 43);
		
		semaforoVerde1.setVisible(false);
		painel.add(semaforoVerde1);
		
		JLabel semaforoVerde2 = new JLabel();
		semaforoVerde2.setIcon(new ImageIcon("img/semaforos/verde/semaforo2.png"));
		semaforoVerde2.setBounds(495, 220, 43, 128);
		
		semaforoVerde2.setVisible(false);
		painel.add(semaforoVerde2);
		
		JLabel semaforoVerde3 = new JLabel();
		semaforoVerde3.setIcon(new ImageIcon("img/semaforos/verde/semaforo3.png"));
		semaforoVerde3.setBounds(375, 485, 128, 43);
		
		semaforoVerde3.setVisible(false);
		painel.add(semaforoVerde3);
		
		JLabel semaforoVerde4 = new JLabel();
		semaforoVerde4.setIcon(new ImageIcon("img/semaforos/verde/semaforo4.png"));
		semaforoVerde4.setBounds(195, 360, 43, 128);
		
		semaforoVerde4.setVisible(false);
		painel.add(semaforoVerde4);
		
		/*Fundo*/
		
		JLabel fundo = new JLabel();
		fundo.setBounds(0, 0, 700, 700);
		fundo.setIcon(new ImageIcon("img/fundo.png"));
		
		/*Carros*/
		
		JLabel carro1 = new JLabel();
		carro1.setIcon(new ImageIcon("img/carros/carro1.png"));
		carro1.setBounds(283, 51, 64, 115);
		
		painel.add(carro1);
		
		JLabel carro2 = new JLabel();
		carro2.setIcon(new ImageIcon("img/carros/carro2.png"));
		carro2.setBounds(561, 272, 115, 64);
		
		painel.add(carro2);
		
		JLabel carro3 = new JLabel();
		carro3.setIcon(new ImageIcon("img/carros/carro3.png"));
		carro3.setBounds(387, 550, 64, 115);
		
		painel.add(carro3);
		
		JLabel carro4 = new JLabel();
		carro4.setIcon(new ImageIcon("img/carros/carro4.png"));
		carro4.setBounds(54, 381, 115, 64);
		
		painel.add(carro4);

		painel.add(fundo);
		
		ControleCarro cc = new ControleCarro(carro1, carro2, carro3, carro4, 
				semaforoVermelho1, semaforoVermelho2, semaforoVermelho3, semaforoVermelho4, 
				semaforoVerde1, semaforoVerde2, semaforoVerde3, semaforoVerde4, 
				fundoInicio, btnInicio);
		
		btnInicio.addActionListener(cc);
		
	}

}
