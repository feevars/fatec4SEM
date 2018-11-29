# b. Considere que o cálculo do Fatorial de um número se dá por Fat = 1 x 2 x 3 x ... x N, fazer um algoritmo que solicite um número inteiro N, onde (0 < N <= 12), e apresente o fatorial deste número. 

.data

   msg_inicio: .asciiz "Vamos calcular o fatorial de um numero!\n"
   msg_digite: .asciiz "Digite o numero que deseja calcular: "
   msg_linha:  .asciiz "\n\n"
   msg_mul:    .asciiz " * "
   msg_eq:     .asciiz " = "
   msg_soma:   .asciiz "\n A soma dos fatoriais do numero e: "

.text

#$t0 - numero
#$t1 - i
#$t2 - numero inicial
#$t3 - soma

main:
li $v0, 4      #exibir mensagem
la $a0, msg_inicio
syscall

li $v0, 4
la $a0, msg_digite
syscall

li $v0, 5      #leitura do número
syscall 
add $t0, $v0, $zero

li $t1, 1      #i <- 1

add $t2, $t0, $zero

programa:

blt $t1, $t2, enquanto
j fim

enquanto:
   li, $v0, 1
   add $a0, $t2, $zero
   syscall

   li $v0, 4
   la, $a0, msg_mul
   syscall

   li $v0, 1
   add $a0, $t1, $zero
   syscall

   li $v0, 4
   la, $a0, msg_eq
   syscall

   mul $t0, $t2, $t1

   li $v0, 1
   add $a0, $t0, $zero
   syscall

   li $v0, 4
   la $a0, msg_linha
   syscall

   add $t1, $t1, 1

   add $t3, $t3, $t0

   j programa

fim:

li $v0, 4
la $a0, msg_linha
syscall

li $v0, 4
la $a0, msg_soma
syscall

li $v0, 1
add $a0, $t3, $zero
syscall

