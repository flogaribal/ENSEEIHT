library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity ual is
	port (
		a : in std_logic_vector (31 downto 0) ;
		b : in std_logic_vector (31 downto 0) ;
		cmd : in std_logic_vector (5 downto 0) ;
		s : inout std_logic_vector (31 downto 0) ;
		evc : out std_logic ;
		en : out std_logic ;
		ez : out std_logic ;
		n : out std_logic ;
		z : out std_logic ;
		v : out std_logic ;
		c : out std_logic
	);
end ual;

architecture synthesis of ual is

	-- submodules declarations
	component decoder6to64
		port (
			e : in std_logic_vector (5 downto 0) ;
			s : out std_logic_vector (63 downto 0)
		) ;
	end component ;
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
	component umult16x16
		port (
			arg1  : in std_logic_vector(15 downto 0);
			arg2  : in std_logic_vector(15 downto 0);
			res  : out std_logic_vector(31 downto 0)
		) ;
	end component ;
	component barrelshifter32
		port (
			r : in std_logic ;
			nb : in std_logic_vector (4 downto 0) ;
			e : in std_logic_vector (31 downto 0) ;
			s : out std_logic_vector (31 downto 0)
		) ;
	end component ;
	component zero32
		port (
			a : in std_logic_vector (31 downto 0) ;
			z : out std_logic
		) ;
	end component ;

	-- internal signals declarations
	signal decode : std_logic_vector (63 downto 0) ;
	signal is_sub : std_logic ;
	signal add : std_logic_vector (31 downto 0) ;
	signal vaddsub : std_logic ;
	signal caddsub : std_logic ;
	signal sand : std_logic_vector (31 downto 0) ;
	signal sor : std_logic_vector (31 downto 0) ;
	signal sxor : std_logic_vector (31 downto 0) ;
	signal tmpmul : std_logic_vector (31 downto 0) ;
	signal shiftr : std_logic_vector (31 downto 0) ;
	signal tmp : std_logic_vector (31 downto 0) ;
	signal tmp1 : std_logic_vector (31 downto 0) ;
	signal tmp2 : std_logic_vector (31 downto 0) ;

begin

	-- concurrent statements
	is_sub <= (decode(4)) or (decode(20)) ;
	s(31 downto 0) <= add(31 downto 0) when decode(0) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	s(31 downto 0) <= add(31 downto 0) when decode(16) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	s(31 downto 0) <= add(31 downto 0) when decode(4) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	s(31 downto 0) <= add(31 downto 0) when decode(20) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	sand(31 downto 0) <= a(31 downto 0) and b(31 downto 0) ;
	s(31 downto 0) <= sand(31 downto 0) when decode(1) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	s(31 downto 0) <= sand(31 downto 0) when decode(17) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	sor(31 downto 0) <= (a(31 downto 0)) or (b(31 downto 0)) ;
	s(31 downto 0) <= sor(31 downto 0) when decode(2) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	s(31 downto 0) <= sor(31 downto 0) when decode(18) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	sxor(31 downto 0) <= (a(31 downto 0) and (not b(31 downto 0))) or ((not a(31 downto 0)) and b(31 downto 0)) ;
	s(31 downto 0) <= sxor(31 downto 0) when decode(3) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	s(31 downto 0) <= sxor(31 downto 0) when decode(19) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	s(31 downto 0) <= tmpmul(31 downto 0) when decode(26) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	s(31 downto 0) <= shiftr(31 downto 0) when decode(13) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	s(31 downto 0) <= shiftr(31 downto 0) when decode(14) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	tmp(12 downto 0) <= a(12 downto 0) ;
	tmp(31 downto 13) <= 
		("1111111111111111111" and (a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12)&a(12))) ;
	s(31 downto 0) <= tmp(31 downto 0) when decode(32) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	tmp1(24 downto 0) <= a(24 downto 0) ;
	tmp1(31 downto 25) <= 
		("1111111" and (a(24)&a(24)&a(24)&a(24)&a(24)&a(24)&a(24))) ;
	s(31 downto 0) <= tmp1(31 downto 0) when decode(33) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	tmp2(31 downto 8) <= a(23 downto 0) ;
	tmp2(7 downto 0) <= "00000000" ;
	s(31 downto 0) <= tmp2(31 downto 0) when decode(35) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	s(31 downto 0) <= b(31 downto 0) when decode(40) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	en <= (decode(16)) or (decode(20)) or (decode(17)) or (decode(18)) or (decode(19)) ;
	evc <= (decode(16)) or (decode(20)) ;
	ez <= (decode(16)) or (decode(20)) or (decode(26)) or (decode(17)) or (decode(18)) or (decode(19)) ;
	n <= s(31) ;
	c <= (caddsub and decode(0)) or (caddsub and decode(16)) or (caddsub and decode(4)) or (caddsub and decode(20)) ;
	v <= (vaddsub and decode(0)) or (vaddsub and decode(16)) or (vaddsub and decode(4)) or (vaddsub and decode(20)) ;

	-- components instanciations
	decoder6to64_0 : decoder6to64 port map (cmd(5 downto 0), decode(63 downto 0)) ;
	addsub32_1 : addsub32 port map (a(31 downto 0), b(31 downto 0), is_sub, add(31 downto 0), vaddsub, caddsub) ;
	umult16x16_2 : umult16x16 port map (a(15 downto 0), b(15 downto 0), tmpmul(31 downto 0)) ;
	barrelshifter32_3 : barrelshifter32 port map (decode(13), b(4 downto 0), a(31 downto 0), shiftr(31 downto 0)) ;
	zero32_4 : zero32 port map (s(31 downto 0), z) ;

end synthesis;
