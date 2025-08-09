#!/bin/bash

#########################################
#	Aim : loop control structures
#########################################

#	init
#	while [ condition ]
#	do						while condition is true
#		body					body will be executed
#		modification
#	done


#	init
#	until [ condition ]
#	do						until condition is true
#		body					body will be executed
#		modification
#	done

echo -n "Enter number : "
read num

i=1
# while [ $i -lt 11 ]
# until [ $i -eq 11 ]
until [[ $i == 11 ]]
do
	echo $((i * num))
	i=`expr $i + 1`
done



















