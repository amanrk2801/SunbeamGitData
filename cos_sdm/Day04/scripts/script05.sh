#!/bin/bash

#########################################
#	Aim : Calculate area of rectangle
#########################################

# area = length * bredth

echo -n "Enter length and bredth of rectangle : "
read le br

# command substitution
#	- result of command is substituted at the place of command
#	- This can be done by two different ways
#		- `command`
#		- $(command)

area=`expr $le \* $br`

echo "Area of rectangle = $area"























