/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavotos;

/**
 *
 * @author bruno
 */
import javax.swing.*;
import java.io.*;

public class SistemaVotos {

    public static void main(String[] args) throws IOException {
        
        int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Bem vindo(a) ao sistema de votos.\nDigite a quantidade de votos que devem ser computados:"));
        
        Voto[] voto = new Voto[qtd];
        
        Voto r = new Voto();
        
        r.registrarVoto(voto, qtd);
        r.classificaSecao(voto, 0, qtd - 1);
        r.gravarVoto(voto, qtd);

        
    }
    
}
