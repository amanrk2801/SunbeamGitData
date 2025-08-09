#!/bin/bash

#########################################
#	Aim : sort image and audio files
#########################################

# $var =~ pattern/regular expression

for file in `ls`
do
	if [ -f $file ]
	then
		if [[ $file =~ \.png$ ]]
		then
			mv $file images
		elif [[ $file =~ \.mp3$ ]]
		then
			mv $file audios
		fi
	fi
done
























