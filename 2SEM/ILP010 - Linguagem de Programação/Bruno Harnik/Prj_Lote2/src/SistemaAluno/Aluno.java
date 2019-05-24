/*
 * Lote 2 - Análise e Desenvolvimento de Sistemas (noturno)
 * Prof.º Ricardo Satoshi
 * 
 * a) Sistema: Aluno - Classe abstrata
 */
package SistemaAluno;

/**
 *
 * @author Bruno Bega Harnik
 */
class Aluno {

    String pnome;
    String unome;
    int pontos;

    // construtor	 
    Aluno() {
        this("", "", 0);
    }

    Aluno(String pnomealuno,
            String unomealuno,
            int pontosaluno) {
        pnome = pnomealuno;
        unome = unomealuno;
        pontos = pontosaluno;
    }
}
