-- GARIBAL Florian
-- 1A IMA Groupe A
--
-- TP9
--




with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

procedure exo3 is


    -----------------------------------------------
    -- procedure affiche2_aux
    -- Affiche une liste de nombre 
    -- Paramètre a : Le compteur pour la valeur m
    --             m : le nombre de lignes de la liste 
    --           b : Le compteur pour la valeur n
    --             n : Le nombre de colonnes -1
    -- Préconditions : m>0 ET n>0 ET d_m>0 ET d_n>0
    -- Postcondition : ----
    -----------------------------------------------
    procedure affiche2_aux(a:Integer; m:Integer; b: Integer; n:Integer) is

    begin
        if a <= m then
            if b <= n then
                Put(10*a + b);
                affiche2_aux(a,m,b+1,n);
            else
                New_Line(1);
                affiche2_aux(a+1,m,0,n);
            end if;
        end if;

    end affiche2_aux;

    -----------------------------------------------
    -- procedure affiche2
    -- Affiche une liste de nombre 
    -- Paramètre m : le nombre de lignes de la liste 
    --           n : Le nombre de colonnes -1
    -- Préconditions : m>0 ET n>0
    -- Postcondition : ----
    -----------------------------------------------
    procedure affiche2(m: IN Integer; n: IN Integer) is

    begin
        affiche2_aux(0,m,0,n);
    end affiche2;


    -----------------------------------------------
    -- procedure affiche
    -- Affiche une liste de nombre 
    -- Paramètre m : le nombre de lignes de la liste 
    --           n : Le nombre de colonnes -1
    -- Préconditions : m>0 ET n>0
    -- Postcondition : ----
    -----------------------------------------------
    procedure affiche(m : in integer; n : in integer) is
    begin
        for a in 0..m loop
        -- afficher une ligne de nombres
                for b in 0.. n loop
                -- afficher un nombre
                        put(10*a + b);
                end loop;
                new_line;
        end loop;
    end affiche;



begin

    affiche(6,4);

    New_Line(2);

    affiche2(6,4);
end exo3;
