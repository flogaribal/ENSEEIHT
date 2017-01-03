clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

% Lecture d'une image interne a Matlab et conversion en doubles :
I_max = 255;
I_min = 0;
I = imread('cameraman.tif');
[nb_lignes,nb_colonnes] = size(I);
I = double(I);

% Affichage de l'image :
figure('Name','Exemple d''image interne a Matlab','Position',[0,0,0.33*L,0.3*L]);
imagesc(I);
axis off;
axis equal;
colormap gray;

% Affichage de l'histogramme de l'image :
histogramme = hist(I(:),[I_min:I_max]);
figure('Name','Histogramme des niveaux de gris','Position',[0.33*L,0,0.33*L,0.3*L]);
plot([I_min:I_max],histogramme);
axis([I_min I_max 0 1.1*max(histogramme)]);
xlabel('Niveau de gris','FontSize',20);
ylabel('Frequence','FontSize',20);

% Vecteurs contenant les niveaux de gris de gauche (de droite) d'une paire de pixels :
I_gauche = I(1:1:nb_lignes, 1:1:nb_colonnes-1);
I_gauche = I_gauche(:);			% Vectorisation de la matrice I_gauche

I_droite = I(1:1:nb_lignes, 2:1:nb_colonnes);
I_droite = I_droite(:);			% Vectorisation de la matrice I_droite

% Affichage des paires de niveaux de gris sous la forme d'un nuage de points :
figure('Name','Mise en evidence de la correlation entre pixels voisins','Position',[0.66*L,0,0.33*L,0.3*L]);
plot(I_gauche,I_droite,'b+');
xlabel('Niveau de gris du pixel de gauche');
ylabel('Niveau de gris du pixel de droite');
axis equal;
axis([I_min I_max I_min I_max]);
hold on;


% Moyenne 
moyenne_gauche = mean(I_gauche(:));
moyenne_droite = mean(I_droite(:));


% Variance
 v_moyenne_gauche = ones(nb_lignes*(nb_colonnes-1),1) * moyenne_gauche;
 v_moyenne_droite = ones(nb_lignes*(nb_colonnes-1),1) * moyenne_droite;
 variance_gauche = mean(I_gauche .* I_gauche - v_moyenne_gauche .* v_moyenne_gauche)
 variance_droite = mean(I_droite .* I_droite - v_moyenne_droite .* v_moyenne_droite)

% Ecart type
e_type_gauche = sqrt(variance_gauche)
e_type_droite = sqrt(variance_droite)

% Covariance
covariance = mean(I_gauche .* I_droite - v_moyenne_gauche .* v_moyenne_droite)


% Coefficient de corrélation
coeff_correlation = covariance / (e_type_gauche * e_type_droite)
 

% Calcul des parametres de la droite de regression 
a = covariance / variance_gauche
b = moyenne_droite

% Affichage de la droite de regression (d'equation y = a*x+b) :
x = I_min:I_max;
y = a*x - a*moyenne_gauche +b;
plot(x,y,'r','LineWidth',3);


