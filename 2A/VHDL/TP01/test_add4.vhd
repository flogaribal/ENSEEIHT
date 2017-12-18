--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   17:36:09 02/06/2017
-- Design Name:   
-- Module Name:   /home/fgaribal/Documents/2A/S8/VHDL/TP01/test_add4.vhd
-- Project Name:  add4bits
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: add4
-- 
-- Dependencies:
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
--
-- Notes: 
-- This testbench has been automatically generated using types std_logic and
-- std_logic_vector for the ports of the unit under test.  Xilinx recommends
-- that these types always be used for the top-level I/O of a design in order
-- to guarantee that the testbench will bind correctly to the post-implementation 
-- simulation model.
--------------------------------------------------------------------------------
LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY test_add4 IS
END test_add4;
 
ARCHITECTURE behavior OF test_add4 IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT add4
    PORT(
         A : IN  std_logic_vector(3 downto 0);
         sum : OUT  std_logic_vector(3 downto 0);
         carryOut : OUT  std_logic;
         carryin : IN  std_logic;
         B : IN  std_logic_vector(3 downto 0)
        );
    END COMPONENT;
    

   --Inputs
   signal A : std_logic_vector(3 downto 0) := (others => '0');
   signal carryin : std_logic := '0';
   signal B : std_logic_vector(3 downto 0) := (others => '0');

 	--Outputs
   signal sum : std_logic_vector(3 downto 0);
   signal carryOut : std_logic;
   -- No clocks detected in port list. Replace <clock> below with 
   -- appropriate port name 
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: add4 PORT MAP (
          A => A,
          sum => sum,
          carryOut => carryOut,
          carryin => carryin,
          B => B
        );
		  
	A <= "0000", 
		  "0101" after 100ns, 
		  "0010" after 200ns;
		  
	B <= "1111",
		  "1010" after 100ns,
		  "1000" after 200ns;
		
	carryin <= '0',
				  '1' after 100ns,
				  '0' after 200ns;		  

END;
