#!/bin/bash

echo "LISTAR DIRETORIO E TIPOS DE ARQUIVOS"

comando=`ls`

for x in $comando

do
	echo "ARQUIVO/DIRETORIO: $x" 
	echo "`file $x`"	
done


