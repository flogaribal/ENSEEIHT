----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:56:19 02/28/2017 
-- Design Name: 
-- Module Name:    mux4to1 - Behavioral 
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

entity mux4to1 is
    Port ( e0 : in  STD_LOGIC;
           e1 : in  STD_LOGIC;
           e2 : in  STD_LOGIC;
           e3 : in  STD_LOGIC;
           sel : in  STD_LOGIC_VECTOR (1 downto 0);
           s : out  STD_LOGIC);
end mux4to1;

architecture Behavioral of mux4to1 is

begin

process (sel,e0,e1,e2,e3)
begin
   case sel is
      when "00" => s <= e0;
      when "01" => s <= e1;
      when "10" => s <= e2;
      when "11" => s <= e3;
      when others => s <= e0;
   end case;
end process;

end Behavioral;

