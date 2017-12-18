function [ hess_f1 ] = hessienne_f1(x)
    global nbEval_hess_f1;

    hess_f1 = [ 6,2,4 ; 2,8,2 ; 4,2,6 ];
    
    nbEval_hess_f1 = nbEval_hess_f1 +1;
end

