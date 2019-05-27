/*
 * Lote 2 - Análise e Desenvolvimento de Sistemas (noturno)
 * Prof.º Ricardo Satoshi
 * 
 * a) Sistema: Aluno - Programa Principal
 */
package sistemaaluno;

/**
 *
 * @author Bruno
 */
import java.io.*;
import javax.swing.*;

class ManipulaDados {

    public static void main(String[] args) {
        
        int opcao = 0;
        
        JOptionPane.showMessageDialog(null, "Bem vindo(a) ao sistema de aluno.");
        
        while(opcao < 1 || opcao > 2){
        
        opcao = Integer.parseInt(JOptionPane.showInputDialog("1: Registrar aluno e pontos\n\n"
                                                           + "2: Verificar lista de alunos e pontos.\n\n"
                                                           + "Digite a opção desejada:"));
        
            switch(opcao){
                
                //Registrar aluno e pontos
                case 1:     int qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de alunos que você deseja registrar:"));
                            
                            //Inicio um objeto array que recebe a Classe Aluno
                            Aluno[] aluno = new Aluno[qtd];
                            
                            //Variáveis de controle
                            int i, ptos;
                            
                            //For: cada posição do array é um novo objeto de Classe Aluno
                            for (i = 0; i < qtd; i++) {
                                aluno[i] = new Aluno();
                            }
                            
                            //For: entrada de dados em cada posição
                            for (i = 0; i < qtd; i++) {
                                aluno[i].setNome(JOptionPane.showInputDialog("Digite o primeiro nome do aluno:"));
                                aluno[i].setSobrenome(JOptionPane.showInputDialog("Digite o sobrenome do aluno:\n" + aluno[i].getNome() + "..."));
                                aluno[i].setPontos(Float.parseFloat(JOptionPane.showInputDialog("Pontos de graduação de " + aluno[i].getNome() + " " + aluno[i].getSobrenome() + ":")));
                            }
                            
                            //For: print do sistema
                            for (i = 0; i < qtd; i++) {
                                System.out.println("\nAluno: " + aluno[i].getNome() + " " + aluno[i].getSobrenome() + "\n Pontos: " + aluno[i].getPontos());
                            }
                            System.exit(0);
                            
                            break;
                
                case 2:     
                            break;
                
                default:    JOptionPane.showMessageDialog(null, "Opção inválida.");
                            break;
            }
        
        }
        
    } // fim do método principal
} // fim da classe
