package controller;

/*================================================================================
 * 
 * O MergeSort possui dois métodos, um que separa (que damos o nome de mergeSort, devido à chamada)
 * e outro que intercala.
 * 
 * 
 * 	
 * O método que intercala possui 4 condições de comparação:
 * - Quando é atingido o último índice da parte esquerda
 * 		o loop de preenchimento de resultados adiciona os elementos da direita sequencialmente.
 * - Quando é atingido o último índice da parte direita
 * 		o loop de preenchimento de resultados adiciona os elementoda da esquerda sequencialmente.
 * – Quando o valor do índice da esquerda é menor do que valor do índice da direita
 * 		o vetor de resultados adiciona o valor do índice da esquerda, incrementando 1 no índice da esquerda.
 * - Quando o valor do índice da direta é menor do que valor do índice da esquerda
 * 		o vetor de resultados adiciona o valor do índice da direita, incrementando 1 no índice da direita.	
 * 
 * 
 * 
 * 
 *===============================================================================*/
public class MergeSort {
	
	public void mergeSort(int [] vetor) {
		
		//Quando o tamanho do vetor é 1, retorna – condição de parada.
		
		
		//Inicia dois vetores com a metade do tamanho do vetor inicial:
		int metade = vetor.length / 2;
		int [] esquerda = new int[metade];
		int [] direita = new int[vetor.length - metade]; //Aqui resolve vetor ímpar.
		
		//Adiciona o conteúdo às duas metades:
		for (int i = 0; i < vetor.length; i++) {
			if(i < metade) esquerda[i] = vetor[i];
			else direita[i - metade] = vetor[i]; //O "i - metade" é para preencher a segunda metade a partir do índice 0.
		}
		
		//Agora vai a recursividade...
		//Os vetores serão divididos até terem 1 de tamanho, ou seja, encontrarão
		//o ponto de parada.
		mergeSort(esquerda);
		mergeSort(direita);
		
		//Depois que tudo está separadinho,
		//intercala.
		intercalar(esquerda, direita, vetor);
	}
	public void intercalar(int [] esquerda, int [] direita, int [] resultado) {
		
		int indiceEsq = 0, indiceDir = 0;
		
		for (int k = 0; k < resultado.length; k++) {
			
			if (indiceEsq == esquerda.length) {
				//Se o índiceEsq aponta para o último elemento do vetor da esquerda...
				resultado[k] = direita[indiceDir];
				indiceDir++;
				//o vetor de resultados começa a ser preenchido com o vetor da direita.
			}
			else if (indiceDir == direita.length) {
				//Se o índiceDir aponta para o último elemento do vetor da direita...
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
				//o vetor de resultados começa a ser preenchido com o vetor da esquerda.
			}
			else if (esquerda[indiceEsq] < direita[indiceDir]) {
				//Se o elemento que está no índice da esquerda é menor que o que está na direita...
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
				//o vetor de resultados recebe o elemento da esquerda.
			}else {
				//Se não, o elemento da direita é menor que o da esquerda...
				resultado[k] = direita[indiceDir];
				indiceDir++;
				//o vetor de resultados recebe o elemento da direita.
			}
		}
	}
}
