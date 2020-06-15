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


dia=`date +´%d´`
mes=`date +´%m´`
ano=`date +´%Y´`



lista=$( egrep "$grupo" /etc/group | awk -F':' '{ print $4 '} )


IFS=',' read -r -a usuarios <<< "$lista"

for x in "${usuarios[@]}"
do
	echo "===================================="
	echo "FAZENDO BACKUP DO USUARIO: $x"
	echo "DIRETORIO /home/$x "
	echo "DATA $dia $mes $ano "	
	echo "===================================="
	sleep 3

	tar -czvf Backup-$x-$dia-$mes-$ano /home/$x

done 

echo "===================================="



