#!/bin/bash

usuario=/home/aluno

echo "Fazer um script no qual é realizado um backup (com tar) do diretório do aluno /home/aluno e salvar esta backup em /tmp
O nome do arquivo tem que ser: aluno_d_m_a_h_M.tar.gz"


	hoje=$(date '_%d_%m_%Y_%H_%M')
	echo "Realizando o backup de $usuario"
	sudo tar -zcvf /tmp/backup-$usuario-$date.tar.gz $usuario
