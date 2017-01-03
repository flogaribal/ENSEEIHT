library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity zero16 is
	port (
		a : in std_logic_vector (15 downto 0) ;
		z : out std_logic
	);
end zero16;

architecture synthesis of zero16 is

	-- submodules declarations
	component zero8
		port (
			a : in std_logic_vector (7 downto 0) ;
			z : out std_logic
		) ;
	end component ;

	-- internal signals declarations
	signal z1 : std_logic ;
	signal z2 : std_logic ;

begin

	-- concurrent statements
	z <= z1 and z2 ;

	-- components instanciations
	zero8_0 : zero8 port map (a(15 downto 8), z1) ;
	zero8_1 : zero8 port map (a(7 downto 0), z2) ;

end synthesis;
