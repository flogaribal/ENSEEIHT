#!/bin/sh

lister(){
    # Parcours les fichiers du dossier courant
    for f in *
    do
        # Si l'option est "-f" ou que c'est "-d" et que le fichier
        # courant est un répertoire on l'affiche
        [ "$1" = "-f" -o \("$1" = "-d" -a -d "$f"\) ] && echo $2$f

        # Si c'est un répertoire on descend à l'intérieur
        if [ -d "$f" ]
        then
            cd $f 
            # On rappelle lister sur le nouveau répertoire
            lister $1 $2"__"
            cd ..
        fi
    done
}

# Options par défaut
opt=-f
dc=`pwd`

# Si l'option "-d" est précisée on l'enregistre et on décale les arguments
[ "$1" = "-d" ] && opt=-d && shift

# Si le premier argument (anciennement 2e) n'est pas nul 
# et que c'est un répertoire j'enregistre le répertoire à
# lister
[ -n "$1" ] && [ -d "$1" ] && dc="$1"
cd $dc

# Appel de la fonction
lister $opt "|__"


