function [fx] = f2(x) 
    global nbEval_f2;
    
    fx = 100 * (x(2)-(x(1)).^2).^2 + (1 - x(1)).^2;
    
    nbEval_f2 = nbEval_f2 + 1;
end

