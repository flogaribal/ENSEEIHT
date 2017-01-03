function Q = cgs(A)

[n, m] =size(A);
Q=A;

for i = 1:m
    y = transpose(Q(:,1:i-1)) * Q(:,i) ;
    y = Q(:,i) - Q(:,1:i-1) * y   ; 
    Q(:,i) = y / norm(y);
end
