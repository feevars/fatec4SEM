#!/bin/bash

echo "------ OPERADORES ------"

valorA=10
echo "VALOR ATUAL: $valorA"

let valorA++
echo "VALOR COM INCREMENTO: $valorA"

let valorA--
echo "VALOR COM DECREMENTO: $valorA"

base=5
exp=3
echo " ------ ------ ------"
echo


pot=$((base**exp))
echo "VALOR DE $base elevado a $exp: $pot"
echo " ------ ------ ------"
echo


nA=50
nB=10

adic=$(($nA+$nB))
echo "A SOMA DE $nA por $nB e: $adic"

sub=$(($nA-$nB))
echo "A SUBTRACAO DE $nA por $nB e: $sub"

mul=$(($nA*$nB))
echo "A MULTIPLICACAO DE $nA por $nB e: $sub"

sub=$(($nA/$nB))
echo "A DIVISAO DE $nA por $nB e: $sub"

echo " ------ ------ ------"
echo





