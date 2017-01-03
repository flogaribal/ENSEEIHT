clear;
close all;

donnees;

% Affichage du centre de gravite :
G = transpose(mean([transpose(x_donnees),transpose(y_donnees)]));
plot(G(1),G(2),'k*','MarkerSize',10,'LineWidth',2);

% Centrage des donnees :
x_centre = x_donnees - G(1);
y_centre = y_donnees - G(2);

% Maximisation de la vraisemblance par tirages aleatoires de theta :
a = zeros(1000,1);
angle = pi * rand(1000,1);

for i=1:1000
   a(i) = sum(power((x_centre * cos(angle(i)) + y_centre *  sin(angle(i))),2));
end

[mini,k] = min(a);
theta_estime = angle(k);
rho_estime = G(1) * cos(theta_estime) + G(2) * sin(theta_estime);

% Affichage de la droite de regression estimee par MV :
pas = 0.01;
if abs(pi/2-theta_estime)<pi/4
	x_regression = -taille:pas:taille;
	y_regression = (rho_estime-x_regression*cos(theta_estime))/sin(theta_estime);
else
	y_regression = -taille:pas:taille;
	x_regression = (rho_estime-y_regression*sin(theta_estime))/cos(theta_estime);
end
plot(x_regression,y_regression,'b-','LineWidth',2);
axis equal;
axis(echelle);
lg = legend('Donnees','Centre de gravite~~~','$D_\perp$ par MV','Location','Best');
set(lg,'Interpreter','Latex');

% Ecart angulaire sur la direction estimee par MV :
%ecart_angulaire = min(abs(theta_estime-theta_0),abs(theta_estime-theta_0+pi));
%ecart_angulaire = min(ecart_angulaire,abs(theta_estime-theta_0-pi));
%disp(['D_perp estimee par MV : ecart angulaire = ' num2str(ecart_angulaire/pi*180,'%.2f') ' degres']);
