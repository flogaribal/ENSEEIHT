library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity fulladder is
	port (
		a : in std_logic ;
		b : in std_logic ;
		cin : in std_logic ;
		s : out std_logic ;
		cout : out std_logic
	);
end fulladder;

architecture synthesis of fulladder is

begin

	-- concurrent statements
	s <= (a and (not b) and (not cin)) or ((not a) and b and (not cin)) or ((not a) and (not b) and cin) or (a and b and cin) ;
	cout <= (a and b) or (b and cin) or (a and cin) ;

end synthesis;
