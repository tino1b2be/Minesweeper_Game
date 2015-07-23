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
				MineCell cell = grid.getCell(row, col);
				if (cell.hasMine()) {					//if the cell has a mine print a "#" else print a "."
					System.out.print(String.format(format, "#"));
				}
				else if (cell.getNeighbouringMines() == 0){
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
	 * Method to print the grid as it would appear for a normal gameplay
	 * 
	 * @param grid - Grid to be processed and printed
	 */
	public static void consolePrintGame(MineGrid grid) {

		String format = "%-3s";
		
		System.out.print("   ");
		for (int i = 0; i < grid.getWidth(); i++){						//loop to print the column numbers
			System.out.print(String.format(format, i));
		}
		System.out.println();
		for (int row = 0; row < grid.getWidth(); row++){				//loop to print the grid contents
			System.out.print(String.format(format, row));								//printing the row number
			for (int col = 0; col < grid.getWidth(); col++){
				MineCell cell = grid.getCell(row, col);
				
				if (cell.isVisible() && cell.getNeighbouringMines() == 0){
					System.out.print(String.format(format, "~"));
				}
				else if (cell.isVisible()){
					System.out.print(String.format(format, grid.getCell(row,col).getNeighbouringMines()));
				}
				else{
					System.out.print(String.format(format, "."));
				}
			}
			System.out.println();
		}
		System.out.println();
		
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
		
		/* Need to check: 
		 * (a) if the cell has a mine first, if so, game is over and all mines are revealed
		 * (b) if the cell is next to a mine, just reveal the number of mines adjacent to it,
		 * 		i.e, if neighbouring mines is not equal to one, set visibility of cell to true
		 * (c) if the cell has no adjacent mines then recursively check and neighbouring cells
		 * 		until you get to a cell with a number greater than one. 
		 */
		
		// TODO implement (a)
		
		if(newGrid.getCell(row, col).hasMine()){
			newGrid.getCell(row, col).setClicked();
			newGrid.setLoseStatus(true);
		}
			
		// TODO implement (b)
		
		
		// TODO implement (c)
		
		
		//+++++++++
		
		newGrid.getCell(row, col).setVisibility(true);
	}

	/**
	 * Method to print the game when the game has ended
	 * 
	 * @param grid : Grid to be printed.
	 */
	public static void consolePrintGameOver(MineGrid grid) {

		/*
		 * @ - successfully flagged mine
		 * X - unsuccessfully flagged mine
		 * . - not clicked
		 * # - mine not flagged or clicked
		 * ~ - clicked and revealed but not adjacent to a mine
		 * 'number' - number of neighbouring mines
		 */
		String format = "%-3s";
		
		System.out.print("``````-------Game Over!!!-------``````\n   ");
		for (int i = 0; i < grid.getWidth(); i++){												//loop to print the column numbers
			System.out.print(String.format(format, i));
		}
		System.out.println();
		for (int row = 0; row < grid.getWidth(); row++){										//loop to print the grid contents
			System.out.print(String.format(format, row));										//printing the row number
			for (int col = 0; col < grid.getWidth(); col++){
				MineCell cell = grid.getCell(row, col);
				if(cell.hasMine() && cell.isFlagged()){							// if its flagged and has a mine
					System.out.print(String.format(format, "@"));
				}
				else if (!cell.hasMine() && cell.isFlagged()) {					//if its flagged but does not have a mine
					System.out.print(String.format(format, "X"));
				}
				else if (cell.hasMine() && cell.isClicked()) {					//if its flagged but does not have a mine
					System.out.print(String.format(format, "X"));
				}
				else if (cell.hasMine()){
					System.out.print(String.format(format, "#"));
				}
				else if (cell.isVisible() && cell.getNeighbouringMines() == 0){	// if its visible and has neighbouring mines
					System.out.print(String.format(format, "~"));
				}
				else if (cell.isVisible()){
					System.out.print(String.format(format, grid.getCell(row,col).getNeighbouringMines()));			// if its visible with no neighbouring mines
				}
				else{
					System.out.print(String.format(format, "."));													// if its not visible
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean checkWon(MineGrid newGrid) {
		// TODO Implement method to check if the grid has won.
		return false;
	}
}
