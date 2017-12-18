/*****************************/
/* Definition of no_attack/2 */
/*****************************/


no_attack(_,[]).
no_attack(X1/Y1,[X2/Y2|Q]) :-	/* Check if the queen is OK with the head of the list */
															no_attack_single(X1/Y1, X2/Y2),

															/* Recursion on queue */
															no_attack(X1/Y1,Q). 

/************************************/
/* Definition of no_attack_single/2 */
/************************************/

no_attack_single(X1/Y1, X2/Y2) :-	/* Check lines and columns */
																	X1 =\= X2,
																	Y1 =\= Y2,

																	/* Check diagonals */
																	T1 is abs(X1-X2),
																	T2 is abs(Y1-Y2), 
																	T1 =\= T2.

/****************************************/
/* Definition of correct_config_eight/1 */
/****************************************/
correct_config_eight(ListeReine) :- length(ListeReine,Len),
																		Len = 8,
																		correct_config_eight_aux(ListeReine).

correct_config_eight_aux([]).
correct_config_eight_aux(ListeReine) :-	[T|Q] = ListeReine,
																				T = X/Y,
																				member(X,[1,2,3,4,5,6,7,8]),
																				member(Y,[1,2,3,4,5,6,7,8]),
																				no_attack(T,Q),
																				correct_config_eight_aux(Q).


/**********************************/
/* Definition of solution_eight/1 */
/**********************************/
solution_eight([X/Y|Others]) :- 	solution_eight_aux([X/Y|Others]),
																	length([X/Y|Others], Len),
																	Len = 8.
							

solution_eight_aux([]).
solution_eight_aux([X/Y|Others]):- 	solution_eight_aux(Others),
																		member(Y, [1, 2, 3, 4, 5, 6, 7, 8]),
																		no_attack(X/Y, Others).

/******************************************/
/* Definition of solution_eight_ordered/1 */
/******************************************/
solution_eight_ordered(Liste) :- 	solution_eight(Liste),
																	print(Liste).



/******************************/
/* Definition of solution_n/1 */
/******************************/
solution_n([X/Y|Others]) :- length([X/Y|Others], N),
														n_ups(N, Intervalle),
														solution_n_aux([X/Y|Others], Intervalle).
							

solution_n_aux([], _).
solution_n_aux([X/Y|Others], Intervalle):- 	solution_n_aux(Others, Intervalle),
																						member(Y, Intervalle),
																						no_attack(X/Y, Others).


/*************************/
/* Definition of n_ups/2 */
/*************************/
n_ups(N, Xs) :-	length(Xs, N),
   							numbered_from(Xs, 1).



/*********************************/
/* Definition of numbered_from/2 */
/*********************************/
numbered_from([], _).
numbered_from([I0|Is], I0) :-	I1 is I0+1,
   														numbered_from(Is, I1).																						


template([1/Y1, 2/Y2, 3/Y3, 4/Y4, 5/Y5, 6/Y6, 7/Y7, 8/Y8]).
template_n([1/Y1, 2/Y2, 3/Y3, 4/Y4, 5/Y5, 6/Y6, 7/Y7, 8/Y8, 9/Y9, 10/Y10, 11/Y11]).

/* 
1-	Une structure de données simple permettant de stocker les positions des reines est une liste de couple X/Y.
2- 	Si no_attack est appelé avec une liste vide alors elle devrait renvoyer "true" car cela correspond à un cas où la reine n'attaque/n'est attaqué par personne


3- 	Correct_config_eight ne permet pas de résoudre le problème des n-reines. 
		En effet cette fonction permet seulement de vérifier qu'une configuration donnée en paramètre est correcte.
		D'autre part étant donné que la fonction s'appelle correct config EIGHT, il est pour moi nécessaire de vérifier qu'il y a bien 8 éléments dans la liste.
		Pour cela j'ai utilisé une fonction auxiliaire qui parcourt la liste tandis que la première fonction sert juste à vérifier la taille de la liste.


4- 
		Commande de lancement : solution_eight([1/Y1, 2/Y2, 3/Y3, 4/Y4, 5/Y5, 6/Y6, 7/Y7, 8/Y8]).
		Je prend une des configurations renvoyée par le programme et je vérifie avec la commande suivante:  correct_config_eight([1/6,2/3,3/7,4/4,5/1,6/8,7/2,8/5]).

5-	Prolog nous renvoie beaucoup de solutions dont une majorité de doublons. En effet il existe de nombreuses permutations possibles cependant on s'intéresse aux configurations 
		strictement différentes.
		Je n'ai pas réussi à trouver un moyen de stocker toutes les solutions dans une même liste afin d'avoir une liste de liste. J'aurais pu, ensuite, repérer les doublons et 
		les supprimer.

6- 	Commande de lancement : solution_n([1/Y1, 2/Y2, 3/Y3, 4/Y4, 5/Y5, 6/Y6, 7/Y7, 8/Y8, 9/Y9, 10/Y10, 11/Y11]).


*/





