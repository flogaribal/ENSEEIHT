function H = H_f_GPS(res, Jr, NbSat, Pu, Pi)

H = Jr' * Jr;


for i=1:NbSat
    norme = norm(Pu-Pi(:,i));

    h_ri = zeros(4,4);
    
    % Calcul hessienne courante
    
        % 1ere ligne
        h_ri(1,1) = 1/norme - ((Pu(1) - Pi(1,i))^2/norme^3) ;
        h_ri(2,1) = - ((Pu(1) - Pi(1,i) * (Pu(2) - Pi(2,i))/norme^3)) ;
        h_ri(3,1) = - ((Pu(1) - Pi(1,i) * (Pu(3) - Pi(3,i))/norme^3)) ;

        % 2eme ligne
        h_ri(1,2) = h_ri(2,1);
        h_ri(2,2) = (1/norme - ((Pu(2) - Pi(2,i))^2/norme^3)) ;
        h_ri(3,2) = - ((Pu(2) - Pi(2,i) * (Pu(3) - Pi(3,i))/norme^3)) ;

        % 3eme ligne
        h_ri(1,3) = h_ri(3,1);
        h_ri(2,3) = h_ri(3,2);
        h_ri(3,3) = (1/norme - ((Pu(3) - Pi(3,i))^2/norme^3)) ;    
        
    H = H + res(i) *  h_ri;   
end