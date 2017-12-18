/*VOEDTS NADIA*/

:- include(libtp2).


/**************************************************/
/*Fonctions utilisées pour créer la liste de 1 a N*/
/**************************************************/

n_ups(N, Xs) :-
   length(Xs, N),
   numbered_from(Xs, 1).

numbered_from([], _).
numbered_from([I0|Is], I0) :-
   I1 is I0+1,
   numbered_from(Is, I1).


/***********************/
/*Fonctions de parcours*/
/***********************/

parcours(_,[],_,_,_,_).
parcours(I,[J|Q],T,Xs,Ys,Ts) :-
	contraintes(I,J,T,Xs,Ys,Ts),
	parcours(I,Q,T,Xs,Ys,Ts).

parcours_pair(Ind,_,_,_,_) :- length(Ind,1).
parcours_pair([I|Q],T,Xs,Ys,Ts) :-
	parcours(I,Q,T,Xs,Ys,Ts),
	parcours_pair(Q,T,Xs,Ys,Ts).




/*************/
/*Contraintes*/
/*************/

contraintes(I,J,T,Xs,Ys,Ts) :- 
	fd_element_var(I,Ts,Tsi),
	fd_element_var(I,Xs,Xsi),
	fd_element_var(I,Ys,Ysi),

	fd_element_var(J,Ts,Tsj),
	fd_element_var(J,Xs,Xsj),
	fd_element_var(J,Ys,Ysj),

	/**********************************************/
	/*Contrainte de non depassement du grand carré*/
	/**********************************************/

	Xsi #=<# T - Tsi,
	Ysi #=<# T - Tsi,
	Xsj #=<# T - Tsj,
	Ysj #=<# T - Tsj, 

	/***************************************************/
	/*Contrainte de non chevauchement des petits carres*/
	/***************************************************/

		(Xsj #>=# Xsi + Tsi) 
	#\/ (Ysj #>=# Ysi + Tsi) 
	#\/ (Xsi #>=# Xsj + Tsj) 
	#\/ (Ysi #>=# Ysj + Tsj).



/*************************/
/*Contraintes redondantes*/
/*************************/
	
contraintes_redondantes([],_,_,_,_).
contraintes_redondantes([Vi|Vs],T,Xs,Ys,Ts) :-
	contraintes_redondantes_verticales(Vi,Sum,T,Xs,Ys,Ts),
	contraintes_redondantes_horizontales(Vi,Sum,T,Xs,Ys,Ts),
	contraintes_redondantes(Vs,T,Xs,Ys,Ts).

contraintes_redondantes_verticales(_,T,_,[],[],T).
contraintes_redondantes_verticales(V,Sum,T,[Xi|Xs],Ys,[Ti|Ts]) :-
	contraintes_redondantes_verticales(V,Sum + (Ti * (Xi #=<# V #/\ V #<# Xi + Ti)),T,Xs,Ys,Ts).


contraintes_redondantes_horizontales(_,T,_,[],[],T).
contraintes_redondantes_horizontales(V,Sum,T,Xs,[Yi|Ys],[Ti|Ts]) :-
	contraintes_redondantes_horizontales(V,Sum + (Ti * (Yi #=<# V #/\ V #<# Yi + Ti)),T,Xs,Ys,Ts).


/************/
/*Resolution*/
/************/
	
solve(Num,Xs,Ys,backtracks(B)) :- 
	data(Num,T,Ts),

	length(Xs,L),
	length(Ys,L),
	length(Ts,L),

	fd_domain(Xs,0,T),
	fd_domain(Ys,0,T),
	
	
	n_ups(L,Ind),
	


	parcours_pair(Ind,T,Xs,Ys,Ts),


	/*************************/
	/*contraintes redondantes*/
	/*************************/

	length(V,T),
	numbered_from(V,0),

	contraintes_redondantes(V,T,Xs,Ys,Ts),



	fd_labeling(Xs,[backtracks(B)]),
	print(B),
	fd_labeling(Ys,[backtracks(B)]),
	print(B),

	printsol('resultat.txt',Xs,Ys,Ts).


