epsilon = 10^(-6);
itermax = 1000;
Delta = 2;
g1 = [0;0];
H1 = [7 0; 0 2];

g2 = [6;2];
H2 = [7 0; 0 2];

g3 = [-2;1];
H3 = [-2 0; 0 10];

g4 = [0;0];
H4 = [-2 0; 0 10];

g5 = [2;3];
H5 = [4 6 ; 6 5];

g6 = [2;0];
H6 = [4 0 ; 0 -15];

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

disp('Test 1 :')
[s1, x, lambda1] = etalonms(g1, H1, Delta, epsilon)
[s_1, lambda_1] = More_Sorensen(g1, H1, Delta, epsilon,itermax)

%s1 == s_1
%lambda1 == lambda_1

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

disp('Test 2 :')
[s2, x, lambda2] = etalonms(g2, H2, Delta, epsilon)
[s_2, lambda_2] = More_Sorensen(g2, H2, Delta, epsilon,itermax)

%s2 == s_2
%lambda2 == lambda_2

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

disp('Test 3 :')
[s3, x, lambda3] = etalonms(g3, H3, Delta, epsilon)
[s_3, lambda_3] = More_Sorensen(g3, H3, Delta, epsilon,itermax)

%s3 == s_3
%lambda3 == lambda_3

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

disp('Test 4 :')
[s4, x, lambda4] = etalonms(g4, H4, Delta, epsilon)
[s_4, lambda_4] = More_Sorensen(g4, H4, Delta, epsilon,itermax)

%s4 == s_4
%lambda4 == lambda_4

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

disp('Test 5 :')
[s5, x, lambda5] = etalonms(g5, H5, Delta, epsilon)
[s_5, lambda_5] = More_Sorensen(g5, H5, Delta, epsilon,itermax)

%s5 == s_5
%lambda5 == lambda_5

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

disp('Test 6 :')
[s6, x, lambda6] = etalonms(g6, H6, Delta, epsilon)
[s_6, lambda_6] = More_Sorensen(g6, H6, Delta, epsilon,itermax)

%s6 == s_6
%lambda6 == lambda_6

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
