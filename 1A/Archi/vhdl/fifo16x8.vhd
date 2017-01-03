library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity fifo16x8 is
	port (
		rst : in std_logic ;
		clk : in std_logic ;
		put : in std_logic ;
		get : in std_logic ;
		din : in std_logic_vector (7 downto 0) ;
		dout : out std_logic_vector (7 downto 0) ;
		empty : out std_logic ;
		full : out std_logic ;
		lastfull : out std_logic ;
		lastempty : out std_logic
	);
end fifo16x8;

architecture synthesis of fifo16x8 is

	-- submodules declarations
	component rams_dual_asyn_read16x8
		port (
			clk  : in std_logic;
			we  : in std_logic;
			waddr  : in std_logic_vector(3 downto 0);
			raddr  : in std_logic_vector(3 downto 0);
			di  : in std_logic_vector(7 downto 0);
			wdo  : out std_logic_vector(7 downto 0);
			rdo  : out std_logic_vector(7 downto 0)
		) ;
	end component ;
	component count4
		port (
			rst : in std_logic ;
			h : in std_logic ;
			en : in std_logic ;
			s : out std_logic_vector (3 downto 0)
		) ;
	end component ;
	component adder4
		port (
			a : in std_logic_vector (3 downto 0) ;
			b : in std_logic_vector (3 downto 0) ;
			cin : in std_logic ;
			s : out std_logic_vector (3 downto 0) ;
			cout : out std_logic
		) ;
	end component ;
	component ucmp4
		port (
			a : in std_logic_vector (3 downto 0) ;
			b : in std_logic_vector (3 downto 0) ;
			sup : out std_logic ;
			eq : out std_logic
		) ;
	end component ;

	-- buffer signals declarations
	signal empty_int : std_logic ;
	signal full_int : std_logic ;
	signal lastfull_int : std_logic ;
	signal lastempty_int : std_logic ;

	-- internal signals declarations
	signal wraddr : std_logic_vector (3 downto 0) ;
	signal rdaddr : std_logic_vector (3 downto 0) ;
	signal doutwr : std_logic_vector (7 downto 0) ;
	signal doutrd : std_logic_vector (7 downto 0) ;
	signal ordrincrput : std_logic ;
	signal ordrincrget : std_logic ;
	signal resultlastfull : std_logic_vector (3 downto 0) ;
	signal cout1 : std_logic ;
	signal sup1 : std_logic ;
	signal resultlastempty : std_logic_vector (3 downto 0) ;
	signal cout2 : std_logic ;
	signal sup2 : std_logic ;
	signal betats : std_logic_vector (1 downto 0) ;
	signal detats : std_logic_vector (1 downto 0) ;

begin

	-- buffer signals assignations
	empty <= empty_int ;
	full <= full_int ;
	lastfull <= lastfull_int ;
	lastempty <= lastempty_int ;

	-- concurrent statements
	ordrincrput <= put and (not full_int) ;
	ordrincrget <= get and (not empty_int) ;
	detats(1 downto 0) <= 
		("00" and (empty_int&empty_int) and ((not get)&(not get)) and ((not put)&(not put))) or
		("00" and (empty_int&empty_int) and (get&get)) or
		("01" and (empty_int&empty_int) and (put&put) and ((not get)&(not get))) or
		("01" and ((not empty_int)&(not empty_int)) and ((not full_int)&(not full_int)) and (put&put) and (get&get)) or
		("01" and ((not empty_int)&(not empty_int)) and ((not full_int)&(not full_int)) and ((not put)&(not put)) and ((not get)&(not get))) or
		("01" and ((not empty_int)&(not empty_int)) and ((not full_int)&(not full_int)) and (put&put) and ((not lastfull_int)&(not lastfull_int)) and ((not get)&(not get))) or
		("01" and ((not empty_int)&(not empty_int)) and ((not full_int)&(not full_int)) and (get&get) and ((not lastempty_int)&(not lastempty_int)) and ((not put)&(not put))) or
		("11" and ((not empty_int)&(not empty_int)) and ((not full_int)&(not full_int)) and (put&put) and (lastfull_int&lastfull_int) and ((not get)&(not get))) or
		("00" and ((not empty_int)&(not empty_int)) and ((not full_int)&(not full_int)) and (get&get) and (lastempty_int&lastempty_int) and ((not put)&(not put))) or
		("11" and (full_int&full_int) and (put&put)) or
		("11" and (full_int&full_int) and ((not put)&(not put)) and ((not get)&(not get))) or
		("01" and (full_int&full_int) and ((not put)&(not put)) and (get&get)) ;
	empty_int <= (not betats(1)) and (not betats(0)) ;
	full_int <= betats(1) and betats(0) ;
	dout(7 downto 0) <= 
		(doutrd(7 downto 0) and (get&get&get&get&get&get&get&get)) ;

	-- sequential statements
	process (clk, rst) begin
		if rst = '1' then
			betats(1 downto 0) <= "00" ;
		elsif clk'event and clk = '1' then
			betats(1 downto 0) <= detats(1 downto 0) ;
		end if ;
	end process ;

	-- components instanciations
	rams_dual_asyn_read16x8_0 : rams_dual_asyn_read16x8 port map (clk, put, wraddr(3 downto 0), rdaddr(3 downto 0), din(7 downto 0), doutwr(7 downto 0), doutrd(7 downto 0)) ;
	count4_1 : count4 port map (rst, clk, ordrincrput, wraddr(3 downto 0)) ;
	count4_2 : count4 port map (rst, clk, ordrincrget, rdaddr(3 downto 0)) ;
	adder4_3 : adder4 port map (wraddr(3 downto 0), "0001", '0', resultlastfull(3 downto 0), cout1) ;
	ucmp4_4 : ucmp4 port map (resultlastfull(3 downto 0), rdaddr(3 downto 0), sup1, lastfull_int) ;
	adder4_5 : adder4 port map (rdaddr(3 downto 0), "0001", '0', resultlastempty(3 downto 0), cout2) ;
	ucmp4_6 : ucmp4 port map (resultlastempty(3 downto 0), wraddr(3 downto 0), sup2, lastempty_int) ;

end synthesis;
