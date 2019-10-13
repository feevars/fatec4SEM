package view;

import javax.swing.JOptionPane;

import controller.ListaDupla;

public class Ex02 {
	
	public static void main(String[] args) {
		
		ListaDupla <Double> l = new ListaDupla<Double>();
		l.inserirPrimeiro(Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número real")));
		l.inserirPrimeiro(Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número real")));
		l.inserirUltimo(Double.parseDouble(JOptionPane.showInputDialog("Digite o ultimo número real")));
		l.inserirPrimeiro(Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número real")));
		l.inserirPrimeiro(Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número real")));
		l.inserirUltimo(Double.parseDouble(JOptionPane.showInputDialog("Digite o ultimo número real")));
		JOptionPane.showMessageDialog(null, l.imprimirLista());
		
	}
}
