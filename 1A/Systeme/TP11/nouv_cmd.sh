#!/bin/sh

nouvcmd=""

while [ -n "$*" ]
do
    if [ "$1" = "-t" ]
    then        
        nouvcmd="$nouvcmd -x"

    elif [ "$1" = "-T" ]
    then
        shift 
        shift

    elif [ "$1" != "-e" ]
    then
        nouvcmd="$nouvcmd $1"
    fi
    shift
done

echo $nouvcmd
