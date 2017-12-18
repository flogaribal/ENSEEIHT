testCauchy = 0;
testRC = 1;

% Résolution de région de confiance avec : 
%% 0 = Pas de Cauchy
%% 1 = Moré Sorensen
choixMethode = 1;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 
%%%%%% PAS DE CAUCHY
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 

%% QUADRATIQUE 1
g1 = [0;0];
H1 = [7 0;0 2];

%% QUADRATIQUE 2
g2 = [6;2];
H2 = H1;

%% QUADRATIQUE 3
g3 = [-2;1];
H3 = [-2 0; 0 10];

%% TESTS
delta = 3;

if testCauchy == 1
    [s1] = pasDeCauchy(delta, H1, g1)

    [s2] = pasDeCauchy(delta, H2, g2)

    [s3] = pasDeCauchy(delta, H3, g3)
end


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 
%%%%%% REGION DE CONFIANCE 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 


% F1 
x_011 = [1;0;0];
x_012 = [10;3;-2.2];


% F2
x_021 = [-1.2 ; 1];
x_022 = [10 ; 0];
x_023 = [0 ; 1/200 + 1/10.^12];

epsilon = sqrt(eps);
nbIter = 100000;

deltaMax = 7;
delta0 = 1;
gamma1 = 0.5;
gamma2 = 1.5;
nu1 = 0.1;
nu2 = 0.6;

if testRC == 1
    %%%%% TESTS F1 %%%%%
    [min1, nbIter1, flag1] = regionDeConfiance(x_011, deltaMax, delta0, nbIter, gamma1, gamma2, nu1, nu2, epsilon, @f1, @gradient_f1, @hessienne_f1, choixMethode);
    disp(['Min f1 : ' ]);
    disp(min1);
    disp(['nombre itérations ',num2str(nbIter1)]);
    disp(['flag de sortie ',num2str(flag1)]);
    disp(['Valeur du min ',num2str(f1(min1))]);
    disp('----------------------------')
    disp('  ')
    
    
    [min2, nbIter2, flag2] = regionDeConfiance(x_012, deltaMax, delta0, nbIter, gamma1, gamma2, nu1, nu2, epsilon, @f1, @gradient_f1, @hessienne_f1, choixMethode);
    disp(['Min f1 : ' ]);
    disp(min2);
    disp(['nombre itérations ',num2str(nbIter2)]);
    disp(['flag de sortie ',num2str(flag2)]);
    disp(['Valeur du min ',num2str(f1(min2))]);
    disp('----------------------------')    
    disp('  ')

    %%%%% TESTS F2 %%%%%
    [min3, nbIter3, flag3] = regionDeConfiance(x_021, deltaMax, delta0, nbIter, gamma1, gamma2, nu1, nu2, epsilon, @f2, @gradient_f2, @hessienne_f2, choixMethode);
    disp(['Min f2 : ' ]);
    disp(min3);
    disp(['nombre itérations ',num2str(nbIter3)]);
    disp(['flag de sortie ',num2str(flag3)]);
    disp(['Valeur du min ',num2str(f2(min3))]);
    disp('----------------------------')
    disp('  ')
    
    
    [min4, nbIter4, flag4] = regionDeConfiance(x_022, deltaMax, delta0, nbIter, gamma1, gamma2, nu1, nu2, epsilon, @f2, @gradient_f2, @hessienne_f2, choixMethode);
    disp(['Min f2 : ' ]);
    disp(min4);
    disp(['nombre itérations ',num2str(nbIter4)]);
    disp(['flag de sortie ',num2str(flag4)]);
    disp(['Valeur du min ',num2str(f2(min4))]);
    disp('----------------------------')
    disp('  ')
    
    
    [min5, nbIter5, flag5] = regionDeConfiance(x_023, deltaMax, delta0, nbIter, gamma1, gamma2, nu1, nu2, epsilon, @f2, @gradient_f2, @hessienne_f2, choixMethode);
    disp(['Min f2 : ' ]);
    disp(min5);
    disp(['nombre itérations ',num2str(nbIter5)]);
    disp(['flag de sortie ',num2str(flag5)]);
    disp(['Valeur du min ',num2str(f2(min5))]);
    disp('----------------------------')
    disp('  ')
end