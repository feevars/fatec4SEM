  GNU nano 2.0.9              File: exec04.sh                         Modified  

#!/bin/bash

YELLOW='\033[0;33m'
NOCOLOR='\033[0m'

echo -e "${YELLOW} Fazer um script para criar uma pasta temporária em ~ e atribuir a permissão que somente o usuário dono do arquivo pode excluir o mesmo."

temp=$HOME/tmp

echo "Criando uma pasta /tmp/..."
sleep 1
mkdir $temp
chmod 700 $temp
echo "permissao concedida${NOCOLOR}"
