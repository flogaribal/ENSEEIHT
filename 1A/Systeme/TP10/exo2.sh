#!/bin/sh


str="t"

while test "$str" != "o" -a "$str" != "n"
do
    read -p "'Etes vous satisfait ?" str
    str=`echo $str | cut -c1`
done
