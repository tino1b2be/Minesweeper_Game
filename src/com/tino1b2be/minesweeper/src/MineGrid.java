/** Copyright (C) 2015 Tinotenda Chemvura
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation; either version 3 of the License, or 
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
package com.tino1b2be.minesweeper.src;

import java.util.Random;

/**
 * 
 * @author Tinotenda Chemvura @tino1b2be
 *
 */
public class MineGrid {
	
	private MineCell[][] grid;				// 2D array for the mine sweeper grid
	private int numMines;					// Number of mines in the grid
	private boolean loseStatus = false;		// the lose status of the game
	
	/**
	 * Default constructor for the minesweeper grid. initiates a "beginner" grid if called
	 */
	public MineGrid(){
		this.numMines = 10;
		initiateGrid(10);
		setMines(10);
		setNeighbouringMinesNumbers();
	}
	
	/**
	 * Constructor that initiates the grid according to the size given as the argument
	 * 
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
		
		for (int row = 0; row < grid.length; row++){
			for (int col = 0; col < grid.length; col++){
				
				int mines = 0;
				
				if (row!=0){ 										//check the top if it is not the top row
					if(grid[row-1][col].hasMine())
						mines++;
				}
				if (row!=grid.length-1){							//check the bottom if it is not in bottom row
					if(grid[row+1][col].hasMine())
						mines++;
				}
				if (col!=0){ 										//check the left if it is not in the left column
					if (grid[row][col-1].hasMine())
						mines++;
				}
				if (col!=grid.length - 1){							//check the right if it is not in the right column
					if (grid[row][col+1].hasMine())
						mines++;
				}
				
				if (col!=grid.length - 1 && row!=0){				// Check top right corner is the cell is not in right column and top row
					if (grid[row - 1][col + 1].hasMine())
						mines++;
				}
				
				if (col!=0 && row!=0){								//Check top left corner if it is not in left column and not in top row
					if (grid[row-1][col-1].hasMine())
						mines++;
				}
				
				if (col!=grid.length - 1 && row!=grid.length-1){	//Check bottom right corner if it is not in right column and not in bottom row
					if (grid[row + 1][col + 1].hasMine())
						mines++;
				}
				
				if (col!=0 && row!=grid.length-1){					//Check bottom left corner if it is not in left column and bottom row 
					if (grid[row + 1][col - 1].hasMine())
						mines++;
				}
				
				grid[row][col].setNeighbouringMines(mines);
			}
		}
	}//end of set number of mines method

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
			if (grid[row][column].hasMine())					//check if the randomly generated cell already has a mine. if it does, generate another random position
				continue;
			else
				break;
			
			}while(true);
			
			grid[row][column].setMineStatus(true);				//this cell is set to have a mine
		}
	}//End of setMines method

	/**
	 * Method to create a grid with empty MineCell objects
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
	 * @param min - lower limit of the range
	 * @param max - upper limit of the range
	 * @return A random integer between min and max
	 */
	private int getRandomInt(int min, int max){
		Random rand = new Random();
	    // Random.nextInt excludes the top value so we have to add 1 to include the top value
	    return rand.nextInt((max - min) + 1) + min;
	}

	/**
	 * 	Method to return the width of the grid
	 * @return Width of the grid
	 */
	
	public int getWidth() {
		return grid.length;
	}

	/**
	 * Getter method for the number of mines in this grid
	 * @return Number of mines in the grid
	 */
	public int getNumMines(){
		return this.numMines;
	}

	/**
	 * Method to return the mine cell at the given coordinates
	 * 
	 * @param row - Row of the grid 
	 * @param col - Column of the grid
	 * @return a reference to a COPY of the MineCell object at the given location [row][col]
	 */
	public MineCell getCellCopy(int row, int col) {
		return new MineCell(grid[row][col]);
	}
	
	/**
	 * Method to return the address to a cell in the grid
	 * 
	 * @param row - Row of the cell
	 * @param col - Column of the Grid
	 * @return An address of the MineCell object in the grid (NOT A COPY), use getCellCopy() for a copy
	 */
	public MineCell getCell(int row, int col) {
		return grid[row][col];
	}

	/**
	 * Method to set the lose status of the game
	 * @param status
	 */
	public void setLoseStatus(boolean status){
		this.loseStatus = true;
	}
	
	/**
	 * Method to check if the game has lost
	 * @return
	 */
	public boolean hasLost(){
		return this.loseStatus;
	}
		
	/**
	 * Method to check if the
	 * @return
	 */
	public boolean hasWon() {
		return GridUtil.checkWon(this);
	}
}
