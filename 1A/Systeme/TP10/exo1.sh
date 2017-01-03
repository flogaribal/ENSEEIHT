#!/bin/sh

directory=`pwd`

if [ $# -eq 1 ]
then
   directory=$1
fi

find $directory -name '*.o' -delete

