.data

	msg_inicio: .asciiz"•••••••••••••••••••••••••••••••••••••\n•   VERIFICAÇÃO DE NÚMEROS PRIMOS   •\n•••••••••••••••••••••••••••••••••••••\n\nDigite um número natural maior que 0 e menor que 100000: "
	msg_maior: .asciiz" é maior que 100000.\nRecomece...\n\n"
	msg_menor: .asciiz" é menor que 1.\nRecomece...\n\n"
	msg_result1: .asciiz"\nOs números primos de 1 a "
	msg_result2: .asciiz" são:\n"
	quebra: .asciiz"\n"



.text

	main:
		
		#t1 -> Armazena o número inicial e contador
		li $t1, 1
		#t2 -> Número máximo
		li $t2, 100000
		#t3 -> Quadrado do número em looping
		li $t3, 0
		#Armazena o resto da divisão do quadrado por números primos da primeira dezena
		li $t4, 0

		li $s1, 1
		li $s2, 2
		li $s3, 3
		li $s5, 5
		li $s7, 7

		#Mensagem incial
		li $v0, 4
		la $a0, msg_inicio
		syscall

		#t0 -> registra o número digitado pelo usuário
		li $v0, 5
		syscall
		add $t0, $v0, $zero

		#Se o número inserido for maior que 100000
		bgt $t0, $t2, se_maior
		
		#Jump se não
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

			j main

			senao_maior:

				#Se o número inserido for mmenor que 1
				blt $t0, $t1, se_menor

				#Jump se não
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

					j main

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

						ble $t1, $s7, primeira_dezena

						j mods

						primeira_dezena:

							#Primos da primeira dezena
							beq $t1, $s1, primo
							beq $t1, $s2, primo
							beq $t1, $s3, primo
							beq $t1, $s5, primo
							beq $t1, $s7, primo

						mods:

							mul $t3, $t1, $t1

							#Mod de t3 por t4 armazenado em t5
							rem $t4, $t3, $s2
							#Se mod for 0 não é primo
							beq $t4, 0, nao_primo

							rem $t4, $t3, $s3
							beq $t4, 0, nao_primo

							rem $t4, $t3, $s5
							beq $t4, 0, nao_primo

							rem $t4, $t3, $s7
							beq $t4, 0, nao_primo
			
						primo:

							li $v0, 1
							add $a0, $t1, $zero
							syscall

							li $v0, 4
							la $a0, quebra
							syscall

							add $t1, $t1, 1
							ble, $t1, $t0, enquanto

							j fim

						nao_primo:

							add $t1, $t1, 1
							ble, $t1, $t0, enquanto

						fim:
