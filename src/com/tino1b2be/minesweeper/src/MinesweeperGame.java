/** Copyright (C) 2015 Tinotenda Chemvura
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation; either version 3 of the License, or 
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along 
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package com.tino1b2be.minesweeper.src;

import java.util.Scanner;

/**
 * Main class with the main function and launches the game
 * 
 * @author Tinotenda Chemvura @tino1b2be
 *
 */
public class MinesweeperGame {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		MineGrid newGrid = null;
		String[] gameSettings;
		if(args.length == 0){
			System.out.println("Welcome to Minesweeper in the console please enter size of grid (width)"
					+ " and the number of mines (seperated by a comma):");
			do{
				gameSettings = sc.nextLine().split(",");
				if (gameSettings.length !=2){
					gameSettings = new String[]{"10","10"};
					newGrid = new MineGrid(Integer.parseInt(gameSettings[0]), Integer.parseInt(gameSettings[1]));
					
				}
				if (gameSettings.length == 2){
					newGrid = new MineGrid(Integer.parseInt(gameSettings[0]), Integer.parseInt(gameSettings[1]));
					break;
				}
				else{
					System.out.println();
				}
			}while(true);
		}
		else if (args.length == 2){
			gameSettings = args;
			newGrid = new MineGrid(Integer.parseInt(gameSettings[0]), Integer.parseInt(gameSettings[1]));
		}
		else{
			gameSettings = new String[]{"10","10"};
			newGrid = new MineGrid(Integer.parseInt(gameSettings[0]), Integer.parseInt(gameSettings[1]));
		}
		
		GridUtil.consolePrintAll(newGrid);
		GridUtil.consolePrintGame(newGrid);
		
		//Game Play
		do{
			System.out.println("Type \"L\" for a left click or \"R\" for a right click: ");
			String clickType;
			do{
				clickType = sc.nextLine().toLowerCase();
				if(!clickType.equals("l") || !clickType.equals("r"))
					break;
				System.out.println("Please try again.\nType \"L\" for a left click or \"R\" for a right click: ");
			}while(true);
			
			if (clickType.equals("l")){
				System.out.println("Please enter the coodinates seperated by a comma:");
				String input[];
				do{
					input = sc.nextLine().split(",");
					if (input.length == 2)
						break;
					else
						System.out.println("Please enter the coordinates correctly (e.g \"0,6\")");
					
				}while(true);
				
				int row = Integer.parseInt(input[0]);
				int col = Integer.parseInt(input[1]);
				
				GridUtil.leftClick(newGrid, row, col);
				
				if(newGrid.hasLost()){
					System.out.println("\nSORRY YOU JUST HIT A MINE!\n");
					GridUtil.consolePrintGameOver(newGrid);
					System.exit(0);
					//TODO write code to start a new game
				}
				else if (newGrid.hasWon()){
					GridUtil.consolePrintGameOver(newGrid);
				}
	
				GridUtil.consolePrintGame(newGrid);
				}
			
			else if (clickType.equals("r")){
				//TODO implement the right click
			}
		}while(true);
	}
}
