package Source;

/**
 * Class for the mine object
 * 
 * @author Tinotenda Chemvura @tino1b2be
 *
 */
public class MineCell {

	private boolean mineStatus = false;
	private int numNeighbouringMines = 0;

	
	/**
	 * Default constructor for the MineCell object
	 */
	public MineCell() {

	}

	/**
	 * Copy constructor for Mine Cell
	 * @param mineCell
	 */
	public MineCell(MineCell mineCell) {
		this.mineStatus = mineCell.hasMine();
		this.numNeighbouringMines = mineCell.getNeighbouringMines();
	}

	/**
	 * Getter method for the number of neighbouring mines next to this cell
	 * 
	 * @return
	 */
	public int getNeighbouringMines() {
		return numNeighbouringMines;
	}

	/**
	 * setter method for the number of mines around this cell
	 * 
	 * @param mines
	 */
	public void setNeighbouringMines(int mines) {
		this.numNeighbouringMines = mines;
	}

	/**
	 * function to check if this cell has a mine in it
	 * 
	 * @return
	 */
	public boolean hasMine() {
		return mineStatus;
	}

	/**
	 * function to set the mine status of this cell
	 * 
	 * @param mineStatus
	 */
	public void setMineStatus(boolean mineStatus) {
		this.mineStatus = mineStatus;
	}

	public String toString(){
		return mineStatus ? "Yes" : "NO";// + "Neighbouring Mines: " + numNeighbouringMines;
	}
}
