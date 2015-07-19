package Source;

import java.util.Random;

/**
 * 
 * @author Tinotenda Chemvura @tino1b2be
 *
 */
public class MineGrid {
	
	private MineCell[][] grid;		// 2D array for the mine sweeper grid
	private int numMines;
	
	/**
	 * Default constructor for the minesweeper grid. initiates a "beginner" grid if called
	 */
	public MineGrid(){
		
	}
	
	/**
	 * Constructor that initiates the grid according to the size given as the argument
	 * @param size - width of the square grid for the game
	 * @param numMines - number of mines to be put in the grid
	 */
	public MineGrid(int size, int numMines){
		this.numMines = numMines;
		initiateGrid(size);					//create a grid with empty MineCell objects
		setMines(numMines);					//randomly add mines to the grid
		setNeighbouringMinesNumbers();		//method to set the number of mines next to each cell for each cell
	}

	/**
	 * Method to set the number of mines around each cell for each cell in the grid
	 */
	private void setNeighbouringMinesNumbers() {
		// TODO implement this method to set number of neighbouring cells
		
	}

	/**
	 * method to put mines in random spots in the grid
	 * 
	 * @param numMines
	 */
	private void setMines(int numMines) {
		
		for (int i = 0; i < numMines; i++){
			
			int row, column;
			do{
				
			row = getRandomInt(0, grid.length - 1);				//these two variables are random number between 0 and the length of the grid
			column = getRandomInt(0, grid.length - 1);			//and will be used to access a random cell in the grid
			
			if (grid[row][column].hasMine())
				continue;
			else
				break;
				
			}while(true);
			
			grid[row][column].setMineStatus(true);					//this cell is set to have a mine
		}
		
	}

	/**
	 * Method to create a grid with empty MineCell objects
	 * 
	 * @param size - width of the square grid
	 */
	private void initiateGrid(int size) {
		
		grid = new MineCell[size][size];
		
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				grid[i][j] = new MineCell();
			}
		}
		
	}//end of initiate grid function

	/**
	 * Method to return a random integer between two numbers (inclusive)
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	private int getRandomInt(int min, int max){
		Random rand = new Random();
	    // Random.nextInt excludes the top value so we have to add 1 to include the top value
	    return rand.nextInt((max - min) + 1) + min;
	}

	
	/**
	 * Returns the width of the grid
	 * @return
	 */
	public int getWidth() {
		return grid.length;
	}

	/**
	 * Getter method for the number of mines in this grid
	 * @return
	 */
	public int getNumMines(){
		return this.numMines;
	}

	/**
	 * Method to return the mine cell at the given coordinates
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public MineCell getCell(int row, int col) {
		return new MineCell(grid[row][col]);
	}
}
