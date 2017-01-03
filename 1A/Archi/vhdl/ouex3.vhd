library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity ouex3 is
	port (
		d1 : in std_logic ;
		d2 : in std_logic ;
		d3 : in std_logic ;
		c : out std_logic
	);
end ouex3;

architecture synthesis of ouex3 is

begin

	-- concurrent statements
	c <= ((not d1) and d2 and d3) or ((not d1) and (not d2) and d3) or (d1 and (not d2) and d3) or (d1 and (not d2) and (not d3)) or (d1 and d2 and (not d3)) or ((not d1) and d2 and (not d3)) ;

end synthesis;
