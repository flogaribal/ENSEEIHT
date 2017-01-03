function Q = mgs(A)

[n, m] =size(A);
Q=A;

for j = 1: m
    y = A(:,j)
    for i = 1: j-1
        composante = dot(y,Q(:,i));
        y = y - composante * Q(:,i) ;      
    end
    Q(:,j) = y / norm(y)  ;  
end