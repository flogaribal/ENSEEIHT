#!/bin/sh

process=`ps -e | grep "$1" | grep -v "grep"`
number=`ps -e | grep "$1" | grep -v "grep" | wc -l`

if [ $number -gt 1 ] 
then
    echo "Plusieurs processus correspondent au pattern, aucun n'est tué"

else
    for l in  $process
    do
        pid=`cut 
    done
    echo "PID = " $pid
    kill $pid
fi


