package dinossauro;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {
		
		Dinossauro skeep = new Dinossauro();
		boolean loop = true;
		String op = "" ;
			

			
			while(loop == true) {
				
				JOptionPane.showMessageDialog(null,
						"\n----------CARACTERISTICAS DO SKEEP-------------------" +
						"\nHUMOR: " + skeep.getHumor() +
						"\nENERGIA: " + skeep.getEnergia() +
						"\nVELOCIADE: " + skeep.getVelocidade() +
						"\nTEMPERATURA: " + skeep.getTemperatura());
				
				JOptionPane.showMessageDialog(null,
						"\n(P)ular" +
						"\n(C)orrer" +
						"\nco(M)er" +
						"\n(A)tirar" +
						"\ntomar (S)ol" +
						"\nficar na s(O)mbra" +
						"\n(E) - sair");
				
				op = JOptionPane.showInputDialog("INFORME A OPCAO: ");			
				
				switch (op.toUpperCase()) {
						
					case "P":
						skeep.pular();
						break;
						
					case "C":
						skeep.correr();
						break;
						
					case "M":
						skeep.comer();
						break;
						
					case "A":
						skeep.atirar();
						break;
						
					case "S":
						skeep.tomarSol();
						break;
					
					case "O":
						skeep.ficarNaSombra();
						break;
						
					case "E":
						loop = false;
						break;
						
				}
			}

		}	
	
	

}
