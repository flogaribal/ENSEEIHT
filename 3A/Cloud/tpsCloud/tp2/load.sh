#!/bin/bash

# Envoie graduellement jusqu'a 6 requetes par seconde
# N.B. remplacer par l'adresse de votre load balancer avant de lancer!

LB_ADDR=autoScaling-etudiant11-19-1219928759.ca-central-1.elb.amazonaws.com

for i in $(seq 1500)
do
        if [ $i -lt 500 ]
        then
                n=$(( $i / 100 + 1 )) 
        elif [ $i -lt 1000 ]
        then
                n=6
        else
                n=$(( 6 - ($i - 1000) / 100 ))
        fi

	for j in $(seq $n)
	do
		wget -q -O /dev/null $LB_ADDR &
	done
	
	echo "Round#$i, $n request(s) per second."
	sleep 1
done

