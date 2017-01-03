-- R0 :Programme permettant de trier un tableau préalablement initialisé
-- 
-- R1 : - Saisie du nombre d'élements du tableau de manière conviviale et fiable
--      - Saisie de chaque valeur du tableau
--      - Tri du tableau
--      - Affichage du tableau trié
--
-- ANALYSE INFORMELLE: 
--    Prendre un tableau de taille NMAX et le remplir de nb_elements (saisie
--    par l'utilisateur) valeurs (saisies par l'utilisateurs)
--    Parcourir ce tableau tant qu'il n'est pas trié
--        Si la valeur suivante n'est pas correctement placé -> la placer à sa
--        palce
--        Sinon continuer le parcours
--    Afficher le tableau trié

-- Structures de contrôle : POUR 

with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;


procedure triInsert is 


    -- Déclaration des constantes 
    NMAX : constant INTEGER := 30; -- Indice max du tableau
   

    -- Déclaration des types 
    TYPE TAB_ENTIER is ARRAY(2..NMAX) of INTEGER;
    
    --
    --
    --
    --
    --
    --
    function insererTab(Tab : TAB_ENTIER, nbElts : INTEGER, elt:INTEGER) return TAB_ENTIER is
        
    begin
        for I in INTEGER range 1..nbElts loop
            if elt<
        end loop;
    end;

    -- Déclaration des variables locales 
    un_tab : TAB_ENTIER; -- un tableau d'au maximum NMAX entiers
    tampon : INTEGER; -- variable qui permettra les échanges de valeurs
   
begin

   -- Initialisation des variables locales
        tampon := 0;

   -- Initialiser un tableau et le trier par ordre croissant 
        -- Initialisation du tableau 
              -- Saisie du nombre d'entiers nb_elements de manière conviviale et
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

        -- Tri du tableau
                -- Parcours du tableau de 1 à nb_elements
                for I in INTEGER range 1..nb_elements loop
                    if un_tab(I) > un_tab(I+1) then
                        tampon := un_tab(I+1);
                        un_tab(i+1) := un_tab(I);
                        un_tab(I) := tampon;
                    else 
                        null;
                    end if;
                end loop;


        -- Affichage du tableau condensé en affichant que le nouveau nombre
        -- d'éléments
                -- Parcours du tableau de 1 à new_nb_elements et affichage de chaque
                -- valeur
                
                for I in Integer range 1..new_nb_elements loop
                    Put(" ");
                    Put(un_tab(i));    
                end loop;
                -- fin du parcours du tableau 

end triInsert;
