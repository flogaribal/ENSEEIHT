library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity ucmp2 is
	port (
		a : in std_logic_vector (1 downto 0) ;
		b : in std_logic_vector (1 downto 0) ;
		sup : out std_logic ;
		eq : out std_logic
	);
end ucmp2;

architecture synthesis of ucmp2 is

	-- submodules declarations
	component ucmp1
		port (
			a : in std_logic ;
			b : in std_logic ;
			sup : out std_logic ;
			eq : out std_logic
		) ;
	end component ;

	-- internal signals declarations
	signal sup0 : std_logic ;
	signal eq0 : std_logic ;
	signal sup1 : std_logic ;
	signal eq1 : std_logic ;

begin

	-- concurrent statements
	sup <= (sup1) or (eq1 and sup0) ;
	eq <= eq1 and eq0 ;

	-- components instanciations
	ucmp1_0 : ucmp1 port map (a(0), b(0), sup0, eq0) ;
	ucmp1_1 : ucmp1 port map (a(1), b(1), sup1, eq1) ;

end synthesis;
