/*
 * Lote 2 - Análise e Desenvolvimento de Sistemas (noturno)
 * Prof.º Ricardo Satoshi
 * 
 * a) Sistema: Aluno - Programa Principal
 */
package sistemaaluno;

/**
 *
 * @author Bruno Bega Harnik
 */
import javax.swing.*;
import java.io.*;

class ManipulaDados {

    public static void main(String[] args) throws IOException {
        
        int opcao = 0;
        
        JOptionPane.showMessageDialog(null, "Bem vindo(a) ao sistema de aluno.");
        
        while((opcao != 9)){
        
        opcao = Integer.parseInt(JOptionPane.showInputDialog("1: Registrar aluno e pontos\n"
                                                           + "2: Verificar lista de alunos e pontos.\n\n"
                                                           + "9: Encerrar programa.\n\n"
                                                           + "Digite a opção desejada:"));
        
            switch(opcao){
                
                //Registrar aluno e pontos
                case 1:     int qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de alunos que você deseja registrar:"));
                            
                            //Inicio um objeto array que recebe a Classe Aluno
                            Aluno[] aluno = new Aluno[qtd];
                            
                            //Inicio um objeto e executo o método de gravação
                            Aluno g = new Aluno();
                            g.gravarAluno(aluno, qtd);
                            
                            break;
                
                case 2:     //Inicio um objeto para executar o método de leitura
                            Aluno l = new Aluno();
                            l.lerAluno();
                            
                            break;
                
                case 9:     JOptionPane.showMessageDialog(null, "Obrigado por testar o Sistema de Aluno.\nFim do programa.");
                            break;
                
                default:    JOptionPane.showMessageDialog(null, "Opção inválida.");
                            break;
            }
        
        }
        
    } // fim do método principal
} // fim da classe
