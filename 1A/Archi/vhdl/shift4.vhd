library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity shift4 is
	port (
		r : in std_logic ;
		en : in std_logic ;
		e : in std_logic_vector (31 downto 0) ;
		s : out std_logic_vector (31 downto 0)
	);
end shift4;

architecture synthesis of shift4 is

begin

	-- concurrent statements
	s(31 downto 28) <= 
		(e(27 downto 24) and (en&en&en&en) and ((not r)&(not r)&(not r)&(not r))) or
		(e(31 downto 28) and ((not en)&(not en)&(not en)&(not en))) ;
	s(27 downto 4) <= 
		(e(27 downto 4) and ((not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en))) or
		(e(31 downto 8) and (en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en) and (r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r)) or
		(e(23 downto 0) and (en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en) and ((not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r))) ;
	s(3 downto 0) <= 
		(e(6 downto 3) and (en&en&en&en) and (r&r&r&r)) or
		(e(3 downto 0) and ((not en)&(not en)&(not en)&(not en))) ;

end synthesis;
