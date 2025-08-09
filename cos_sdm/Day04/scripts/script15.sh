#!/bin/bash

#########################################
#	Aim : Array
#########################################

# declaration	:	arr=(10 20 30 40 50)

#	${arr[@]}	:	list of all array elements
#	${#arr[@]}	:	number of elements

#	${arr[$i]}	:	ith element of array

arr=(10 20 30 40 50)

echo "Array elements : ${arr[@]}"
echo "Number of elements : ${#arr[@]}"

echo "arr[0] = ${arr[0]}"
echo "arr[1] = ${arr[1]}"
echo "arr[2] = ${arr[2]}"
echo "arr[3] = ${arr[3]}"
echo "arr[4] = ${arr[4]}"

i=0
echo -n "Array : "
while [ $i -lt ${#arr[@]} ]
do
	echo -n " ${arr[$i]}"
	i=`expr $i + 1`
done
echo ""

sum=0
for ele in ${arr[@]}
do
	sum=$((sum + ele))
done

echo "sum = $sum"













