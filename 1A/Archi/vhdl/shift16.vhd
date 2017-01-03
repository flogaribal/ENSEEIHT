library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity shift16 is
	port (
		r : in std_logic ;
		en : in std_logic ;
		e : in std_logic_vector (31 downto 0) ;
		s : out std_logic_vector (31 downto 0)
	);
end shift16;

architecture synthesis of shift16 is

begin

	-- concurrent statements
	s(31 downto 16) <= 
		(e(15 downto 0) and (en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en) and ((not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r)&(not r))) or
		(e(31 downto 16) and ((not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en))) ;
	s(15 downto 0) <= 
		(e(31 downto 16) and (en&en&en&en&en&en&en&en&en&en&en&en&en&en&en&en) and (r&r&r&r&r&r&r&r&r&r&r&r&r&r&r&r)) or
		(e(15 downto 0) and ((not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en)&(not en))) ;

end synthesis;
