-- R0 : Le programme va demander à l'utilisateur le nombre de valeurs que doit
-- contenir le tableau puis demander la saisie des ces valeurs pour enfin les
-- incrémenter de 1 et les afficher à l'écran

-- ANALYSE INFORMELLE : 
-- On doit prendre une variable de type tableau comportant au maximum NMAX
-- entiers et ayant un nombre de valeurs effectives donné
-- On parcourt le tableau de 1 au nombre de valeurs effectives et pour chaque
-- case on récupère la saisie de l'utilisateur et on la met dans la case du
-- tableau correspondante.
-- On reparcourt ensuite ce tableau de 1 au nombre de valeurs effectives qu'il
-- contient et on incrémente chaque valeur de 1
-- On reparcourt enfin ce tableau de 1 au nombre de valeurs effectives qu'il
-- contient et on affiche chaque valeur à l'écran
-- 
-- Structures de contrôle : POUR

with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

procedure exo3 is 

    -- Déclaration des constantes 
    NMAX : constant INTEGER := 5; -- Indice amx du tableau
    
    -- Déclaration des types 
    TYPE TAB_ENTIERS is ARRAY(1..NMAX) of INTEGER;
    
    -- Déclaration des variables locales 
    un_tab : TAB_ENTIERS; -- un tableau d'au maximum NMAX entiers
    nb_elements : INTEGER; -- nombre effectif d'éléments (<=NMAX) de un_tab

begin
   -- Afficher un tableau préalablement initialisé
    
        -- Initialisation du tableau 
              -- Saisie du nombre de valeurs effectives  nb_elements de manière conviviale et
              -- fiable
                loop
                        Put("Saisissez le nombre de valeurs que le tableau doit contenir <=");
                        Put(NMAX,2);
                        Put(" : ");
                        Get(nb_elements);
                        exit when nb_elements > 0 and nb_elements <=NMAX;
                end loop;
                -- nb_elements > 0 et nb_elements <=NMAX
               
              -- Saisie de chaque valeur du tableau
              -- Parcours du tableau de 1 à nb_elements et saisie de chaque
              -- valeur
                for I in Integer range 1..nb_elements loop
                    Put("Saissez la valeur ");
                    Put(I,2);
                    Put(" du tableau : ");
                    Get(un_tab(I));
                end loop;
                -- Tableau initialisé
                

        -- Incrémentation de chaque valeur du tableau de 1
                -- Parcours du tableau de 1 à nb_elements et incrémentation de 1               
                for I in Integer range 1..nb_elements loop
                    un_tab(I) := un_tab(I) + 1 ;  
                end loop;
                -- fin du parcours du tableau 


        -- Affichage du tableau 
                -- Parcours du tableau de 1 à nb_elements et affichage de chaque
                -- valeur
                
                for I in Integer range 1..nb_elements loop
                    Put(" ");
                    Put(un_tab(i),3);    
                end loop;
                -- fin du parcours du tableau 
end exo3;
