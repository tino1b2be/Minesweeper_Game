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
	private boolean visibility = false;
	private boolean mineClicked = false;
	private boolean flagged = false; //TODO

	
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

	/**
	 * Method to set the visibility of the cell
	 * @param status
	 */
	public void setVisibility(boolean status){
		this.visibility = status;
	}
	
	/**
	 * Check to see if the cell is visible
	 * @return visibility status of the cell
	 */
	public boolean isVisible(){
		return this.visibility;
	}
	
	
	public void mineClicked(){
		this.mineClicked = true;
	}
	
	public boolean isClicked(){
		return mineClicked;
	}
	
	public String toString(){
		return mineStatus ? "Yes" : "NO";// + "Neighbouring Mines: " + numNeighbouringMines;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setClicked() {
		this.mineClicked = true;
	}
}
