/**************************/
/* Definition of fact/2 */
/**************************/

fact(0,1).
fact(X,Y) :- X > 0, T is X-1, fact(T,Z), Y is X*Z.
