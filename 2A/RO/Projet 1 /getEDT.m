%PROMO 1
% x est la solution optimale
% 5 jours par semaine et 4 créneaux par jour
% on représente un créneau par un rectangle de 1 sur 2
% L'emploi du temps est contenu dans le 
%rectangle  = [0 0 ; 0 10 ; 4 10 ; 4 0];



     
function getEDT(promoX,x)
figure
%on définit la fenêtre
    j=0:10;
    h=0:4;
    grid('on');
    axis([0 10 0 4]);
    
    set(gca,'Xtick',0:2:10);  set(gca,'Ytick',0:1:5);  
    title(x);
    xlabel('jour'); ylabel('heure');

    %On définit les créneaux sous forme de rectangle (blanc par défaut, en
    %couleur si occupé)
    creneau = zeros(10,4);
    
    for i= 1:5
        for j= 1:4  
          creneau (i,j) = rectangle;
          if (i == 1) && (j == 1) 
            creneau(i,j) = rectangle('Position',[2*(i-1) 4-j 2 1], 'FaceColor', [0, 0.4, 0]);
            text(2*(i-1)+0.2, 4-j+0.5, 'Partiel');
          else 
              creneau(i,j) = rectangle('Position',[2*(i-1) 4-j 2 1], 'FaceColor', 'white');
          end
          
        end
    end
    
    for i=1:5
        for j=1:4
            if promoX(j,i) == 1
                rectangle('Position',[2*(i-1) 4-j 2 1], 'FaceColor', 'red');
                text(2*(i-1)+0.2, 4-j+0.5, 'Droite Maths');
            end
            if promoX(j,i) == 2
                rectangle('Position',[2*(i-1) 4-j 2 1], 'FaceColor', 'magenta');
                text(2*(i-1)+0.2, 4-j+0.5, 'Ellips Maths');
            end
            if promoX(j,i) == 3
                rectangle('Position',[2*(i-1) 4-j 2 1], 'FaceColor', 'yellow');
                text(2*(i-1)+0.1, 4-j+0.5, 'Proton Physique');
            end
            if promoX(j,i) == 4
                rectangle('Position',[2*(i-1) 4-j 2 1], 'FaceColor', 'green');
                text(2*(i-1)+0.2, 4-j+0.5, 'Pascal Info');
            end
            if promoX(j,i) == 5
                rectangle('Position',[2*(i-1) 4-j 2 1], 'FaceColor', 'cyan');
                text(2*(i-1)+0.2, 4-j+0.5, 'Dell Info');
            end
            if promoX(j,i) == 6
                rectangle('Position',[2*(i-1) 4-j 2 1], 'FaceColor', 'blue');
                text(2*(i-1)+0.2, 4-j+0.5, 'Young Anglais');
            end
            if promoX(j,i) == 7
                rectangle('Position',[2*(i-1) 4-j 2 1], 'FaceColor',[0.5 0.2 0.75]);
                text(2*(i-1)+0.2, 4-j+0.5, 'Gazelle Sport');
            end
            if promoX(j,i) == 8
                rectangle('Position',[2*(i-1) 4-j 2 1], 'FaceColor',[1 0.7 0]);
                text(2*(i-1)+0.2, 4-j+0.5, 'Bigceps Sport');
            end
        end
    end
end


    
        
    