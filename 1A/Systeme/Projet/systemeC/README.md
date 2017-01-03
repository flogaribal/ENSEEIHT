Projet Système C

FAIT : 

	- Execution de commande avec attente non-bloquante
	- Gestion de la liste des processus (ajout/suppression/changement état)
	- Ajout du nom de la commande, de l'utilisateur et de la machine source à la structure
	- Gestion du nom de la commande (ajout & affichage)
	- Ajout de la commande "rlp"
	- Ajout d'un mode DEBUG pour accélerer le debuggage du programme
	- Ajout de la commande kill avec deux possibilités d'arguments
		("kill [-signal] pid" OU "kill pid")
	- Gestion de la fermeture de l'application
		(Kill de tous les processus de la liste puis destruction de la liste)



COMPILATION : 
	gcc -Wall -o main main.c cmds.o liste_proc.c  

EXECUTION : 
	./main
