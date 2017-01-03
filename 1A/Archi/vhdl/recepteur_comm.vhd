library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity recepteur_comm is
    port (
        mclk : in std_logic ;
        pdb : inout std_logic_vector (7 downto 0) ;
        astb : in std_logic ;
        dstb : in std_logic ;
        pwr : in std_logic ;
        pwait : out std_logic
) ;
end recepteur_comm ;

architecture synthesis of recepteur_comm is

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
	component recepteur
		port (
			dr4 : in std_logic ;
			dr3 : in std_logic ;
			dr2 : in std_logic ;
			cr3 : in std_logic ;
			dr1 : in std_logic ;
			cr2 : in std_logic ;
			cr1 : in std_logic ;
			err : out std_logic ;
			d4 : out std_logic ;
			d3 : out std_logic ;
			d2 : out std_logic ;
			d1 : out std_logic
		) ;
	end component ;

    -- internal signals declarations
    signal pc2board : std_logic_vector (127 downto 0) ;
    signal board2pc : std_logic_vector (127 downto 0) ;
    signal dr4 : std_logic ;
    signal dr3 : std_logic ;
    signal dr2 : std_logic ;
    signal cr3 : std_logic ;
    signal dr1 : std_logic ;
    signal cr2 : std_logic ;
    signal cr1 : std_logic ;
    signal err : std_logic ;
    signal d4 : std_logic ;
    signal d3 : std_logic ;
    signal d2 : std_logic ;
    signal d1 : std_logic ;

begin

    -- combinatorial statements
    dr4 <= pc2board(0) ;
    dr3 <= pc2board(1) ;
    dr2 <= pc2board(2) ;
    cr3 <= pc2board(3) ;
    dr1 <= pc2board(4) ;
    cr2 <= pc2board(5) ;
    cr1 <= pc2board(6) ;
    board2pc(0) <= err ;
    board2pc(1) <= d4 ;
    board2pc(2) <= d3 ;
    board2pc(3) <= d2 ;
    board2pc(4) <= d1 ;

    -- components instanciations
    commUSB_0 : commUSB port map (mclk, pdb(7 downto 0), astb, dstb, pwr, pwait, pc2board(127 downto 0), board2pc(127 downto 0)) ;
    recepteur_0 : recepteur port map (dr4, dr3, dr2, cr3, dr1, cr2, cr1, err, d4, d3, d2, d1) ;


end synthesis;
