-- GARIBAL Florian
-- 1A IMA Groupe A
--
-- TP5 

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

procedure tp5 is
        
        -- Déclaration des constantes
        MAX : constant integer := 30 ;
       
        -- Déclaration des types
        type elements is array(1..MAX) of integer;
        
        type ensemble is record
                contenu : elements;       -- les elements de l'ensemble
                cardinal : integer;       -- le nombre d'elements de l'ensemble
        end record;

        -- Déclaration des fonctions et procédures 

        -- Fonction creer : cree un ensemble vide
        -- retour : ensemble (R)
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


        -- Fonction appartient : verifie la presence d'un element dans l'ensemble
        -- Paramètres x : integer (D)
        --            e : ensemble (D)
        -- retour : boolean
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

        -- procedure ajouter
        -- ajoute un element dans l'ensemble
        -- Paramètres x : integer (D)
        --            e : ensemble (D/R)
        procedure ajouter (x: Integer; e: IN OUT ensemble) 
            WITH 
                PRE => e.cardinal < MAX,

                POST => (((FOR ALL I IN 1..e'OLD.cardinal => e'OLD.contenu(I) /= x) and e.cardinal = e'OLD.cardinal + 1) or
                        ((FOR SOME I IN 1..e'OLD.cardinal => e'OLD.contenu(I) = x) and e.cardinal = e'OLD.cardinal)) and
                        (FOR SOME I IN 1..e.cardinal => e.contenu(I) = x);
                        
        procedure ajouter (x: Integer; e: IN OUT ensemble) is

        begin
            -- Si l'ensemble n'est pas vide
            if e.cardinal > 0 then

                -- Test de présence de l'élément dans l'ensemble
                    if not appartient(x,e) then
                       e.contenu(e.cardinal +1) := x;
                       e.cardinal := e.cardinal +1;
                    else -- Sinon élément présent -> on ne l'ajoute pas
                        null;
                    end if;
            else
               -- Si c'est le premier élément de l'ensemble on l'ajoute à la
               -- première case du tableau
               e.contenu(1) := x;
               e.cardinal := e.cardinal +1;               
            end if;
            
        end ajouter;


        -- procedure supprimer
        -- supprime un element de l'ensemble
        -- Paramètres x : integer (D)
        --            e : ensemble (D/R)
        procedure supprimer(x: Integer; e: IN OUT ensemble) 
            WITH 
                PRE => (e.cardinal > 0) and
                       (FOR SOME I IN 1..e.cardinal => e.contenu(I) = x),

                POST => (e.cardinal = e.cardinal'OLD -1) and
                        (FOR ALL I IN 1..e.cardinal => e.contenu(I) /= x);
                
        procedure supprimer(x: Integer; e: IN OUT ensemble) is
            -- Déclaration des variables
            i : Integer;

        begin

            -- Initialisation des variables 
            i := 0;
                
            -- Parcours du tableau jusqu'à trouver l'élément ou avoir fini le
            -- tableau
            while i<= e.cardinal and then e.contenu(i) /= x loop
                i:= i+1;
            end loop;
            -- Fin du parcours -> fin du tableau ou élément trouvé à l'indice i

            -- Si le tableau a été entiérement parcouru -> élément non
            -- trouvé
            if i > e.cardinal then
                 null;
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
        
        end supprimer;
        

        -- procedure afficher :  Affiche le contenu de l'ensemble
        -- e : ensemble (D)
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
--        ajouter(2,mon_ensemble);
        ajouter(3,mon_ensemble);
        ajouter(4,mon_ensemble);
        ajouter(5,mon_ensemble);
        ajouter(6,mon_ensemble);

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
        supprimer(4,mon_ensemble);

        -- Affichage de l'ensemble
        afficher(mon_ensemble);

        -- Test d'appartenance 
        if appartient(4,mon_ensemble) then
            Put_Line("4 appartient à l'ensemble");
        else
            Put_Line("4 n'appartient pa à l'ensemble");
        end if;




end tp5;
