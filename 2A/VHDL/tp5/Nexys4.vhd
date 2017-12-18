library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_arith.all;
use IEEE.std_logic_unsigned.all;

entity Nexys4 is
  port (
    -- les 16 switchs
    swt : in std_logic_vector (15 downto 0);
    -- les anodes pour sélectionner l'afficheur 7 segments
    an : out std_logic_vector (7 downto 0);
    -- afficheur 7 segments (point décimal compris, segment 7)
    ssg : out std_logic_vector (7 downto 0);
    -- horloge
    mclk : in std_logic;
    -- les 5 boutons noirs
    btnC, btnU, btnL, btnR, btnD : in std_logic;
    -- les 16 leds
    led : out std_logic_vector (15 downto 0)
  );
end Nexys4;

architecture synthesis of Nexys4 is

	component Ip_fifo is
	  port (clk 	: std_logic;
			  rst 	: in std_logic;
			  din 	: in std_logic_vector(3 downto 0);
			  wr_en 	: in std_logic;
			  rd_en 	: in std_logic;
			  dout  	: out std_logic_vector(3 downto 0);
			  full 	: out std_logic;
			  empty 	: out std_logic;
			  data_count : out std_logic_vector(3 downto 0));
   end component;

	component dec7seg
		port (	value 	: in 		std_logic_vector (3 downto 0);
					seg 		: out 	std_logic_vector (7 downto 0)
		);
	end component ;
	
	component diviseurClk is 
		generic(facteur : natural);
		port (
            clk, reset : in  std_logic;
            nclk       : out std_logic
        );
	end component; 
	
	signal my_clk  	: std_logic := '0';
	signal cpt  		: std_logic_vector (3 downto 0);
	
begin

  -- valeurs des sorties (à modifier)

  -- convention afficheur 7 segments 0 => allumé, 1 => éteint
  --ssg <= (others => '1');
  -- aucun afficheur sélectionné
  an(7 downto 0) <= (0 => '0', others => '1');
  -- 16 leds éteintes
  led(9 downto 0) <= (others => '0');
  
	divClk : diviseurClk 
		generic map (facteur => 100000000)
		port map (mclk,not btnC,my_clk);
	
	la_fifo : Ip_fifo--			 DIN             WR			RD			  FULL   EMPTY     DATA COUNT
 	  port map (my_clk, btnC,swt(3 downto 0),swt(15),swt(14),cpt,led(15),led(14), led(13 downto 10));
	
	dec7 : dec7seg
		port map (cpt, ssg);
			
  

end synthesis;
