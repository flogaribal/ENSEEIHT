library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_arith.all;
use IEEE.std_logic_unsigned.all;

entity dec8seg is
  port (
    clk                         					: in std_logic;
    v1,v2,v3,v4,v5,v6,v7,v8     					: in std_logic_vector(3 downto 0);
    seg1,seg2,seg3,seg4,seg5,seg6,seg7,seg8  : out std_logic_vector (7 downto 0)
  );
end dec7seg;

architecture synthesis of dec8seg is

  component dec7seg
    port (	value 	: in 		std_logic_vector (3 downto 0);
				seg 		: out 	std_logic_vector (7 downto 0)
    );
  end component ;

  signal s1,s2,s3,s4,s5,s6,s7,s8 : std_logic_vector (7 downto 0);
  variable cpt : natural := 0;	
	
begin
	if (rising_edge(clk)) then
		if (cpt = 7) then
			cpt = 0;
		else 
			cpt = cpt + 1;
		end if;
			
		case cpt is
			when 0 =>
				dec7seg (v1,s1);
			when 1 =>
				dec7seg (v2,s2);
			when 2 =>
				dec7seg (v3,s3);
			when 3 =>
				dec7seg (v4,s4);
			when 4 =>
				dec7seg (v5,s5);
			when 5 =>
				dec7seg (v6,s6);
			when 6 =>
				dec7seg (v7,s7);
			when 7 =>
				dec7seg (v8,s8);
		end case;
	end if;
  

  seg <= not s;

end synthesis;
