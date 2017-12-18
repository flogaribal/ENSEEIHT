dgr(Vars) :- 
	/* Déclaration des variables */
	Vars = [A,B,D,E,G,L,N,O,R,T],
	fd_domain(Vars,0,9),

	/* Contraintes */
	fd_all_different(Vars),
	D #\= 0,
	G #\= 0,
	R #\= 0,
	(D + 10*L + 100*A + 1000*N + 10000*O + 100000*D) + (D + 10*L + 100*A + 1000*R + 10000*E + 100000*G) #= (T + 10*R + 100*E + 1000*B + 10000*O + 100000*R),

	/* Solutions */
	fd_labeling(Vars).

hardy(Vars) :- 
	/* Déclaration des variables */
	Vars = [A,B,C,D],
	fd_domain(Vars,1,100),

	/* Contraintes */
	A #=< B,
	C #=< D,
	A #< C,
	N #= A*A*A + B*B*B,
	N #= C*C*C + D*D*D,
	N #< 1000000,

	/* Solutions */
	fd_minimize(fd_labeling(Vars),N).

monnaie(Vars) :- 
	/* Déclaration des variables */
	Vars = [UN, DEUX, CINQ, DIX, VINGT, CINQUANTE, UNEURO, DEUXEUROS],
	fd_domain(Vars,0,3),

	/* Contraintes */
	2000 #= 1729 + 1*UN + 2*DEUX + 5*CINQ + 10*DIX + 20*VINGT + 50*CINQUANTE + 100*UNEURO + 200*DEUXEUROS,

	sum(Vars, NbPieces),

	/* Solutions */
	fd_minimize(fd_labeling(Vars),NbPieces).

/* AUTANT DE CONTRAINTES QUE DE PASSAGE RECURSIF */
%% sum([],0).
%% sum([H|Q],S)  :- 
%% 	sum(Q,S1),
%% 	S #= S1+H.


/* AUTRE VERSION AVEC 1 SEULE CONTRAINTE*/
sum_expr([],0).
sum_expr([T|Q],T+S) :-
	sum_expr(Q,S).

sum(L,S) :-
	sum_expr(L, Expr),
	S #= Expr.


