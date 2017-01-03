-- R0 : Le programme va demander à l'utilisateur le nombre de valeurs que doit
-- contenir le tableau puis demander la saisie des ces valeurs, ensuite demander
-- l'élément recherché et quelle occurrence de cet élément pour enfin afficher à l'écran l'indice de
-- cette occurrence ou si il ne la trouve pas un message d'erreur

-- ANALYSE INFORMELLE :
-- R1 : Saisie du nombre d'éléments du tableau
--      Saisie des valeurs du tableau
--      Saisie de la valeur recherchée 
--      Saisie du nombre d'occurrence de la valeur recherchée
--      Recherche dans le tableau
--      Affichage du résultat 
-- R2 :
-- On doit prendre une variable de type tableau comportant au maximum NMAX
-- entiers et ayant un nombre de valeurs effectives donné
-- On parcourt le tableau de 1 au nombre de valeurs effectives et pour chaque
-- case on récupère la saisie de l'utilisateur et on la met dans la case du
-- tableau correspondante.
-- On prend une variable indice, compteur occurrence, une variable nombre d'occurrence et une variable élement recherché pour stocker
-- respectivement l'indice de l'élément trouvé, le nombre d'occurrence actuellement trouvé, le nombre d'occurrence réellement
-- souhaité et une variable pour l'élément recherché
-- On reparcourt ensuite ce tableau et pour chaque valeur on teste si elle
-- correspond à l'élément recherché
--                     Si c'est le cas on incrémente le compteur d'occurrence
--                             Si le compteur d'occurrence est égal au nombre
--                             d'occurrence souhaité on enregistre l'indice
--                             courant
--                             Sinon on continue
--                     Sinon on continue le parcours
--
--              Si à la fin du parcours on a pas trouvé le bon nombre
--              d'occurrence ou on a pas trouvé l'élément on affiche un message
--              d'erreur
--
-- Structures de contrôle : POUR pour l'initialisation
--                          TANT QUE pour la recherche
--
with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

procedure exo4 is 


    -- Déclaration des constantes 
    NMAX : constant INTEGER := 5; -- Indice amx du tableau
    
    -- Déclaration des types 
    TYPE TAB_ENTIERS is ARRAY(1..NMAX) of INTEGER;
    
    -- Déclaration des variables locales 
    un_tab : TAB_ENTIERS; -- un tableau d'au maximum NMAX entiers
    nb_elements : INTEGER; -- nombre effectif d'éléments (<=NMAX) de un_tab
    cpt_occur : INTEGER; -- Compte le nombre d'occurrences de l'élément recherché
    element_rech : INTEGER; -- Element recherché par l'utilisateur dans le
                            -- tableau
    nbOccur_souhaite : INTEGER; -- Nombre d'occurences souhaitées par
                               -- l'utlisateur
    i : INTEGER; -- variable de parcours

begin

   -- Initialisation des variables locales 

    cpt_occur := 0;
    i := 0;

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
        
        -- Récupération de l'élément recherché et du nombre d'occurrences
        -- souhaité de cet élément

              -- Saisie de l'élément recherché de manière conviviale et fiable
                 Put("Saisissez l'élément que vous souhaitez rechercher dans le tableau : ");
                 Get(element_rech); 
 
              -- Saisie du nombre d'occurrence de l'élément recherché de manière conviviale et
              -- fiable
                loop
                        Put("Saisissez le nombre d'occurrences de l'élément que vous souhaitez (<");
                        Put(NMAX,2);
                        Put(") : ");
                        Get(nbOccur_souhaite);
                        exit when nbOccur_souhaite > 0 and nbOccur_souhaite < nb_elements;
                end loop;
                -- nbOccur_souhaite > 0 et nbOccur_souhaite < nb_elements
 
        -- Parcours du tableau pour chercher l'élément nbOccur_souhaite fois

                
                -- Parcours du tableau tant que parcours non fini et cpt_occur
                -- /= nbOccur_souhaite
                while i<=nb_elements and cpt_occur /= nbOccur_souhaite loop
                    i := i+1;
                    -- Si l'élément courant est égal à l'élément recherché                   
                    if un_tab(i) = element_rech then 
                        cpt_occur := cpt_occur +1;
                    else 
                        null;
                    end if;           
                    
                end loop;
                -- i > nb_element ou cpt_occur = nbOccur_souhaite


        -- Affichage du resultat 
               
                -- Si on a pas trouvé l'élément, afficher un message d'erreur
                if cpt_occur /= nbOccur_souhaite then
                    Put("Valeur non présente");
                -- Sinon
                else 
                    Put("La valeur ");
                    Put(element_rech,3);
                    Put(" est présente à l'indice ");
                    Put(i,2);
                end if;

        end exo4;
