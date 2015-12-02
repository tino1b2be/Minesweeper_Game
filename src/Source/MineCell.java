/** Copyright (C) 2015 Tinotenda Chemvura
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation; either version 2 of the License, or 
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along 
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package Source;

/**
 * Class for the mine object
 * 
 * @author Tinotenda Chemvura @tino1b2be
 *
 */
public class MineCell {

	private boolean mineStatus = false;
	private int numNeighbouringMines = 0;		// Number showing the number of mines around this Cell
	private boolean visibility = false;			// This is the visibility status of this cell
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

	/**
	 * Method to check if this cell has any neighbouring mines.
	 * @return true if it has neigbouring mines
	 */
	public boolean hasNeighbouringMines() {
		return numNeighbouringMines == 0;
	}
}
