#!/bin/bash

echo " ------- LISTANDO PASTAS/ARQUIVOS ------- "

for x in `ls`

do

tamanho=`expr length $x`

if [ $tamanho -lt 10 ]
then	
   echo "TAMANHO: $tamanho - DIRETORIO/ARQUIVO: $x" 
fi

done

