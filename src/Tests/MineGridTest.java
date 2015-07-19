package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Source.MineGrid;

public class MineGridTest {

	@Test
	/**
	 * Test for set mines method to check if the number of mines in the game is accurate
	 */
	public void numberOfMinesTest() {
		
		MineGrid grid = new MineGrid(1000, 50000);			//create a new grid of width 1000 and 50 000 mines
		
		int numMines = 0;
		for (int i = 0; i < 1000; i++){
			for (int j = 0; j < 1000; j++){
				if (grid.getCell(i, j).hasMine())
					numMines++;
			}
		}
		
		assertEquals(50000, numMines);						//there should be 50 000 mines in this grid
	}

}
