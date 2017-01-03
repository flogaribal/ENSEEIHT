library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity ucmp4 is
	port (
		a : in std_logic_vector (3 downto 0) ;
		b : in std_logic_vector (3 downto 0) ;
		sup : out std_logic ;
		eq : out std_logic
	);
end ucmp4;

architecture synthesis of ucmp4 is

	-- submodules declarations
	component ucmp2
		port (
			a : in std_logic_vector (1 downto 0) ;
			b : in std_logic_vector (1 downto 0) ;
			sup : out std_logic ;
			eq : out std_logic
		) ;
	end component ;

	-- internal signals declarations
	signal sup32 : std_logic ;
	signal eq32 : std_logic ;
	signal sup10 : std_logic ;
	signal eq10 : std_logic ;

begin

	-- concurrent statements
	sup <= (sup32) or (eq32 and sup10) ;
	eq <= eq32 and eq10 ;

	-- components instanciations
	ucmp2_0 : ucmp2 port map (a(3 downto 2), b(3 downto 2), sup32, eq32) ;
	ucmp2_1 : ucmp2 port map (a(1 downto 0), b(1 downto 0), sup10, eq10) ;

end synthesis;
