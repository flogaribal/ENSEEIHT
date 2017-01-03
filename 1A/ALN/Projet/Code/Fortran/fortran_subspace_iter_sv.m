function [U s V] = fortran_subspace_iter_sv(A, l, p, percentage, eps, maxit)
    %
    % This method computes an approximated singular value
    % decomposition A=U*diag(s)*V'
    %
    %
    %
    %
    %
    % INPUT arguments:
    %
    % version    = the subspace iteration version to be used to
    %              compute the eigenvalues
    %             
    % A          = the input matrix
    %             
    % p          = the number of products per iteration in the block
    %              algorithm
    %             
    % m          = the size of the iteration subspace
    %
    % percentage = the percentage of the trace to be retained
    %
    % eps        = threshold value to stop the subspace iteration
    %
    % maxit      = the maximum number of iterations
    %
    %
    %
    % OUTPUT arguments:
    %
    % U          = a matrix containing the left singular vectors
    %
    % s          = a vector containing the computed singular vectors
    %
    % V          = a matrix containing the right singular vectors

    if((nargin ~= 6) || (nargout~=3))
        fprintf('Wrong number of input/output arguments\n\n\nUsage:             \n');  
        fprintf('    INPUT arguments:                                               \n');  
%        fprintf('                                                                   \n');
%        fprintf('    version    = the subspace iteration version to be used to      \n');
%        fprintf('                 compute the eigenvalues                           \n');
        fprintf('                                                                   \n');
        fprintf('    A          = the input matrix                                  \n');
        fprintf('                                                                   \n');
        fprintf('    p          = the number of products per iteration in the block \n');
        fprintf('                 algorithm                                         \n');
        fprintf('                                                                   \n');
        fprintf('    m          = the size of the iteration subspace                \n');
        fprintf('                                                                   \n');
        fprintf('    percentage = the percentage of the trace to be retained        \n');
        fprintf('                                                                   \n');
        fprintf('    eps        = threshold value to stop the subspace iteration    \n');
        fprintf('                                                                   \n');
        fprintf('    maxit      = the maximum number of iterations                  \n');
        fprintf('                                                                   \n');
        fprintf('                                                                   \n');
        fprintf('                                                                   \n');
        fprintf('    OUTPUT arguments:                                              \n');
        fprintf('                                                                   \n');
        fprintf('    U          = a matrix containing the left singular vectors     \n');
        fprintf('                                                                   \n');
        fprintf('    s          = a vector containing the computed singular vectors \n');
        fprintf('                                                                   \n');
        fprintf('    V          = a matrix containing the right singular vectors    \n');
        U=0;
        v=0;
        s=0;
        return
    else
        [U, s, V]  = mex_subspace_iter_sv(A, l, p, percentage, eps, maxit);
    end
    
    
    
    
    
