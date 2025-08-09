#!/bin/bash

#########################################
#	Aim : String conditionals
#########################################

#	=		:	true if strings are equal
#	!=		:	true if strings are not equal
#	-z $str	:	true if str is empty	
#	-n $str	:	true if str is not empty

echo -n "Enter string : "
read str

if [ -z $str ]
then
	echo "string is empty"
	exit
fi

rstr=`echo $str | rev`

echo "str = $str"
echo "rstr = $rstr"

if [ $str = $rstr ]
then
	echo "String is palindrome"
else
	echo "String is not palindrome"
fi




















