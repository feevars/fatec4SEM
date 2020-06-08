#!/bin/bash

ORANGE='\033[0;33m'
LIGHTPURPLE='\033[1;35m'
LIGHTCYAN='\033[1;36m'
NOCOLOR='\033[0m'

backup=$"/home/$user/backup"

echo -e "${ORANGE}Criar um script que auxilie o usuário final a usar o linux a partir "
echo "de um menu que permita criar diretórios dentro da pasta home, "
echo "fazer backups dos arquivos pessoais e limpar a pasta temporária."
echo "Resposta:"

userMenu(){
clear
echo -e "Welcome to Linux. "
echo "-----------------------"
echo "1- Criar novo diretório"
echo "2- Excluir um diretório"
echo "3- Permitir acesso de escrita e leitura a um arquivo ou diretório"
echo "4- Fazer backups dos arquivos pessoais"
echo "5- Limpar meus arquivos temporários"
echo "6- Sair"
echo "-----------------------"
echo "O que deseja fazer?"
read opc

case "$opc" in 
	1)
	echo "Qual o nome do diretório que deseja criar?"
	read newdir
	mkdir $HOME/$newdir
;;	
	2)
	echo "Qual o nome do diretório que deseja excluir?"
    	ls /home/`users`/*
	read newdir
	rmdir $HOME/$newdir
;;
	3)
	echo "A qual arquivo deseja dar permissão?"
	ls 
	read newarch
	chmod +u $newarch
	echo "arquivo com permissão"
;;
	4)
	echo "Digite o diretório que deseja fazer backup."
	echo "Os arquivos serão armazenados em /home/backup"	
	ls -d $HOME/*
	read newdir
	if [! -d "$HOME/backup" ]
	then		
		mkdir $HOME/backup
	fi	
	cp -R $HOME/$newdir $HOME/backup
	echo "backup efetuado com sucesso"
	ls $backup
;;
	5)
	echo "Excluir arquivos temporários."
	rm /home/`users`/Downloads/*
	echo "excluido tudo"
;;	

	6)
	echo "Saindo do programa..."
	sleep 2
	exit
;;
	
	*)
	echo "opção invalida"
;;
esac

userMenu	
}
userMenu
echo ${NOCOLOR}
