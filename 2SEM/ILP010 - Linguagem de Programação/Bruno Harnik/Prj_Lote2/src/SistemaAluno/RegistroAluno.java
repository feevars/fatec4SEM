/*
 * Lote 2 - Análise e Desenvolvimento de Sistemas (noturno)
 * Prof.º Ricardo Satoshi
 * 
 * a) Sistema: Aluno - Classe do Registro
 */
package SistemaAluno;

/**
 *
 * @author Bruno
 */
import java.io.*;
import javax.swing.*;

class RegistroAluno {

    public static void main(String[] args) {
        Aluno[] aluno = new Aluno[3];
        int i, ptos;
        for (i = 0; i < 3; i++) {
            aluno[i] = new Aluno();
        }

        for (i = 0; i < 3; i++) {
            aluno[i].pnome = JOptionPane.showInputDialog("Entre o nome do aluno:");
            aluno[i].unome = JOptionPane.showInputDialog("Entre o sobrenome do aluno:");
            aluno[i].pontos = Integer.parseInt(JOptionPane.showInputDialog("Pontos Graduação do aluno:"));
        }

        for (i = 0; i < 3; i++) {
            System.out.println(aluno[i].pnome + " " + aluno[i].unome + " pontos: " + aluno[i].pontos);
        }

        System.exit(0);
    } // fim do método	
} // fim da classe	
