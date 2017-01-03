-- R0 :Programme permettant d'afficher les nombres entiers compris entre 2 et N
-- par la méthode du crible d'Eratosthene
-- 
-- R1 : Saisie du nombre jusqu'auquel on doit chercher les nombres premiers
--      Tests pour chaque nombre si il est premiers
--      Affichage des nombres premiers
--
-- ANALYSE INFORMELLE: 
--      Pour chaque entier de 2 à N, tester si il est le multiple des entiers
--      suivants :
--              - si c'est le cas, donner "faux" comme état pour les entiers suivants
--                concernés car ils ne sont pas premiers 
--              - sinon continuer le parcours
--      Parcourir le tableau et afficher les entiers dont la case est égale à
--      vrai   


-- Structures de contrôle : 2 boucles POUR 


with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;


procedure eratosthene is 


    -- Déclaration des constantes 
    NMAX : constant INTEGER := 120; -- Indice max du tableau
    
    -- Déclaration des types 
    TYPE TAB_BOOL is ARRAY(2..NMAX) of BOOLEAN;
    
    -- Déclaration des variables locales 
    un_tab : TAB_BOOL; -- un tableau d'au maximum NMAX booleens
    n : INTEGER; -- nombre n jusqu'auquel on va chercher des nombres premiers
   
begin

   

   -- Afficher les nombres premiers compris entre 2 et n

        -- Initialisation du tableau 
              -- Saisie du nombre n de manière conviviale et fiable
                loop
                        Put("Saisissez le nombre N jusqu'auquel le programme va chercher des nombres premiers (>0 et <=");
                        Put(NMAX,3);
                        Put(") : ");
                        Get(n);
                        exit when n > 0 and n <= 120;
                end loop;

                -- Remplissage des cases par "true"
                for I in INTEGER range 2..n loop
                    un_tab(I) := true;
                end loop;

                

        -- Calcul des nombres premiers entre 2 et n
                -- Parcours du tableau de 2 à n
                for I in INTEGER range 2..n loop
                    -- Parcours du tableau de I à n pour tester si les entiers
                    -- suivants sont des multiples de l'entier courant
                    for J in INTEGER range I+1..n loop
                        -- Si J multiple de I alors J non premier
                        if J mod I = 0 then
                           un_tab(J) := false;
                        -- Si J non multiple de I
                        else
                           null;
                        end if;
                    end loop;
                    -- Fin du parcours de la fin du tableau 
                end loop;
                -- Fin du parcours du tableau

           -- Affichage des nombres premiers de 2 à N

                --for I in INTEGER range 2..n loop
                --    if un_tab(I) then
                --        Put(" 1 ");
                --    else 
                --        Put(" 0 ");
                --    end if;
                --end loop;

                -- Parcours du tableau de 2 à n
                for I in INTEGER range 2..n loop
                    -- Si le nombre est premier on l'affiche
                    if un_tab(I) then
                        Put(I,3);
                        Put(" ");
                    -- Sinon rien
                    else
                        null;
                    end if;
                end loop;
                -- Fin du parcours du tableau

end eratosthene;
