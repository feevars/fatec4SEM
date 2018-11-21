.data

msg_inicio: .asciiz "Vamos calcular uma progressão aritmética! \n"
msg_n_inicial: .asciiz "Digite um número inicial: "
msg_razao: .asciiz " \n Digite a razão: "
msg_num_termos: .asciiz "\n Digite o número de termos da progressão: "
msg_soma: asciiz "\n A soma dos termos da progressão é: "

.text


main:

li $v0, 4	#exibir mensagem	"Vamos calcular uma progressão aritmética! \n"	
	la $a0, msg_inicio 	
	syscall	

inicio:

li $v0, 4	#exibir mensagem		"Digite um número inicial: "
la $a0, msg_n_inicial 	
syscall	

li $v0, 5				#ler numero inicial <- $t0
syscall				
add $t0, $v0, $zero

li $v0, 4	#exibir mensagem	 " \n Digite a razão: "	
la $a0, msg_razao 	
syscall	

li $v0, 5
la syscall 					#ler razão <- $t1
add $t1, $v0, $zero

li $v0, 4	#exibir mensagem	 " \n Digite o numero de termos da progressão "	
la $a0, msg_num_termos 	
syscall

la $v0, 5
la syscall
add $t2, $v0, $zero   		#ler num_termos <- $t2

loop:

bge $t2, 0, enquanto 
beq $t2, 0, fim
enquanto:
sub $t4, $t2, 1 	#$t4 <- num_termos - 1
mul $t5, $t4, $t1 	#$t5 <- $t4 * $t1
add $t3, $t0, $t5	# num <- $t3
add $t6, $t6, $t3	#soma <- soma + num
sub $t2, $t2, 1 	#num_termos <- num_termos - 1

li $v0, 4
add $a0, $t3, $zero
syscall

 j loop

 fim:
 li $v0, 4
 la $a0, msg_soma
 syscall

 li $v0, 4
 add $a0, $t6, $zero
 syscall