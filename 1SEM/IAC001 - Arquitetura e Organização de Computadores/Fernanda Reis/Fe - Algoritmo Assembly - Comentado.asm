.data
	
	#mensagens
	msg_inicio: .asciiz "Palíndromo! Digite um número:"
	msg_outof: .asciiz "O número informado não atende aos requisitos do programa."
	msg_ok: .asciiz "O número digitado é um palíndromo!"
	msg_nok: .asciiz "O número informado não é palíndromo :( mas..."
	msg_abaixo: .asciiz "O número palíndromo mais próximo abaixo é o: "



.text

.globl main

	main:

	#msg de inicio
	li $v0, 4			#load immediate, v0 tem funções pré definidas,4 <- printar >>> mensagem <<<
	la $a0, msg_inicio 	#armazena variavel principal  |  a <- mensagem 
	syscall				#altera os regitradores, a tela
					
						#v <- mensagens do sistema para usuario
	li $v0, 5			#registra >>>inteiro<<<
	syscall				#LEIA(informado)
	add $t0, $v0, $zero #receba o numero informado pelo usuário e armazena no temp

	inicio:
						#t <- registradores (variável)

	blt $t0, 1, fora

	fora:
	li $v0, 4			
	la $a0, msg_outof 	
	syscall	 #delimita o valor digitado pelo usuário
	
	bge $t0,10000, fora #"O número informado não atende aos requisitos do programa."
		
    #se nao (se tiver dentro dos limites, vai para programa:)
    #chamar a função ver_palindromo para armazenar o resultado no inv
    
    bge $t0,1, programa
    
	
    programa:


	jal ver_palindromo #ver_palindromo
	add $t4, $t4, 0 #inv <- ver_palindromo


	beq $t0, $t4, seigual #se (informado = inv) entao

	seigual:
   	li $v0, 4			
	la $a0, msg_ok 		#escreval("O número digitado é um palíndromo!")
	syscall
	#talvezz um j fim 

	bne $t0, $t4, sediferente #se ninformado <> inv entao

	sediferente:
	li $v0, 4			
	la $a0, msg_nok 	#"O número informado não é palíndromo :( mas..."
	syscall	
	j segunda_parte 

	segunda_parte:
	li $t8, 1	# p <- 1
       
    beq $t8, 1, ver_palindromo #enquanto p = 1 faca
    #jal ver_palindromo
    add $t4, $t4, 0     					   #inv <- ver_palindromo
    j enquanto_repete

   	enquanto_repete:
    beq $t0, $t4, outroseigual

	outroseigual:
	li $t8, 0			 #p <- 0
	li $v0, 4			
	la $a0, msg_abaixo 	#"O número palíndromo mais próximo abaixo é o: "
	syscall	

    bne $t0, $t4, outrosediferente 

	outrosediferente:
	sub $t0, $t0, 1
	j enquanto_repete

	
	
						
	ver_palindromo: 

	add $t3, $v0, $zero			#num <- informado + 0
	li $t4, 0				#inv <- 0

	
	bne $t3, $zero, enquanto_palindromo  		#num <> 0 faca
	
	enquanto_palindromo:
	rem $t6, $t3, 10 		#t6 <- num % 10
   	div $t5,$t3, 10  		# dig <- int(num % 10) <<<<<< vou colocar div dig, num / 10
   	mul $t7, $t4, 10   		#$t7 <- (inv * 10)
   	add $t4, $t7, $t5		#inv <- (inv *10) + dig
   	add $t3, $t5, $zero   	#num <- int(num / 10) ou num <- div num/10
   	   	
    syscall #sei la #fim funcao 
  


 



