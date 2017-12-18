%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Fonction newton_local qui implémente l'algorithme newton local fourni dans le sujet
%% f             : Fonction à minimiser 
%% x0            : Première approximation de la solution recherchée
%% fct_gradient  : Fonction calculant le gradient de f
%% fct_hessienne : Fonction calculant la hessienne de f
%% epsilon       : Précision demandée
%% nbMaxIter     : Nombre d'itérations maximum
%%%%%%% SORTIES 
%% x_min         : Valeur où f(x_min) est minimale
%% flag          : Raison pour laquelle le calcul s'est arrêté (cf rapport ou code)
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [x_min, flag] = newton_local(f, x0, fct_gradient, fct_hessienne, epsilon, nbMaxIter) 

    xk = x0;
    xk1 = x0;
    nbIter = 0;
    flag = 0;
    
    gradient_x0 = fct_gradient(x0);
    norm_grad_x0 = norm(gradient_x0);
    
    while (flag == 0)
        xk = xk1;
        
        grad = fct_gradient(xk);
        hess = fct_hessienne(xk);
                
        dk = hess\(-grad);
        
        xk1 = xk + dk;
        
        nbIter = nbIter+1;
        f_xk = f(xk);
        
        if (nbIter > nbMaxIter) 
           flag = 1;
        
        elseif norm(grad)/(norm_grad_x0+epsilon) <= epsilon
            flag = 2;
        
        elseif (norm(xk1-xk)/norm(xk)) <= epsilon
           flag = 3;
        
        elseif norm(f(xk1)-f_xk)/norm(f_xk) <= epsilon
           flag = 4;
        end
    
    end
    nbIter
    x_min= xk;
end
