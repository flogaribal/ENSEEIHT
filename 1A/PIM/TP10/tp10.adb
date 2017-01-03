-- GARIBAL Florian
-- 1A IMA Groupe A
--
-- TP10 

--------------------------------------------------
-- Pour les pre et post conditions
pragma Assertion_Policy(CHECK);
with Ada.Assertions; 
use Ada.Assertions;
--------------------------------------------------


with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

procedure tp10 is
        
        -- Déclaration des constantes
        MAX : constant integer := 30 ;
       
        -- Déclaration des types
        type elements is array(1..MAX) of integer;
        
        type ensemble is record
                contenu : elements;       -- les elements de l'ensemble
                cardinal : integer;       -- le nombre d'elements de l'ensemble
        end record;

        -- Déclaration des fonctions et procédures 

        ------------------------------------------------------------------------------------
        -- Fonction creer : cree un ensemble vide
        -- retour : ensemble (R)
        -- exceptions : /
        ------------------------------------------------------------------------------------
        function creer return ensemble
                WITH    
                        POST => creer'RESULT.cardinal = 0;

        function creer return ensemble is
                ens : ensemble;

        begin
            -- Initialisation des variables
            ens.cardinal := 0;
            return ens;
        end creer;

        ------------------------------------------------------------------------------------
        -- Fonction appartient : verifie la presence d'un element dans l'ensemble
        -- Paramètres x : integer (D)
        --            e : ensemble (D)
        -- retour : boolean
        -- exceptions : /
        ------------------------------------------------------------------------------------
        function appartient (x: Integer; e: ensemble) return boolean 
            WITH
                PRE => e.cardinal > 0, 

                POST => ((FOR SOME I IN 1..e.cardinal => e.contenu(I) = x) and
                        appartient'RESULT = true) or 
                        ((FOR SOME I IN 1..e.cardinal => e.contenu(I) /= x) and
                        appartient'RESULT = false) ;
                        
        function appartient (x: Integer; e: ensemble) return boolean  is
            
            -- Déclaration des variables
            i : Integer;
            trouve : boolean;

        begin

            -- Initialisation des variables 
            i := 1;
            trouve := false;

                -- Parcours du tableau jusqu'à que l'élément soit trouvé ou que
                -- le tableau soit fini
                while i<=e.cardinal and not trouve loop
                    if e.contenu(i) = x then
                        trouve := true;    
                    else 
                        null;
                    end if;
                    i:=i+1;
                end loop;
                -- Tableau entiérement parcouru ou élément trouvé

                -- Si le tableau a été entiérement parcouru -> élément non
                -- trouvé
                if not trouve  then
                    return false;
                else -- Sinon élément trouvé
                    return true;
                end if;

        end appartient;

        ------------------------------------------------------------------------------------
        -- procedure ajouter
        -- ajoute un element dans l'ensemble
        -- Paramètres x : integer (D)
        --            e : ensemble (D/R)
        -- exceptions : ensemble_plein, element_present
        ------------------------------------------------------------------------------------
        procedure ajouter (x: Integer; e: IN OUT ensemble) is

            ensemble_plein: Exception;
            element_present: Exception;

        begin
            -- Si l'ensemble n'est pas plein
            if e.cardinal < MAX then
                    -- Si l'ensemble n'est pas vide
                    if e.cardinal > 0 then
        
                        -- Test de présence de l'élément dans l'ensemble
                            if not appartient(x,e) then
                               e.contenu(e.cardinal +1) := x;
                               e.cardinal := e.cardinal +1;
                            else -- Sinon élément présent -> on ne l'ajoute pas
                                raise element_present;
                            end if;
                    else
                       -- Si c'est le premier élément de l'ensemble on l'ajoute à la
                       -- première case du tableau
                       e.contenu(1) := x;
                       e.cardinal := e.cardinal +1;               
                    end if;
            else -- Si l'ensemble est plein
                raise ensemble_plein;
            end if;

        exception
            when element_present => Put_Line("L'élément est déjà présent dans l'ensemble");
            when ensemble_plein => Put_Line("L'ensemble est déjà plein, vous ne pouvez rajouter un élément");
            when others => Put_Line("Erreur inconnue");
            
        end ajouter;


        ------------------------------------------------------------------------------------
        -- procedure supprimer
        -- supprime un element de l'ensemble
        -- Paramètres x : integer (D)
        --            e : ensemble (D/R)
        -- exceptions : ensemble_vide, element_absent            
        ------------------------------------------------------------------------------------
        procedure supprimer(x: Integer; e: IN OUT ensemble) is
            -- Déclaration des variables
            i : Integer;

            -- Déclaration des exceptions
            ensemble_vide: Exception;
            element_absent: Exception;

        begin

            -- Si ensemble vide
            if e.cardinal = 0 then
                raise ensemble_vide;
            else -- si ensemble non vide 
            
                -- Initialisation des variables 
                    i := 1;
                        
                    -- Parcours du tableau jusqu'à trouver l'élément ou avoir fini le
                    -- tableau
                    while i<= e.cardinal and then e.contenu(i) /= x loop
                        i:= i+1;
                    end loop;
                    -- Fin du parcours -> fin du tableau ou élément trouvé à l'indice i
        
                    -- Si le tableau a été entiérement parcouru -> élément non
                    -- trouvé
                    if i > e.cardinal then
                         raise element_absent;
                    else -- Sinon élément trouvé -> suppression et décalage des suivants
                         -- Parcours de i+1 jusqu'au nombre de valeur avant suppression
                         for j in i+1..e.cardinal loop
                             -- Décalage des valeurs suivantes
                             e.contenu(i) := e.contenu(j);
                             i := i+1;
                         end loop;
                         -- Fin du parcours du tableau
                    end if;
            
                    -- Décrémentation du nombre de valeurs dans l'ensemble
                    e.cardinal := e.cardinal -1;

               end if;
        Exception 
            when ensemble_vide => Put_Line("L'ensemble ne contient aucun élément");
            when element_absent => Put_Line("L'élément n'est pas présent dans l'ensemble et ne peut être supprimé");
            when others => Put_Line("Erreur inconnue");
        end supprimer;
        

        ------------------------------------------------------------------------------------
        -- procedure afficher :  Affiche le contenu de l'ensemble
        -- e : ensemble (D)
        -- exceptions : /
        ------------------------------------------------------------------------------------
        procedure afficher(e: ensemble) 
            WITH  
                PRE => e.cardinal > 0;

        procedure afficher(e: ensemble) is
        
        begin
            -- Affichage cardinal de l'ensemble
            Put("Cardinal de l'ensemble : ");
            Put(e.cardinal,2);
            New_Line(1);

            -- Parcours de l'ensemble et affichage       
            Put("====================");
            -- Parcours du tableau contenant les valeurs
            for i in Integer Range 1..e.cardinal loop
                New_Line(1);
                Put(e.contenu(i),3);
            end loop;
            -- Fin du parcours
            New_Line(1);
            Put("====================");
        end afficher;


        -- Déclaration des variables locales
        mon_ensemble : ensemble;
begin

        -- Initialisation des variables
        mon_ensemble := creer;
        
        -- Test d'ajouts dans l'ensemble
        
        ajouter(1,mon_ensemble);
        ajouter(2,mon_ensemble);
        ajouter(2,mon_ensemble); -- DOIT RENVOYER element_present
        ajouter(3,mon_ensemble);
        for I in Integer range 4..31 loop
            ajouter(I,mon_ensemble);    -- DOIT RENVOYER ensemble_plein à la dernière itération
        end loop;
        
        -- Affichage de l'ensemble
        afficher(mon_ensemble);

        -- Test d'appartenance 
        New_Line(1);
        if appartient(4,mon_ensemble) then
            Put_Line("4 appartient à l'ensemble");
        else
            Put_Line("4 n'appartient pa à l'ensemble");
        end if;

        if appartient(9,mon_ensemble) then
            Put_Line("9 appartient à l'ensemble");
        else
            Put_Line("9 n'appartient pas à l'ensemble");
        end if;

        -- Test de suppression
        supprimer(1,mon_ensemble);
        supprimer(40,mon_ensemble); -- DOIT RENVOYER element_absent
        for I in Integer range 2..31 loop
                supprimer(I,mon_ensemble);
        end loop;


end tp10;
