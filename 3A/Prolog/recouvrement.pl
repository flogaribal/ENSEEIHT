%% GARIBAL Florian Groupe A

:- include(libtp2).

/**************************/
/* Definition of domain/3 */
/**************************/
domain([],[],_).
domain([Xi|Xs],[Ti|Ts],Capacite) :- /* Restriction du domaine de la variable Xi et Yi pour ne pas que les petits carres depassent du grand carre */
																		Max is Capacite-Ti,
																		fd_domain(Xi,0,Max),

																		/* Appel recursif sur le reste des Xs et Ts */
																		domain(Xs,Ts,Capacite).

/****************************************************/
/* 						Definition of no_overlap/3 						*/
/* Contraint chaque petit carré de ne pas dépasser 	*/
/* sur un autre petit carré 												*/
/****************************************************/
no_overlap([],[],[]).
no_overlap([Ti|Ts], [Xi|Xs], [Yi|Ys]) :- 	no_overlap_single(Ti,Xi,Yi, Ts, Xs, Ys),
																					no_overlap(Ts,Xs,Ys).

no_overlap_single(_,_,_,[],[],[]).
no_overlap_single(Ti,Xi,Yi, [Tj|Ts], [Xj|Xs], [Yj|Ys]) :-	/* Verification du chevauchement */
																															Xi + Ti #=< Xj 
																													#\/ Xj + Tj #=< Xi 
																													#\/ Yi + Ti #=< Yj 
																													#\/ Yj + Tj #=< Yi,

																													/* Appel recursif sur les autres petits carres */
																													no_overlap_single(Ti,Xi,Yi,Ts,Xs,Ys).


/***************************************************/
/*             Definition of solve1/3              */
/* Résoud le problème sans contraintes redondantes */
/***************************************************/
/* Lancement : solve1(1,Xs,Ys, B) */

solve1(Num,Xs,Ys, B) :- 
			/* Recuperation des donnees dans le fichier libtp2.pl */
			data(Num, Capacite, Ts),

			/* Recuperation de la taille de Ts pour instancier les listes Xs et Ys avec la meme taille */
			length(Ts, Len),
			length(Xs, Len),
			length(Ys, Len),

			/* Definition du domaine des variables presentes dans les listes Xs et Ys */
			/* Domaine permettant aux petits carrés de ne pas dépasser du grand carré */
			domain(Xs,Ts,Capacite),
			domain(Ys,Ts,Capacite),

			/* Verification du chevauchement */
			no_overlap(Ts, Xs, Ys),

			/* Calcul de la solution et récupération du nombre de backtrack */
			fd_labeling(Xs, [backtracks(B)]),
			fd_labeling(Ys, [backtracks(B)]),

			/* Ecrit la solution dans un fichier */
			printsol('tiles1.txt',Xs,Ys,Ts).

/* ====================================================================== */
/* 												CONTRAINTES REDONDANTES 												*/
/* ====================================================================== */

sum_expr([], 0).
sum_expr([X|Xs], X+S) :- sum_expr(Xs, S).

sum_compare(L, S) :- 	/* Calcule la somme de la liste et stocke l'expression crée dans Expr */
											sum_expr(L, Expr),

											/* Vérifie que la valeur de l'expression est bien égale à S */
             					S #= Expr.


/*********************************************/
/* 				Definition of times_list/3 				 */
/* Calcul la somme ddes éléments d'une liste */
/*********************************************/

times_list([],[],[]).
times_list([T1|Q1], [T2|Q2], R) :-
        P #= T1*T2,
        times_list(Q1, Q2, R1),
        append([P], R1, R).



/************************************************************/
/* 								Definition of cross/3 										*/
/* Vérifie que la somme des longueurs/largeur petits carrés */
/* est égale à la longueur/largeur du grand carré 					*/
/************************************************************/
cross(Capacite, Capacite, _, _).
cross(Capacite, Verticale, Xs, Ts) :-
				/* Construction de l'expression pour la verticale courante */
        cross_single(Verticale, Xs, Ts, B),
        
        /* Calcul du produit de Ts*B et résultat dans S */
        times_list(Ts, B, S),

        /* Calcul de la somme de S et vérifie que le résultat est égal à Capacite */
        sum_compare(S, Capacite),

        /* Calcul de la prochaine droite */
        Next #= Verticale + 1,

        /* Appel récursif pour la prochaine droite */
        cross(Capacite, Next, Xs, Ts).

cross_single(_, [], [], []).
cross_single(Verticale, [Xi|Xs], [Ti|Ts], [B|Bs]) :-
				/* Predicat qui vérifie que la verticale coupe le carre courant */
        B #<=> (Xi #=< Verticale #/\ Verticale #< Xi + Ti),

        /* Appel recursif sur les autres petits carres */
        cross_single(Verticale, Xs, Ts, Bs).


/***************************************************/
/*             Definition of solve2/3              */
/* Résoud le problème avec contraintes redondantes */
/***************************************************/
/* Lancement : solve2(1/2,Xs,Ys, B) */

solve2(Num,Xs,Ys, B) :- 
			/* Recuperation des donnees dans le fichier libtp2.pl */
			data(Num, Capacite, Ts),

			/* Recuperation de la taille de Ts pour instancier les listes Xs et Ys avec la meme taille */
			length(Ts, Len),
			length(Xs, Len),
			length(Ys, Len),

			/* Definition du domaine des variables presentes dans les listes Xs et Ys */
			/* Domaine permettant aux petits carrés de ne pas dépasser du grand carré */
			domain(Xs,Ts,Capacite),
			domain(Ys,Ts,Capacite),

			/* Verification du chevauchement */
			no_overlap(Ts, Xs, Ys),

			%% Contraintes redondantes 
				%% La premiere verticale que je teste est "Capacite" d'où les 2 arguments Capacite
			cross(Capacite, 0, Xs, Ts),
			cross(Capacite, 0, Ys, Ts),

			/* Calcul de la solution et récupération du nombre de backtrack */
			fd_labeling(Xs, [backtracks(B)]),
			fd_labeling(Ys, [backtracks(B)]),

			/* Ecrit la solution dans un fichier */
			printsol('tiles2.txt',Xs,Ys,Ts).


/* ====================================================================== */
/* 													STRATEGIES DE RECHERCHE 											*/
/* ====================================================================== */

/***************************************************/
/*             Definition of solve3/3              */
/* Résoud le problème avec contraintes redondantes */
/* en autorisant le choix du but et en affichant le*/
/* nombre de solutions trouvées										 */
/***************************************************/

/* Lancement : solve3(2,Xs,Ys, B, assign/indomain, NbSol) */

solve3(Num,Xs,Ys, B, Goal, NbSol) :- 
			/* Recuperation des donnees dans le fichier libtp2.pl */
			data(Num, Capacite, Ts),

			/* Recuperation de la taille de Ts pour instancier les listes Xs et Ys avec la meme taille */
			length(Ts, Len),
			length(Xs, Len),
			length(Ys, Len),

			/* Definition du domaine des variables presentes dans les listes Xs et Ys */
			/* Domaine permettant aux petits carrés de ne pas dépasser du grand carré */
			domain(Xs,Ts,Capacite),
			domain(Ys,Ts,Capacite),

			/* Verification du chevauchement */
			no_overlap(Ts, Xs, Ys),

			%% Contraintes redondantes 
				%% La premiere verticale que je teste est "Capacite" d'où les 2 arguments Capacite
			cross(Capacite, 0, Xs, Ts),
			cross(Capacite, 0, Ys, Ts),

			/* Calcul de la solution et récupération du nombre de backtrack */
      labeling(Xs, Ys, Goal, minmin, B, NbSol),

			/* Ecrit la solution dans un fichier */
			printsol('tiles3.txt',Xs,Ys,Ts).



/* ====================================================================== */
/* 															SYMETRIE						 											*/
/* ====================================================================== */

/***************************************************/
/*             Definition of sort/3	               */
/* Trie les petits carrés qui ont la même taille	 */
/***************************************************/
sort([_], [_], [_]).
sort([Xi|Xs], [Yi|Ys], [Ti|Ts]) :-
        sort_single(Xi, Xs, Yi, Ys, Ti, Ts),
        sort(Xs, Ys, Ts).

sort_single(Xi, [X1|_], Yi, [Y1|_], Ti, [T1|_]) :-
        		(Ti #\= T1) 
        #\/ ((Yi #< Y1 #\/ Xi #< X1) #/\ Xi #=< X1).

/***************************************************/
/*             Definition of solve4/3              */
/* Résoud le problème avec contraintes redondantes */
/* en autorisant le choix du but, en affichant le  */
/* nombre de solutions trouvées	et en cassant les  */
/* syémtries dûes aux petits carrés de même taille */
/***************************************************/

/* Lancement : solve4(1,Xs,Ys, B, indomain, NbSol) */

solve4(Num,Xs,Ys, B, Goal, NbSol) :- 
			/* Recuperation des donnees dans le fichier libtp2.pl */
			data(Num, Capacite, Ts),

			/* Recuperation de la taille de Ts pour instancier les listes Xs et Ys avec la meme taille */
			length(Ts, Len),
			length(Xs, Len),
			length(Ys, Len),

			/* Definition du domaine des variables presentes dans les listes Xs et Ys */
			/* Domaine permettant aux petits carrés de ne pas dépasser du grand carré */
			domain(Xs,Ts,Capacite),
			domain(Ys,Ts,Capacite),

			/* Verification du chevauchement */
			no_overlap(Ts, Xs, Ys),

			%% Contraintes redondantes 
				%% La premiere verticale que je teste est "Capacite" d'où les 2 arguments Capacite
			cross(Capacite, 0, Xs, Ts),
			cross(Capacite, 0, Ys, Ts),

			/* Trie les petits carrés qui ont la meme taille */
			sort(Xs, Ys, Ts),

			/* Calcul de la solution et récupération du nombre de backtrack */
      labeling(Xs, Ys, Goal, minmin, B, NbSol),

			/* Ecrit la solution dans un fichier */
			printsol('tiles4.txt',Xs,Ys,Ts).



/* ====================================================================== */
/* 															REPONSES 																	*/
/* ====================================================================== */
/*
-- Contraintes redondantes :

Commande de lancement avec ou sans contraintes redondantes :
	- sans : solve1(1,Xs,Ys,B)
	- avec : solve2(2,Xs,Ys,B)

2. Comparaison du nombre de backtracks sur la solution 1 selon la presence ou non des contraintes redondantes
	- Sans : 2 Backtracks
	- Avec : 0 Backtrack

	Les contraintes redondantes permettent de rajouter une partie d'intelligence que l'ordinateur ne peut pas deviner.
	Cette aprtie d'intelligence permet de restreindre certains cas théoriquement possible (selon l'ordinateur) mais que
	nous ne souhaitons pas. De ce fait le nombre de back track est forcément moins important.

-- Stratégies de recherche :

2. Nombre de backtrack selon la stratégie de recherche choisie :
	- indomain : 9038
	- assign 	 : 805

	Ce résultat est celui attendu car la stratégie "assign" est plus dynamique que "indomain" est permet donc de réévaluer
	le critère après chaque choix car ce dernier peut modifier l'évaluation du critère. Cela nous permet donc d'éviter de 
	remonter un backtrap "plus haut" puisque qu'à chaque noeud de choix le critère (ici minmin) est réevalué.



-- Symétrie : 

Pour le premier exemple je trouve 480 solutions en comptant les solutions présentes en double du aux permutations.
Après avoir cassé les symétries en triant les petits carrés de même taille, j'obtiens 4 solutions pour le premier jeu de données.







NOTES:


PARTIES CONTRAINTES REDONDANTES

Faire la somme des largeur/hauteur des petits carrés et imposer qu'elle soit égale à celle du grand carré
Construire expr au fur et à mesure (cf tp1) et évaluer à la fin

PARTIE STRATEGIES DE RECHERCHE

assign + dynamique


PARTIE SYMETRIE

Marche que pour 1 & 2 
ROMPRE SYMETRIE --> couple (x1,y1) plus petit que (x2,y2)  
										x1 < x2


*/


