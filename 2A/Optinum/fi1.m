function [fi_lambda] = fi1(lambda)
    norm_s_lambda_2 = 4/((lambda+2)^2) + 36/((lambda+14)^2);
    delta = 0.5;
    
    fi_lambda = norm_s_lambda_2 - delta^2 ;

    
end

