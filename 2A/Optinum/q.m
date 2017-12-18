function [qs] = q(f_xk,s,g,H)
    qs = f_xk + g'*s+1/2*s'*H*s;
end

