%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Fonction newton_ENL qui résoud résoud une équation comportant une fonction non linéaire à variable réelle
%% lambdaMin     : Borne inférieure
%% lambdaMax     : Borne supérieure
%% espilon       : Précision voulue pour le résultat
%% maxIter       : Nombre maximum d'itérations
%% f             : Fonction f
%% f_deriv       : Fonction dérivée de f
%%%%%% SORTIES
%% res           : Solution du de l'équation
%% nbIter        : Nombre d'itérations que le calcul a prit 
%% flag          : Raison pour laquelle le calcul s'est arrêté
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function [res,nbIter, flag] = newton_ENL(lambdaMin,lambdaMax,epsilon,maxIter,f,f_deriv)

    nbIter = 0;
    flag = 0;

    abs_f_lambdaMin = abs(f(lambdaMin));
    abs_f_lambdaMax = abs(f(lambdaMax));
    mini =  min(abs_f_lambdaMin, abs_f_lambdaMax);
    
    if mini < epsilon
        if abs_f_lambdaMin < abs_f_lambdaMax
            lambda =  lambdaMin;
        else
            lambda = lambdaMax;
        end        
        
    else
        lambda = lambdaMax;
                
        while flag == 0
            % CALCUL DERIVEE %
            f_der = f_deriv(lambda); 
            
            % CALCUL LAMBDA(N) %
            lambda_n = lambda - (f(lambda)/f_der);
            
            % ITERE ACCEPTE %
            if lambdaMin <= lambda_n <= lambdaMax && abs(f(lambda_n)) < 1/2 * abs(f(lambda))
                lambda = lambda_n;                
            
            else 
            % ITERE REFUSE %
                lambda_d = (lambdaMin + lambdaMax)/2;
                
                if (f(lambdaMin)*f(lambda_d) <= 0)
                    lambdaMax = lambda_d;
                else 
                    lambdaMin = lambda_d;
                end
                lambda = lambda_d;
            end
            
            nbIter = nbIter + 1;
            if abs(f(lambda))<= epsilon
                flag = 1;
            elseif nbIter >= maxIter 
               flag = 2;
            end
        end
    end
    res = lambda;
    f(lambda);
end

