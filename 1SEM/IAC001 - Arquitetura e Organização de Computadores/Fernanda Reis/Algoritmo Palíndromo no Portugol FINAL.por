programa
{
	
	funcao inicio()
	{
		
	escreva("Fa�a um algoritmo que leia um n�mero (1 < n�mero < 10000) e,\ncaso ele n�o seja um n�mero pal�ndromo, aponte qual o n�mero pal�ndromo mais pr�ximo antes dele."






Var
// Se�?o de Declara�?es das vari�veis
informado, inv : inteiro
num, dig, p : inteiro


funcao ver_palindromo: inteiro

inicio

num <- informado
inv <-0

enquanto num <> 0 faca
   dig <- int(num % 10)
   inv <- (inv *10) + dig
   num <- int(num / 10)
fimenquanto
retorne inv
FimFuncao


Inicio
// Se�?o de Comandos, procedimento, fun�?es, operadores, etc...
escreval ("Vamos descobrir se um n?mero � pal�ndromo!")
ESCREVA("Digite um n?mero: ")
LEIA(informado)

se (informado >= 1) e (informado < 10000) entao
   inv <- ver_palindromo
   se (informado = inv) entao
      escreval("N?mero digitado: ", informado, " |  N?mero inverso: ", inv)
      escreval("O n?mero digitado � um pal�ndromo!")
   senao
      escreval ("O n?mero informado n?o � pal�ndromo :( mas...")
      p <- 1
      enquanto p = 1 faca
         inv <- ver_palindromo
         //fun�?o � definida pelo invertido pois � com ele que vamos comparar
         se informado = inv  entao
            p <- 0
            escreval ("O pal�ndromo mais pr�ximo abaixo �: ", informado)
         senao
            informado <- informado - 1
         fimse

      fimenquanto
   fimse
senao
   escreva("O n?mero informado n?o atende aos requisitos do programa.")
fimse
Fimalgoritmo












	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta se��o do arquivo guarda informa��es do Portugol Studio.
 * Voc� pode apag�-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 188; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */