library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_unsigned.all;
use IEEE.std_logic_arith.all;

entity diviseurClk is
  -- facteur : ratio entre la fréquence de l'horloge origine et celle
  --           de l'horloge générée
  --  ex : 50 MHz -> 1Hz : facteur = 50 000 000
  --  ex : 50 MHz -> 1kHz : facteur = 50 000
  generic(facteur : natural);
  port (
            clk, reset : in  std_logic;
            nclk       : out std_logic
        );
end diviseurClk;

-- troisième architecture : vue comportementale == algorithme
architecture arch_diviseurClk of diviseurClk is
  
  
  begin

    process(clk, reset) -- se réveille dès qu'un de ces 2 signaux évolue
    
      variable cpt_aux : natural := 0;
    
      begin
        if (reset = '0') then
            cpt_aux := 0;

        elsif (rising_edge(clk)) then 
	
				if (cpt_aux = facteur - 1) then
					cpt_aux := 0;
					nclk <= '1'; 
				else
					cpt_aux := (cpt_aux + 1)  ;
					nclk <= '0';
				end if;
			
        end if;     
      end process;

end arch_diviseurClk;
