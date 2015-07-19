package Source;

/**
 * Class to print the game's grid in the console
 * 
 * @author user
 *
 */
public class DisplayGrid {

	public DisplayGrid(){}
	
	/**
	 * Method to print the grid in the console
	 * @param grid - Grid to be printed in the console
	 */
	public static void consolePrintGrid(MineGrid grid){
		
		System.out.print("   ");
		for (int i = 0; i < grid.getWidth(); i++){				//loop to print the column numbers
			System.out.print(i + "  ");
		}
		System.out.println();
		for (int row = 0; row < grid.getWidth(); row++){				//loop to print the grid contents
			System.out.print(row + "  ");								//printing the row number
			for (int col = 0; col < grid.getWidth(); col++){
				if (grid.getCell(row, col).hasMine())					//if the cell has a mine print a "#" else print a "~"
					System.out.print("#  ");
				else
					System.out.print("-  ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
