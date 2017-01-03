function [r]=power_method_dense(A,eps)
% Algorithme de la puissance iteree dans le cas "dense"
% A est la matrice dont on cherche le couple propre (r,lambda) associe a la plus
% grande valeur propre en module.
% eps est la precision souhaitee (critere d'arret).

% Initialisation
n=length(A(:,1));
r=ones(n,1)./n;
qk = ones(n,1);
k = 0;
kmax = 1000;


while norm(A*r-r,1) >= eps*norm(r,1) & k<= kmax
     qk = A*r;
     r = qk/norm(qk,1);
     k = k+1;
end

r;

end