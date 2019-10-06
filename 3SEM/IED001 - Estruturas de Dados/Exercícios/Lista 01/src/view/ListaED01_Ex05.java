package view;
import javax.swing.JOptionPane;

public class ListaED01_Ex05 {

	public static void main(String[] args) {

		int [][] matriz = new int [4][4];
		String resultado = "Matriz: \n";
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(i == j) {
					matriz[i][j] = (int) Math.pow(3, i);
				}else {
					matriz[i][j] = (int) (Math.random() * 80) - 40;
				}
				resultado += "[" + matriz[i][j] + "]";
			}
			resultado += "\n";
		}
		JOptionPane.showMessageDialog(null, resultado);
	}
}