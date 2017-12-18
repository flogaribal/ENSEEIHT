function [fi_deriv_lambda] = fi_deriv2(lambda)
    
    fi_deriv_lambda = (-8/(lambda-38)^3) - (400*2/(lambda+20)^3);

end

