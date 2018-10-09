programa
{
	funcao inicio()
	{
		real volt, ext, temp, vm
		
		escreva("Número de voltas: ")
		leia(volt)

		escreva("Extensão do circuito (em metros): ")
		leia(ext)
		
		escreva("Duração (em minutos): ")
		leia(temp)

		temp = temp * 60
		vm = ((ext/temp) * 3.6) * volt

		escreva(vm,"Km/h")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 218; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */