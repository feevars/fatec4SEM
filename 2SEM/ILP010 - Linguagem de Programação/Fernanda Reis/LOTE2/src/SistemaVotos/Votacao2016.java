/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaVotos;
import java.io.*;
import javax.swing.*;

 /*
 * @author Fernanda
 */

class Votacao2016 {
    public static void main (String args []) throws IOException {
        Votacao[] voto = new Votacao[2];
        int i,ptos;
        String fileName = "RegistroVotos.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter (fileName)); //escrever no arquivo .txt 
        
        for (i=0; i<100; i++)
         voto[i] = new Votacao(); //array para puxar os arquivo
    }
}
