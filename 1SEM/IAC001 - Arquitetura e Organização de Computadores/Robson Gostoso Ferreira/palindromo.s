.data
	
	#mensagens
	msg_intro: 
		.asciiz "\nBem vindo. A seguir, você poderá observar se um número X entre 1 e 10.000 é um Palíndromo.\n"
	msg_numero: 
		.asciiz "Digite um numero entre 1 e 10.000: "
	msg_erro: 
		.asciiz "Você não digitou um número entre 1 e 10.000!"
	msg_sim: 
		.asciiz "Esse número é um palindromo!"
	msg_nao: 
		.asciiz "Esse número não é um palíndromo!"
	
.text

	main:

	#msg introdutoria
	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem
	la $a0, msg_intro 		#endereco da mensagem introdutoria
	syscall				#invocacao do servico print_str
	
	
	inicio:				#inicio

	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem
	la $a0, msg_numero 		#endereco da mensagem de ordem 
	syscall				#invocacao do servico print_str
			
	li $v0, 5			#identificacao do servico read_int / leitura de um numero
	syscall				#invocacao do servico read_int
	add $t0, $v0, $zero		#adiciona o valor de $v0 ao $t0
					
					#Agora meu $t0 tem o número digitado pelo usuário
					
	
	li $s0, 1			#atribuicao do valor 1 para variavel
	li $s1, 10000 			#atribuicao do valor 10000 para variavel

	ble $t0, $s0, erro		#Se numero digitado for menor ou igual a 1, ir para erro
	bge $t0, $s1, erro  		#Se numero digitado for maior ou igual a 1000, ir para erro 
	j ver_palindromo


	erro:				#erro

	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem	
	la $a0, msg_erro 		#endereco da mensagem de erro
	syscall	 			#invocacao do servico print_str
	j inicio
 		
							
	ver_palindromo: 		#ver_palindromo

	add $t2, $t0, 0			#Adicionou o número informado ao t2
	li $t1, 0			#adicionou o zero ao t1
	bne $t2, 0, enquanto_palindromo

		
	enquanto_palindromo:		#enquanto palindromo
	
	rem $t3, $t2, 10 		#t3 recebe resto de valor informado dividido por 10		
  	mul $t1, $t1, 10   		#t1 recebe multiplicação de zero com 10
   	add $t1, $t1, $t3		# adicionei t3 ao t1
   	div $t2, $t2, 10    		#t2 recebe t2 dividido por 10
   	
   	bne $t2, 0, enquanto_palindromo
   	beq $t2, 0, prog

	prog:				#prog
	
	li $s2, 0
	add $t1, $t1, 0
	beq $t0, $t1, fim1 		#se (informado = inv) entao
	j fim_nok 			#se ninformado <> inv entao
    
   	
  	fim1:				#fim1
  	
  	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem
	la $a0, msg_sim 		#escreval("O nÃºmero digitado Ã© um palÃ­ndromo!")
	syscall
  	j o_fim

	fim_nok:			#fim_nok
	
	li $t4, 0			#p <- 0
	li $v0, 4			#identificacao do servico print_str / escrita de uma mensagem
	la $a0, msg_nao		 	#"O nÃºmero informado nÃ£o Ã© palÃ­ndromo :("
	syscall	
 	

 	o_fim:				#o_fim

	