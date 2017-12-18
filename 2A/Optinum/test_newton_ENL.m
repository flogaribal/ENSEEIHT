
%% INIT VARIABLES
epsilon = sqrt(eps);
maxIter = 1000;

%% FI1
%delta_1 = 0.5;

%% FI2
%norm_s_lambda_2_2 = 4/((lambda-38)^2) + 400/((lambda+20)^2);
%delta_2 = 0.4;

%% TEST NEWTON EQUATIONS NON LINEAIRES 
[res1,nbIter1,flag1] = newton_ENL(0,10,epsilon,maxIter,@fi1,@fi_deriv1);
disp(['Solution : ' ]);
disp(res1);
disp(['nombre itérations ',num2str(nbIter1)]);
disp(['flag de sortie ',num2str(flag1)]);
disp('  ')


[res2,nbIter2,flag2] = newton_ENL(-100,100,epsilon,maxIter,@fi2,@fi_deriv2);
disp(['Solution : ' ]);
disp(res2);
disp(['nombre itérations ',num2str(nbIter2)]);
disp(['flag de sortie ',num2str(flag2)]);
disp('  ')
