function [ grad_f1 ] = gradient_f1(x)
    global nbEval_grad_f1;
    
    grad_f1 = [ 6*x(1)+2*x(2)+4*x(3)-12 ; 2*x(1)+8*x(2)+2*x(3)-12 ; 4*x(1)+2*x(2)+6*x(3)-12 ];
    
    nbEval_grad_f1 = nbEval_grad_f1+1;
end

