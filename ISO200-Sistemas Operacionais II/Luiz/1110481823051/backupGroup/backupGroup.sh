#!/bin/bash


echo "===================================="
echo "=========BACKUP DE USUARIOS========="
echo "===================================="
echo "INFORME O NOME DO GRUPO:            "
echo "===================================="

read grupo
echo "===================================="
echo "VOCE ESCOLHEU O GRUPO $grupo"
echo "===================================="


getent group $grupo | awk -F: '{pp=$4}'
echo $pp



#usuarios=`egrep $grupo /etc/group | awk -F: '{ print $4 }' `

#for user in $usuarios | `awk -F,`
#do
#	echo "USUARIO: $user"
#done

#	echo "USUARIOS: $x"
#	cp -r /home/$x BACKUP
#	echo "BACKUP DE $x REALIZADO!"



