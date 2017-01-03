library IEEE;
library UNISIM;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity registres is
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
	);
end registres;

architecture synthesis of registres is

	-- submodules declarations
	component decoder5to32
		port (
			e : in std_logic_vector (4 downto 0) ;
			s : out std_logic_vector (31 downto 0)
		) ;
	end component ;
	component reg32
		port (
			rst : in std_logic ;
			clk : in std_logic ;
			en : in std_logic ;
			d : in std_logic_vector (31 downto 0) ;
			q : out std_logic_vector (31 downto 0)
		) ;
	end component ;
	component eq32
		port (
			a : in std_logic_vector (31 downto 0) ;
			b : in std_logic_vector (31 downto 0) ;
			equal : out std_logic
		) ;
	end component ;

	-- internal signals declarations
	signal aregdec : std_logic_vector (31 downto 0) ;
	signal bregdec : std_logic_vector (31 downto 0) ;
	signal dregdec : std_logic_vector (31 downto 0) ;
	signal r0 : std_logic_vector (31 downto 0) ;
	signal r20 : std_logic_vector (31 downto 0) ;
	signal r1 : std_logic_vector (31 downto 0) ;
	signal r2 : std_logic_vector (31 downto 0) ;
	signal r3 : std_logic_vector (31 downto 0) ;
	signal r4 : std_logic_vector (31 downto 0) ;
	signal r5 : std_logic_vector (31 downto 0) ;
	signal r6 : std_logic_vector (31 downto 0) ;
	signal r7 : std_logic_vector (31 downto 0) ;
	signal r8 : std_logic_vector (31 downto 0) ;
	signal r9 : std_logic_vector (31 downto 0) ;
	signal r21 : std_logic_vector (31 downto 0) ;
	signal r22 : std_logic_vector (31 downto 0) ;
	signal r26 : std_logic_vector (31 downto 0) ;
	signal r27 : std_logic_vector (31 downto 0) ;
	signal r28 : std_logic_vector (31 downto 0) ;
	signal r29 : std_logic_vector (31 downto 0) ;
	signal r30 : std_logic_vector (31 downto 0) ;
	signal r31 : std_logic_vector (31 downto 0) ;

begin

	-- concurrent statements
	r0(31 downto 0) <= "00000000000000000000000000000000" ;
	abus(31 downto 0) <= r0(31 downto 0) when aregdec(0) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r0(31 downto 0) when bregdec(0) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	r20(31 downto 0) <= "00000000000000000000000000000001" ;
	abus(31 downto 0) <= r20(31 downto 0) when aregdec(20) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r20(31 downto 0) when bregdec(20) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r1(31 downto 0) when aregdec(1) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r1(31 downto 0) when bregdec(1) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r2(31 downto 0) when aregdec(2) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r2(31 downto 0) when bregdec(2) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r3(31 downto 0) when aregdec(3) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r3(31 downto 0) when bregdec(3) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r4(31 downto 0) when aregdec(4) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r4(31 downto 0) when bregdec(4) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r5(31 downto 0) when aregdec(5) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r5(31 downto 0) when bregdec(5) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r6(31 downto 0) when aregdec(6) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r6(31 downto 0) when bregdec(6) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r7(31 downto 0) when aregdec(7) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r7(31 downto 0) when bregdec(7) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r8(31 downto 0) when aregdec(8) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r8(31 downto 0) when bregdec(8) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r9(31 downto 0) when aregdec(9) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r9(31 downto 0) when bregdec(9) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r21(31 downto 0) when aregdec(21) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r21(31 downto 0) when bregdec(21) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r22(31 downto 0) when aregdec(22) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r22(31 downto 0) when bregdec(22) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r26(31 downto 0) when aregdec(26) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r26(31 downto 0) when bregdec(26) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r27(31 downto 0) when aregdec(27) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r27(31 downto 0) when bregdec(27) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r28(31 downto 0) when aregdec(28) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r28(31 downto 0) when bregdec(28) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r29(31 downto 0) when aregdec(29) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r29(31 downto 0) when bregdec(29) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r30(31 downto 0) when aregdec(30) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r30(31 downto 0) when bregdec(30) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	abus(31 downto 0) <= r31(31 downto 0) when aregdec(31) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	bbus(31 downto 0) <= r31(31 downto 0) when bregdec(31) = '1' else "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ" ;
	ir(31 downto 0) <= r31(31 downto 0) ;

	-- components instanciations
	decoder5to32_0 : decoder5to32 port map (areg(4 downto 0), aregdec(31 downto 0)) ;
	decoder5to32_1 : decoder5to32 port map (breg(4 downto 0), bregdec(31 downto 0)) ;
	decoder5to32_2 : decoder5to32 port map (dreg(4 downto 0), dregdec(31 downto 0)) ;
	reg32_3 : reg32 port map (rst, clk, dregdec(1), dbus(31 downto 0), r1(31 downto 0)) ;
	reg32_4 : reg32 port map (rst, clk, dregdec(2), dbus(31 downto 0), r2(31 downto 0)) ;
	reg32_5 : reg32 port map (rst, clk, dregdec(3), dbus(31 downto 0), r3(31 downto 0)) ;
	reg32_6 : reg32 port map (rst, clk, dregdec(4), dbus(31 downto 0), r4(31 downto 0)) ;
	reg32_7 : reg32 port map (rst, clk, dregdec(5), dbus(31 downto 0), r5(31 downto 0)) ;
	reg32_8 : reg32 port map (rst, clk, dregdec(6), dbus(31 downto 0), r6(31 downto 0)) ;
	reg32_9 : reg32 port map (rst, clk, dregdec(7), dbus(31 downto 0), r7(31 downto 0)) ;
	reg32_10 : reg32 port map (rst, clk, dregdec(8), dbus(31 downto 0), r8(31 downto 0)) ;
	reg32_11 : reg32 port map (rst, clk, dregdec(9), dbus(31 downto 0), r9(31 downto 0)) ;
	reg32_12 : reg32 port map (rst, clk, dregdec(21), dbus(31 downto 0), r21(31 downto 0)) ;
	reg32_13 : reg32 port map (rst, clk, dregdec(22), dbus(31 downto 0), r22(31 downto 0)) ;
	reg32_14 : reg32 port map (rst, clk, dregdec(26), dbus(31 downto 0), r26(31 downto 0)) ;
	reg32_15 : reg32 port map (rst, clk, dregdec(27), dbus(31 downto 0), r27(31 downto 0)) ;
	reg32_16 : reg32 port map (rst, clk, dregdec(28), dbus(31 downto 0), r28(31 downto 0)) ;
	reg32_17 : reg32 port map (rst, clk, dregdec(29), dbus(31 downto 0), r29(31 downto 0)) ;
	reg32_18 : reg32 port map (rst, clk, dregdec(30), dbus(31 downto 0), r30(31 downto 0)) ;
	reg32_19 : reg32 port map (rst, clk, dregdec(31), dbus(31 downto 0), r31(31 downto 0)) ;
	eq32_20 : eq32 port map (r26(31 downto 0), r30(31 downto 0), break) ;

end synthesis;
