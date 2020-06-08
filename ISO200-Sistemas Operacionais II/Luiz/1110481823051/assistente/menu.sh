#!/bin/bash

x=1

menu(){

while true $x == 1

do

echo "===================================="
echo " ASSISTENTE DO USUARIO              "
echo "===================================="
echo "=  1 - CRIAR NOVO DIRETORIO         "
echo "=  2 - EXCLUIR UM DIRETORIO         "
echo "=  3 - DAR PERMISSAO A UM ARQUIVO   "
echo "=  4 - FAZER BACKUP DE ARQUIVOS     "
echo "=  5 - LIMPAR ARQUIVOS TEMPORARIOS  "
echo "=  6 - SAIR                         "
echo "===================================="

echo " O QUE DESEJA EXECUTAR? "
read op
echo "===================================="
echo " VOCE ESCOLHEU A OPCAO: $op"
echo "===================================="

case "$op" in

	1)
	echo "Informe o diretorio que deseja criar: "
	read diret
	echo "CRIANDO DIRETORIO.."	
	mkdir $diret
	echo "DIRETORIO CRIADO!"
	sleep 3
;;
	
	2)
	echo "Informe o diretorio que deseja excluir: "
	read diret
	echo "EXCLUINDO DIRETORIO.."	
	rmdir $diret
	echo "DIRETORIO CRIADO!"
	sleep 3
;;

	3)
	echo "O arquivo o qual deseja dar permissao: "
	echo "OBS: caso esteja em diretorio diferente, informa-lo tambem"
	read arq
	echo "APLICANDO PERMISSOES..."	
	chmod +rw $arq
	echo "PERMISSOES APLICADAS COM SUCESSO!"
	sleep 3
;;

	4)
	echo "Informe o diretorio o qual deseja fazer bakup: "
	read diretBackup
	echo "EXECUTANDO ROTINA DE BAKUP..."	
	chmod +rw $diretBackup BACKUP
	echo "BACKUP EFETUADO COM SUCESSO!"
	sleep 3
;;

	5)
	echo "Remover arquivos temporarios (da pasta downloads): "
	echo "ARQUIVOS NA PASTA DOWNLOADS: "
	
	d="/home/`users`/Downloads/*"	

	for x in `ls $d` 
	do
		echo $x
	done

	rm -r $d
	echo "EXCLUINDO ARQUIVOS..."	
	echo "ARQUIVOS REMOVIDOS COM SUCESSO!"
	sleep 3
;;

	6)
	echo "ENCERRANDO EXECUÇÃO..."
	sleep 3
	exit;
;;

esac
done
}

menu




