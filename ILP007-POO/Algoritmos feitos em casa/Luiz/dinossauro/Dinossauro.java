package dinossauro;

import javax.swing.JOptionPane;

public class Dinossauro {

	private Integer energia = 1;
	private Integer velocidade = 1;
	private Integer temperatura = 1;
	private Integer humor = 1;
	
	
	
	
	public Integer getEnergia() {
		return energia;
	}

	public void setEnergia(Integer energia) {
		this.energia = energia;
	}

	public Integer getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}

	public Integer getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

	public Integer getHumor() {
		return humor;
	}

	public void setHumor(Integer humor) {
		this.humor = humor;
	}

	public Dinossauro() {
		JOptionPane.showMessageDialog(null,"SKEEP CRIADO!");
	}
	
	public void pular() {
		this.energia --;
		this.humor ++;
		JOptionPane.showMessageDialog(null,"PULANDO! -1 energia  + 1 humor");
	}
	
	public void correr() {
		this.energia --;
		this.humor ++;
		JOptionPane.showMessageDialog(null,"CORRENNDO! -1 energia  + 1 humor");
	}
	
	public void comer(){
		this.energia ++;
		this.humor ++;
		JOptionPane.showMessageDialog(null,"COMENDO! +1 energia  + 1 humor");
	}
	
	public void atirar(){
		this.energia --;
		this.humor ++;
		JOptionPane.showMessageDialog(null,"ATIRANDO! -1 energia  + 1 humor");
	}
	
	public void tomarSol(){
		this.velocidade ++;
		this.energia --;
		this.humor ++;
		JOptionPane.showMessageDialog(null,"TOMANDO SOL! -1 energia  + 1 humor  + 1 velocidade");
	}
	
	public void ficarNaSombra(){
		this.energia ++;
		this.humor --;
		JOptionPane.showMessageDialog(null,"DESCANSANDO NA SOMBRA! +1 energia  - 1 humor");
	}
	
}
