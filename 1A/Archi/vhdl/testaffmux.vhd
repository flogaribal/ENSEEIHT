library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity testaffmux is
	port (
		mclk : in std_logic ;
		data : in std_logic_vector (15 downto 0) ;
		an : out std_logic_vector (3 downto 0) ;
		ssg : out std_logic_vector (6 downto 0)
	);
end testaffmux;

architecture synthesis of testaffmux is

	-- submodules declarations
	component clock28
		port (
			rst : in std_logic ;
			h : in std_logic ;
			s : out std_logic_vector (27 downto 0)
		) ;
	end component ;
	component affmux
		port (
			h : in std_logic ;
			data : in std_logic_vector (15 downto 0) ;
			anodes : out std_logic_vector (3 downto 0) ;
			segs : out std_logic_vector (6 downto 0)
		) ;
	end component ;

	-- internal signals declarations
	signal s : std_logic_vector (27 downto 0) ;
	signal a : std_logic_vector (3 downto 0) ;
	signal seg : std_logic_vector (6 downto 0) ;

begin

	-- concurrent statements
	an(3 downto 0) <= not a(3 downto 0) ;
	ssg(6 downto 0) <= not seg(6 downto 0) ;

	-- components instanciations
	clock28_0 : clock28 port map ('0', mclk, s(27 downto 0)) ;
	affmux_1 : affmux port map (s(15), data(15 downto 0), a(3 downto 0), seg(6 downto 0)) ;

end synthesis;
