%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Fonction grad_lagrangien_generic qui calcule le gradient du lagrangien générique
%% gradf        :
%% jacobc       :
%% c            :
%% xk           : 
%% lambdak      :
%% muk          :
%%%%%%%%%%%%%%% SORTIES
%% y            :
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function [y] = grad_lagrangien_generic(gradf, jacobc, c, xk, lambdak, muk)
y = gradf(xk) + jacobc(xk)'*(lambdak + muk*c(xk));
end