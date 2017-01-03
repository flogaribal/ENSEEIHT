library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity shift2 is
	port (
		r : in std_logic ;
		en : in std_logic ;
		e : in std_logic_vector (31 downto 0) ;
		s : out std_logic_vector (31 downto 0)
	);
end shift2;

architecture synthesis of shift2 is

begin

	-- concurrent statements
	s(31 downto 30) <= 
		(e(29 downto 28) and (en&en) and ((not r)&(not r))) or
		(e(31 downto 30) and ((not en)&(not en))) ;
	s(29 downto 2) <= 
		(e(29 downto 2) and ((not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en))) or
		(e(31 downto 4) and (en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en) and (r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r)) or
		(e(27 downto 0) and (en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en) and ((not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r))) ;
	s(1 downto 0) <= 
		(e(3 downto 2) and (en&en) and (r&r)) or
		(e(1 downto 0) and ((not en)&(not en))) ;

end synthesis;
