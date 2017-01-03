library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity affmux is
	port (
		h : in std_logic ;
		data : in std_logic_vector (15 downto 0) ;
		anodes : out std_logic_vector (3 downto 0) ;
		segs : out std_logic_vector (6 downto 0)
	);
end affmux;

architecture synthesis of affmux is

	-- submodules declarations
	component clock28
		port (
			rst : in std_logic ;
			h : in std_logic ;
			s : out std_logic_vector (27 downto 0)
		) ;
	end component ;
	component decoder2to4
		port (
			e : in std_logic_vector (1 downto 0) ;
			s : out std_logic_vector (3 downto 0)
		) ;
	end component ;
	component dec7segsH
		port (
			x : in std_logic_vector (3 downto 0) ;
			seg : out std_logic_vector (6 downto 0)
		) ;
	end component ;

	-- buffer signals declarations
	signal anodes_int : std_logic_vector (3 downto 0) ;

	-- internal signals declarations
	signal s : std_logic_vector (27 downto 0) ;
	signal x : std_logic_vector (3 downto 0) ;

begin

	-- buffer signals assignations
	anodes(3 downto 0) <= anodes_int(3 downto 0) ;

	-- concurrent statements
	x(3 downto 0) <= 
		(data(3 downto 0) and (anodes_int(0)&anodes_int(0)&anodes_int(0)&anodes_int(0))) or
		(data(7 downto 4) and (anodes_int(1)&anodes_int(1)&anodes_int(1)&anodes_int(1))) or
		(data(11 downto 8) and (anodes_int(2)&anodes_int(2)&anodes_int(2)&anodes_int(2))) or
		(data(15 downto 12) and (anodes_int(3)&anodes_int(3)&anodes_int(3)&anodes_int(3))) ;

	-- components instanciations
	clock28_0 : clock28 port map ('0', h, s(27 downto 0)) ;
	decoder2to4_1 : decoder2to4 port map (s(1 downto 0), anodes_int(3 downto 0)) ;
	dec7segsH_2 : dec7segsH port map (x(3 downto 0), segs(6 downto 0)) ;

end synthesis;
