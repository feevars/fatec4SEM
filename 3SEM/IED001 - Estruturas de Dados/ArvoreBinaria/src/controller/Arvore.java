package controller;

public class Arvore {
	public static No raiz;
	
	//Inserir novo valor a um novo nó
	public void inserir(int valor) {
		inserir(raiz, valor);
	}
	
	//Inserir nó com regra de arvore
	public void inserir( No node, int valor) {
		//Se a raiz for nula, inserimos na raiz
		if(node ==null) {
			System.out.println("Valor " +valor+ " inserido na raiz da arvore!");
			raiz = new No(valor);
			
		//Caso contrario:
		//Se for menor, inserimos no nó a esquerda
		}else {
			//Caso o valor seja menor que o nó raiz
			if (valor < node.getValor()) {
				//Verificando se o nó a esquerda é nulo
				if(node.getNoEsquerda() != null) {
					//Caso nao seja, chamanos a função inserir, passando o nó a esquerda como raiz
					inserir(node.getNoEsquerda(), valor);
				}
				//Se for nulo, inserimos o valor diretamente ao nó
				else {
					System.out.println("Valor " + valor + " inserido a esquerda de "+ node.getValor());
					node.setNoEsquerda(new No(valor));
				}
			}
			//Caso o valor seja maior que o nó raiz
			else {
				//Se no a direita nao for nulo, chamaos a funcao inserir passando
				//Passamos no a direita como raiz 
				if(node.getNoDireita() != null) {
					inserir(node.getNoDireita(), valor);
				}
				else {
					//Se for nulo, inserimos o valor no nó a direita
					System.out.println("Valor " + valor + " inserido a direita de "+ node.getValor());
					node.setNoDireita(new No(valor));
				}
			}
		}
	}
	
}
