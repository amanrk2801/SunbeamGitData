#!/bin/bash

#########################################
#	Aim : Selection control structure
#########################################

#	case $choice in
#	1|one|4)
#		...
#		;;
#	2)
#		...
#		;;
#	*)
#		...
#		;;
#	esac
echo -n "Enter two numbers : "
read num1 num2

echo -e "1. Add\n2. Sub\n3. Mul\n4. Div"
echo -n "Enter your choice : "
read choice

case $choice in
1|Add|add|ADD)
	echo "sum = $((num1 + num2))"
	;;

2)
	echo "diff = $((num1 - num2))"
	;;

3)
	echo "product = $((num1 * num2))"
	;;

4)
	echo "q = $((num1 / num2))"
	;;
esac

















