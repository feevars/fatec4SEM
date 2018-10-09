.data
	msg1: .asciiz "\nSoma = "
	msg2: .asciiz "\nMultiplicacao = "
.text
main:
	li $t3, 5 			#$t3 <- 5
	li $t4, 2			#$t4 <- 2
	add $t0, $t3, $t4	#$t0 <- St3 + $t4
	mul $t1, $t3, $t4	#$t1 <- $t3 * $t4
	
	#Escreva(msg1)
	li $v0, 4			#$v0 <- 4 (Escrever car.)
	la $a0, msg1		#$a0 <- msg1
	syscall				#chamada de sistema
	
	#Escreva($t0)
	li $v0, 1			#$v0 <- 1 (Escrever int.)
	add $a0, $t0, $zero	#$a0 <- $t0 + 0
	syscall				# chamada de sistema
	
	#Escreva(msg2)	
	li $v0, 4			#Sv0 <- 4 (Escrever car.)
	la $a0, msg2		#$a0 <- msg2
	syscall				# chamada de sistema
	
	#Escreva($t1)
	li $v0, 1			#$v0 <- 1 (Escrever int.)
	add $a0, $t1, $zero	#$a0 <- $t1 + 0
	syscall				# chamada de sistema