function [ hess_f2 ] = hessienne_f2(x)
    global nbEval_hess_f2;
        
    hess_f2 = [-400*x(2)+1200*(x(1))^2+2 , -400*x(1); -400*x(1) , 200];
    
    nbEval_hess_f2 = nbEval_hess_f2 +1;
end

