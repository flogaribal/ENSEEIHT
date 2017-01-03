library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity micromachine is
	port (
		rst : in std_logic ;
		clk : in std_logic ;
		areg : in std_logic_vector (4 downto 0) ;
		breg : in std_logic_vector (4 downto 0) ;
		dreg : in std_logic_vector (4 downto 0) ;
		cmd_ual : in std_logic_vector (5 downto 0) ;
		oe_num : in std_logic_vector (1 downto 0) ;
		write : in std_logic ;
		monitor : in std_logic_vector (31 downto 0) ;
		switch : in std_logic_vector (7 downto 0) ;
		swclk : in std_logic ;
		dbus : inout std_logic_vector (31 downto 0) ;
		n : out std_logic ;
		z : out std_logic ;
		v : out std_logic ;
		c : out std_logic ;
		ir : out std_logic_vector (31 downto 0) ;
		break : out std_logic ;
		leds : out std_logic_vector (7 downto 0)
	);
end micromachine;

architecture synthesis of micromachine is

	-- submodules declarations
	component decoder2to4
		port (
			e : in std_logic_vector (1 downto 0) ;
			s : out std_logic_vector (3 downto 0)
		) ;
	end component ;
	component decoder4to16
		port (
			e : in std_logic_vector (3 downto 0) ;
			s : out std_logic_vector (15 downto 0)
		) ;
	end component ;
	component rams_asyn_read512x32
		port (
			clk  : in std_logic;
			we  : in std_logic;
			addr  : in std_logic_vector(8 downto 0);
			di  : in std_logic_vector(31 downto 0);
			do  : out std_logic_vector(31 downto 0)
		) ;
	end component ;
	component reg8
		port (
			rst : in std_logic ;
			clk : in std_logic ;
			cs : in std_logic ;
			d : in std_logic_vector (7 downto 0) ;
			q : out std_logic_vector (7 downto 0)
		) ;
	end component ;
	component registres
		port (
			rst : in std_logic ;
			clk : in std_logic ;
			areg : in std_logic_vector (4 downto 0) ;
			breg : in std_logic_vector (4 downto 0) ;
			dreg : in std_logic_vector (4 downto 0) ;
			dbus : in std_logic_vector (31 downto 0) ;
			abus : inout std_logic_vector (31 downto 0) ;
			bbus : inout std_logic_vector (31 downto 0) ;
			ir : out std_logic_vector (31 downto 0) ;
			break : out std_logic
		) ;
	end component ;
	component ual
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
		) ;
	end component ;

	-- internal signals declarations
	signal oe : std_logic_vector (3 downto 0) ;
	signal abus : std_logic_vector (31 downto 0) ;
	signal cs : std_logic_vector (15 downto 0) ;
	signal tmpaddr : std_logic_vector (8 downto 0) ;
	signal wr : std_logic ;
	signal dbus_ram : std_logic_vector (31 downto 0) ;
	signal enled : std_logic ;
	signal qswitch : std_logic_vector (7 downto 0) ;
	signal reg8ext32 : std_logic_vector (31 downto 0) ;
	signal dbus_ual : std_logic_vector (31 downto 0) ;
	signal cond_dbus_ram : std_logic ;
	signal cond_dbus_switch : std_logic ;
	signal bbus : std_logic_vector (31 downto 0) ;
	signal evc : std_logic ;
	signal en : std_logic ;
	signal ez : std_logic ;
	signal n_ual : std_logic ;
	signal z_ual : std_logic ;
	signal v_ual : std_logic ;
	signal c_ual : std_logic ;

begin

	-- concurrent statements
	tmpaddr(8 downto 0) <= abus(8 downto 0) ;
	wr <= write and cs(0) ;
	enled <= write and cs(11) ;
	reg8ext32(7 downto 0) <= qswitch(7 downto 0) ;
	reg8ext32(31 downto 8) <= "000000000000000000000000" ;
	dbus(31 downto 0) <= dbus_ual(31 downto 0) when oe(1) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	cond_dbus_ram <= oe(2) and cs(0) ;
	dbus(31 downto 0) <= dbus_ram(31 downto 0) when cond_dbus_ram = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	dbus(31 downto 0) <= monitor(31 downto 0) when oe(3) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	cond_dbus_switch <= oe(2) and cs(9) ;
	dbus(31 downto 0) <= reg8ext32(31 downto 0) when cond_dbus_switch = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;

	-- sequential statements
	process (clk, rst) begin
		if rst = '1' then
			n <= '0' ;
		elsif en = '1' and clk'event and clk = '1' then
			n <= n_ual ;
		end if ;
	end process ;
	process (clk, rst) begin
		if rst = '1' then
			z <= '0' ;
		elsif ez = '1' and clk'event and clk = '1' then
			z <= z_ual ;
		end if ;
	end process ;
	process (clk, rst) begin
		if rst = '1' then
			v <= '0' ;
		elsif evc = '1' and clk'event and clk = '1' then
			v <= v_ual ;
		end if ;
	end process ;
	process (clk, rst) begin
		if rst = '1' then
			c <= '0' ;
		elsif evc = '1' and clk'event and clk = '1' then
			c <= c_ual ;
		end if ;
	end process ;

	-- components instanciations
	decoder2to4_0 : decoder2to4 port map (oe_num(1 downto 0), oe(3 downto 0)) ;
	decoder4to16_1 : decoder4to16 port map (abus(31 downto 28), cs(15 downto 0)) ;
	rams_asyn_read512x32_2 : rams_asyn_read512x32 port map (clk, wr, tmpaddr(8 downto 0), dbus(31 downto 0), dbus_ram(31 downto 0)) ;
	reg8_3 : reg8 port map (rst, clk, enled, dbus(7 downto 0), leds(7 downto 0)) ;
	reg8_4 : reg8 port map (rst, swclk, '1', switch(7 downto 0), qswitch(7 downto 0)) ;
	registres_5 : registres port map (rst, clk, areg(4 downto 0), breg(4 downto 0), dreg(4 downto 0), dbus(31 downto 0), abus(31 downto 0), bbus(31 downto 0), ir(31 downto 0), break) ;
	ual_6 : ual port map (abus(31 downto 0), bbus(31 downto 0), cmd_ual(5 downto 0), dbus_ual(31 downto 0), evc, en, ez, n_ual, z_ual, v_ual, c_ual) ;

end synthesis;
