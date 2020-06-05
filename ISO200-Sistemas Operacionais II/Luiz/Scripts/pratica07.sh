#CONDICIONAIS

ra=1110481823051

res=$(( $ra % 2 ))

if [ $res -eq '0' ]

then 
	echo "MEU RA $ra : é PAR"
else
	echo "MEU RA $ra : é IMPAR"
fi