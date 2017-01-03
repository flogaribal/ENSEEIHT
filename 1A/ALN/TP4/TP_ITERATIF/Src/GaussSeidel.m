function [x,iter,niter] = GaussSeidel(A,b,x0,maxiter,eps)

    x = x0;
    M = tril(A);
    N = A - M;
    iter = 0;
    niter = 0;
    
    while norm(A*x - b) / norm(b) > eps && iter < maxiter
        r = b - A*x;
        m1 = M \ (M*x + r);
        x = m1;
        iter = iter + 1;
        niter(iter) =   norm(r) / norm(b);
    end
end
