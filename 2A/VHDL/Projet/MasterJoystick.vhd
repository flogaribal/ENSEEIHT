----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:51:29 03/14/2017 
-- Design Name: 
-- Module Name:    MasterJoystick - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity MasterJoystick is
    Port ( clk 	: in   STD_LOGIC;
           reset 	: in   STD_LOGIC;
           miso 	: in   STD_LOGIC;
           en 		: in   STD_LOGIC;
			  led 	: in 	 STD_LOGIC_VECTOR(1 downto 0);
           busy 	: out  STD_LOGIC;
           sclk 	: out  STD_LOGIC;
			  x_axis : out  STD_LOGIC_VECTOR ( 9 downto 0);
			  y_axis : out  STD_LOGIC_VECTOR ( 9 downto 0);
			  buttons: out  STD_LOGIC_VECTOR ( 2 downto 0);
           mosi 	: out  STD_LOGIC;
           SS 		: out  STD_LOGIC);
end MasterJoystick;

architecture Behavioral of MasterJoystick is
	
	-- Constantes
   constant clk_period : time := 10 ns;
	
	-- Composants utilisés 
	component er_1octet is
    port ( en 		: in   STD_LOGIC;
           din 	: in   STD_LOGIC_VECTOR (7 downto 0);
           miso 	: in   STD_LOGIC;
           clk 	: in   STD_LOGIC;
           reset 	: in   STD_LOGIC;
           dout 	: out  STD_LOGIC_VECTOR (7 downto 0);
           busy 	: out  STD_LOGIC;
           sclk 	: out  STD_LOGIC;
           mosi 	: out  STD_LOGIC);
	end component;
	
	-- Type etat permettant de définir les états possibles de l'automate
	type t_etat is (AttenteOrdre,AttenteXperiod,EchangeX);

	-- Signaux
	signal etat 			: t_etat;
	signal en_er1octet	: STD_LOGIC := '0';
	signal dataToEr		: STD_LOGIC_VECTOR (7 DOWNTO 0) := (others => '0');
	signal dataFromEr		: STD_LOGIC_VECTOR (7 DOWNTO 0) := (others => '0');
	signal busy_er1octet : STD_LOGIC := '0';


begin

	-- Echange opérande
	
	emission1: er_1octet 
	--					    en          din     miso                 dout           busy           sclk  mosi  
			PORT MAP (en_er1octet, dataToEr, miso,    clk,reset,dataFromEr,      busy_er1octet, sclk, mosi);


	master: process(clk,reset)
		-- Variables
		variable dureeAttente	: natural ;
		variable cptOctet			: natural ;

	begin
		if (reset = '0') then
			SS 				<= '1';		
			busy 				<= '0';
			cptOctet 		:= 1;
			dureeAttente 	:= 0;
			x_axis 			<= (others => '0');			
			y_axis 			<= (others => '0');			
			buttons 			<= (others => '0');			
			en_er1octet 	<= '0';
			dataToEr 		<= (others => '0');			
			etat 				<= AttenteOrdre;
			
		elsif (rising_edge(clk)) then
		
			-- Action selon chaque état
			case etat is 
			
				when AttenteOrdre =>
					-- Réception de l'ordre
					if (en = '1') then
												
						-- Init de l'esclave
						SS <= '0';
						busy <= '1';
						
						-- Chargement de l'attente à 30 car 15µs
						dureeAttente := 30;
						
						cptOctet := 1;
						
						etat <= AttenteXPeriod;
					end if;		

					
				
				when AttenteXperiod => 
				
					-- Attente cpt periodes					
					if dureeAttente = 0 then
							
							etat <= EchangeX;
							-- Actionneur de er_1octet
							en_er1octet <= '1';
							if cptOctet = 1 then
								-- Envoi des commandes de LED à l'échangeur 1 octet
								dataToEr <= "100000"&led;	
							else 
								-- Envoi d'une donnée quelconque à l'échangeur 1 octet
								dataToEr <= "00000000";	
							end if;
						-- Remise à zéro de la durée de l'atttente
						dureeAttente := 0;
					end if;
					
					dureeAttente := dureeAttente  - 1;
					
					
							

				when EchangeX =>
					en_er1octet <= '0';	
						
					-- Attente de fin de transmission
					if (busy_er1octet = '0' and en_er1octet = '0') then	
						if (cptOctet = 1) then	
								-- Après la fin de la transmission récéption du 
								-- début de la valeur de l'axe X
								x_axis(7 downto 0) <= dataFromEr;
								
								-- Chargement de l'attente à 20 car µs
								dureeAttente := 20;
								
								etat <= AttenteXPeriod;
								
							
						elsif (cptOctet = 2) then 
								-- Après la fin de la transmission récéption de la 
								-- fin de la valeur de l'axe X
								x_axis(8) <= dataFromEr(0);
								x_axis(9) <= dataFromEr(1);								
								
								-- Chargement de l'attente à 10
								dureeAttente := 20;			
								
								etat <= AttenteXPeriod;								
						
						elsif (cptOctet = 3) then 
								-- Après la fin de la transmission récéption du 
								-- début de la valeur de l'axe Y
								y_axis(7 downto 0) <= dataFromEr;
						
								-- Chargement de l'attente à 10
								dureeAttente := 20;
								etat <= AttenteXPeriod;								
								
						elsif (cptOctet = 4) then 
								-- Après la fin de la transmission récéption de la 
								-- fin de la valeur de l'axe Y
								y_axis(8) <= dataFromEr(0);
								y_axis(9) <= dataFromEr(1);
								
								-- Chargement de l'attente à 10
								dureeAttente := 20;
								etat <= AttenteXPeriod;								
						elsif (cptOctet = 5) then 
								-- Après la fin de la transmission récéption de la 
								-- valeur des boutons
								buttons(0) <= dataFromEr(0);
								buttons(1) <= dataFromEr(1);
								buttons(2) <= dataFromEr(2);								
								
								etat <= AttenteOrdre;
								-- Transmission terminée
								SS <= '1';
								busy <= '0';
								
						end if;
						-- Incrémentation du numéro de l'octet
						cptOctet := cptOctet + 1;
					end if;
			end case;							
		end if;
		
	end process;
	
end Behavioral;

