.data
	
	#Mensagens
	msg_inicio: .asciiz"•••••••••••••••••••••••••••••••••••••\n•   VERIFICAÇÃO DE NÚMEROS PRIMOS   •\n•••••••••••••••••••••••••••••••••••••\nBruno Bega Harnik - 1º Sem FATEC 2019\n•••••Professor Colevati - IAC001•••••\n\nDigite um número natural maior que 0 e menor que 100000: "
	msg_maior: .asciiz" é maior que 100000.\nDigite outro número: "
	msg_menor: .asciiz" é menor que 1.\nDigite outro número: "
	msg_result1: .asciiz"\nOs números primos de 1 a "
	msg_result2: .asciiz" são:\n"
	quebra: .asciiz"\n"
	msg_refaz: .asciiz"\nDeseja verificar os números primos de 1 a um novo valor menor ou igual a 100000?\nDigite o novo valor: "

.text

.globl main

	main:

	#Mensagem incial
	li $v0, 4
	la $a0, msg_inicio
	syscall

	#Início do código – Coloquei o título acima para não repetir caso haja uma segunda consulta.
	inicio:
		
		#t1 -> Armazena o número inicial e contador: 1
		li $t1, 1

		#t2 -> Número máximo: 100000
		li $t2, 100000

		#t3 -> Quadrado do número em looping
		li $t3, 0

		#t4 -> Armazena o resto da divisão do quadrado por números primos da primeira dezena
		li $t4, 0

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

			j inicio

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

						ble $t1, 7, primeira_dezena

						j mods

						primeira_dezena:

							#Primos da primeira dezena
							beq $t1, 1, primo
							beq $t1, 2, primo
							beq $t1, 3, primo
							beq $t1, 5, primo
							beq $t1, 7, primo

						mods:

							mul $t3, $t1, $t1

							#Mod de t3 por t4 armazenado em t5
							rem $t4, $t3, 2
							#Se mod for 0 não é primo
							beq $t4, 0, nao_primo

							rem $t4, $t3, 3
							beq $t4, 0, nao_primo

							rem $t4, $t3, 5
							beq $t4, 0, nao_primo

							rem $t4, $t3, 7
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

							li $v0, 4
							la $a0, msg_refaz
							syscall

							j inicio


