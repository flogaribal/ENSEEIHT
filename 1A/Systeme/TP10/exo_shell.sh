#!/bin/sh
# la ligne dessus indique le shell utilise pour executer le script
# Une ligne de commentaire commence par #

# $1 est le premier argument, $2 le deuxième, etc
# $# est le nombre d'arguments

# test ou [  ] permettent d'effectuer des tests sur des variables 
# test -n : chaine non vide

# la variable dc prend le resultat de l'execution de pwd
dc=`pwd`
if test -n "$2"; then
  echo "Trop d'arguments"
  exit 1
elif test -n "$1"; then
# test -d : vrai si l'argument est un dossier, -x vrai s'il est executable
  if test -d $1 && test -x $1; then
    cd $1
    dc=$1
  else
    echo "Ce n'est pas un dossier"
    exit 2
  fi
fi
# variables numeriques initialisees à 0
nbx=0
nbd=0
# pour tous les objets du dossier : equivalent à  for f in * 
for f in `ls`
do 
# $ permet d'obtenir la valeur d'une vaiable
# [ -d $f ] idem que test -d $f : attention aux espaces necessaires
  if [ -d $f ]
# expr permet de faire des calculs simples
  then nbd=`expr $nbd + 1`
  elif [ -x $f ]
# un autre moyen de faire des calculs simples
  then nbx=$(($nbx + 1))
  fi
done
echo "Dossier :" $dc
echo "- nombre de dossiers :" $nbd
echo "- nombre d'executables :" $nbx

