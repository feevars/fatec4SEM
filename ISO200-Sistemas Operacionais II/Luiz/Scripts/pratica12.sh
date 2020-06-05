#!/bin/bash

for x in `users`

do
	echo "USUARIO: $x" 
	echo "GRUPOS: `groups` $x"
done
