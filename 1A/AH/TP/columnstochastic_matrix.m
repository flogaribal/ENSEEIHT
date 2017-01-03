function [P]=columnstochastic_matrix(Q)
% Modification par une matrice de rang 1 afin d'obtenir une matrice
% stochastique par colonne
% Q est la matrice carree du graphe d'internet. 
% P est la matrice carree du graphe d'internet modifie.


% Initialisation
n=length(Q(:,1));
P=Q;

for c=1:n 
    if Q(:,c) == zeros(n,1)
        P(:,c) = P(:,c)+1/n;
    end
end
    
end