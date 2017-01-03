function M = positionnement(M0,TGps,TRecep,X,Y,Z,c)
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Calcul de la position de l'utilisateur
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

NbIter = 0;
Critere = 0;
continuer = true;
normGrad0 = 0;
MaxIter = 6;
%%%%%%%%%%%%%%%%%%%%%  A COMPLETER %%%%%%%%%%%%%%%%%%%%%%%
% Iterations de Gauss-Newton :

while  continuer 
    
    res = res_GPS(TGps, TRecep, CoordSat, Mn(1:3), Mn(4), NbSat, c);
    Jr = J_res_GPS(Mn(1:3), CoordSat, NbSat, c); 
    grad = Jr' * res;
    
    % Stockage du gradient à l'iteration 0
    if NbIter == 0
       normGrad0 = norm(grad);
    end
    
    choles = CholeskiMdC(Jr, res)
    Mn = Mn - choles;
    
    NbIter = NbIter + 1;
    
    
    if norm(grad) < my_eps * normGrad0
        continuer = false;
        disp(['Sortie par gradient très petit en ', int2str(NbIter), ' itérations']);
   
    elseif norm(choles) < my_eps * normGrad0
        continuer = false;
        disp(['Sortie par convergence de || x^k - x(k+1) || en ', int2str(NbIter), ' itérations']);
        
    elseif NbIter > MaxIter
        continuer = false;
        disp('Sortie par dépassement du nombre d''iteration pour Gauss Newton');
        
    else 
        continuer = true;
    end 
    
end


%%%%%%%%%%%%%%%%%%%%%  A COMPLETER (fin) %%%%%%%%%%%%%%%%

% Affichage du nombre d'iterations et du critere d'arret ainsi
% que des erreurs sur la position calculee et le biais d'horloge:
%%test_convergence( Mn(1:3), Mn(4), NbIter, Critere );

% Affectation de la solution retournee:
M = Mn;
