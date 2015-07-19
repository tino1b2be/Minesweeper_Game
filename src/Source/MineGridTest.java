package Source;

import static org.junit.Assert.*;

import org.junit.Test;

public class MineGridTest {

	@Test
	/**
	 * Test for set mines method
	 */
	public void numberOfMinesTest() {
		MineGrid grid = new MineGrid(100, 5000);
		int numMines = 0;
		
		for (int i = 0; i < 100; i++){
			for (int j = 0; j < 100; j++){
				if (grid.getCell(i, j).hasMine())
					numMines++;
			}
		}
		
		assertEquals(5000, numMines);
	}

}
