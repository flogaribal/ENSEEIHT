#!/bin/sh

DIR=$(dirname $0)
LOGIN=$(whoami)
mkdir ${LOGIN}
cp ${DIR}/signes.ml ${LOGIN}
cp ${DIR}/produitPariteIntervalles.ml ${LOGIN}
tar czf ${LOGIN}.tgz ${LOGIN}
rm -rf ${LOGIN}

echo "Vérifiez que l'archive ${LOGIN}.tgz contient bien les fichiers signes.ml"
echo "et produitPariteIntervalles.ml avec votre travail puis envoyez là"
echo "depuis le webmail de l'ENSEEIHT dans un mail intitulé \"[VAS] Rendu BE\""
echo "à l'adresse thirioux@enseeiht.fr."
