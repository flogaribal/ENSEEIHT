library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity ucmp16 is
	port (
		a : in std_logic_vector (15 downto 0) ;
		b : in std_logic_vector (15 downto 0) ;
		sup : out std_logic ;
		eq : out std_logic
	);
end ucmp16;

architecture synthesis of ucmp16 is

	-- submodules declarations
	component ucmp8
		port (
			a : in std_logic_vector (7 downto 0) ;
			b : in std_logic_vector (7 downto 0) ;
			sup : out std_logic ;
			eq : out std_logic
		) ;
	end component ;

	-- internal signals declarations
	signal sup1 : std_logic ;
	signal eq1 : std_logic ;
	signal sup2 : std_logic ;
	signal eq2 : std_logic ;

begin

	-- concurrent statements
	sup <= (sup1) or (eq1 and sup2) ;
	eq <= eq1 and eq2 ;

	-- components instanciations
	ucmp8_0 : ucmp8 port map (a(15 downto 8), b(15 downto 8), sup1, eq1) ;
	ucmp8_1 : ucmp8 port map (a(7 downto 0), b(7 downto 0), sup2, eq2) ;

end synthesis;
