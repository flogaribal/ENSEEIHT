library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity zero8 is
	port (
		a : in std_logic_vector (7 downto 0) ;
		z : out std_logic
	);
end zero8;

architecture synthesis of zero8 is

begin

	-- concurrent statements
	z <= (not a(7)) and (not a(6)) and (not a(5)) and (not a(4)) and (not a(3)) and (not a(2)) and (not a(1)) and (not a(0)) ;

end synthesis;
