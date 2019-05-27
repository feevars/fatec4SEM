/*
--- LOTE2 ---

Exercício: Sistema de registro de alunos

 
*/
package RegistroAluno;

/**
 *
 * @author Fernanda Reis
 */
class Aluno {   //classe abstrata --> não é procedimento, pois não passa parâmetros
    String primeiro_nome;	 
    String ultimo_nome;	 
    int    notas;	 
	 
 // construtor	--> cria os "espaços" em branco, o modelo 
 Aluno () {
    this("", "" ,0);	 //String, String, int
 }
 
  Aluno (String aluno_primeironome, String aluno_ultimonome, int aluno_notas) {	 
  primeiro_nome   = aluno_primeironome;	 
  ultimo_nome  = aluno_ultimonome;	 
  notas  = aluno_notas;	 
 }	 
}
