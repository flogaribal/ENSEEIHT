%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Fonction hess_lagrangien_generic qui calcule la hessienne du lagrangien générique
%% hessf        :
%% jacobc       :
%% hess         :
%% xk           : 
%% muk          :
%%%%%%%%%%%%%%% SORTIES
%% y            :
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function [y] = hess_lagrangien_generic(hessf, jacobc, hessc, xk, muk)
    y = hessf(xk) + muk*jacobc(xk)'*jacobc(xk) + hessc(xk, lambdak+mukc(xk));
end
