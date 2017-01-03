function [E,S_cos,S_sin,contour,indices_tries] = recursion(E,S_cos,S_sin,contour,indices_tries,...
					i,j,voisins,Gx,Gy,G_norme,card_max,cos_alpha,nb_lignes,nb_colonnes)
% Fonction recursive permettant de construire un ensemble candidat E

theta_E = atan(S_sin/S_cos);		% Angle polaire du gradient moyen sur E
G_moyen = [cos(theta_E); sin(theta_E)]; % Gradient de départ 

k = 1;
while k<=8 & size(E,1)<=card_max
	i_voisin = i+voisins(k,1);
	j_voisin = j+voisins(k,2);
    
	if contour(i_voisin,j_voisin) > 0 
        gradPtCourant = [Gx(i,j) Gy(i,j)];
        gradVoisin = [Gx(i_voisin, j_voisin) Gy(i_voisin, j_voisin)];
              
        
        % Si gradient dans la même direction
        if abs(Gx(i_voisin,j_voisin) * G_moyen(1) + Gy(i_voisin,j_voisin) * G_moyen(2)) >= G_norme(i_voisin, j_voisin) * cos_alpha
        
            % Ajout de l'élément
            E = [E ; [i_voisin,j_voisin]];
            
            % Pixel voisin enlevé du contour
            contour(i_voisin,j_voisin) = 0;
            
            % Retrait du pixel voisin
            indices_tries = indices_tries(indices_tries ~= sub2ind(size(contour), i_voisin, j_voisin));
            
            % Mise à jour des variables pour récursivité
            S_cos = S_cos + (Gx(i_voisin,j_voisin) / G_norme(i_voisin, j_voisin));
            S_sin = S_sin + (Gy(i_voisin,j_voisin) / G_norme(i_voisin,j_voisin));   

            % Rappel 
            [E,S_cos,S_sin,contour,indices_tries] = recursion(E, S_cos, S_sin, contour, indices_tries, i_voisin, j_voisin, voisins, Gx, Gy, G_norme, card_max, cos_alpha, nb_lignes, nb_colonnes);
        end
	end
	k = k+1;
end
