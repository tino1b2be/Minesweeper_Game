package Source;

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
		MineGrid newGrid;
		
		System.out.println("Welcome to Minesweeper in the console please enter size of grid (width) and the number of mines (seperated by a comma):");
		do{
			
			String[] gameSettings = sc.nextLine().split(",");
			if (gameSettings.length == 2){
				newGrid = new MineGrid(Integer.parseInt(gameSettings[0]), Integer.parseInt(gameSettings[0]));
				break;
			}
			else{
				System.out.println();
			}
		}while(true);
		
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
