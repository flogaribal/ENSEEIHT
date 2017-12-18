library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_arith.all;
use IEEE.std_logic_unsigned.all;

entity Nexys4 is
  port (
    
    swt 			: in std_logic_vector (15 downto 0);-- les 16 switchs
    an 				: out std_logic_vector (7 downto 0);-- les anodes pour sélectionner l'afficheur 7 segments
    ssg 			: out std_logic_vector (7 downto 0);-- afficheur 7 segments (point décimal compris, segment 7)
    mclk 			: in std_logic;							-- Horloge
	 miso 			: in std_logic;						   -- Miso
    btnC, btnU, btnL, btnR, btnD : in std_logic;   -- les 5 boutons noirs
    led 			: out std_logic_vector (15 downto 0);-- les 16 leds
	 mosi 			: out std_logic; 							-- Mosi
	 SS 			: out std_logic;
	 sclk 			: out std_logic
  );
end Nexys4;

architecture synthesis of Nexys4 is
	component MasterJoystick is
		 Port (   clk 		: in   STD_LOGIC;
				  reset 	: in   STD_LOGIC;
				  miso 		: in   STD_LOGIC;
				  en 		: in   STD_LOGIC;
				  led 		: in 	 STD_LOGIC_VECTOR(1 downto 0);
				  busy 		: out  STD_LOGIC;
				  sclk 		: out  STD_LOGIC;
				  x_axis 	: out  STD_LOGIC_VECTOR ( 9 downto 0);
				  y_axis 	: out  STD_LOGIC_VECTOR ( 9 downto 0);
				  buttons	: out  STD_LOGIC_VECTOR ( 2 downto 0);
				  mosi 		: out  STD_LOGIC;
				  SS 		: out  STD_LOGIC);
	end component;
	
	component all7segments
		 Port  (	clk 	: in  std_logic;
					reset : in  std_logic;
					e0 	: in  std_logic_vector(3 downto 0);
					e1 	: in  std_logic_vector(3 downto 0);
					e2 	: in  std_logic_vector(3 downto 0);
					e3 	: in  std_logic_vector(3 downto 0);
					e4 	: in  std_logic_vector(3 downto 0);
					e5 	: in  std_logic_vector(3 downto 0);
					e6 	: in  std_logic_vector(3 downto 0);
					e7 	: in  std_logic_vector(3 downto 0);          
					an 	: out std_logic_vector(7 downto 0);
					ssg 	: out std_logic_vector(7 downto 0));
	end component;
	
	component diviseurClk
		  Generic(facteur : natural);
		  Port ( clk, reset : in  std_logic;
					nclk       : out std_logic);
   end component;
	
	signal x_axis : STD_LOGIC_VECTOR(9 downto 0);
	signal y_axis : STD_LOGIC_VECTOR(9 downto 0);
	signal my_clk : STD_LOGIC;
	signal tmp_x  : STD_LOGIC_VECTOR(3 downto 0);
	signal tmp_y  : STD_LOGIC_VECTOR(3 downto 0);
begin

	  -- convention afficheur 7 segments 0 => allumé, 1 => éteint
	  --ssg <= (others => '1');
	  -- aucun afficheur sélectionné
	  --an(7 downto 0) <= (others => '1');
	  -- 16 leds éteintes
	  led(14 downto 3) <= (others => '0');
	
	  divClk : diviseurClk
				generic map (50)
				port map (mclk, not(btnC), my_clk);

	  
	  joystick: MasterJoystick
	  --                       reset	             en          led         busy		                     buttons
				port map(my_clk, not(btnC), miso,swt(15),swt(1 downto 0),led(15),sclk,x_axis,y_axis,led(2 downto 0),mosi, SS);
    
	 tmp_x <= "00" & x_axis(9 downto 8);
	 tmp_y <= "00" & y_axis(9 downto 8);
	 
	  Inst_All7Segments: All7Segments 
	  --                               e0                  e1               e2     e3    
				port map(mclk,not(btnC),x_axis(3 downto 0),x_axis(7 downto 4),tmp_x,"0000",
	  -- 						e4                  e5            e6    e7
						y_axis(3 downto 0),y_axis(7 downto 4),tmp_y,"0000",an,ssg); 
	
  
end synthesis;
