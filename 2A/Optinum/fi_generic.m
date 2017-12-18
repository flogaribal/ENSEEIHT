function [fi] = fi_generic(B,lambda,delta,x)
    
    % Calcul de la valeur fi 
    tmp_fi = 0;
    for i=1:size(B,1)
        tmp_fi = tmp_fi + B(i)^2/(x+lambda(i))^2;
    end

    fi = 1/tmp_fi - 1/(delta^2);

end

