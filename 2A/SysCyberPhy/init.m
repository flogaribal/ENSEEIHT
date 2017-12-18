K = [100;10];

l = 10;

ue = 0;

xe = [0;0];

g = -9.81;

alpha0 = 2*pi/10;
alpha0deriv1 = sqrt(2*(g/l)*(1+cos(alpha0-pi)));

alpha0deriv2 = 0;

t0 = 0;
tf = (4*pi) * sqrt(l/g);

N = 500;

h = (tf-t0)/N;

X0 = pi/4;
    