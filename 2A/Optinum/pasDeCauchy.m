%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Fonction pasDeCauchy qui résoud un sous problèmes des régions de confiance
%% delta         : Contrainte sur la norme de la solution
%% H             : Matrice H du problème
%% g             : Matrice g du problème
%%%%%% SORTIES
%% s             : Solution du sous problèmes
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function [s] = pasDeCauchy(delta, H, g)

    a = 1/2 * g' * H * g;
    normg = norm(g);
    b = -norm(g)^2;
    lambda = -b/(2*a);
    borneSup = delta/normg;

    if ((a>0 && lambda > borneSup) || (a<=0))
       lambda = borneSup;      
    end

    s = -lambda * g ;
end