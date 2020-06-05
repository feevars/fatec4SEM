
# USANDO VARIAVEIS DO SHELL


funcao01(){
	echo "LISTAR ARQUIVOS"
	echo "$1"
	
}

echo "(`funcao01 teste`)"
echo $?