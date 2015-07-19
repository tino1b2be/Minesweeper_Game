package Source;

/**
 * Class for the mine object
 * 
 * @author Tinotenda Chemvura @tino1b2be
 *
 */
public class MineCell {

	private boolean mineStatus;

	public MineCell(){
		
	}
	
	/**
	 * function
	 * @return
	 */
	public boolean hasMine() {
		return mineStatus;
	}

	/**
	 * function to set the mine status of this cell
	 * @param mineStatus
	 */
	public void setMineStatus(boolean mineStatus) {
		this.mineStatus = mineStatus;
	}

}
