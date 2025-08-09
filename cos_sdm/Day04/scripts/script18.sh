#!/bin/bash

#########################################
#	Aim : Function
########################################

# Function declaration
#	function funName		funName()
#	{						{
#		...						...
#	}						}

# function call :	funName arg1 arg2 arg3
# function arguments will be accessed like $1, $2, $3, ...
#	$1 - arg1
#	$2 - arg2
#	$3 - arg3
#	...

function print_msg
{
	echo "inside print_msg()"
}

function print_values
{
	echo "Number = $1"
	echo "String = $2"
}
addition()
{
	res=`expr $1 + $2`
	echo $res
}

# main script
echo "inside main script"

print_msg

print_values 10 sunbeam

sum=$(addition 10 20)
echo "sum = $sum"
















