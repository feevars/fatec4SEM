.data
	msg1: .asciiz "\nDigite um numero: "
	msg2: .asciiz "\n"
.text
main:
	#TABUADA
	li $v0, 4		#$v0 <- 4 (Escrever car.)
	la $a0, msg1	#(mostra)
	syscall
	
	#Leia($t0)
	li  $v0, 5		# 5 = leitura de inteiros
	syscall
	
	add $t0, $v0, $zero		# soma v0 e 0 e coloca em t0
	li $t1, 0
		
	enquanto:
	mul $t2, $t0, $t1
	add $t1, $t1, 1			#t1 = contador
	
	li $v0, 1		# 1 = imprime inteiros
	add $a0, $t2, $zero
	syscall
	
	li $v0, 4
	la $a0, msg2
	syscall
	
	ble $t1, 10, enquanto			#t1 <= 10