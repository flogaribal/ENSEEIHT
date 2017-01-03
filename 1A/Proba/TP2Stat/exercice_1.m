clear;
close all;

donnees;

% Calcul et affichage du centre de gravite :
G = transpose(mean([transpose(x_donnees),transpose(y_donnees)]));
plot(G(1),G(2),'k*','MarkerSize',10,'LineWidth',2);

% Centrage des donnees :
x_centre = x_donnees - G(1);
y_centre = y_donnees - G(2);

% Maximisation de la vraisemblance par tirages aleatoires de psi :
a = zeros(1000,1);
angle = pi * rand(1000,1) - pi/2;

for i=1:1000
   a(i) = sum(power((y_centre - tan(angle(i)) * x_centre),2));
end

[min,k] = min(a);
psi_estime = angle(k);
a_estime = tan(psi_estime);
b_estime = G(2)-a_estime *G(1);

% Affichage de la droite de regression estimee par MV :
pas = 0.01;
if abs(a_estime)<1
	x_regression = -taille:pas:taille;
	y_regression = a_estime*x_regression+b_estime;
else
	y_regression = -taille:pas:taille;
	x_regression = (y_regression-b_estime)/a_estime;
end
plot(x_regression,y_regression,'b-','LineWidth',2);
axis equal;
axis(echelle);
lg = legend('Donnees','Centre de gravite~~~','$D_{YX}$ par MV','Location','Best');
set(lg,'Interpreter','Latex');

% Ecart angulaire sur la direction estimee par MV :
theta_estime = psi_estime+pi/2;
%ecart_angulaire = min(abs(theta_estime-theta_0),abs(theta_estime-theta_0+pi));
%ecart_angulaire = min(ecart_angulaire,abs(theta_estime-theta_0-pi));
%disp(['D_YX estimee par MV : ecart angulaire = ' num2str(ecart_angulaire/pi*180,'%.2f') ' degres']);
