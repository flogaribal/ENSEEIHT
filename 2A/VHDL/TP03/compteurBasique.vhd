library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_unsigned.all;
use IEEE.std_logic_arith.all;

-- interface du composant compteur
entity compteurBasique is
  port(clk, reset     : in std_logic;
       cpt	          : out std_logic_vector (3 downto 0);
       carry          : out std_logic
      );
end compteurBasique;

-- troisième architecture : vue comportementale == algorithme
architecture arch_compteur of compteurBasique is
  
  
  begin

    process(clk, reset) -- se réveille dès qu'un de ces 2 signaux évolue
    
      variable cpt_aux : std_logic_vector (3 downto 0) := (others => '0');
    
      begin
        if (reset = '0') then
            cpt_aux := (others => '0');
            cpt <= cpt_aux;
            carry <= '0';

        elsif (rising_edge(clk)) then 

            cpt_aux := cpt_aux + 1;

            if (cpt_aux = 0) then
              carry <= '1';
            else
              carry <= '0';  
            end if;
        end if;
        cpt <= cpt_aux;
        
      end process;

end arch_compteur;
