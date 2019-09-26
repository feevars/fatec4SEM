/**
 * Classe de controle de carros da aplicação.
 * @author Augusto Luiz Silva
 * @date: 10/04/18
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ControleCarro implements ActionListener{
	private JLabel carro1, carro2, carro3, carro4;
	private JLabel semaforoVermelho1, semaforoVermelho2, semaforoVermelho3, semaforoVermelho4;
	private JLabel semaforoVerde1, semaforoVerde2, semaforoVerde3, semaforoVerde4;
	private JLabel fundoInicio;
	private JButton btnInicio;
	
	private Semaphore semaforo = new Semaphore(1);
	
	/**
	 * Construtor
	 * @param carro1 recebe o JLabel correspondente ao primeiro carro
	 * @param carro2 recebe o JLabel correspondente ao segundo carro
	 * @param carro3 recebe o JLabel correspondente ao terceiro carro
	 * @param carro4 recebe o JLabel correspondente ao quarto carro
	 * @param semaforoVermelho1 recebe o JLabel do primeiro semaforo vermelho
	 * @param semaforoVermelho2 recebe o JLabel do segundo semaforo vermelho
	 * @param semaforoVermelho3 recebe o JLabel do terceiro semaforo vermelho
	 * @param semaforoVermelho4 recebe o JLabel do quarto semaforo vermelho
	 * @param semaforoVerde1 recebe o JLabel do primeiro semaforo verde
	 * @param semaforoVerde2 recebe o JLabel do segundo semaforo verde
	 * @param semaforoVerde3 recebe o JLabel do terceiro semaforo verde
	 * @param semaforoVerde4 recebe o JLabel do quarto semaforo verde
	 * @param fundoInicio recebe o JLabel do fundo de início
	 * @param btnInicio recebe o JButton que inicia a aplicação
	 */
	
	public ControleCarro(JLabel carro1, JLabel carro2, JLabel carro3, JLabel carro4,
			JLabel semaforoVermelho1, JLabel semaforoVermelho2, JLabel semaforoVermelho3,
			JLabel semaforoVermelho4, JLabel semaforoVerde1, JLabel semaforoVerde2,
			JLabel semaforoVerde3, JLabel semaforoVerde4, JLabel fundoInicio, JButton btnInicio) {
		
		this.carro1 = carro1;
		this.carro2 = carro2;
		this.carro3 = carro3;
		this.carro4 = carro4;
		
		this.semaforoVermelho1 = semaforoVermelho1;
		this.semaforoVermelho2 = semaforoVermelho2;
		this.semaforoVermelho3 = semaforoVermelho3;
		this.semaforoVermelho4 = semaforoVermelho4;
		
		this.semaforoVerde1 = semaforoVerde1;
		this.semaforoVerde2 = semaforoVerde2;
		this.semaforoVerde3 = semaforoVerde3;
		this.semaforoVerde4 = semaforoVerde4;
		
		this.fundoInicio = fundoInicio;
		this.btnInicio = btnInicio;
	}
	
	/**
	 * Método que é executado ao clicar sobre o JButton. Aqui será feita as chamadas à classe ThreadSemaforo com seus respectivos objetos
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fundoInicio.setVisible(false);
		btnInicio.setVisible(false);
		
		ThreadSemaforo ts1 = new ThreadSemaforo(carro1, semaforoVermelho1, semaforoVerde1,
				semaforo, fundoInicio, btnInicio, 1);
		
		ThreadSemaforo ts2 = new ThreadSemaforo(carro2, semaforoVermelho2, semaforoVerde2,
				semaforo, fundoInicio, btnInicio, 2);
		
		ThreadSemaforo ts3 = new ThreadSemaforo(carro3, semaforoVermelho3, semaforoVerde3,
				semaforo, fundoInicio, btnInicio, 3);
		
		ThreadSemaforo ts4 = new ThreadSemaforo(carro4, semaforoVermelho4, semaforoVerde4,
				semaforo, fundoInicio, btnInicio, 4);
		
		ts1.start();
		ts2.start();
		ts3.start();
		ts4.start();
	}
	
}
