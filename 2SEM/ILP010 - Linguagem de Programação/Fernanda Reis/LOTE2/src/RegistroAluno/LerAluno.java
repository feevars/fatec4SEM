/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroAluno;

import java.io.*;	
import javax.swing.*;	

class LerAluno	
{	
	
 public static void main ( String[] args ) throws IOException	
 {	
  Aluno[] aluno = new Aluno[3];	
  int i,ptos;	
  String fileName = "ArquivoAluno.txt";	
	
  BufferedReader ler = new BufferedReader(new FileReader( fileName ));	

  for (i = 0 ; i < 3 ; i++)	
   aluno[i] = new Aluno();
	
  for (i = 0 ; i < 3 ; i++)
   {	
    aluno[i].primeiro_nome = ler.readLine();  	
    aluno[i].ultimo_nome = ler.readLine();	
    aluno[i].notas = Integer.parseInt(ler.readLine());	
   }	
  	
  for (i = 0 ; i < 3; i++) {	
   System.out.println(aluno[i].primeiro_nome + " " + aluno[i].ultimo_nome + " pontos: " + aluno[i].notas);	
  }
  ler.close();	
  System.exit(0);	
   } // fim do método	
} // fim da classe	

