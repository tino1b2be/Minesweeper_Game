package Source;

/**
 * Class to print the game's grid in the console
 * 
 * @author user
 *
 */
public class GridUtil {

	public GridUtil(){}
	
	/**
	 * Method to print the grid in the console
	 * 
	 * @param grid - Grid to be printed in the console
	 */
	public static void consolePrintAll(MineGrid grid){
		String format = "%-3s";
		
		System.out.print("   ");
		for (int i = 0; i < grid.getWidth(); i++){						//loop to print the column numbers
			System.out.print(String.format(format, i));
		}
		System.out.println();
		for (int row = 0; row < grid.getWidth(); row++){				//loop to print the grid contents
			System.out.print(String.format(format, row));								//printing the row number
			for (int col = 0; col < grid.getWidth(); col++){
				if (grid.getCell(row, col).hasMine()) {					//if the cell has a mine print a "#" else print a "."
					System.out.print(String.format(format, "#"));
				}
				else if (grid.getCell(row, col).getNeighbouringMines() == 0){
					System.out.print(String.format(format, "."));
				}
				else {
					System.out.print(String.format(format, grid.getCell(row,col).getNeighbouringMines()));
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Method to print the grid as it would apear for a normal gameplay
	 * 
	 * @param grid - Grid to be processed and printed
	 */
	public static void consolePrintGame(MineGrid grid) {
		// TODO Implement method to print the game in gameplay mode
		
	}

	/**
	 * Method to perform a left click on the grid
	 * 
	 * @param newGrid - Grid to be processed
	 * @param row - The row number in the grid
	 * @param col - The column number in the grid
	 * 
	 */
	public static void leftClick(MineGrid newGrid, int row, int col) {
		// TODO Implement the left click for the game
		
	}
}
