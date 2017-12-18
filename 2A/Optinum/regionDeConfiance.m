%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Fonction regionDeConfiance qui implémente la méthode des régions de confiance
%% x0            : Première approximation de la solution recherchée
%% deltaMax      : Région de confiance maximum
%% delta0        : Région de confiance initiale 
%% nbMaxIter     : Nombre d'itérations maximum
%% gamma1        : 
%% gamma2        : 
%% nu1           :
%% nu2           :
%% epsilon       : Précision demandée
%% f             : Fonction à minimiser 
%% grad          : Fonction calculant le gradient de f
%% hess          : Fonction calculant la hessienne de f
%% choixMethode  : Choix de la méthode pour la résolution d'équations
%%                 0 = Pas de Cauchy
%%                 1 = Moré-Sorensen
%%%%%%%% SORTIES
%% min_f         : Valeur où f(min_f) est minimale
%% nbIter        : Nombre d'itérations utilisé pour faire le calcul
%% flag          : Raison pour laquelle le calcul s'est arrêté (cf code ou rapport)
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [min_f, nbIter, flag] = regionDeConfiance(x0, deltaMax, delta0, nbMaxIter, gamma1, gamma2, nu1, nu2, epsilon, f, grad, hess, choixMethode)

    xk = x0;
    delta = delta0;
    nbIter = 0;
    flag = 0;
    
    while flag == 0
        
        gradient = grad(xk);
        hessienne = hess(xk);
        
        % APPROXIMATION DE LA SOLUTION SELON METHODE CHOISIE
        sk = 0;
        if choixMethode == 0 
            sk = pasDeCauchy(delta,hessienne,gradient);
        elseif choixMethode == 1
            [sk,useless] = More_Sorensen(gradient, hessienne, delta, epsilon,nbMaxIter );
        else
            disp('ERREUR : choixMethode doit être égal à 1 ou 0')
        end
        
        % CALCUL  f(xk+sk)
        f_xk_sk = f(xk+sk);
        
        % CALCUL roh_k
        roh_k = (f(xk) - f_xk_sk) / (f(xk) - q(f(xk),sk,gradient,hessienne));
        
        % MAJ ITERE COURANT
        if roh_k >= nu1
            xk = xk+sk;
        else 
            xk = xk;
        end
        
        % MAJ REGION DE CONFIANCE
        if roh_k >= nu2 
            delta = min((gamma2*delta),deltaMax);
            
        elseif roh_k >= nu1 && roh_k <= nu2
        %    delta = delta; 
        else
            delta = gamma1 * delta;
        end
        
        % CONDITIONS D'ARRET
        if (norm(gradient)/norm(grad(x0)+epsilon) < epsilon)
            flag = 2;
        elseif (nbIter > nbMaxIter )
            flag = 1;
        end
        nbIter = nbIter + 1;
    end
    min_f = xk;
end

