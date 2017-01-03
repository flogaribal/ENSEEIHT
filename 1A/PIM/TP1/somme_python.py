# Garibal Florian, Groupe A
# Programme permettant de tester la fonction somme


## somme : int*int -> int
## Calculer la somme des entiers compris entre 2 entiers naturels m et n 
## Paramètre m : entier naturel, la borne inférieure de l'intervalle
##           n : entier naturel, la borne supérieure de l'intervalle
## Précondition : m et n doivent être strictement positifs et m doit être inférieur ou égal à n
## Résultat : la sommme des entiers compris entre m et n
def somme(m,n):

    somme = 0 # Variable qui stockera la somme des entiers
        
    # Sommer les entiers compris entre m et n
    # Parcours des entiers compris entre m et n
    for i in range (m,n+1):
        somme += i # Ajout de l'entier courant dans la variable somme
    # Fin parcours des entiers -> somme calculée
    
    # Affichage du résultat
    print("La somme des entiers compris entre " + str(m) + " et " + str(n) + " est " + str(somme))

## Programme principal

#m = 1
#n = 4 
# Lire m
m = int(input("Entrer la borne inférieure de l'intervalle : "))
while m<0 :
    m = int(input("Entrer la borne inférieure de l'intervalle : "))
# m>0

# Lire n 
n = int(input("Entrer la borne supérieure de l'intervalle : "))
while n<0 or m>n:
    n = int(input("Entrer la borne supérieure de l'intervalle : "))
# n>0

somme(m,n)
