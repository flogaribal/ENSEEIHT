function [r]=power_method_sparse(Q,v,alpha,eps)
% Algorithme de la puissance iteree dans le cas "creux"
% Q est la matrice representative du graphe d'Internet.
% v est le vecteur de personalisation.
% alpha est le parametre de poids.
% eps est la precision souhaitee (critere d'arret).
% r est le vecteur propre assoicee a la valeur propre 1.

% Initialisation
n=length(Q(:,1));

e = ones(n,1);

r=ones(n,1)./n;

qk = ones(n,1);

kmax = 1000;
k = 0;

while norm((alpha*Q*r+alpha*(1/n)*e*(1-norm(Q*r,1))+(1-alpha)*v)-r,1) >= eps*norm(r,1) & k<=kmax
     qk = alpha*Q*r+alpha*(1/n)*e*(1-norm(Q*r,1))+(1-alpha)*v;
     r = qk/norm(qk,1);
     k = k+1;
end

r;

end