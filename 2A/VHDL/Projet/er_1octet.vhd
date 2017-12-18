----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    10:22:14 03/09/2017 
-- Design Name: 
-- Module Name:    er_1octet - Behavioral 
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

entity er_1octet is
    Port ( en 		: in  STD_LOGIC;
           din 	: in  STD_LOGIC_VECTOR (7 downto 0);
           miso 	: in  STD_LOGIC;
           clk 	: in  STD_LOGIC;
           reset 	: in  STD_LOGIC;
           dout 	: out  STD_LOGIC_VECTOR (7 downto 0);
           busy 	: out  STD_LOGIC;
           sclk 	: out  STD_LOGIC;
           mosi 	: out  STD_LOGIC);
end er_1octet;

architecture arch_er_1octet of er_1octet is

	-- Constantes
	
	-- Type etat permettant de définir les états possibles de l'automate
	type t_etat is (Attente,Envoi,Reception);
	
	-- Signaux
	signal etat : t_etat;

begin
	p_etat: process(clk,reset)
		variable cpt 			: natural;
		variable registre 	: std_logic_vector(7 downto 0);
		
	begin
		if (reset = '0') then
			etat <= Attente;
			busy <= '0';
			dout <= (others => '0');
			sclk <= '0';
			mosi <= '0';
			
		elsif (rising_edge(clk)) then
			case etat is 
				when Attente =>
					if (en = '1') then
						etat <= Reception;
						busy <= '1';
						cpt := 7;
						registre := din; 
						mosi <= registre(cpt);
					end if;
					
				when Reception =>
					registre(cpt) := miso;
					sclk <= '1';
					etat <= Envoi;
				
				when Envoi => 
					if (cpt > 0) then
						cpt := cpt - 1;
						mosi <= registre(cpt);
						etat <= Reception;
						
					elsif (cpt = 0) then
						busy <= '0';
						dout <= registre;
						etat <= Attente;
					end if;
					sclk <= '0';
			end case;
		end if;
	end process;
end arch_er_1octet;

