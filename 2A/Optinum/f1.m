function [fx] = f1(x)
    global nbEval_f1;
    
    fx = 2 * (x(1)+x(2)+x(3)-3).^2 + (x(1)-x(2)).^2 + (x(2)-x(3)).^2 ;
    
    nbEval_f1 = nbEval_f1+1;
end

