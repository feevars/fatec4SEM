package controller;

import javax.swing.JOptionPane;

class Ponteiros <T>extends Thread {
	int id;
	T conteudo;
	int posicao;

	Ponteiros (int id,T conteudo, int posicao2){
		this.id = id;
		this.conteudo = conteudo;
		this.posicao = posicao;

	}

	public void run() {
		boolean ok = true;
		ListaDupla<T> lista = new ListaDupla<T>();
		No<T> novoNo = new No<T>(conteudo);
		while(ok) {
			if(id==1) {
				No<T> atual = lista.getPrimeiro();
				for (int i = 1; i < posicao-1; i++) {
					atual = atual.getProximo();
				}
				novoNo.setAnterior(atual);
				novoNo.setProximo(atual.getProximo());
				atual.setProximo(novoNo);
				atual = novoNo.getProximo();
				atual.setAnterior(novoNo);
				JOptionPane.showMessageDialog(null, "O ponteiro 1 fez o trabalho");
				ok = false;
			}


			No<T> atual = lista.getUltimo();
			for (int i = lista.getQtdNo(); i > posicao; i--) {
				atual = atual.getAnterior();

			}
			novoNo.setProximo(atual);
			novoNo.setAnterior(atual.getAnterior());
			atual.setAnterior(novoNo);
			atual = novoNo.getAnterior();
			atual.setProximo(novoNo);
			JOptionPane.showMessageDialog(null, "O ponteiro 2 fez o trabalho");
			ok = false;
		}


	}

}



