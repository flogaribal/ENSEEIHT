function [Q]=matrix_representation(A,n)
% Representation sous forme de matrice du graphe Internet
% A contient les arcs du graphe oriente.
% n represente le nombre de sommets.
% Q est la matrice du graphe Internet.

% Initialisation
Q = zeros(n);

[nbLignes,~] = size(A);
tabNbApparitions = zeros(1,n);

for m = 1:nbLignes
    tabNbApparitions(A(m,1))= tabNbApparitions(A(m,1)) +1;
end

for l = 1:nbLignes
    i = A(l,2);
    j = A(l,1);
    Q(i,j) = 1/tabNbApparitions(j);
end

end