%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Fonction More_Sorensen qui implémente l'algorithme de Moré-Sorensen en utilisant la résolution
%% de Newton pour les équations non linéaires
%% g             : Matrice g du problème
%% H             : Matrice H du problème
%% delta         : Contrainte sur la norme de la solution
%% eps           : Précision souhaitée de la solution 
%% maxIter       : Nombre maximum d'itérations demandé
%%%%%% SORTIES
%% sEtoile       : Solution du problème
%% lambdaEtoile  : Multiplicateur de lagrange
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function [sEtoile,lambdaEtoile] = More_Sorensen(g,H,delta,eps, maxIter)

% Si debug activé, affichage des différents passages dans les conditions %
debug = 0;

% Récupération valeurs propres
[Q valPropres] = eig(H);
[lambda, indices] = sort(diag(valPropres));
Q = Q(:,indices);
lambdaEtoile = 0;

% Calcul pas de Newton
sn=-H\g;
%disp([sn])
n = size(lambda,1);

% Si Q SEMI DEFINIE POSITIVE
% Solution intérieure
if lambda(1,1) >= 0 &&  norm(sn) < delta
    if debug == 1
        disp('Q semi définie positive')
    end 
    
    sEtoile = sn;
    lambdaEtoile = 0;
    
% Solution sur la frontière
% Si Q NON SEMI DEFINIE POSITIVE
else
    if debug == 1
        disp('Q non semi définie positive')
    end
    lambda1 = lambda(1,1);
    sEtoile = 0;
    lambdaMin = 0;
    lambdaMax = max(0,-lambda1 + 2);
    
    %% LAMBDA MAX
    k = 0;
    
    continuer = true;    
    while (continuer)
        lambdaMax = -lambda1 + 2^k;
        k = k+1;
        
        sLambdaMax = 0;
        % Calcul de s(Lambda Max)
        for i=1:n
            sLambdaMax = sLambdaMax + (Q(:,i)' * g)/(lambda(i)+lambdaMax);
        end
        
        % Fin de boucle ?
        continuer = norm(sLambdaMax)^2 > delta^2 ;
    end
    
    B = Q'*g; 
    
    if Q(1)'*g ~= 0 % g et q1 non orthogonal
        %% SI -Lambda1 >= 0
        %if - lambda1 >= 0
        if debug == 1
            disp('Q(1)''*g non orthogonal')
        end

        lambdaMin = max(0,-lambda1 + 1/2);

        %% LAMBDA MIN
        k = 0;
        continuer = true;
        while (continuer)
            lambdaMin = -lambda1 + 1/(2^k);
            sLambdaMin = 0;

            % Calcul de s(Lambda Min)
            for i=1:n
                sLambdaMin = sLambdaMin + (Q(:,i)' * g)/(lambda(i)+lambdaMin);
            end

            k = k+1;

            % Fin de boucle ?                
            continuer = norm(sLambdaMin)^2 < delta^2 ;                
        end
        %end
        %%%%%%%% APPEL NEWTON ENL %%%%%%%%%%%%%%
        lambdaEtoile = newton_ENL(lambdaMin,lambdaMax,eps,maxIter, @(x)fi_generic(B,lambda,delta,x), @(x)fi_deriv_generic(B,lambda,delta,x));

        % Calcul de sEtoile
        for i=1:size(Q(:,1))
            sEtoile = sEtoile - (B(i)./(lambdaEtoile+lambda(i))) * Q(:,i);
        end
        
    else %% g et q1 orthogonal
        
        sTLambda1 = sum((-B(2:end)./(lambda(2:end) - lambda(1)))*Q(2:end));
        
        if norm(sTLambda1) < delta
            if debug == 1
                disp('Q(1)''*g orthogonal ET norm(sTLambda1 < delta)')
            end
            % On cherche alpha tel que
            % NORM(Somme de 1 a n de : (q(i)_t*g*q(i))/lambda(i)+lambda) + alpha q(1)) = DELTA
            lambdaEtoile = -lambda1;
            
            alpha = sqrt(norm(delta)^2 - norm(sTLambda1)^2);
                   
            % Calcul de sEtoile
            sEtoile = alpha*Q(:,1);
            
            for i=2:size(Q(:,1))
                sEtoile = sEtoile - (B(i)./(lambdaEtoile+lambda(i))) * Q(:,i);
            end            
        else
            if debug == 1
                disp('Q(1)''*g orthogonal ET norm(sTLambda1 >= delta)')
            end
            %% LAMBDA MIN
            k = 0;
            continuer = true;
            while (continuer)
                
                % Calcul de s(Lambda Min)
                for i=1:n
                    sLambdaMin = sLambdaMin + (Q(:,i)' * g)/(lambda(i)+lambdaMin);
                end
                
                lambdaMin = -lambda1 + 1/2^k;
                k = k+1;
                
                % Fin de boucle ?
                continuer = norm(sLambdaMin)^2 < delta^2 ;
                
            end
            
            B = Q'*g;          
            
            %%%%%%%% APPEL NEWTON ENL %%%%%%%%%%%%%%
            lambdaEtoile = newton_ENL(lambdaMin,lambdaMax,eps,maxIter, @(x)fi_generic(-B,-lambda1,delta,x), @(x)fi_deriv_generic(-B,-lambda1,delta,x));
            
            % Calcul de sEtoile
            for i=1:size(Q(:,1))
                sEtoile = sEtoile + (B(i)./(lambdaEtoile+lambda(i))) * Q(:,i);
            end
        end
    end
end
end

