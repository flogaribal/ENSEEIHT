function [fi_deriv] = fi_deriv_generic(B,lambda,delta,x)

    fi = fi_generic(B,lambda,delta,x);
    
    % Calcul de la valeur fi_deriv
    tmp_fi = 0;
    tmp_fi_deriv = 0;
    
    for i=1:size(B,1)
        tmp_fi = tmp_fi + B(i)^2/(x+lambda(i))^2;
        tmp_fi_deriv = tmp_fi_deriv + - 2*(B(i)^2)/(x+lambda(i))^3;        
    end
    
    fi = 1/tmp_fi - 1/(delta^2);
    fi_deriv = tmp_fi_deriv / fi^2;

end

