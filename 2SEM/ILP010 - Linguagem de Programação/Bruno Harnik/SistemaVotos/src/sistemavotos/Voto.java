package sistemavotos;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class Voto {
    
    //Argumentos
    private int candidato, secao;
    
    
    //Construtores
    Voto(){
        this(0,0);
    }
    Voto(int c, int s){   
        this.candidato = c;
        this.secao = s;
    }
    
    //Métodos Especiais
    //Registrar voto (Inicia objeto em cada posição do vetor e popula com random seus conteúdos
    public Voto[] registrarVoto(Voto[] voto, int qtd) {
        
        System.out.println("Votação: \n");
        
        int i;
        
        //Este 'FOR' cria um objeto voto em cada posição do array de voto.
        for(i = 0; i < qtd; i++){
            voto[i] = new Voto();
        }
        
        for(i = 0; i < qtd; i++){
            voto[i].setCanditado((int) (Math.random() * 13) + 1);
            voto[i].setSecao((int) (Math.random() * 50) + 1);
            System.out.println("Candidato: " + voto[i].getCandidato() + "\tSeção: " + voto[i].getSecao());
        }
        
        return voto;
    }
    
    //classificaSecao (QuickSort)
    public Voto[] classificaSecao(Voto[] voto, int esquerda, int direita){
    
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
                voto[esq].setCanditado(voto[dir].getCandidato());
                voto[dir].setSecao(troca_s);
                voto[dir].setCanditado(troca_c);
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
    
    public Voto[] gravarVoto(Voto[] voto, int qtd) throws IOException {
        
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
            bf.write("⌊_______________⌋⌊______________⌋");
            
        }
        JOptionPane.showMessageDialog(null, "Arquivo de votação gerado.");
        
        return voto;
    }
    
    //Métodos GET & SET
    public int getCandidato(){
        return candidato;
    }
    public void setCanditado(int candidato){
        this.candidato = candidato;
    }
    public int getSecao(){
        return secao;
    }
    public void setSecao(int secao){
        this.secao = secao;
    }
   
}
