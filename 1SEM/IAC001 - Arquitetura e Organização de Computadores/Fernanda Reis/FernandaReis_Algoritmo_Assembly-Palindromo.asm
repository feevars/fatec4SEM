.data
	
	#mensagens
	msg_aluno: .asciiz "Nome: Fernanda Pinheiro Reis   |   R.A: 1110481823022 \n \n"
	msg_enunciado: .asciiz "13. Faca um algoritmo que leia um numero (1 < numero < 10000) e, \ncaso ele nao seja um numero palindromo, apontar qual o numero \n palindromo mais proximo antes dele. \n \n "
	msg_inicio: .asciiz "Palindromo! \n\n Numeros palindromos sao aqueles que lidos da esquerda para a \ndireita ou da direita para a esquerda sao iguais.\nVamos verificar se um numero e palindromo.\n"
	msg_digite: .asciiz "\nDigite um numero entre 1 e 10.000: "
	msg_outof: .asciiz "\nO numero informado nao atende aos requisitos do programa. \n"
	msg_ok: .asciiz "\nO numero digitado e um palindromo! \n \n"
	msg_nok: .asciiz "\nO numero informado nao e palindromo :( mas... \n"
	msg_abaixo: .asciiz "\nO numero palindromo mais proximo abaixo e o: "
	msg_linha: .asciiz "\n \n"
	

.text

.globl main

	main:


	#msg com nome 
	li $v0, 4			
	la $a0, msg_aluno 	
	syscall		


	#msg enunciado
	li $v0, 4			
	la $a0, msg_enunciado 	
	syscall		


	#msg de inicio
	li $v0, 4			
	la $a0, msg_inicio 	
	syscall				
	
	inicio:
		#digite um valor
		li $v0, 4			
		la $a0, msg_digite 	
		syscall		

		#leitura do nº informado pelo usuário e armazenamento em variável				
		li $v0, 5			
		syscall				
		add $t0, $v0, $zero 

	
		#delimita 1 < número < 10.000				
		li $s1, 1

		li $s2, 10000 

		#se valor < 1 ou > 10.000
		ble $t0, $s1, fora
		bge $t0,$s2, fora
		#se tiver dentro dos limites, vai para programa  
		bge $t0,$s1, programa	
    	
    
	
	fora:
		#msg de "fora dos limites do programa"
		li $v0, 4			
		la $a0, msg_outof 	
		syscall	

		#quebra de msg_linha
		li $v0, 4			
		la $a0, msg_linha 		
		syscall 
	j inicio

	
	    	
    programa:
    	#$s3 inicia o primeiro loop 
    	li $s3, 1 
		beq $s3, 1, ver_palindromo 

	prog1:
		#para o primeiro loop
		li $s3, 0
		add $t4, $t4, 0
		beq $t0, $t4, fim1  #se (informado = inv) entao
		bne $t0, $t4, sediferente 	#se (informado <> inv) entao

	
	sediferente:
		#msg de "O número informado não é palíndromo :( mas..."
		li $v0, 4			
		la $a0, msg_nok 	
		syscall

		#msg de "O número palíndromo mais próximo abaixo é o: "
		li $v0, 4			
		la $a0, msg_abaixo 		
		syscall
	j segunda_parte 

	segunda_parte:
		#informado decresce 1 e roda o loop novamente
		sub $t0, $t0, 1
		li $s4, 2  					#variável que inicia o loop 
    	beq $s4, 2, ver_palindromo 	
    
    segp:
    	bne $t0, $t4, segunda_parte 		#se (informado <> inv) entao
		sub $s4, $s4, 1						#para o loop 
		bne $s4, 2, fim2
    
  								
	ver_palindromo: 
		add $t3, $t0, 0				#num <- informado + 0
		li $t4, 0					#inv <- 0
		li $t6, 0					#dig <- 0
		bne $t3,0, enquanto_palindromo

		
	enquanto_palindromo:							
		rem $t6, $t3, 10 	#dig (t6) <- num % 10		
  		mul $t4, $t4, 10   	#$t4 (inv) <- inv * 10		
   		add $t4, $t4, $t6	# inv <- (inv *10) + dig 	
   		div $t3, $t3, 10    #num <- int(num / 10)		
   					 		  	
    	bne $t3, 0, enquanto_palindromo
    	beq $s3, 1, prog1 
    	beq $s4, 2, segp
   

  	fim1:
  		#msg de "O número digitado é um palíndromo!"
  		li $v0, 4			
		la $a0, msg_ok 		
		syscall
  	j inicio

	fim2:
		#exibe o palíndromo abaixo mais próximo
		li $v0, 1				
		add $a0, $t4, $zero
		syscall

		#quebra de msg_linha
		li $v0, 4			
		la $a0, msg_linha 		
		syscall
 	j inicio 
 	
	