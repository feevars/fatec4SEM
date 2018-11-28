.data

	msg_entra: .asciiz"Digite um número binário entre 1 e 1000000000: "
	msg_erro: .asciiz"O valor inserido não é válido. Refaça...\n\n "

	msg_fim1: .asciiz"\nO número binário "
	msg_fim2: .asciiz" em decimal é "
	msg_volta: .asciiz"\n\nPara nova consulta, digite um número binário entre 1 e 1000000000: "

.text

.globl main

	main:

	# mensagem inicial
	li $v0, 4
	la $a0, msg_entra
	syscall

	inicio:
		# s0 - entrada do valor
		li $v0, 5
		syscall
		add $s0, $v0, $zero

		# maior - erro
		bge $s0, 1000000000, erro

		# menor - erro
		ble $s0, 1, erro

		# s1 - dezenas - 1ª dezena:
		li $s1, 1

		# s2 - resultado
		li $s2, 0

		#t0
		# divisao
		div $t0, $s0, $s1

		# resto
		rem $t0, $t0, 10

		bgt $t0, 1, erro
		blt $t0, 0, erro

		# multiplica 10 no s1
		mul $s1, $s1, 10

		add $s2, $s2, $t0


		#t1
		# divisao
		div $t1, $s0, $s1

		# resto
		rem $t1, $t1, 10

		bgt $t1, 1, erro
		blt $t1, 0, erro

		# multiplica 10 no s1
		mul $s1,$s1, 10

		mul $t1, $t1, 2
		add $s2, $s2, $t1


		#t2
		# divisao
		div $t2, $s0, $s1

		# resto
		rem $t2, $t2, 10

		bgt $t2, 1, erro
		blt $t2, 0, erro

		# multiplica 10 no s1
		mul $s1,$s1, 10

		mul $t2, $t2, 4
		add $s2, $s2, $t2


		#t3
		# divisao
		div $t3, $s0, $s1

		# resto
		rem $t3, $t3, 10

		bgt $t3, 1, erro
		blt $t3, 0, erro

		# multiplica 10 no s1
		mul $s1,$s1, 10

		mul $t3, $t3, 8
		add $s2, $s2, $t3


		#t4
		# divisao
		div $t4, $s0, $s1

		# resto
		rem $t4, $t4, 10

		bgt $t4, 1, erro
		blt $t4, 0, erro

		# multiplica 10 no s1
		mul $s1,$s1, 10

		mul $t4, $t4, 16
		add $s2, $s2, $t4


		#t5
		# divisao
		div $t5, $s0, $s1

		# resto
		rem $t5, $t5, 10

		bgt $t5, 1, erro
		blt $t5, 0, erro

		# multiplica 10 no s1
		mul $s1,$s1, 10

		mul $t5, $t5, 32
		add $s2, $s2, $t5


		#t6
		# divisao
		div $t6, $s0, $s1

		# resto
		rem $t6, $t6, 10

		bgt $t6, 1, erro
		blt $t6, 0, erro

		# multiplica 10 no s1
		mul $s1,$s1, 10

		mul $t6, $t6, 64
		add $s2, $s2, $t6


		#t7
		# divisao
		div $t7, $s0, $s1

		# resto
		rem $t7, $t7, 10

		bgt $t7, 1, erro
		blt $t7, 0, erro

		# multiplica 10 no s1
		mul $s1,$s1, 10

		mul $t7, $t7, 128
		add $s2, $s2, $t7


		#t8
		# divisao
		div $t8, $s0, $s1

		# resto
		rem $t8, $t8, 10

		bgt $t8, 1, erro
		blt $t8, 0, erro

		# multiplica 10 no s1
		mul $s1,$s1, 10

		mul $t8, $t8, 256
		add $s2, $s2, $t8


		#t9
		# divisao
		div $t9, $s0, $s1

		# resto
		rem $t9, $t9, 10

		bgt $t9, 1, erro
		blt $t9, 0, erro

		# multiplica 10 no s1
		mul $s1,$s1, 10

		mul $t9, $t9, 512
		add $s2, $s2, $t9

		j fim

		erro:
			# mensagem de erro
			li $v0, 4
			la $a0, msg_erro
			syscall

		j main

		fim:
			# mensagem fim 1
			li $v0, 4
			la $a0, msg_fim1
			syscall

			# escreve o binario
			li $v0, 1
			add $a0, $s0, $zero
			syscall

			# mensagem fim 2
			li $v0, 4
			la $a0, msg_fim2
			syscall

			# escreve o decimal
			li $v0, 1
			add $a0, $s2, $zero
			syscall

			# mensagem recomeço
			li $v0, 4
			la $a0, msg_volta
			syscall

		j inicio