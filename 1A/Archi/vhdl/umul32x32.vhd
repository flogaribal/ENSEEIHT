library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity umul32x32 is
	port (
		a : in std_logic_vector (31 downto 0) ;
		b : in std_logic_vector (31 downto 0) ;
		s : out std_logic_vector (63 downto 0)
	);
end umul32x32;

architecture synthesis of umul32x32 is

	-- submodules declarations
	component umul32x16
		port (
			a : in std_logic_vector (31 downto 0) ;
			b : in std_logic_vector (15 downto 0) ;
			s : out std_logic_vector (47 downto 0)
		) ;
	end component ;
	component adder16
		port (
			a : in std_logic_vector (15 downto 0) ;
			b : in std_logic_vector (15 downto 0) ;
			cin : in std_logic ;
			s : out std_logic_vector (15 downto 0) ;
			cout : out std_logic
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
	signal s1 : std_logic_vector (63 downto 0) ;
	signal s2 : std_logic_vector (47 downto 0) ;
	signal cout : std_logic ;
	signal c : std_logic ;

begin

	-- concurrent statements
	s(15 downto 0) <= s1(15 downto 0) ;
	s1(63 downto 48) <= "0000000000000000" ;

	-- components instanciations
	umul32x16_0 : umul32x16 port map (a(31 downto 0), b(15 downto 0), s1(47 downto 0)) ;
	umul32x16_1 : umul32x16 port map (a(31 downto 0), b(31 downto 16), s2(47 downto 0)) ;
	adder16_2 : adder16 port map (s1(31 downto 16), s2(15 downto 0), '0', s(31 downto 16), cout) ;
	adder32_3 : adder32 port map (s1(63 downto 32), s2(47 downto 16), cout, s(63 downto 32), c) ;

end synthesis;
