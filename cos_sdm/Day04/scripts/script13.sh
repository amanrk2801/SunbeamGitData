#!/bin/bash

#########################################
#	Aim : for loop
#########################################

# for(( init ; cond ; mod ))
# do
# 	body
# done

# for element in collection
# do
#	body
# done

# collection : space seperated values
#	eg	10 20 30 40

num=5

# for(( i = 1 ; i < 11 ; i++ ))
# for i in 1 2 3 4 5 6 7 8 9 10
for i in `seq 10`
do
	echo $((i * num))
done


















