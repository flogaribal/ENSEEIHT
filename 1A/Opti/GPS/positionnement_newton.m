function M = positionnement_newton(M0,TGps,TRecep,X,Y,Z,c)
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Calcul de la position de l'utilisateur avec la méthode newton
% function M = positionnement(M0,TGps,TRecep,X,Y,Z,c)
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Entrees :
%       M0 : point initial M0 = [X0,Y0,Z0,BH0]' (4x1)
%       TGps : vecteur colonne de taille le nombre de satellites visibles
%               indiquant le temps GPS � l'�mission du signal
%       TRecep : vecteur colonne de taille le nombre de satellites visibles
%               indiquant le temps Utilisateur � la r�ception du signal
%       X : vecteur colonne de taille le nombre de satellites visibles
%               indiquant la coordonn�e X des satellites visibles
%       Y : vecteur colonne de taille le nombre de satellites visibles
%               indiquant la coordonn�e Y des satellites visibles
%       Z : vecteur colonne de taille le nombre de satellites visibles
%               indiquant la coordonn�e Z des satellites visibles
%       c : vitesse de propagation du signal
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Sortie :
%       M : point solution (4x1)
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% fonctions utiles :
%       test_convergence : 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Initialisations / recuperation des donnees
CoordSat = [X';Y';Z'];
NbSat = size(CoordSat,2);
Mn=M0;
my_eps = 10^(-3);

NbIter = 1;
Critere = 0;
continuer = true;
normGrad0 = 0;
MaxIter = 6;

MnOld = Mn;
%%%%%%%%%%%%%%%%%%%%%  A COMPLETER %%%%%%%%%%%%%%%%%%%%%%%
% Iterations de Newton :

%while  continuer 
 for i=1:5
     
    MnOld = Mn;
    
    res = res_GPS(TGps, TRecep, CoordSat, Mn(1:3), Mn(4), NbSat, c);
    Jr = J_res_GPS(Mn(1:3), CoordSat, NbSat, c); 
    grad = Jr' * res;
    
    Mn = MnOld - H_f_GPS(res, Jr, NbSat, Mn(1:3), CoordSat) \ grad;
    
    NbIter = NbIter + 1;
    
end


%%%%%%%%%%%%%%%%%%%%%  A COMPLETER (fin) %%%%%%%%%%%%%%%%

% Affichage du nombre d'iterations et du critere d'arret ainsi
% que des erreurs sur la position calculee et le biais d'horloge:
%%test_convergence( Mn(1:3), Mn(4), NbIter, Critere );

% Affectation de la solution retournee:
M = Mn;
