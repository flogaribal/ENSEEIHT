%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Script C14 - TP "Premiers Algos" de l'UE d'Optimisation Numerique de 2e
% annee ENSEEIHT-IMA.
%
% Ce script permet d'implementer et de tester les algorithmes de Newton et
% Gauss-Newton. L'idee sous-jacente est d'estimer les parametres d'un modele
% de la radioactivite du carbone 14. Le modele est de la forme:
% A(t) = A0*exp(-lambda*t),
% et on cherche beta = (A0,lambda) de sorte que le modele soit la meilleure
% approximation possible au sens des moindres carres.
%
% ENSEEIHT - Annee universitaire 2015-2016
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
clear all; close all; format short
%
% Declaration et affectation des variables globales representant les
% observations du probleme
global Ti Ai
Ti=[500 1000 2000 3000 4000 5000 6300]';% Vecteur des ages
Ai=[14.5 13.5 12.0 10.8 9.9 8.9 8.0]';% Vecteur des radioactivites
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%% TRACES INITIAUX DES FIGURES %%%%%%%%%%%%%%%%%%%%%
%
% Cette partie n'est pas a modifier durant le TP. Elle consiste essentiellement
% en l'appel de procedures d'affichage specifiques.
%
% Figure 1 - Trace des modeles obtenus par l'algorithme de Newton
figure(1); setPos(1,1,6);
plot(Ti,Ai,'o')
rect=[0 7000 0 18];
axis(rect)
xlabel('t')
ylabel('A(t)')
title('Observations et modeles obtenus par les iterations de Newton');
hold on
%
% Figure 2 - Trace des modeles obtenus par l'algorithme de Gauss-Newton
figure(2); setPos(2,2,6);
plot(Ti,Ai,'o')
axis(rect)
xlabel('t')
ylabel('A(t)')
title('Observations et modeles obtenus par les iterations de Gauss-Newton');
hold on
%
% Figure 3 - Visualisation 3D de la fonctionnelle aux moindres carres f
xmin=9;
xmax=20;
nx=100;
pasx=(xmax-xmin)/nx;
ymin=0;
ymax=0.0003;
ny=100;
pasy=(ymax-ymin)/ny;
%
x=xmin:pasx:xmax;
y=ymin:pasy:ymax;
[X,Y]=meshgrid(x,y);
[m,n]=size(X);
for i=1:m,
   for j=1:n,
      Z(i,j)=f_C14([X(i,j),Y(i,j)]);
   end;
end;
figure(3); setPos(3,3,6);
mesh(X,Y,Z)
xlabel('A_0');
ylabel('\lambda')
zlabel('f(A_0,\lambda)')
%
% Figs 4 et 5 : Visualisation 2D de f (courbes de niveaux)
%		Les iteres devront etre affiches sur ces figures
%
% Figure 4 - Trace 2D de f et iteres de l'algorithme de Newton
figure(4); setPos(4,4,6);
contour(X,Y,Z,50);
xlabel('A_0')
ylabel('\lambda')
title('Courbes de niveaux de f et iteres de Newton');
hold on
% Figure 5 - Trace 2D de f et iteres de l'algorithme de Gauss-Newton
figure(5); setPos(5,5,6);
contour(X,Y,Z,50);
xlabel('A_0')
ylabel('\lambda')
title('Courbes de niveaux de f et iteres de Gauss-Newton');
hold on
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%% PARTIE A COMPLETER %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Ajout des iterations des algorithmes de Newton et Gauss-Newton
%
% Etant donne un point de depart, on veut afficher plusieurs iterations des
% algorithmes de Newton/Gauss-Newton et observer la correspondance entre les
% modeles engendres et les observations reelles.
%
%%%%%%%%%%%%%%%%%%%%%%%%
% Etape initiale
%%%%%%%%%%%%%%%%%%%%%%%%
%
% Point de d�part - Valeur initiale des parametres
fprintf('Point initial :\n');
beta0=[10 0.0001]'
%
% On trace le modele obtenu avec les parametres initiaux
%
T=0:10:6300;% Vecteur qui nous servira pour tracer tous les modeles
A=beta0(1)*exp(-beta0(2)*T);% Vecteur de radioactivites
%
% On place le modele et l'itere initiaux sur les figures lies a Newton
%
figure(1)
plot(T,A)
figure(4)
text(beta0(1),beta0(2),'o point de d\''epart','interpreter','latex')
% On place le modele et l'itere initiaux sur les figures lies a Gauss-Newton
figure(2)
hold on
plot(T,A)
figure(5)
text(beta0(1),beta0(2),'o point de d\''epart','interpreter','latex')
%
%%%%%%%%%%%%%%%%%%%%%%%%
% Newton
%%%%%%%%%%%%%%%%%%%%%%%%
%
% On part du point initial
beta = beta0;
%
% COMPLETER AVEC 5 ITERATIONS DE NEWTON 
%       Pour chaque iteration, 
%               1) Calculer le nouvel itere
%               2) Tracer le modele correspondant sur la figure 1
%               3) Afficher l'itere correspondant sur la figure 4
max_iter = 10;
curr_iter = 0;
beta = beta0;
beta_old = beta0 -1;
continuer = true;
my_eps = 10^(-5);


