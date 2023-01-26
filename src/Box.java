public class Box {
	private int row;
	private int column;
	private String placeHolder;
	
	/*
	 * Box parameterized constructor
	 * 
	 * Purpose: This parameterized constructor initializes the box's row position, column position, and
	 * place holder within a mini board.
	 * 
	 * Parameters: The board's row position, column position, and place holder are passed into this method.
	 * 
	 * Return Value: Nothing is returned from a constructor.
	 */
	
	public Box(int row, int column, String placeHolder) {
		this.setRow(row);
		this.setColumn(column);
		this.setPlaceHolder(placeHolder);
	}
	
	/*
	 * getRow method
	 * 
	 * Purpose: The getRow method is an accessor that fetches the box's row position within a mini board.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The box's row position within the mini board is returned.
	 */
	
	public int getRow() {
		return this.row;
	}
	
	/*
	 * setRow method
	 * 
	 * Purpose: The setRow method is a mutator that modifies the box's row position within a mini board.
	 * 
	 * Parameter: The box's row position within the mini board is passed into this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setRow(int row) {
		this.row = row;
	}
	
	/*
	 * getColumn method
	 * 
	 * Purpose: The getColumn method is an accessor that fetches the box's column position within a mini board.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The box's column position within the mini board is returned.
	 */
	
	public int getColumn() {
		return this.column;
	}
	
	/*
	 * setColumn method
	 * 
	 * Purpose: The setColumn method is a mutator that modifies the box's column position within a mini board.
	 * 
	 * Parameter: The box's column position within the mini board is passed into this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	/*
	 * getPlaceHolder method
	 * 
	 * Purpose: The getPlaceHolder method is an accessor that fetches the box's place holder.
	 * 
	 * Parameters: There are no paramters to this method.
	 * 
	 * Return Value: The box's place holder is returned.
	 */
	
	public String getPlaceHolder() {
		return this.placeHolder;
	}
	
	/*
	 * setPlaceHolder method
	 * 
	 * Purpose: The setPlaceHolder method is a mutator that modifies the box's place holder.
	 * 
	 * Parameter: The box's place holder is passed into this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public boolean setPlaceHolder(String placeHolder) {
		if(this.placeHolder == null || this.isAvailable()) {
			this.placeHolder = placeHolder;
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * isAvailable method
	 * 
	 * Purpose: The isAvailable method checks if the box is available to be played on by a player during the
	 * ultimate TTT game.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The box's availability status (true or false) is returned.
	 */
	
	public boolean isAvailable() {
		return !placeHolder.equals("X") && !placeHolder.equals("O");
	}
	
	/*
	 * print method
	 * 
	 * Purpose: The print method outputs the box format to the console.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void print() {
		System.out.print(" | " + placeHolder + " |");
	}
}
