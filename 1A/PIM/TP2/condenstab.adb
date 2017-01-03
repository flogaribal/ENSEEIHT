-- R0 : Programme permettant de condenser (supprimer les cases contenant le
-- caractère ' ' situées entre deux cases contenant des caractères)
--
-- R1 : 
--      -Initialisation du tableau 
--      -Condensation du tableau
--      -Ajout des espaces en fin de tableau
--      -Affichage du tableau
--
-- ANALYSE INFORMELLE : 
--
-- Le programme va demander à l'utilisateur le nombre de caractères que doit
-- contenir le tableau puis demander la saisie des ces caractères
-- Ensuite le programme va parcourir le tableau et supprimer tous les espaces du
-- tableau
-- On doit prendre une variable de type tableau comportant au maximum NMAX
-- entiers et ayant un nombre de valeurs effectives donné
-- On parcourt le tableau de 1 au nombre de valeurs effectives et pour chaque
-- case on récupère la saisie de l'utilisateur et on la met dans la case du
-- tableau correspondante.
-- Ensuite on parcourt le tableau et dés que l'on trouve un espace on met la
-- valeur suivante dans la case courante et cela jusqu'à la fin du parcours
-- Pour finir on affiche les new_nb_elements valeurs du tableau

-- Structures de contrôle : POUR


with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

procedure condenstab is 


    -- Déclaration des constantes 
    NMAX : constant INTEGER := 20; -- Indice amx du tableau
    
    -- Déclaration des types 
    TYPE TAB_CHAR is ARRAY(1..NMAX) of CHARACTER;
    
    -- Déclaration des variables locales 
    un_tab : TAB_CHAR; -- un tableau d'au maximum NMAX caractères
    nb_elements : INTEGER; -- nombre effectif d'éléments (<=NMAX) de un_tab
    indEcr : INTEGER; -- Indice d'écriture du tableau
    new_nb_elements : INTEGER ; -- nouveau nombre d'éléments dans le tableau
                                -- condensé
   
begin
   -- Initialisation des variables locales
   indEcr := 1 ;
   

   -- Afficher un tableau préalablement initialisé
    
        -- Initialisation du tableau 
              -- Saisie du nombre de caractères effectifs  nb_elements de manière conviviale et
              -- fiable
                loop
                        Put("Saisissez le nombre de caractères que le tableau doit contenir <=");
                        Put(NMAX,2);
                        Put(" : ");
                        Get(nb_elements);
                        new_nb_elements := nb_elements;
                        exit when nb_elements > 0 and nb_elements <=NMAX;
                end loop;
                -- nb_elements > 0 et nb_elements <=NMAX
               
              -- Saisie de chaque caractère du tableau
              -- Parcours du tableau de 1 à nb_elements et saisie de chaque
              -- caractère
                for I in Integer range 1..nb_elements loop
                    Put("Saissez le caractère ");
                    Put(I,2);
                    Put(" du tableau : ");
                    Get(un_tab(I));
                end loop;
                -- Tableau initialisé

        -- Condensation du tableau
                for I in INTEGER RANGE 1..nb_elements loop
                    if un_tab(I) /= ' ' then
                       un_tab(indEcr) := un_tab(I);
                       indEcr := indEcr +1;
                    else
                       new_nb_elements := new_nb_elements - 1;
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
end condenstab;
