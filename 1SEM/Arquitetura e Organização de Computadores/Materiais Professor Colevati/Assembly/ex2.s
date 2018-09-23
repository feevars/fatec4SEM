.data
.text
main:
li $t0, 8 #
li $t1, 4 #

bge $t0,$t1, entao 			#se (condição) entao
	j senao					#jump = pula as instruções 

	entao:					#label = nome 
	li $v0, 1				# Escrever inteiro 
	add $a0, $t0, $zero 	#soma
	syscall
	j fimse

	senao:
	li $v0, 1
	add $a0, $t1, $zero
	syscall
	j fimse

fimse: