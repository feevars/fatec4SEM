import javax.swing.JOptionPane;

public class ListaED01_Ex04 {

	public static void main(String[] args) {
		
		int [][] matriz = new int [4][4];
		String resultado = "Matriz carregada:\n";
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				
				matriz[i][j] = (int) (Math.random() * 200) - 100;
				resultado += "[" + matriz[i][j] + "]";
				
			}
			resultado += "\n";
		}
		
		resultado += "Soma dos valores no intervalo de 1 a 100: " + soma1a100(matriz) + "\n";
		resultado += "Quantidade de números impares entre 30 a 50: " + qtdImpar30a50(matriz) + "\n";
		resultado += "Quantidade de números divisíveis por 8: " + qtdMod8(matriz) + "\n";
		resultado += "Quantidade de números ímpares divisíveis por 3: " + qtdImparMod3(matriz) + "\n";
		resultado += "Fatorial do maior número informado na matriz: " + fatorialMaior(matriz) + "\n";
		
		JOptionPane.showMessageDialog(null, resultado);

	}
	
	static int soma1a100(int [][] m) {
		
		int soma = 0;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] > 0 && m[i][j] <= 100) {
					soma += m[i][j]; 
				}
			}
		}
		
		return soma;
	}
	static int qtdImpar30a50(int [][] m) {
		
		int q = 0;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if(m[i][j] > 30 && m[i][j] < 50 && m[i][j] % 2 != 0) {
					q++;
				}
			}
		}
		
		return q;		
	}
	static int qtdMod8(int [][] m) {
		
		int q = 0;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] % 8 == 0) {
					q++;
				}
			}
		}
		
		return q;
	}
	static int qtdImparMod3(int [][] m) {
		
		int q = 0;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if(m[i][j] % 2 != 0 && m[i][j] % 3 == 0) {
					q++;
				}
			}
		}
		
		return q;
		
	}
	static long fatorialMaior(int [][] m) {
		
		long f = 0;
		long maior = m[0][0];
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if(m[i][j] > maior) {
					maior = m[i][j];
				}
			}
		}
		
		if(maior > 0) {
			f = maior;
			
			for(long i = 2; i < maior; i++) {
				f *= i;
			}
		}
		
		return f;
	}
}
