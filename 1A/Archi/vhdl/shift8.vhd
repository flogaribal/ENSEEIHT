library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity shift8 is
	port (
		r : in std_logic ;
		en : in std_logic ;
		e : in std_logic_vector (31 downto 0) ;
		s : out std_logic_vector (31 downto 0)
	);
end shift8;

architecture synthesis of shift8 is

begin

	-- concurrent statements
	s(31 downto 24) <= 
		(e(24 downto 17) and (en&en&en&en&en&en&en&en) and ((not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r))) or
		(e(31 downto 24) and ((not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en))) ;
	s(23 downto 8) <= 
		(e(23 downto 8) and ((not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en))) or
		(e(31 downto 16) and (en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en) and (r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r)) or
		(e(15 downto 0) and (en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en) and ((not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r))) ;
	s(7 downto 0) <= 
		(e(15 downto 8) and (en&en&en&en&en&en&en&en) and (r&r&r&r&r&r&r&r)) or
		(e(7 downto 0) and ((not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en))) ;

end synthesis;
