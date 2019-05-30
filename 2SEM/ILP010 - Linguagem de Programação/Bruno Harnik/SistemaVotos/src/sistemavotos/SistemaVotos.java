/*
 * Lote 2 - Análise e Desenvolvimento de Sistemas (noturno)
 * Prof.º Ricardo Satoshi
 * 
 * c) Sistema: Eleicao - Programa Principal
 */
package sistemavotos;

/**
 *
 * @author Bruno Bega Harnik
 */
import javax.swing.*;
import java.io.*;

public class SistemaVotos {

    public static void main(String[] args) throws IOException {
        
        int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem vindo(a) ao sistema de votos.\nDigite a quantidade de votos que devem ser computados:"));
        
        Eleicao[] voto = new Eleicao[qtd];
        
        Eleicao metodos = new Eleicao();
        
        Estatisticas stat = new Estatisticas();
        
        metodos.registrarVoto(voto, qtd);
        metodos.classificaSecao(voto, 0, qtd - 1);
        metodos.gravarVoto(voto, qtd);
        
        
        stat.eleitoresSecao(voto, qtd);
        stat.secaoMaiorMenor();
        //metodos.classificaCandidato(voto, 0, qtd - 1);
        //stat.votosCandidatos(voto, qtd);

        
    }
    
}
