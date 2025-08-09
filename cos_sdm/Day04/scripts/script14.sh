#!/bin/bash

#########################################
#	Aim : Count number of entries in current directory
#########################################

count=0

for entry in `ls`
do
	count=`expr $count + 1`
done

echo "entry count = $count"






















