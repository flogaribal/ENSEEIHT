--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   16:38:19 03/07/2017
-- Design Name:   
-- Module Name:   /home/fgaribal/Documents/2A/S8/VHDL/tp5/test_fifo.vhd
-- Project Name:  fifo
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: fifo
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
use IEEE.std_logic_arith.all;
use IEEE.std_logic_unsigned.all;
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY test_fifo IS
END test_fifo;
 
ARCHITECTURE behavior OF test_fifo IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT fifo
    PORT(
         clk : IN  std_logic;
         rst : IN  std_logic;
         din : IN  std_logic_vector(3 downto 0);
         wr_en : IN  std_logic;
         rd_en : IN  std_logic;
         dout : OUT  std_logic_vector(3 downto 0);
         full : OUT  std_logic;
         empty : OUT  std_logic;
         data_count : OUT  std_logic_vector(3 downto 0)
        );
    END COMPONENT;
    

   --Inputs
   signal clk : std_logic := '0';
   signal rst : std_logic := '0';
   signal din : std_logic_vector(3 downto 0) := (others => '0');
   signal wr_en : std_logic := '0';
   signal rd_en : std_logic := '0';

 	--Outputs
   signal dout : std_logic_vector(3 downto 0);
   signal full : std_logic;
   signal empty : std_logic;
   signal data_count : std_logic_vector(3 downto 0);

   -- Clock period definitions
   constant clk_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: fifo PORT MAP (
          clk => clk,
          rst => rst,
          din => din,
          wr_en => wr_en,
          rd_en => rd_en,
          dout => dout,
          full => full,
          empty => empty,
          data_count => data_count
        );

   -- Clock process definitions
   clk_process :process
   begin
	
		clk <= '0';
		wait for clk_period/2;
		clk <= '1';
		wait for clk_period/2;
   end process;
 

   -- Stimulus process
   stim_proc: process
   begin
		rst <= '1';
		wait for clk_period/2;
		rst <= '0';
		
		wr_en <= '1';
		wait for 20*clk_period;
		wr_en <= '0';
		wait for clk_period;
		rd_en <= '1';
		wait for 20*clk_period;
 	   wait;
   end process;
	
	process (clk)
	begin
		if (falling_edge(clk)) then
			din <= din + 3;
		end if;
	end process;
END;
