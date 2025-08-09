#!/bin/bash

#########################################
#	Aim : Calculate area of circle
#########################################

# area = 3.142 * r * r

echo -n "Enter radius of circle : "
read r

area=$(echo "3.142 * $r * $r" | bc)

echo "Area of circle : $area"





















