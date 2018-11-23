.data
	
	#mensagens
	msg_inicio: .asciiz "\n Palindromo! \n"
	msg_digite: .asciiz "Digite um numero: "
	msg_outof: .asciiz "O numero informado nao atende aos requisitos do programa."
	msg_ok: .asciiz "O numero digitado e um palindromo!"
	msg_nok: .asciiz "O numero informado nao e palindromo :("
	


.text

.globl main

	main:

	#msg de inicio
	li $v0, 4			#load immediate, v0 tem funções pré definidas,4 <- printar >>> mensagem <<<
	la $a0, msg_inicio 	#armazena variavel principal  |  a <- mensagem 
	syscall				#altera os regitradores, a tela
	
	inicio:

	li $v0, 4			#load immediate, v0 tem funções pré definidas,4 <- printar >>> mensagem <<<
	la $a0, msg_digite 	#armazena variavel principal  |  a <- mensagem 
	syscall		

						#v <- mensagens do sistema para usuario
	li $v0, 5			#registra >>>inteiro<<<
	syscall				#LEIA(informado)
	add $t0, $v0, $zero #receba o numero informado pelo usuário e armazena no temp

	
						#t <- registradores (variável)
	li $s1, 1

	li $s2, 10000 

	#se valor < 1
	ble $t0, $s1, fora
	bge $t0,$s2, fora  #"O número informado não atende aos requisitos do programa."
	bge $t0,$s1, programa	
    #se nao (se tiver dentro dos limites, vai para programa)
    
	
	fora:

	li $v0, 4			
	la $a0, msg_outof 	#"numero fora do limite"
	syscall	 
	j inicio

	
	    	
    programa:
    li $s3, 1 #definir uma variável como 1
	beq $s3, 1, ver_palindromo #ver_palindromo

	prog:
	li $s3, 0
	add $t4, $t4, 0
	beq $t0, $t4, fim1 #se (informado = inv) entao
	j fim_nok #se ninformado <> inv entao
	
							
	ver_palindromo: 

	add $t3, $t0, 0			#num <- informado + 0
	li $t4, 0					#inv <- 0
	bne $t3,0, enquanto_palindromo

		
	enquanto_palindromo:
	rem $t6, $t3, 10 	#dig (t6) <- num % 10		
  	mul $t4, $t4, 10   	#$t4 (inv) <- inv * 10
   	add $t4, $t4, $t6	# inv <- (inv *10) + dig 
   	div $t3, $t3, 10    #num <- int(num / 10) 
   	
   	bne $t3, 0, enquanto_palindromo
   	beq $t3, 0, prog

    
   	
  	fim1:
  	li $v0, 4			
	la $a0, msg_ok 		#escreval("O número digitado é um palíndromo!")
	syscall
  	j o_fim

	fim_nok:
	li $t8, 0			 	#p <- 0
	li $v0, 4			
	la $a0, msg_nok 	#"O número informado não é palíndromo :("
	syscall	
 	

 	o_fim: