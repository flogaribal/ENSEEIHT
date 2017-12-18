/***********************************************************************/
/* Programmation par contraintes - TP2                                 */
/* Louis Chausserie-Lapree                                             */
/***********************************************************************/

:- include(libtp2).

/***********************************************************************/
/************************* MODELE BASIQUE ******************************/
/***********************************************************************/

/* domains vérifie que les abscisses (ou ordonnées) des petits carrés  */
/* sont correctes.                                                     */
/* [X|Xs] : la liste des abscisses (ou ordonnées) des petits carrés    */
/* [T|Ts] : la liste des tailles des petits carrés                     */
/* C : la taille du grand carré                                        */
domains([], [], _).
domains([X|Xs], [T|Ts], C) :-
        Diff is C - T,
        fd_domain([X], 0, Diff),
        domains(Xs, Ts, C).

/* no_overlap_aux vérifie qu'un petit carré donné ne chevauche aucun   */
/* des autres petits carrés                                            */
/* Ti : la taille du petit carré donné                                 */
/* Xi : l'abscisse du petit carré donné                                */
/* Yi : l'ordonnée du petit carré donné                                */
/* [T|Ts] : la liste des autres petits carrés                          */
/* [X|Xs] : la liste des abscisses des autres petits carrés            */
/* [Y|Ys] : la liste des ordonnées des autres petits carrés            */
no_overlap_aux(_, _, _, [], [], []).
no_overlap_aux(Ti, Xi, Yi, [T|Ts], [X|Xs], [Y|Ys]) :-
            Xi + Ti #=< X 
        #\/ X + T   #=< Xi 
        #\/ Yi + Ti #=< Y 
        #\/ Y + T   #=< Yi,
        no_overlap_aux(Ti, Xi, Yi, Ts, Xs, Ys).

/* no_overlap vérifie que les carrés ne se chevauchent pas.            */
/* [T|Ts] : la liste des tailles des petits carrés                     */
/* [X|Xs] : la liste des abscisses des petits carrés                   */
/* [Y|Ys] : la liste des ordonnées des petits carrés                   */
no_overlap([], [], []).
no_overlap([T|Ts], [X|Xs], [Y|Ys]) :-
        no_overlap_aux(T, X, Y, Ts, Xs, Ys),
        no_overlap(Ts, Xs, Ys).

/* solve1 est la première solution au problème                         */
/* Num : numéro du problème                                            */
/* Xs : liste des abscisses des petits carrés                          */
/* Ys : liste des ordonnées des petits carrés                          */
/* B : nombre de backtracks réalisés                                   */
solve1(Num, Xs, Ys, B) :-
        data(Num, T, Ts),
        length(Ts, N),
        length(Xs, N),
        length(Ys, N),
        domains(Xs, Ts, T),
        domains(Ys, Ts, T),
        no_overlap(Ts, Xs, Ys),
        fd_labeling(Xs, [backtracks(B)]),
        fd_labeling(Ys, [backtracks(B)]),
        printsol('sol1', Xs, Ys, Ts).


/***********************************************************************/
/********************** CONTRAINTES REDONDANTES ************************/
/***********************************************************************/

/* sum et sum_expr permettent de faire la somme des éléments d'1 liste */
/* L : la liste                                                        */
/* S : le résultat de la somme                                         */
sum_expr([], 0).
sum_expr([X|Xs], X+S) :- sum_expr(Xs, S).

sum(L, S) :- sum_expr(L, Expr),
             S #= Expr.


/* Produit entre 2 listes                                              */
/* R contient le produit des listes [T1|Q1] et [T2|Q2]                 */
/* Par exemple le produit de [1,2] et [2,2] est [2,4]                  */
prod([],[],[]).
prod([T1|Q1], [T2|Q2], R) :-
        P #= T1*T2,
        prod(Q1, Q2, R1),
        append([P], R1, R).

/* cross_aux indique quels sont les petits carrés traversés par la     */
/* verticale (ou l'horizontale) numéro V.                              */
/* V : numéro de la verticale (ou de l'horizontale)                    */
/* [X|Xs] : liste des abscisses (ou ordonnées) des petits carrés       */
/* [T|Ts] : liste des tailles des petits carrés                        */
/* B : liste contenant que des 0 ou des 1.                             */
/* B[i] = 1 si la verticale (ou l'horizontale) traverse le carré i     */
/* B[i] = 0 sinon.                                                     */
cross_aux(_, [], [], []).
cross_aux(V, [X|Xs], [T|Ts], [B|Bs]) :-
        B #<=> (X #=< V #/\ V #< X + T),
        cross_aux(V, Xs, Ts, Bs).

/* Pour chaque verticale (ou horizontale), cross permet de vérifier que */
/* la somme des tailles des petits carrés traversés par la verticale    */
/* (ou l'horizontale) est égale à la taille du grand carré.             */
/* T : taille du grand carré                                            */
/* Vi : numéro de la verticale (ou horizontale) initiale                */
/* Xs : liste des abscisses (ou ordonnées) des petits carrés            */
/* Ts : liste des tailles des petits carrés                             */
cross(T, T, _, _).
cross(T, Vi, Xs, Ts) :-
        Plus #= Vi + 1,
        cross_aux(Vi, Xs, Ts, B),
        prod(Ts, B, S),
        sum(S, T),
        cross(T, Plus, Xs, Ts).

/* solve2 résoud le problème avec les contraintes redondantes           */
/* Num : numéro du problème                                             */
/* Xs : liste des abscisses des petits carrés                           */
/* Ys : liste des ordonnées des petits carrés                           */
/* B : nombre de backtracks réalisés                                    */
solve2(Num, Xs, Ys, B) :-
        data(Num, T, Ts),
        length(Ts, N),
        length(Xs, N),
        length(Ys, N),
        domains(Xs, Ts, T),
        domains(Ys, Ts, T),
        no_overlap(Ts, Xs, Ys),

        cross(T, 0, Xs, Ts),
        cross(T, 0, Ys, Ts),
        
        fd_labeling(Xs, [backtracks(B)]),
        fd_labeling(Ys, [backtracks(B)]),
        printsol('sol2', Xs, Ys, Ts).


/***********************************************************************/
/********************** STRATEGIE DE RECHERCHE *************************/
/***********************************************************************/

/* solve3 résoud le problème avec les contraintes redondantes et en    */
/* utilisant la fonction labeling fournie.                             */
/* Num : numéro du problème                                            */
/* Xs : liste des abscisses des petits carrés                          */
/* Ys : liste des ordonnées des petits carrés                          */
/* B : nombre de backtracks réalisés                                   */
/* NbSol : numéro de la solution                                       */
solve3(Num, Xs, Ys, B, NbSol, Goal) :-
        data(Num, T, Ts),
        length(Ts, N),
        length(Xs, N),
        length(Ys, N),
        domains(Xs, Ts, T),
        domains(Ys, Ts, T),
        no_overlap(Ts, Xs, Ys),
        cross(T, 0, Xs, Ts),
        cross(T, 0, Ys, Ts),
        labeling(Xs, Ys, Goal, minmin, B, NbSol),
        printsol('sol3', Xs, Ys, Ts).

/* En utilisant le but assign, on obtient 805 backtracks contre 9038   */
/* avec le but indomain.                                               */


/***********************************************************************/
/**************************** SYMETRIES ********************************/
/***********************************************************************/

/* Pour la première instance, on trouve 480 solutions. Il y a des doublons */

/* Pour supprimer les doublons, on ordonne les coordonnées des petits   */
/* carrés de même taille. Si 2 petits carrés ont la même taille alors,  */
/* le 1er a une abscisse inférieure ou égale au deuxième. De plus, si   */
/* ils ont la même abscisse alors l'ordonnée du premier est strictement */
/* inférieure à celle du deuxième.                                      */

/* order_aux ordonne les coordonnées de 2 petits carrés de même taille. */
/* X : abscisse du premier petit carrée                                 */
/* [X1|_] : liste des abscisses des petits carrés suivant le 1er        */
/* Y : ordonnée du premier petit carrée                                 */
/* [X1|_] : liste des ordonnées des petits carrés suivant le 1er        */
/* T : taille du premier petit carré                                    */
/* [T1|_] : liste des tailles des petits carrés suivant le 1er          */
order_aux(X, [X1|_], Y, [Y1|_], T, [T1|_]) :-
        (T #\= T1) #\/ ((Y #< Y1 #\/ X #< X1) #/\ X #=< X1).

/* order ordonne les petits carrés qui ont la même taille.              */
/* [X|Xs] : abscisses des petits carrés.                                */
/* [Y|Ys] : ordonnées des petits carrés.                                */
/* [T|Ts] : tailles des petits carrés.                                  */
order([_], [_], [_]).
order([X|Xs], [Y|Ys], [T|Ts]) :-
        order_aux(X, Xs, Y, Ys, T, Ts),
        order(Xs, Ys, Ts).

/* solve4 résoud le problème avec les contraintes redondantes en        */
/* utilisant la fonction labeling fournie et en ordonnant               */
/* les coordonnées des petits carrés de même taille.                    */
/* Num : numéro du problème                                             */
/* Xs : liste des abscisses des petits carrés                           */
/* Ys : liste des ordonnées des petits carrés                           */
/* B : nombre de backtracks réalisés                                    */
/* NbSol : numéro de la solution                                        */
solve4(Num, Xs, Ys, B, NbSol, Goal) :-
        data(Num, T, Ts),
        length(Ts, N),
        length(Xs, N),
        length(Ys, N),
        domains(Xs, Ts, T),
        domains(Ys, Ts, T),
        no_overlap(Ts, Xs, Ys),
        cross(T, 0, Xs, Ts),
        cross(T, 0, Ys, Ts),
        order(Xs, Ys, Ts),
        labeling(Xs, Ys, Goal, minmin, B, NbSol),
        printsol('sol4', Xs, Ys, Ts).

/* Avec cette solution on obtient 4 solutions pour la 1ere instance.   */

/* On utilise temp pour forcer le premier petit carré (le plus grand)  */
/* à être dans le coin bas gauche.                                     */
temp([0|_], [0|_]).

/* solve5 résoud le problème avec les contraintes redondantes en       */
/* utilisant la fonction labeling fournie et en ordonnant les          */
/* coordonnées des petits carrés de même taille. De plus, on force le  */
/* plus grand carré à être dans le coin en bas à gauche                */

/* Num : numéro du problème                                            */
/* Xs : liste des abscisses des petits carrés                          */
/* Ys : liste des ordonnées des petits carrés                          */
/* B : nombre de backtracks réalisés                                   */
/* NbSol : numéro de la solution                                       */
solve5(Num, Xs, Ys, B, NbSol, Goal) :-
        data(Num, T, Ts),
        length(Ts, N),
        length(Xs, N),
        length(Ys, N),
        domains(Xs, Ts, T),
        domains(Ys, Ts, T),
        temp(Xs, Ys),
        no_overlap(Ts, Xs, Ys),
        cross(T, 0, Xs, Ts),
        cross(T, 0, Ys, Ts),
        order(Xs, Ys, Ts),
        labeling(Xs, Ys, Goal, minmin, B, NbSol),
        printsol('sol5', Xs, Ys, Ts).

/* En rompant les symétries géométriques en restreignant la position du centre du */
/* plus grand carré dans le coin inférieur gauche, on obtient 1 solution pour la  */
/* première instance. Pour la deuxième instance, on obtient 2254 solutions.       */

