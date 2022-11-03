#!/bin/bash

#Logic 
#1- run urlFinder
#2- run downloader.py
#3- loop through files 
#3.5- convert .3gpp to mp3
#4- print done

python3 urlFinder.py
python3 downloader.py
python3 converter.py

#OLD SCRIPT FOR BASH
#cd files
#for i in ./*; do
#    echo $i
#    NAME=${i:2:${#i}-7}
#    echo "$NAME"
#    OUTPUT="$NAME.mp3"

#    ffmpeg -i "$i" -vn -ar 44100 -ac 2 -b:a 192k "../output/$OUTPUT"
#done


