#!/bin/bash

#########################################
#	Aim : Positional parameters
#########################################

#	./script17.sh 10 3.142 A sunbeam

#	$*	- 	list of all positional parameters
#			"10 3.142 A sunbeam"

#	$#	-	number of positional parameters
#			4

#	$1, $2, $3, ...	- individual positional parameter
#	$1 - 10
#	$2 - 3.142
#	$3 - A
#	$4 - sunbeam

#	$0	-	name of script
#			./script17.sh

#	$$	-	shell process PID

echo "List of pos param : $*"
echo "Number of pos param : $#"

echo "Name of script : $0"
echo "shell process PID : $$"

echo "1st param = $1"
echo "2nd param = $2"
echo "3rd param = $3"
echo "4th param = $4"

for param in $*
do
	echo $param
done

























