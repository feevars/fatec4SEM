#!/bin/bash

NOCOLOR='\033[0m'
LILAS='\033[0;35m'

echo "${LILAS}Exercício 3: Backup dos usuários de determinado grupo\n\n"
echo "Lista de todos os grupos desta máquina em ordem alfabética:\n"

grupos=$(cut -d: -f1 /etc/group)

echo -e $grupos
echo "Digite o nome do grupo que deseja fazer backup: "

read nomeGrupo

if grep -q $nomeGrupo /etc/group
	then
		echo "Grupo selecionado: $nomeGrupo$"
	usuarios=$(grep "$nomeGrupo" /etc/group | cut -d: -f1)
	for usuario in $usuarios
	do
		hoje=$(date '+%d-%m-%Y')
		echo "Realizando o backup de $usuario"
		sudo tar -zcvf /home/backup-$usuario-$hoje.tar.gz /home/$usuario
	done
else
	echo "O grupo não está na lista.${SC}"
fi
