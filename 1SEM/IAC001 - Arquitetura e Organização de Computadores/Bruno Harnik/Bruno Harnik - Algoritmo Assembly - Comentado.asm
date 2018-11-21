.data
	
	# Mensagens
	msg_inicio: .asciiz"•••••••••••••••••••••••••••••••••••••\n•   VERIFICAÇÃO DE NÚMEROS PRIMOS   •\n•••••••••••••••••••••••••••••••••••••\nBruno Bega Harnik - 1º Sem FATEC 2019\n•••••Professor Colevati - IAC001•••••\n\nDigite um número natural maior que 0 e menor que 100000: "
	msg_maior: .asciiz" é maior que 100000.\nDigite outro número: "
	msg_menor: .asciiz" é menor que 1.\nDigite outro número: "
	msg_result1: .asciiz"\nOs números primos de 1 a "
	msg_result2: .asciiz" são:\n"
	msg_total: .asciiz"\nTotal de números primos do intervalo: "
	msg_refaz: .asciiz"\n\nCaso queira executar novamente o programa, insira um número de 1 a 100000:"
	# Quebra de linha
	quebra: .asciiz"\n"

	# Array de números primos - Já calculei que existem 9593 primos no intervalo de 1 a 100000
	primos: .space 38372

.text

.globl main

	main:

	# Mensagem incial
	li $v0, 4
	la $a0, msg_inicio
	syscall

	# Início do código – Coloquei o título acima para não repetir caso haja uma segunda consulta.
	inicio:
		# t0 -> registra o número digitado pelo usuário
		li $v0, 5
		syscall
		add $t0, $v0, $zero

		# $t1 -> Armazena o número inicial e contador: 1
		li $t1, 1

		# $t2 -> Número máximo: 100000
		li $t2, 100000

		# $t3 -> quantidade total de primos
		li $t3, 0

		# $t4, $t5, $t6 e $t7 -> Primos da primeira dezena:

		# Posição de bytes no array: 0
		li $t4, 2
		# Posição no array: 4
		li $t5, 3
		# Posição no array: 8
		li $t6, 5
		# Posição no array: 12
		li $t7, 7

		# $t9 -> armazenador de restos

		# $s0 -> $Índice de primos
		add $s0, $zero, 0

		# Atribui 0 ao à posição 0
		# até que surja o primeiro primo e substitua o 0 desta posição

		# Validações

		# Se o número inserido for maior que 100000
		bgt $t0, $t2, se_maior
		
		# $Jump se não
		j senao_maior

			se_maior:

				# Pula linha
				li $v0, 4
				la $a0, quebra
				syscall

				# Printa o valor inserido
				li $v0, 1
				add $a0, $t0, $zero
				syscall

				# Mensagem de valor inválido maior
				li $v0, 4
				la $a0, msg_maior
				syscall

			j inicio

			senao_maior:

				# Se o número inserido for menor que 1
				blt $t0, $t1, se_menor

				# Jump se não
				j senao_menor

					se_menor:

						# Pula linha
						li $v0, 4
						la $a0, quebra
						syscall

						# Printa o valor inserido
						li $v0, 1
						add $a0, $t0, $zero
						syscall

						# Mensagem de valor inválido menor
						li $v0, 4
						la $a0, msg_menor
						syscall

					# Volta pro início
					j inicio

				senao_menor:

					# A partir daqui o valor é válido para calcular os primos do intervalo.

					# Texto do resultado
					li $v0, 4
					la $a0, msg_result1
					syscall

					# Printa o valor inserido
					li $v0, 1
					add $a0, $t0, $zero
					syscall

					# continua texto do resultado:
					li $v0, 4
					la $a0, msg_result2
					syscall

					enquanto:

						# O looping acontece enquanto o índice for maior ou igual que o valor digitado
						ble $t1, $t0, looping

						# se chegar no último número pula para o fim
						j fim
						
						looping:

							# Enquanto o valor do t1 for menor ou igual a 7, o programa executa a primeira dezena.
							# O intervalo pode ser curto e devemos atender essa condição...
							ble $t1, 7, primeira_dezena

							# Se o t1 passou de 7, já pula pro mods
							j mods

							primeira_dezena:

								# Primos da primeira dezena
								# se Branch for igual a executa label primo...
								beq $t1, $t4, primo
								beq $t1, $t5, primo
								beq $t1, $t6, primo
								beq $t1, $t7, primo

								# Passou do 7 adiciona 1 no $t1...
								add $t1, $t1, 1

								# Volta pro enquanto
								j enquanto

							mods:
								# Resto de $t1 / $t4 armazenado em $t9
								rem $t9, $t1, $t4
								# Se o resto for 0, $t1 não é primo...
								beq $t9, 0, nao_primo

								# Resto de $t1 / $t5 armazenado em $t9
								rem $t9, $t1, $t5
								# Se o resto for 0, $t1 não é primo...
								beq $t9, 0, nao_primo

								# Resto de $t1 / $t6 armazenado em $t9
								rem $t9, $t1, $t6
								# Se o resto for 0, $t1 NÃO é primo...
								beq $t9, 0, nao_primo

								# Resto de $t1 / $t7 armazenado em $t9
								rem $t9, $t1, $t7
								# Se o resto for 0, $t1 NÃO é primo...
								beq $t9, 0, nao_primo

								#zera pra primos(12)
								add $s1, $zero, 12

								#looping até achar o 0
								primos_seguintes:
									
									#primos(x) -> adiciona 4 ao índice
									add $s1, $s1, 4

									#carrega o primo em questão no $s2
									lw $s2, primos($s1)
								
									#se #s2 == 0 é primo
									beq $s2, 0, primo

									#se não divide $t1 pelo primo do índice e armazena em $t9
									rem $t9, $t1, $s2

									#se resto for igual a 0, não é primo
									beq $t9, 0, nao_primo

									#se resto for diferente de 0, confere o próximo número primo, volta...
								j primos_seguintes

							primo:

								# Escrita do número primo
								li $v0, 1
								add $a0, $t1, $zero
								syscall

								# Pula linha
								li $v0, 4
								la $a0, quebra
								syscall

								# Atribui $t1 ao índice em questão do array Primos
								sw $t1, primos($s0)

									# Adiciona 4 bytes ao array Primos
									add $s0, $s0, 4

								# Adiciona 1 ao $t1
								add $t1, $t1, 1

								# Adiciona 1 ao $t3
								add $t3, $t3, 1

								# Volta pro enquanto
								j enquanto

							nao_primo:

								# Adiciona 1 ao $t1
								add $t1, $t1, 1

								# Volta pro enquanto
								j enquanto

							fim:
									
									# Mensagem do total de números primos
									li $v0, 4
									la $a0, msg_total
									syscall

									# Escrita do número total de primos
									li $v0, 1
									add $a0, $t3, $zero
									syscall

									# Mensagem de recomeço
									li $v0, 4
									la $a0, msg_refaz
									syscall

									add $t3, $zero, 0

									zerando:

									beq $s0, 0, inicio

									sw $t3, primos($s0)

									sub $s0, $s0, 4

									#Se o $0 virar 0 volta pro início
									
									# se não volta pro zerando
									j zerando

								





