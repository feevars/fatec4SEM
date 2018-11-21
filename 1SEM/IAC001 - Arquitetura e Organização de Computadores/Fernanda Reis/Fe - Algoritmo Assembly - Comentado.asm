.data
	
	#mensagens
	msg_inicio: .asciiz "Palindromo! \n"
	msg_digite: .asciiz "Digite um numero: "
	msg_outof: .asciiz "O numero informado nao atende aos requisitos do programa."
	msg_ok: .asciiz "O numero digitado e um palindromo!"
	msg_nok: .asciiz "O numero informado nao e palindromo :( mas..."
	msg_abaixo: .asciiz "O numero palindromo mais proximo abaixo e o: "


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
    #se nao (se tiver dentro dos limites, vai para programa:)
    #chamar a função ver_palindromo para armazenar o resultado no inv
	
	fora:

	li $v0, 4			
	la $a0, msg_outof 	#"numero fora do limite"
	syscall	 
	j inicio

	
	    	
    programa:
    li $s3, 1 #definir uma variável como 1
	jal ver_palindromo #ver_palindromo
	prog1:
	beq $t0, $t4, fim1 #se (informado = inv) entao

	bne $t0, $t4, sediferente #se ninformado <> inv entao

	
	sediferente:
	li $v0, 4			
	la $a0, msg_nok 	#"O número informado não é palíndromo :( mas..."
	syscall	
	j segunda_parte 

	segunda_parte:
	li $t8, 1							# p <- 1
    li $s4, 2  #definir uma variavel como 2   
    beq $t8, 1, ver_palindromo 			#enquanto p = 1 faca
    segp:
    #jal ver_palindromo
    add $t4, $t4, 0     				#inv <- ver_palindromo
    bne $t0, $t4, outrosediferente 		#se (informado <> inv) entao
	beq $t0, $t4, fim2
    

   
	outrosediferente:
	sub $t0, $t0, 1
	j segunda_parte

	
						
	ver_palindromo: 

	add $t3, $v0, $zero			#num <- informado + 0
	li $t4, 0
	bne $t3,0, enquanto_palindromo

		
	enquanto_palindromo:
	rem $t6, $t3, 10 		#t6 <- num % 10
   	div $t5,$t3, 10  		# dig <- int(num % 10) <<<<<< vou colocar div dig, num / 10
   	mul $t7, $t4, 10   		#$t7 <- (inv * 10)
   	add $t4, $t7, $t5		#inv <- (inv *10) + dig
   	div $t3, $t3, 10        #num <- int(num / 10) ou num <- div num/10
   	add $t4, $t4, 0 		#inv <- ver_palindromo   	
    beq $s2, 1, prog1 
    j segp

  	fim1:
  	li $v0, 4			
	la $a0, msg_ok 		#escreval("O número digitado é um palíndromo!")
	syscall
  	j o_fim

	fim2:
	li $t8, 0			 	#p <- 0
	li $v0, 4			
	la $a0, msg_abaixo 		#"O número palíndromo mais próximo abaixo é o: "
	syscall	
 	j o_fim

 	o_fim:
