package Source;

/**
 * 
 * @author Tinotenda Chemvura @tino1b2be
 *
 */
public class MineGrid {
	
	private MineCell[][] grid;		// 2D array for the mine sweeper grid
	
	/**
	 * Default constructor for the minesweeper grid. initiates a "beginner grid
	 */
	public MineGrid(){
		
	}
	
	/**
	 * Constructor that initiates the grid according to the size given as the argument 
	 * @param size - 
	 * @param numMines - number of mines to be put in the grid
	 */
	public MineGrid(int size, int numMines){
		
		initiateGrid(size);
		setMines(numMines);
	}

	/**
	 * method to put mines in random spots in the grid
	 * 
	 * @param numMines
	 */
	private void setMines(int numMines) {
		
		for (int i = 0; i < numMines; i++){
			
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
	 * Method to return a random integer between two numbers
	 * 
	 * @param low
	 * @param high
	 * @return
	 */
	private int getRandomInt(int low, int high){
		
		return 0;
	}
}
