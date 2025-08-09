#!/bin/bash

#########################################
#	Aim : File conditionals
#########################################

#	-e $path	:	true if path exist
#	-f $file	:	true if file is regular file
#	-d $file	: 	true if file is directory file

#	-x $file	:	true if file has execute permissions
#	-r $file	:	true if file has read permissions
#	-w $file	:	true if file has write permissions

echo -n "Enter path : "
read path

if [ -e $path ]
then
	echo "$path exists"
	if [ -f $path ]
	then
		echo "Regular file"
	elif [ -d $path ]
	then
		echo "Directory file"
	else
		echo "something else"
	fi
else
	echo "$path does not exist"
fi





















