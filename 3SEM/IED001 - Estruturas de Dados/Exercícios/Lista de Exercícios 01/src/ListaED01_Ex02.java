import javax.swing.JOptionPane;

public class ListaED01_Ex02 {
	
	public static void main (String[] args) {
		
		int [] numeros = new int [5];
		int [] fatoriais = new int [5];
		String resultado = "";
		
		for(int i = 0; i < 5; i++) {
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i+1) + "º número inteiro:"));
			resultado += "Fatorial de " + numeros[i] + ": ";
			fatoriais[i] = fatorial(numeros[i]);
			resultado += fatoriais[i] + "\n";
		}
		
		JOptionPane.showMessageDialog(null, resultado);
	}
	
	static int fatorial(int n) {
		
		int f = n;
		
		for(int i = 2; i < n; i++) {
			f *= i;
		}
		
		return f;
	}
}