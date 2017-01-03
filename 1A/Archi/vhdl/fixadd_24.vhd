library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity fixadd_24 is
	port (
		a : in std_logic_vector (31 downto 0) ;
		b : in std_logic_vector (31 downto 0) ;
		s : out std_logic_vector (31 downto 0) ;
		v : out std_logic
	);
end fixadd_24;

architecture synthesis of fixadd_24 is

	-- submodules declarations
	component addsub32
		port (
			a : in std_logic_vector (31 downto 0) ;
			b : in std_logic_vector (31 downto 0) ;
			sub : in std_logic ;
			s : out std_logic_vector (31 downto 0) ;
			v : out std_logic ;
			c : out std_logic
		) ;
	end component ;

	-- buffer signals declarations
	signal s_int : std_logic_vector (31 downto 0) ;

	-- internal signals declarations
	signal c : std_logic ;

begin

	-- buffer signals assignations
	s(31 downto 0) <= s_int(31 downto 0) ;

	-- components instanciations
	addsub32_0 : addsub32 port map (a(31 downto 0), b(31 downto 0), '0', s_int(31 downto 0), v, c) ;

end synthesis;
