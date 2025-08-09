#!/bin/bash

#########################################
#	Aim : Package installation automation
#########################################

packages=(git ncal vim rename gcc)

sudo apt-get update
if [ $? -ne 0 ]
then
	echo "sources list is not updated ???"
	exit
fi

echo "Sources list is updated successfully !!!"

for pkg in ${packages[@]}
do
	echo "$pkg is getting installed !!!"
	
	sudo apt-get install $pkg
	if [ $? -ne 0 ]
	then
		echo "$pkg is not installed ???"
	fi

	echo "$pkg is insalled successfully !!!"
done






















