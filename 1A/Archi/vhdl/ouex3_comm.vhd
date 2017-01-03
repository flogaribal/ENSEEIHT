library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity ouex3_comm is
    port (
        mclk : in std_logic ;
        pdb : inout std_logic_vector (7 downto 0) ;
        astb : in std_logic ;
        dstb : in std_logic ;
        pwr : in std_logic ;
        pwait : out std_logic
) ;
end ouex3_comm ;

architecture synthesis of ouex3_comm is

    -- submodules declarations
    component commUSB
        port (
            mclk     : in std_logic;
            pdb      : inout std_logic_vector(7 downto 0);
            astb     : in std_logic;
            dstb     : in std_logic;
            pwr      : in std_logic;
            pwait    : out std_logic;
            pc2board : out std_logic_vector(127 downto 0);
            board2pc : in std_logic_vector(127 downto 0)
        ) ;
    end component ;
	component ouex3
		port (
			d1 : in std_logic ;
			d2 : in std_logic ;
			d3 : in std_logic ;
			c : out std_logic
		) ;
	end component ;

    -- internal signals declarations
    signal pc2board : std_logic_vector (127 downto 0) ;
    signal board2pc : std_logic_vector (127 downto 0) ;
    signal d1 : std_logic ;
    signal d2 : std_logic ;
    signal d3 : std_logic ;
    signal c : std_logic ;

begin

    -- combinatorial statements
    d1 <= pc2board(0) ;
    d2 <= pc2board(1) ;
    d3 <= pc2board(2) ;
    board2pc(0) <= c ;

    -- components instanciations
    commUSB_0 : commUSB port map (mclk, pdb(7 downto 0), astb, dstb, pwr, pwait, pc2board(127 downto 0), board2pc(127 downto 0)) ;
    ouex3_0 : ouex3 port map (d1, d2, d3, c) ;


end synthesis;
