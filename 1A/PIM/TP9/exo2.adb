-- GARIBAL Florian
-- 1A IMA Groupe A
--
-- TP9
--




with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

procedure exo2 is
        TMAX : constant Integer := 100;
        Type Tableau is array (1..TMAX) of Integer;

        -----------------------------------------------
        -- procedure affiche_d_g
        -- Affiche les valeurs du tableau de droite à gauche
        -- Paramètre tab : le tableau à afficher
        --        nb_elt : Le nombre d'éléments contenus dans le tableau
        -- Précondition : ----
        -- Postcondition : ----
        -----------------------------------------------
        procedure affiche_d_g(tab: Tableau; nb_elt: Integer) is

        begin
            if nb_elt >= 1 then
                Put(tab(nb_elt),2);
                Put("-");
                affiche_d_g(tab, nb_elt-1);
            end if;
        end affiche_d_g;


        -----------------------------------------------
        -- procedure affiche_g_d
        -- Affiche les valeurs du tableau de gauche à droite
        -- Paramètre tab : le tableau à afficher
        --         debut : L'indice de début du tableau à afficher
        --        nb_elt : Le nombre d'éléments contenus dans le tableau
        -- Précondition : ----
        -- Postcondition : ----
        -----------------------------------------------
        procedure affiche_g_d(tab: Tableau; debut: Integer; nb_elt: Integer) is

        begin
            if debut <= nb_elt then
                Put(tab(debut),2);
                Put("-");
                affiche_g_d(tab,debut+1,nb_elt);
            end if;
        end affiche_g_d;

      
        -----------------------------------------------
        -- function rech_val
        -- Retourne l'indice de la valeur recherchée dans le tableau, 0 si non
        -- trouvée
        -- Paramètre tab : le tableau à afficher
        --        nb_elt : Le nombre d'éléments contenus dans le tableau
        --             e : L'élément recherché
        -- Précondition : nb_elt > 0
        -- Postcondition : For SOME I IN 1..nb_elt => tab(I) = e ET I =
        --                 rech_val'RESULT 
        --                 OU 
        --                 rech_val'RESULT = 0 ET for ALL I IN 1..nb_elt =>
        --                 tab(I) /= e
        -----------------------------------------------
        function rech_val(tab: Tableau; nb_elt: Integer; e: Integer) return Integer is
                
            indice : Integer;

        begin
            
            indice := 0;

            if nb_elt >= 1 then
                if tab(nb_elt) = e then 
                    indice := nb_elt;
                else
                    indice := rech_val(tab, nb_elt-1,e);
                end if;
            end if;

            return indice;

        end rech_val;



        tab: Tableau;

begin
        -- Initialisation tableau
        for I in Integer range 1..80 loop
            tab(I) := I;
        end loop;
        
        affiche_d_g(tab, 80);

        New_Line(1);

        affiche_g_d(tab,1,80);

        Put("Valeur recherchée 60 : ");
        Put(rech_val(tab,80,60),2);

        New_Line(1);

        Put("Valeur recherchée 90 : ");
        Put(rech_val(tab,80,90),2);

end exo2;


