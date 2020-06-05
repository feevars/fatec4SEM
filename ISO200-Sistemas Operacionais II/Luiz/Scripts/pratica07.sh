#!/bin/bash

echo "------ CONDICIONAIS ------"

ra=1110481823051

res=$(($ra % 2))

if [ $res -eq '0' ]

then
	echo "RA: $ra : é PAR"
	echo "------ ------"
else
	echo "RA: $ra : é IMPAR"
	echo "------ ------"
fi
