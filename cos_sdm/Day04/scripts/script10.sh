#!/bin/bash

#########################################
#	Aim : Check regular file has execute permissions or not
#########################################

echo -n "Enter file path : "
read filepath

if [ -e $filepath ]
then
	if [ -f $filepath -a -x $filepath ]
	then
		echo "file has execute permissions"
	else
		echo "file don't have execute permissions or not regular file"
	fi
else
	echo "$filepath does not exists"
fi






















