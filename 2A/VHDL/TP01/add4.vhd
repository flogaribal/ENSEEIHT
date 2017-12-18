----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:10:47 02/06/2017 
-- Design Name: 
-- Module Name:    add4 - Behavioral 
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

entity add4 is
    Port ( A 			: in  STD_LOGIC_VECTOR (3 downto 0);
           sum 		: out  STD_LOGIC_VECTOR (3 downto 0);
           carryOut 	: out  STD_LOGIC;
           carryin 	: in  STD_LOGIC;
           B 			: in  STD_LOGIC_VECTOR (3 downto 0));
end add4;

architecture Behavioral of add4 is

   COMPONENT additionneur
	PORT(
		X 		: IN  std_logic;
		Y 		: IN  std_logic;
		Cin 	: IN  std_logic;          
		S 		: OUT std_logic;
		Cout 	: OUT std_logic
		);
	END COMPONENT;
	
	SIGNAL tmp_Cout : std_logic_vector(2 downto 0);

begin

	Inst_add1_1 : additionneur 
		PORT MAP (
			X => A(0),
			Y => B(0),
			Cin => carryIn,
			S => sum(0),
			Cout => tmp_Cout(0)
		);
		
	Inst_add1_2 : additionneur 
		PORT MAP (
			X => A(1),
			Y => B(1),
			Cin => tmp_Cout(0),
			S => sum(1),
			Cout => tmp_Cout(1)
		);
		
	Inst_add1_3 : additionneur 
		PORT MAP (
			X => A(2),
			Y => B(2),
			Cin => tmp_Cout(1),
			S => sum(2),
			Cout => tmp_Cout(2)
		);
		
	Inst_add1_4 : additionneur 
		PORT MAP (
			X => A(3),
			Y => B(3),
			Cin => tmp_Cout(2),
			S => sum(3),
			Cout => carryOut
		);


end Behavioral;

