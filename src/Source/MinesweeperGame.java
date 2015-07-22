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
		MineGrid newGrid = new MineGrid(10, 10);
		GridUtil.consolePrintAll(newGrid);
		GridUtil.consolePrintGame(newGrid);
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.println("Please enter the coodinates seperated by a comma:");
			String input;
			String[] input2;
			do{
				input = sc.nextLine();
				input2 = input.split(",");
				if (input2.length == 2)
					break;
				else
					System.out.println("Please enter the coordinates correctly (e.g \"0,6\")");
			}while(true);
			
			int row = Integer.parseInt(input2[0]);
			int col = Integer.parseInt(input2[1]);
			
			GridUtil.leftClick(newGrid, row, col);
			GridUtil.consolePrintGame(newGrid);
			
		}while(true);
	}
}
