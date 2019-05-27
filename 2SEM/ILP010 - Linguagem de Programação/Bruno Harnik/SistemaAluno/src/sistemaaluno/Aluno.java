/*
 * Lote 2 - Análise e Desenvolvimento de Sistemas (noturno)
 * Prof.º Ricardo Satoshi
 * 
 * a) Sistema: Aluno - Classe do Objeto
 */
package sistemaaluno;

/**
 *
 * @author bruno
 */
public class Aluno {

    public String nome;
    public String sobrenome;
    private double pontos;

    // Métodos construtores: 1º - Recebendo em array, 2º - Declaração de cada variável	 
    Aluno() {
        this("", "", 0);
    }

    Aluno(String nomealuno, String sobrenomealuno, double pontosaluno){
          nome = nomealuno;
          sobrenome = sobrenomealuno;
          pontos = pontosaluno;
    }
    
    //Métodos get & set de encapsulamento
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }
    
    
}
