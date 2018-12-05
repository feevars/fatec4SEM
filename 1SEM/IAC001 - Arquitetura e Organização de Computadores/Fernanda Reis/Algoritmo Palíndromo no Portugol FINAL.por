programa
{
	
	funcao inicio()
	{
		
	escreva("Faça um algoritmo que leia um número (1 < número < 10000) e,\ncaso ele não seja um número palÌndromo, aponte qual o número palíndromo mais próximo antes dele."






Var
// SeÁ?o de DeclaraÁ?es das vari·veis
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
// SeÁ?o de Comandos, procedimento, funÁ?es, operadores, etc...
escreval ("Vamos descobrir se um n?mero È palÌndromo!")
ESCREVA("Digite um n?mero: ")
LEIA(informado)

se (informado >= 1) e (informado < 10000) entao
   inv <- ver_palindromo
   se (informado = inv) entao
      escreval("N?mero digitado: ", informado, " |  N?mero inverso: ", inv)
      escreval("O n?mero digitado È um palÌndromo!")
   senao
      escreval ("O n?mero informado n?o È palÌndromo :( mas...")
      p <- 1
      enquanto p = 1 faca
         inv <- ver_palindromo
         //funÁ?o È definida pelo invertido pois È com ele que vamos comparar
         se informado = inv  entao
            p <- 0
            escreval ("O palÌndromo mais prÛximo abaixo È: ", informado)
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
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 188; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */