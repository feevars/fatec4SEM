package RegistroAluno;
import java.io.*;	
import javax.swing.*;


/*
 *
 * @author Fernanda Reis
 */

class GravaAluno {    	
 public static void main ( String[] args ) throws IOException //pesquisarrrrrrrrrrrrr	
 {	
  Aluno[] aluno = new Aluno[3];	
  int i,ptos;	
  String fileName = "ArquivoAluno.txt";	
	
  BufferedWriter writer = new BufferedWriter(new FileWriter( fileName )); //pacote do .io para escrever arquivo .txt	

  for (i = 0 ; i < 3 ; i++)	
   aluno[i] = new Aluno();
	
  for (i = 0 ; i < 3 ; i++) //para escrever no .txt
   {	
   aluno[i].primeiro_nome = JOptionPane.showInputDialog("Entre o nome do aluno:");	
   writer.write( aluno[i].primeiro_nome );  	
   writer.newLine();	
   aluno[i].ultimo_nome = JOptionPane.showInputDialog("Entre o sobrenome do aluno:");	
   writer.write( aluno[i].ultimo_nome );  	
   writer.newLine();	
   aluno[i].notas = Integer.parseInt(JOptionPane.showInputDialog("Pontos Graduação do aluno:"));	
   writer.write(Integer.toString(aluno[i].notas));   	
   writer.newLine();	
   }	
  	
  for (i = 0 ; i < 3; i++) {	//printar
   System.out.println(aluno[i].primeiro_nome + " " + aluno[i].ultimo_nome + " pontos: " + aluno[i].notas);	
  }
  writer.close();	
  System.exit(0);	
   } // fim do método	
} // fim da classe	
