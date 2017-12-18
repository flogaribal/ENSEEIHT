function [sum] = sumVect(vecteur_proba, i)
    sum = 0;
    for j=i:size(vecteur_proba)
        sum += vecteur_proba(j);
    end

end


function [distribution_limite]= Chaine_Markov(vecteur_proba,s,S,C1,C2,C3,C4,v)

P = zeros(S+1,S+1);

%%%%%%%%%%%%%%% CONSTRUCTION DE P %%%%%%%%%%%%%%%%

%%%% Première colonne %%%%%

% Bloc Haut gauche De 1 à s-1
for j=1:s
    P(1,j) = sum(vecteur_proba,S);
end

% Bloc bas gauche De s à S
for j=s+1:S+1
    P(1,j) = sum(vecteur_proba,j);
end

% Bloc haut droit
for j=2:S+1
    for i=1:s
        P(j,i) = vecteur_proba(S-j+1);
    end
end

% Bloc bas droit
for j=2:S+1
    for i=s+1:S+1
        if j>i 
            P(j,i) = 0;
        else 
            P(j,i) = vecteur_proba(i-1);
        end 
    end
end

%%%%%%%%%%%%%%% FIN CONSTRUCTION DE P %%%%%%%%%%%%%%%%



%%%%%%%%%%%%%%% DISTRIBUTION LIMITE %%%%%%%%%%%%%%%%%%

A = eye(S+1)-P ; 
A= A' ;
b = zeros(S+1,1) ;
distribution_limite = (A)\b ; 

%%%%%%%%%%%%%%% FIN DISTRIBUTION LIMITE %%%%%%%%%%%%%%


%%%%%%%%%%%%%%% CALCUL REVENU SELON S et s %%%%%%%%%%%
cout_stockage = 0;
for i=1:S+1
    cout_stockage += distribution_limite(i) * i * C1    
end

cout_commande = 0;
for i=1:s
    cout_commande += S - i
end
cout_commande = cout_commande*C4+C3;

cout_penurie = 0;
for i=1:S+1
    if i < s
        ci = 
    else
        
    end
    cout_penurie += distribution_limite * ci
end




%%%%%%%%%%%%%%% FIN CALCUL REVENU SELON S et s %%%%%%%