Hess = zeros(length(Ti), 2);

while continuer
%for i=1:5
    beta_old = beta;
    
    Jr = J_res_C14(beta);
    res = res_C14(beta);
    Hess = H_f_C14(beta);
    
    beta = beta - inv(Hess) * Jr'*res;
    
    A = beta(1) * exp(-beta(2)*T);
        
    curr_iter = curr_iter +1;
    
    figure(1)
    plot(T,A)
    
    figure(4)
    text(beta(1),beta(2),['o_',int2str(curr_iter)])
    
    if norm(grad_f_C14(beta)) < my_eps * norm(grad_f_C14(beta0))
        continuer = false;
        disp(['Sortie par gradient très petit en ', int2str(curr_iter), ' itérations']);
    elseif norm(beta-beta_old) < my_eps * norm(beta0)
        continuer = false;
        disp(['Sortie par convergence de || x^k - x(k+1) || en ', int2str(curr_iter), ' itérations'])
    elseif norm(f_C14(beta) - f_C14(beta_old)) < my_eps * norm(f_C14(beta0))
        continuer = false;
        disp(['Sortie par || f(x^k) - f(x^k+1) || suffisamment petit en ', int2str(curr_iter), ' itérations'])
    elseif curr_iter > max_iter
        continuer = false;
        disp('Sortie par dépassement du nombre d''iteration pour Gauss Newton')
    else 
        continuer = true;
    end 

end

%%%%%%%%%%%%%%%%%%%%%%%%
% Gauss-Newton
%%%%%%%%%%%%%%%%%%%%%%%%
%
% On repart du meme point initial
beta = beta0;
%
% COMPLETER AVEC 5 ITERATIONS DE GAUSS-NEWTON 
%	Pour chaque iteration, 
%		1) Calculer le nouvel itere
%		2) Tracer le modele correspondant sur la figure 2
%		3) Afficher l'itere correspondant sur la figure 5

max_iter = 8;
curr_iter = 1;
beta = beta0;
beta_old = beta0 -1;
continuer = true;

while  continuer 

    beta_old = beta;
    
    Jr = J_res_C14(beta);
    res = res_C14(beta);
    grad = Jr' * res;
    beta = beta - inv(Jr'*Jr) * grad;

    A = beta(1) * exp(-beta(2)*T);
    
    figure(2)
    plot(T,A)
    
    figure(5)
    text(beta(1),beta(2),['o_',int2str(curr_iter)])
    curr_iter = curr_iter +1;
    
        
    if norm(grad_f_C14(beta)) < my_eps * norm(grad_f_C14(beta0))
        continuer = false;
        disp(['Sortie par gradient très petit en ', int2str(curr_iter), ' itérations']);
    elseif norm(beta-beta_old) < my_eps * norm(beta0)
        continuer = false;
        disp(['Sortie par convergence de || x^k - x(k+1) || en ', int2str(curr_iter), ' itérations'])
    elseif norm(f_C14(beta) - f_C14(beta_old)) < my_eps * norm(f_C14(beta0))
        continuer = false;
        disp(['Sortie par || f(x^k) - f(x^k+1) || suffisamment petit en ', int2str(curr_iter), ' itérations '])
    elseif curr_iter > max_iter
        continuer = false;
        disp('Sortie par dépassement du nombre d''iteration pour Gauss Newton')
    else 
        continuer = true;
    end 
end


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
