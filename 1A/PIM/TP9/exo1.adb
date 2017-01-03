-- GARIBAL Florian
-- 1A IMA Groupe A
--
-- TP9
--




with Ada.Text_IO;
use Ada.Text_IO;
with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;

procedure exo1 is

    -----------------------------------------------
    -- function McCarthy
    -- Calcule la valeur de n par la fonction McCarthy
    -- Paramètre n : La valeur à calculer
    -- Précondition : ----
    -- Postcondition : n>100 ET n-10
    --                 n<=100 ET McCarthy(McCarthy(n+11))
    -----------------------------------------------
    function McCarthy (n : Integer) return Integer is
        tmp : Integer;
    begin
        
        if n>100 then
            tmp := (n-10);
        else 
            tmp := McCarthy(McCarthy(n+11));
        end if;

        return tmp;
    end McCarthy;


begin
       for n in Integer range 0..110 loop
            Put("M(");
            Put(n,3);
            Put(") = ");
            Put(McCarthy(n));
            New_Line(1);
       end loop;
end exo1;
