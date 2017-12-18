function [grad_f2] = gradient_f2(x)
    global nbEval_grad_f2;
    
    grad_f2 = [-400*x(1)*x(2)+400*(x(1))^3+2*x(1)-2 ; -200*(x(1))^2+200*x(2)];
    
    nbEval_grad_f2 = nbEval_grad_f2 +1;
end

