.data
msg_inicio: .asciiz"•••••••••••••••••••••••••••••••••••••\n•   VERIFICAÇÃO DE NÚMEROS PRIMOS   •\n•••••••••••••••••••••••••••••••••••••\nBruno Bega Harnik - 1º Sem FATEC 2019\n•••••Professor Colevati - IAC001•••••\n\nDigite um número natural maior que 0 e menor que 100000: "
msg_maior: .asciiz" é maior que 100000.\nDigite outro número: "
msg_menor: .asciiz" é menor que 1.\nDigite outro número: "
msg_result1: .asciiz"\nOs números primos de 1 a "
msg_result2: .asciiz" são:\n"
msg_total: .asciiz"\nTotal de números primos do intervalo: "
msg_refaz: .asciiz"\n\nCaso queira executar novamente o programa, insira um número de 1 a 100000:"
quebra: .asciiz"\n"
primos: .space 38372
.text
.globl main
main:
li $v0, 4
la $a0, msg_inicio
syscall
inicio:
li $v0, 5
syscall
add $t0, $v0, $zero
li $t1, 1
li $t2, 100000
li $t3, 0
li $t4, 2
li $t5, 3
li $t6, 5
li $t7, 7
add $s0, $zero, 0
bgt $t0, $t2, se_maior
j senao_maior
se_maior:
li $v0, 4
la $a0, quebra
syscall
li $v0, 1
add $a0, $t0, $zero
syscall
li $v0, 4
la $a0, msg_maior
syscall
j inicio
senao_maior:
blt $t0, $t1, se_menor
j senao_menor
se_menor:
li $v0, 4
la $a0, quebra
syscall
li $v0, 1
add $a0, $t0, $zero
syscall
li $v0, 4
la $a0, msg_menor
syscall
j inicio
senao_menor:
li $v0, 4
la $a0, msg_result1
syscall
li $v0, 1
add $a0, $t0, $zero
syscall
li $v0, 4
la $a0, msg_result2
syscall
enquanto:
ble $t1, $t0, looping
j fim
looping:
ble $t1, 7, primeira_dezena
j mods
primeira_dezena:
beq $t1, $t4, primo
beq $t1, $t5, primo
beq $t1, $t6, primo
beq $t1, $t7, primo
add $t1, $t1, 1
j enquanto
mods:
rem $t9, $t1, $t4
beq $t9, 0, nao_primo
rem $t9, $t1, $t5
beq $t9, 0, nao_primo
rem $t9, $t1, $t6
beq $t9, 0, nao_primo
rem $t9, $t1, $t7
beq $t9, 0, nao_primo
add $s1, $zero, 12
primos_seguintes:
add $s1, $s1, 4
lw $s2, primos($s1)
beq $s2, 0, primo
rem $t9, $t1, $s2
beq $t9, 0, nao_primo
j primos_seguintes
primo:
li $v0, 1
add $a0, $t1, $zero
syscall
li $v0, 4
la $a0, quebra
syscall
sw $t1, primos($s0)
add $s0, $s0, 4
add $t1, $t1, 1
add $t3, $t3, 1
j enquanto
nao_primo:
add $t1, $t1, 1
j enquanto
fim:
li $v0, 4
la $a0, msg_total
syscall
li $v0, 1
add $a0, $t3, $zero
syscall
li $v0, 4
la $a0, msg_refaz
syscall
add $t3, $zero, 0
zerando:
beq $s0, 0, inicio
sw $t3, primos($s0)
sub $s0, $s0, 4
j zerando