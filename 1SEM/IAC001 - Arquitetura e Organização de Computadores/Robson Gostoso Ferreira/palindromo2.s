.data
	
	msgintro: 
		.asciiz "\nBem vindo. A seguir, você poderá observar se um número X entre 1 e 10.000 é um Palíndromo.\n"
	msgnumero: 
		.asciiz "Digite um numero entre 1 e 10.000: "
	msgerro: 
		.asciiz "Você não digitou um número entre 1 e 10.000!"
	msgsim: 
		.asciiz "Esse número é um palindromo!\n"
	msgnao: 
		.asciiz "Esse número NÃO é um palíndromo!\n"
	msgfim:
		.asciiz "\nObrigado por usar esse programa!"
	msgfim2: 
		.asciiz "\nCréditos: Robson Henrique Ferreira"
	
.text

	main:

	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem
	la $a0, msgintro 		#endereco da mensagem introdutoria
	syscall				#invocacao do servico print_str
	
	
	inicio:				

	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem
	la $a0, msgnumero 		#endereco da mensagem de ordem 
	syscall				#invocacao do servico print_str
			
	li $v0, 5			#identificacao do servico read_int / leitura de um numero
	syscall				#invocacao do servico read_int
	add $t0, $v0, $zero		#adiciona o valor de $v0 ao $t0 / Agora o $t0 tem o número digitado pelo usuário			
					
						
	li $s0, 1			#atribuicao do valor 1 para variavel
	li $s1, 10000 			#atribuicao do valor 10000 para variavel

	ble $t0, $s0, erro		#Se numero digitado for menor ou igual a 1, ir para erro
	bge $t0, $s1, erro  		#Se numero digitado for maior ou igual a 1000, ir para erro 
	j palindromo


	erro:				

	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem	
	la $a0, msgerro 		#endereco da mensagem de erro
	syscall	 			#invocacao do servico print_str
	j inicio
 		
							
	palindromo: 			

	add $t2, $t0, 0			#Adicionou o número informado ao t2
	li $t1, 0			#adicionou o zero ao t1
	
		
	enquanto:		
	
	rem $t3, $t2, 10 		#$t3 recebe resto de valor informado dividido por 10		
  	mul $t1, $t1, 10   		#$t1 recebe multiplicacao de zero com 10
   	add $t1, $t1, $t3		#adiciona $t3 ao $t1
   	div $t2, $t2, 10    		#$t2 recebe $t2 dividido por 10
   	bne $t2, 0, enquanto		#Se $t2 nao e zero, então volta para enquanto
	
	bne $t0, $t1, fimnao 		#se $t0 e $t1 forem diferentes, nao e palindromo
    
   	
  	fimsim:				
  	
  	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem
	la $a0, msgsim 			#endereco da mensagem de sim para palindromo
	syscall				#invocacao do servico print_str
  	j fim

	fimnao:			
	
	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem
	la $a0, msgnao		 	#endereco da mensagem de nao para palindromo
	syscall				#invocacao do servico print_str
 	

 	fim:	
 				
	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem
	la $a0, msgfim 			#endereco da mensagem de fim do programa
	syscall				#invocacao do servico print_str
	
	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem
	la $a0, msgfim2 		#endereco da mensagem de créditos do autor
	syscall				#invocacao do servico print_str