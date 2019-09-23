import javax.swing.JOptionPane;

public class ListaED01_Ex01 {

	static int qtd = 100;

	public static void main(String[] args) {
		
		double [] saldos = new double [qtd];
		String resultado = "Vetor: ";
		
		for(int i = 0; i < qtd; i++) {
			
			saldos[i] = (double) (Math.random() * 20000) - 10000;
			resultado += "[" + saldos[i] + "]";
			if((i + 1) % 10 == 0) {
				resultado += "\n";
			}
		}
		
		resultado += "\nMédia dos saldos de 100 a 1000: " + media100a1000(saldos) + "\n"; 
		resultado += "\nMédia geral: " + mediaGeral(saldos) + "\n"; 
		resultado += "\nSoma dos saldos negativos: " + somaNegativos(saldos) + "\n"; 

		JOptionPane.showMessageDialog(null, resultado);

	}

	static double media100a1000(double [] saldos) {
		
		double m = 0;
		int t = 0;

		for(int i = 0; i < saldos.length; i++) {
			if(saldos[i] >= 100 && saldos[i] <= 1000) {
				m += saldos[i];
				t++;
			}
		}
		if(t > 0) {
			m /= t;
		}
		
		return m;
	}

	static double mediaGeral(double [] saldos) {
		
		double m = 0;
		
		for(int i = 0; i < saldos.length; i++) {
			
			m += saldos[i];
		}	
		m /= qtd;
		
		return m;
	}

	static double somaNegativos(double [] saldos) {
		
		double s = 0;

		for(int i = 0; i < saldos.length; i++) {
			
			if(saldos[i] < 0) {
				
				s += saldos[i];
			}
		}
		
		return s;
	}
}
