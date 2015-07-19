package Source;

/**
 * Main class with the main function and launches the game
 * 
 * @author Tinotenda Chemvura @tino1b2be
 *
 */
public class MinesweeperGame {

	public static void main(String[] args) {
		MineGrid newGrid = new MineGrid(10, 10);
		DisplayGrid.consolePrintGrid(newGrid);
	}
}
