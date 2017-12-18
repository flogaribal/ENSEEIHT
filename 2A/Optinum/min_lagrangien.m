%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Fonction min_lagrangien qui implémente la méthode des régions de confiance
%% f            :
%% c            :
%% xk           :
%% lambda       : 
%% muk          :
%%%%%%%%%%%%%%% SORTIES
%% y            :
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function [y] = min_lagrangien(f, c, xk, lambdak, muk)
    y = f(xk) + lambdak'*c(x) + (1/2)*muk*norm(c(x))^2;
end