--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   10:31:02 03/09/2017
-- Design Name:   
-- Module Name:   /home/fgaribal/Documents/2A/S8/VHDL/Projet/test_er_1octet.vhd
-- Project Name:  Projet
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: er_1octet
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
 
ENTITY test_er_1octet IS
END test_er_1octet;
 
ARCHITECTURE behavior OF test_er_1octet IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT er_1octet
    PORT(
         en 		: IN  std_logic;
         din 		: IN  std_logic_vector(7 downto 0);
         miso 		: IN  std_logic;
         clk 		: IN  std_logic;
         reset 	: IN  std_logic;
         dout 		: OUT  std_logic_vector(7 downto 0);
         busy 		: OUT  std_logic;
         sclk 		: OUT  std_logic;
         mosi 		: OUT  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal en 		: std_logic := '0';
   signal din 		: std_logic_vector(7 downto 0) := (others => '0');
   signal miso 	: std_logic := '0';
   signal clk 		: std_logic := '0';
   signal reset 	: std_logic := '0';

 	--Outputs
   signal dout : std_logic_vector(7 downto 0);
   signal busy : std_logic;
   signal sclk : std_logic;
   signal mosi : std_logic;

   -- Clock period definitions
   constant clk_period : time := 10 ns;
   constant sclk_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: er_1octet PORT MAP (
          en 		=> en,
          din 		=> din,
          miso 	=> miso,
          clk 		=> clk,
          reset 	=> reset,
          dout 	=> dout,
          busy 	=> busy,
          sclk 	=> sclk,
          mosi 	=> mosi
        );

   -- Clock process definitions
   clk_process :process
   begin
		clk <= '0';
		wait for clk_period/2;
		clk <= '1';
		wait for clk_period/2;
   end process;
 	
	cmd_en: process 
	begin 
	
		reset <= '0';
		wait for clk_period/2;
		reset <= '1';
		
		-- 1er envoi
		din <= "11111111";
		wait for clk_period;
		en <= '1';
		wait for clk_period*2;
		en <= '0';		
		wait until busy = '0';
		
		-- 2eme envoi
		din <= "00000000";
		wait for clk_period;
		en <= '1';
		wait for clk_period*2;
		en <= '0';		
		wait until busy = '0';
		
		-- 3eme envoi
		din <= "10101010";
		wait for clk_period;
		en <= '1';
		wait for clk_period*2;
		en <= '0';		
		wait until busy = '0';
		
		--
		wait;	
		
	end process;
	
	gen_miso: process (clk)
		variable cpt : natural;
	begin 
		if (rising_edge(clk)) then
			if (cpt mod 4 = 0) then
				miso <= not miso;
			end if;
			cpt := cpt + 1;
		end if;
	end process;

END;
