package view;


import javax.swing.JOptionPane;

import controller.Fila;
import controller.Pilha;
import model.Livro;

public class exerciciosLivros {

	public static void main(String[] args) {
		
		int capacidade = Integer.parseInt((JOptionPane.showInputDialog("Digite a capacidade das estruturas de dados: ")));
		
		Fila<Livro> filaLivros = new Fila<Livro>(capacidade);
		Pilha<Livro> pilhaLivros = new Pilha<Livro>(capacidade);
		
		inserirLivros(filaLivros, capacidade);
		
		JOptionPane.showMessageDialog(null, "Fila de livros: " + filaLivros + "\nPilha de livros: " + pilhaLivros);
		
		daFilaParaPilha(filaLivros, pilhaLivros, capacidade);
		
		JOptionPane.showMessageDialog(null, "Da fila para a pilha:\n\nFila de livros: " + filaLivros + "\nPilha de livros: " + pilhaLivros);
		
		daPilhaParaFila(pilhaLivros, filaLivros, capacidade);
		
		JOptionPane.showMessageDialog(null, "Da pilha para a fila:\n\nFila de livros: " + filaLivros + "\nPilha de livros: " + pilhaLivros);
		
	}
	
	public static void inserirLivros(Fila<Livro> f, int c) {
		
		Livro [] l = new Livro[c];

		for (int i = 0; i < c; i++) {
			
			l[i] = new Livro();
			l[i].setTitulo(JOptionPane.showInputDialog("Digite o Título do livro " + (i + 1)));
			l[i].setAutor(JOptionPane.showInputDialog("Digite o Autor do livro " + (i + 1)));
			l[i].setAnoLancamento(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento (inteiro) do livro " + (i + 1))));
			l[i].setEditora(JOptionPane.showInputDialog("Digite a Editora do livro " + (i + 1)));
			l[i].setIsbn(JOptionPane.showInputDialog("Digite o ISBN do livro " + (i + 1)));
			l[i].setEdicao(Integer.parseInt(JOptionPane.showInputDialog("Digite a Edição (inteiro) do livro " + (i + 1))));
			f.enqueue(l[i]);
		}
	}
	
	public static void daFilaParaPilha(Fila<Livro> f, Pilha<Livro> p, int c) {
		
		for (int i = 0; i < c; i++) {
			p.push(f.dequeue());
		}
	}
	
	public static void daPilhaParaFila(Pilha<Livro> p, Fila<Livro> f, int c) {
		for (int i = 0; i < c; i++) {
			f.enqueue(p.pop());
		}
	}

}
