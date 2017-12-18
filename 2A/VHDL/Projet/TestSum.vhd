--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   16:18:04 03/14/2017
-- Design Name:   
-- Module Name:   /home/fgaribal/Documents/2A/S8/VHDL/Projet/test_master_sum.vhd
-- Project Name:  Projet
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: masterSum
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
 
ENTITY TestSum IS
END TestSum;
 
ARCHITECTURE behavior OF TestSum IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT MasterSum
    PORT(
         en 		: IN   std_logic;
         clk 		: IN   std_logic;
         reset 	: IN   std_logic;
         miso 		: IN   std_logic;
         e1 		: IN   std_logic_vector(7 downto 0);
         e2 		: IN   std_logic_vector(7 downto 0);
         carry 	: OUT  std_logic;
         busy 		: OUT  std_logic;
         sclk 		: OUT  std_logic;
         mosi 		: OUT  std_logic;
         SS 		: OUT  std_logic;
         sum 		: OUT  std_logic_vector(7 downto 0)
        );
    END COMPONENT;
	 
	 component slave_sum is
			port ( 
				sclk : in  std_logic ;
				mosi : in  std_logic ;
				miso : out std_logic ;
				ss   : in  std_logic
			 );
	end component;
    

   -- Inputs
   signal en 		: std_logic := '0';
   signal clk 		: std_logic := '0';
   signal reset 	: std_logic := '0';
   signal miso 	: std_logic := '0';
   signal e1 		: std_logic_vector(7 downto 0) := (others => '0');
   signal e2 		: std_logic_vector(7 downto 0) := (others => '0');

 	-- Outputs
   signal carry 	: std_logic;
   signal busy 	: std_logic;
   signal sclk 	: std_logic;
   signal mosi 	: std_logic;
   signal SS 		: std_logic;
   signal sum 		: std_logic_vector(7 downto 0);

   -- Clock period definitions
   constant clk_period : time := 10 ns;
   constant sclk_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: MasterSum PORT MAP (
          en => en,
          clk => clk,
          reset => reset,
          miso => miso,
          e1 => e1,
          e2 => e2,
          carry => carry,
          busy => busy,
          sclk => sclk,
          mosi => mosi,
          SS => SS,
          sum => sum
        );
		  
		  
		  
	slave: slave_sum 
			port map (sclk,mosi,miso,SS);
			
			

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
		-- RAZ de tous les signaux
      reset <= '0';
		wait for clk_period/2;
		reset <= '1';
		
		--------------------------------------
		-- Remplissage des opérandes
		e1 <= "00000001";
		e2 <= "00000010";
		wait for clk_period;
		
		-- Lancement de la transmission
		en <= '1';
		wait for clk_period*2;
		en <= '0';
		
		-- Attente de fin de transmission
		wait until busy = '0';
		
		
		--------------------------------------
		-- Remplissage des opérandes
		e1 <= "10000000";
		e2 <= "10000001";
		wait for clk_period;
		
		-- Lancement de la transmission
		en <= '1';
		wait for clk_period*2;
		en <= '0';
		
		-- Attente de fin de transmission
		wait until busy = '0';
		
		
		--------------------------------------
		-- Remplissage des opérandes
		e1 <= "00011000";
		e2 <= "00100100";
		wait for clk_period;
		
		-- Lancement de la transmission
		en <= '1';
		wait for clk_period*2;
		en <= '0';
		
		-- Attente de fin de transmission
		wait until busy = '0';
			
		wait;
   end process;

END;
