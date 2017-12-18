warning off 
global nbEval_f1 nbEval_f2 nbEval_grad_f1 nbEval_grad_f2 nbEval_hess_f1 nbEval_hess_f2;

% F1 
x_011 = [1;0;0];
x_012 = [10;3;-2.2];


% F2
x_021 = [-1.2 ; 1];
x_022 = [10 ; 0];
x_023 = [0 ; 1/200 + 1/10.^12];

epsilon = 0.00001;
nbIter = 100;

% Tests 


% 1 seule itération car juste à côté du minimum
nbEval_f1=0;
nbEval_grad_f1=0;
nbEval_hess_f1=0;

[min1, flag1] = newton_local(@f1,x_011, @gradient_f1, @hessienne_f1,epsilon, nbIter);

disp(['nbEval_f1 : ',num2str(nbEval_f1), '    nbEval_grad_f1 : ', num2str(nbEval_grad_f1), '   nbEval_hess_f1 : ', num2str(nbEval_hess_f1) ]);
disp(['Min f1 : ' ]);
disp(min1);
disp(['flag de sortie ',num2str(flag1)]);
disp(['Valeur du min ',num2str(f1(min1))]);
disp('----------------------------')
disp('  ')

nbEval_f1 = 0;
nbEval_grad_f1 = 0;
nbEval_hess_f1 = 0;
[min2, flag2] = newton_local(@f1,x_012, @gradient_f1, @hessienne_f1, epsilon, nbIter);
disp(['nbEval_f1 : ',num2str(nbEval_f1), '    nbEval_grad_f1 : ', num2str(nbEval_grad_f1), '   nbEval_hess_f1 : ', num2str(nbEval_hess_f1)]);
disp(['Min f1 : ' ]);
disp(min2);
disp(['flag de sortie ',num2str(flag2)]);
disp(['Valeur du min ',num2str(f1(min2))]);
disp('----------------------------')
disp('  ')


%% Car plusieurs min globaux
nbEval_f2=0;
nbEval_grad_f2=0;
nbEval_hess_f2=0;
[min3, flag3] = newton_local(@f2,x_021, @gradient_f2, @hessienne_f2, epsilon, nbIter);
disp(['nbEval_f2 : ',num2str(nbEval_f2), '    nbEval_grad_f2 : ', num2str(nbEval_grad_f2), '   nbEval_hess_f2 : ', num2str(nbEval_hess_f2) ]);
disp(['Min f2 : ' ]);
disp(min3);
disp(['flag de sortie ',num2str(flag3)]);
disp(['Valeur du min ',num2str(f2(min3))]);
disp('----------------------------')
disp('  ')



nbEval_f2=0;
nbEval_grad_f2=0;
nbEval_hess_f2=0;
[min4, flag4] = newton_local(@f2,x_022, @gradient_f2, @hessienne_f2, epsilon, nbIter);
disp(['nbEval_f2 : ',num2str(nbEval_f2), '    nbEval_grad_f2 : ', num2str(nbEval_grad_f2), '   nbEval_hess_f2 : ', num2str(nbEval_hess_f2) ]);
disp(['Min f2 : ' ]);
disp(min4);
disp(['flag de sortie ',num2str(flag4)]);
disp(['Valeur du min ',num2str(f2(min4))]);
disp('----------------------------')
disp('  ')

nbEval_f2=0;
nbEval_grad_f2=0;
nbEval_hess_f2=0;
[min5, flag5] = newton_local(@f2,x_023, @gradient_f2, @hessienne_f2, epsilon, nbIter);
disp(['nbEval_f2 : ',num2str(nbEval_f2), '    nbEval_grad_f2 : ', num2str(nbEval_grad_f2), '   nbEval_hess_f2 : ', num2str(nbEval_hess_f2) ]);
disp(['Min f2 : ' ]);
disp(min5);
disp(['flag de sortie ',num2str(flag5)]);
disp(['Valeur du min ',num2str(f2(min5))]);
disp('----------------------------')
disp('  ')



%disp(['Min f1 : ' num2str(min1) ' | flag de sortie ' num2str(flag1)]);






