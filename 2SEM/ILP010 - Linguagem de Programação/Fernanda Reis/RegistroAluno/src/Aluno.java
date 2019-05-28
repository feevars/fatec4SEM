/*
--- LOTE 2 ---

Exercício: Sistema de Registro de Alunos


Professor: Ricardo Satoshi
Programadora: Fernanda Reis 

 */
class Aluno {
 String pnome;	
 String unome;	
 int pontos;	
	
 // construtor	
 Aluno () {	
  this("" ,"" , 0);	//referenciar 
 }	
	
   Aluno ( String pnomealuno,	
   String unomealuno,	
   int pontosaluno )	
 {	
  pnome   = pnomealuno;	
  unome  = unomealuno;	
  pontos  = pontosaluno;	
 }	    
}
