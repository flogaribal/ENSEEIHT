----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    11:17:55 03/09/2017 
-- Design Name: 
-- Module Name:    masterSum - Behavioral 
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

entity MasterSum is
    Port ( en 		: in  STD_LOGIC;
           clk 	: in  STD_LOGIC;
           reset 	: in  STD_LOGIC;
           miso 	: in  STD_LOGIC;
           e1 		: in  STD_LOGIC_VECTOR (7 downto 0);
           e2 		: in  STD_LOGIC_VECTOR (7 downto 0);
           carry 	: out  STD_LOGIC;
           busy 	: out  STD_LOGIC;
           sclk 	: out  STD_LOGIC;
           mosi 	: out  STD_LOGIC;
           SS 		: out  STD_LOGIC;
           sum		: out  STD_LOGIC_VECTOR (7 downto 0));
end MasterSum;

architecture archMasterSum of MasterSum is
	
	-- Constantes
   constant clk_period : time := 10 ns;
	
	-- Composants utilisés 
	component er_1octet is
    port ( en 		: in  STD_LOGIC;
           din 	: in  STD_LOGIC_VECTOR (7 downto 0);
           miso 	: in  STD_LOGIC;
           clk 	: in  STD_LOGIC;
           reset 	: in  STD_LOGIC;
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
			carry 			<= '0';
			cptOctet 		:= 1;
			dureeAttente 	:= 0;
			en_er1octet 	<= '0';
			sum 				<= (others => '0');
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
						
						-- Chargement de l'attente à 5 
						dureeAttente := 5;
						
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
								-- Envoi de la donnée e1 à l'échangeur 1 octet
								dataToEr <= e1;	
							else 
								-- Envoi de la donnée e2 à l'échangeur 1 octet
								dataToEr <= e2;	
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
								-- Après la fin de la transmission récéption de la 
								-- somme précédente
								sum <= dataFromEr;
								
								-- Chargement de l'attente à 2 
								dureeAttente := 2;
								
								etat <= AttenteXPeriod;
								
								-- Incrémentation du numéro de l'octet
								cptOctet := cptOctet + 1;
							
						elsif (cptOctet = 2) then 
								-- Après la fin de la transmission récéption de la 
								-- carry précédente
								carry <= dataFromEr(0);
								
								-- Transmission terminée
								SS <= '1';
								busy <= '0';
								
								etat <= AttenteOrdre;
								
								-- Incrémentation du numéro de l'octet
								cptOctet := cptOctet + 1;
						end if;
					end if;
			end case;							
		end if;
	end process;

end archMasterSum;

