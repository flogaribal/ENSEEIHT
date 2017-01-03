library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity zero32 is
	port (
		a : in std_logic_vector (31 downto 0) ;
		z : out std_logic
	);
end zero32;

architecture synthesis of zero32 is

	-- submodules declarations
	component zero16
		port (
			a : in std_logic_vector (15 downto 0) ;
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
	zero16_0 : zero16 port map (a(31 downto 16), z1) ;
	zero16_1 : zero16 port map (a(15 downto 0), z2) ;

end synthesis;
