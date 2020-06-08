#!/bin/bash

echo " ----- Recebendo usuário -------"

echo " Informe o nome do usuário: "

read usuario

echo "USUARIO INFORMADO: $usuario"
echo "LISTANDO GRUPOS: "
groups $usuario

echo "-------------------------------"

