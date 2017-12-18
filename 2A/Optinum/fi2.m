function [fi_lambda] = fi2(lambda)
    norm_s_lambda_2 = 4/((lambda-38)^2) + 400/((lambda+20)^2);
    delta = 0.04;
    
    fi_lambda = norm_s_lambda_2 - delta^2 ;

end

