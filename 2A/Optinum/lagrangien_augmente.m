%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Fonction lagrangien_augmente qui implémente la méthode du lagrangien augmenté
%% f            :
%% c            :
%% gradient     :
%% jacobienne   : 
%% hessienne    :
%% mu0          : 
%% tho          : 
%% ethaChapoO   : 0.1258925
%% alpha        :
%% betha        :
%% x0           :
%% lambda0      :
%% deltaO       :
%% deltaMax     :
%% n1           :
%% n2           :
%% gamma1       :
%% gamma2       :
%% nbMaxIter       :
%% choixMethode : Méthode choisie 
%%                   choixMethode = 0 -> Newton local
%%                   choixMethode = 1 -> Région de confiance
%%%%%%%%%%%%%%% SORTIES
%% x            :
%% lambda       :
%% mu           :
%% flag         :
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [x, lambda, mu, flag] = lagrangien_augmente(f, c, gradient, jacobienne, hessienne, mu0, tho, etaChapoO, alpha, betha, x0, lambda0, deltaO, deltaMax, n1, n2, gamma1, gamma2, nbMaxIter , choixMethode)

nbIter  = 0;
epsilon0 = 1/mu0;
etha0 = etaChapoO/(mu0^alpha);

xk = x0;
lambdak = lambda0;
muk = mu0;
ethak = etha0;
epsilonk = 1/muk;

continuer = true;

% Tant que pas convergence 
while continuer 
    
    % Construction du Lagrangien augmenté
    f = @(x)Lagrangien_generic(f, c, xk, lambdak, muk);
    grad = @(x)grad_Lagrangien_generic(gradient, jacobienne, c, xk, lambdak, muk);
    hess = @(x)hess_Lagrangien_generic(hessienne, jacobienne, hessienne, xk, muk);
     
    % Résolution selon méthode choisie
    % choixMethode = 0 -> Newton local
    % choixMethode = 1 -> Région de confiance
    if choixMethode == 0
        [xk, flag] = newton_local(f, xk, grad, hess, epsilonk, nbMaxIter);
        
    elseif choixMethode == 1
        % J'utilise la méthode de Moré Sorensen car elle converge plus rapidement
        [xk, useless, flag] = region_confiance(xk, deltaMax, deltaO, nbMaxIter, gamma1, gamma2, n1, n2, epsilonk, f, grad, hess,1); 
    end
            
    % Critères d'arrêts
    if norm(c(ck)) < epsilon2 
        flag = 1;
        continuer = false;
        
    elseif nbIter >= nbMaxIter 
        flag = 2;
        continuer = false;
    else
        if norm(c(xk)) < ethak
            % MAJ multiplicateurs
            lambdak = lambdak + muk*c(xk);
            %muk = muk
            epsilonk = epsilonk/muk;
            ethak = ethak/(muk^betha);
            nbIter  = nbIter  + 1;
        else
            % MAJ pénalités
            %lambdak = lambdak
            muk = tho*muk;
            epsilonk = epsilon0/muk;
            ethak = etaChapoO/(muk^alpha);
            nbIter  = nbIter  + 1;
        end
    end    
end
end

