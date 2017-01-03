function Jr = J_res_GPS(Pu, Pi, nbSat, celerite)

% Calcul de la matrice Jacobienne de la fonction vectorielle residu 

Jr = zeros(nbSat, 4);

for i=1:nbSat
   Jr(i,1) = (Pu(1) - Pi(1,i)) / norm(Pu - Pi(:,i));
   Jr(i,2) = (Pu(2) - Pi(2,i)) / norm(Pu - Pi(:,i));
   Jr(i,3) = (Pu(3) - Pi(3,i)) / norm(Pu - Pi(:,i));
   Jr(i,4) = celerite;
end