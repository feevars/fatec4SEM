#funcoes com parametros

segundaFuncao(){
	echo "VALORES: $1 e $2 RECEBIDOS!"
	res=$(($1 / $2))

	echo "RESULTADO DA DIVISAO DE $1 por $2: $res" 
}

echo "SEGUNDA FUNCAO(`segundaFuncao 10 2`)"

