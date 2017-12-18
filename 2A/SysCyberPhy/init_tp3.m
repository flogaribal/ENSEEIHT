t0 = 0;
        
l = 5;
g = -9.81;
tf=4*pi*sqrt(-l/g);
X0 = 2*pi/10;

K = [20 10];
X0p = 0;

N=500;
h= (tf-t0)/N;
ue = 0;
xe = [0 0];
