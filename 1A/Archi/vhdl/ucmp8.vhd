library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity ucmp8 is
	port (
		a : in std_logic_vector (7 downto 0) ;
		b : in std_logic_vector (7 downto 0) ;
		sup : out std_logic ;
		eq : out std_logic
	);
end ucmp8;

architecture synthesis of ucmp8 is

	-- submodules declarations
	component ucmp4
		port (
			a : in std_logic_vector (3 downto 0) ;
			b : in std_logic_vector (3 downto 0) ;
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
	ucmp4_0 : ucmp4 port map (a(7 downto 4), b(7 downto 4), sup1, eq1) ;
	ucmp4_1 : ucmp4 port map (a(3 downto 0), b(3 downto 0), sup2, eq2) ;

end synthesis;
