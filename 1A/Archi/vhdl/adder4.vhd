library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity adder4 is
	port (
		a : in std_logic_vector (3 downto 0) ;
		b : in std_logic_vector (3 downto 0) ;
		cin : in std_logic ;
		s : out std_logic_vector (3 downto 0) ;
		cout : out std_logic
	);
end adder4;

architecture synthesis of adder4 is

	-- submodules declarations
	component fulladder
		port (
			a : in std_logic ;
			b : in std_logic ;
			cin : in std_logic ;
			s : out std_logic ;
			cout : out std_logic
		) ;
	end component ;

	-- internal signals declarations
	signal cout0 : std_logic ;
	signal cout1 : std_logic ;
	signal cout2 : std_logic ;

begin

	-- components instanciations
	fulladder_0 : fulladder port map (a(0), b(0), cin, s(0), cout0) ;
	fulladder_1 : fulladder port map (a(1), b(1), cout0, s(1), cout1) ;
	fulladder_2 : fulladder port map (a(2), b(2), cout1, s(2), cout2) ;
	fulladder_3 : fulladder port map (a(3), b(3), cout2, s(3), cout) ;

end synthesis;
