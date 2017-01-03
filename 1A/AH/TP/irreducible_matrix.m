function [A,err]=irreducible_matrix(P,alpha,v)
% Modification de rang 1 d'une matrice colonne stochastique afin de la rendre
% irreductible
% P est la matrice colonne stochastique.
% alpha est le parametre de poids (0<alpha<1).
% v est le vecteur de personalisation (vi>0 et ||v||1=1)
% A est la matrice irreductible
% err vaut 1 si alpha et v ne respectent pas les contraintes.

% Initialisation
n=length(P(:,1));

% Tests sur alpha et v
conditionsOK = true;
i = 1;
len = length(v);

while conditionsOK & i <= len
    if v(i)<=0 
        conditionsOK = false;
    end
    i = i+1;
end

if alpha <= 0 || alpha >= 1 || abs(norm(v,1)-1) > eps || ~conditionsOK
    err = 1;    
else
    
    % Calcul de A
    A=P*alpha;
    deuxTerme = (1-alpha)*v*transpose(ones(n,1));
    
    A = A + deuxTerme;
    
    err=0;
    
end


end