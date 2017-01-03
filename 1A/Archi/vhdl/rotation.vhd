library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity rotation is
	port (
		rst : in std_logic ;
		clk : in std_logic ;
		a : in std_logic ;
		b : in std_logic ;
		sens : out std_logic
	);
end rotation;

architecture synthesis of rotation is

	-- internal signals declarations
	signal betats : std_logic_vector (1 downto 0) ;
	signal detats : std_logic_vector (1 downto 0) ;
	signal a1 : std_logic ;
	signal b1 : std_logic ;
	signal c1 : std_logic ;
	signal d1 : std_logic ;

begin

	-- concurrent statements
	detats(1 downto 0) <= 
		("11" and (a1&a1) and (a&a) and (b&b)) or
		("00" and (a1&a1) and ((not a)&(not a)) and ((not b)&(not b))) or
		("10" and (b1&b1) and (a&a) and ((not b)&(not b))) or
		("01" and (b1&b1) and ((not a)&(not a)) and (b&b)) or
		("00" and (c1&c1) and ((not a)&(not a)) and ((not b)&(not b))) or
		("11" and (c1&c1) and (a&a) and (b&b)) or
		("01" and (d1&d1) and ((not a)&(not a)) and (b&b)) or
		("10" and (d1&d1) and (a&a) and ((not b)&(not b))) ;
	sens <= (a1 and (not a) and (not b)) or (b1 and (not a) and b) or (c1 and a and b) or (d1 and a and (not b)) ;
	a1 <= (not betats(1)) and betats(0) ;
	b1 <= betats(1) and betats(0) ;
	c1 <= betats(1) and (not betats(0)) ;
	d1 <= (not betats(1)) and (not betats(0)) ;

	-- sequential statements
	process (clk, rst) begin
		if rst = '1' then
			betats(1 downto 0) <= "00" ;
		elsif clk'event and clk = '1' then
			betats(1 downto 0) <= detats(1 downto 0) ;
		end if ;
	end process ;

end synthesis;
