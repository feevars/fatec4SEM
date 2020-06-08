#!/bin/bash

LIGHTCYAN='\033[1;36m'
NOCOLOR='\033[0m'

echo -e "${LIGHTCYAN}Fazer um script que leia do terminal o nome de um usuário e escreva na tela quais são os grupos que este pertence."


echo "usuarios disponiveis: "
awk -F':' '{ print $1}' /etc/passwd 

echo "Diz aí o usuário que você deseja verificar os grupos:"
read usuario

echo "Grupos:"
groups $usuario

echo -e ${NOCOLOR}
