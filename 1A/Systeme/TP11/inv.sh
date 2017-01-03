#!/bin/sh

src="$*"

echo "Chaine initiale " $src

while [ ! -z "$src" ] 
do
    cc=`expr "$src" : "\(.\).*"`
    src=`expr "$src" : ".\(.*\)"`

    nouvch="$cc$nouvch"
done

echo "Chaine inversée " $nouvch
