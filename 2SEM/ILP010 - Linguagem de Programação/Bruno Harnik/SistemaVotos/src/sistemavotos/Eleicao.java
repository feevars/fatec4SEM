/*
 * Lote 2 - Análise e Desenvolvimento de Sistemas (noturno)
 * Prof.º Ricardo Satoshi
 * 
 * c) Sistema: Eleicao - Classe do Objeto Eleicao
 */
package sistemavotos;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Bega Harnik
 */
public class Eleicao {
    
    //Argumentos
    private int candidato, secao;
    public int num_candidatos = 13;
    public int num_secoes = 30;
    public int [] votos_candidatos = new int [num_candidatos];
    
    //Construtores
    Eleicao(){
        this(0,0);
    }
    Eleicao(int c, int s){   
        this.candidato = c;
        this.secao = s;
    }
    
    //Métodos Especiais
    //Registrar voto (Inicia objeto em cada posição do vetor e popula com random seus conteúdos
    public Eleicao[] registrarVoto(Eleicao[] voto, int qtd) {
        
        System.out.println("Votação: \n");
        
        int i;
        
        //Este 'FOR' cria um objeto voto em cada posição do array de voto.
        for(i = 0; i < qtd; i++){
            voto[i] = new Eleicao();
        }
        
        for(i = 0; i < qtd; i++){
            voto[i].setCandidato((int) (Math.random() * num_candidatos) + 1);

            voto[i].setSecao((int) (Math.random() * num_secoes) + 1);
            System.out.println("Candidato: " + voto[i].getCandidato() + "\tSeção: " + voto[i].getSecao());
        }
        
        return voto;
    }
    
    //classificaSecao (QuickSort)
    public Eleicao[] classificaSecao(Eleicao[] voto, int esquerda, int direita){
    
        int esq = esquerda;
        int dir = direita;
        int pivo = voto[(esq + dir) / 2].getSecao();
        int troca_s, troca_c;
        
        while(esq <= dir){
            while(voto[esq].getSecao() < pivo){
                esq++;
            }
            while(voto[dir].getSecao() > pivo){
                dir--;
            }
            if(esq <= dir){
                troca_s = voto[esq].getSecao();
                troca_c = voto[esq].getCandidato();
                voto[esq].setSecao(voto[dir].getSecao());
                voto[esq].setCandidato(voto[dir].getCandidato());
                voto[dir].setSecao(troca_s);
                voto[dir].setCandidato(troca_c);
                esq++;
                dir--;
            }
        }
        if(dir > esquerda)
            classificaSecao(voto, esquerda, dir);
        
        if(esq < direita)
            classificaSecao(voto, esq, direita);
        
        return voto;
    }
    
    public Eleicao[] classificaCandidato(Eleicao[] voto, int esquerda, int direita){
    
        int esq = esquerda;
        int dir = direita;
        int pivo = voto[(esq + dir) / 2].getCandidato();
        int troca_c, troca_s;
        
        while(esq <= dir){
            while(voto[esq].getCandidato() < pivo){
                esq++;
            }
            while(voto[dir].getCandidato() > pivo){
                dir--;
            }
            if(esq <= dir){
                troca_c = voto[esq].getCandidato();
                troca_s = voto[esq].getSecao();
                voto[esq].setCandidato(voto[dir].getCandidato());
                voto[esq].setSecao(voto[dir].getSecao());
                voto[dir].setCandidato(troca_c);
                voto[dir].setSecao(troca_s);
                esq++;
                dir--;
            }
        }
        if(dir > esquerda)
            classificaCandidato(voto, esquerda, dir);
        
        if(esq < direita)
            classificaCandidato(voto, esq, direita);
        
        return voto;
    }
    
    public Eleicao[] gravarVoto(Eleicao[] voto, int qtd) throws IOException {
        
        String nome_do_arquivo = "Resultado_da_votacao.txt";
        
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(nome_do_arquivo))) {
            int i;
            
            bf.write("Resultado da votação do programa ordenado por seção."
                    + "\n _______________________________ "
                    + "\n|---Candidato---||----Seção-----|"
                    + "\n|               ||              |");
            bf.newLine();
            
            for(i = 0; i < qtd; i++){
                bf.write("|\t" + voto[i].getCandidato() + "\t||\t" + voto[i].getSecao() + "\t|");
                bf.newLine();
            }
            bf.write("|_______________||______________|");
            
        }
        JOptionPane.showMessageDialog(null, "Arquivo de votação gerado.");
        
        return voto;
    }
    
    
    
    //Métodos GET & SET
    public int getCandidato(){
        return candidato;
    }
    public void setCandidato(int candidato){
        this.candidato = candidato;
    }
    public int getSecao(){
        return secao;
    }
    public void setSecao(int secao){
        this.secao = secao;
    }
   
}
