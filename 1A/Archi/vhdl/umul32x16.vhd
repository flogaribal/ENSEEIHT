library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity umul32x16 is
	port (
		a : in std_logic_vector (31 downto 0) ;
		b : in std_logic_vector (15 downto 0) ;
		s : out std_logic_vector (47 downto 0)
	);
end umul32x16;

architecture synthesis of umul32x16 is

	-- submodules declarations
	component umult16x16
		port (
			arg1  : in std_logic_vector(15 downto 0);
			arg2  : in std_logic_vector(15 downto 0);
			res  : out std_logic_vector(31 downto 0)
		) ;
	end component ;
	component adder32
		port (
			a : in std_logic_vector (31 downto 0) ;
			b : in std_logic_vector (31 downto 0) ;
			cin : in std_logic ;
			s : out std_logic_vector (31 downto 0) ;
			cout : out std_logic
		) ;
	end component ;

	-- internal signals declarations
	signal s1 : std_logic_vector (47 downto 0) ;
	signal s2 : std_logic_vector (31 downto 0) ;
	signal c : std_logic ;

begin

	-- concurrent statements
	s(15 downto 0) <= s1(15 downto 0) ;
	s1(47 downto 32) <= "0000000000000000" ;

	-- components instanciations
	umult16x16_0 : umult16x16 port map (a(15 downto 0), b(15 downto 0), s1(31 downto 0)) ;
	umult16x16_1 : umult16x16 port map (a(31 downto 16), b(15 downto 0), s2(31 downto 0)) ;
	adder32_2 : adder32 port map (s1(47 downto 16), s2(31 downto 0), '0', s(47 downto 16), c) ;

end synthesis;
