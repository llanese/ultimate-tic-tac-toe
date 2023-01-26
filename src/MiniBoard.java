public class MiniBoard extends ABoard {
	private String winStatus = "-";
	private Box[] miniBoxes;
	
	/*
	 * MiniBoard default constructor
	 * 
	 * Purpose: This default constructor initializes the row and column sizes of the mini board to three boxes. It
	 * does this by invoking the parameterized constructor.
	 * 
	 * Parameters: There are no parameters to this constructor.
	 * 
	 * Return Value: Nothing is returned from a constructor.
	 */
	
	public MiniBoard() {
		this(3, 3);
	}
	
	/*
	 * MiniBoard parameterized constructor
	 * 
	 * Purpose: This parameterized constructor initializes the row, column, and total sizes of the mini board.
	 * 
	 * Parameters: The row and column sizes of the mini board are passed into this constructor.
	 * 
	 * Return Value: Nothing is returned from a constructor.
	 */
	
	public MiniBoard(int rowSize, int columnSize) {
		this.setColumnSize(columnSize);
		this.setRowSize(rowSize);
		this.setTotalSize(columnSize * rowSize);
		this.initializeMiniBoard();
	}
	
	/*
	 * initializeMiniBoard method
	 * 
	 * Purpose: The initializeBoard method dynamically allocates Box objects to create a mini board and sets
	 * the place holders of each box with the box's indices within the mini board.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	private void initializeMiniBoard() {
		
		//Dynamically allocate each playable box on the mini board. For a 3x3 mini board, dynamically allocate
		//nine boxes.
		
		miniBoxes = new Box[getRowSize() * getColumnSize()];
		
		//Provide each box on the mini board with their row position, column position, and mark. The initial
		//mark that a box holds is simply its index number.
		
		for(int miniBoxIndex = 0; miniBoxIndex < miniBoxes.length; miniBoxIndex++) {
			Box currentBox = new Box(miniBoxIndex / getColumnSize(), miniBoxIndex % getColumnSize(), Integer.toString(miniBoxIndex));
			miniBoxes[miniBoxIndex] = currentBox;
		}
	}
	
	/*
	 * getWinStatus method
	 * 
	 * Purpose: The getWinStatus method is an accessor that fetches the win status held by the mini board.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The mini board's win status is returned.
	 */
	
	public String getWinStatus() {
		return this.winStatus;
	}
	
	/*
	 * setWinStatus method
	 * 
	 * Purpose: The setWinStatus method is a mutator that modifies the win status held by the mini board.
	 * 
	 * Parameter: The mini board's win status (or mark of player who won the board) is passed into this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setWinStatus(String winStatus) {
		this.winStatus = winStatus;
	}
	
	/*
	 * getMark method
	 * 
	 * Purpose: The getMark method is extracts the place holder held by a box in the mini board.
	 * 
	 * Parameter: The box index in the mini board is passed into this method.
	 * 
	 * Return Value: The box's place holder is returned.
	 */

	public String getMark(int miniBoxIndex) {
		return miniBoxes[miniBoxIndex].getPlaceHolder();
	}
	
	/*
	 * printRow method
	 * 
	 * Purpose: The printRow method individually prints each row of boxes of a mini board. This makes it
	 * feasible to print the large board during the ultimate TTT game for visualiation.
	 * 
	 * Parameter: The row position of mini board that needs to be printed is passed into this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void printRow(int rowPosition) {
		
		//Individually print each row of boxes on the mini board to display a visualization of the mini board.
		
		for(int miniBoxIndex = getRowSize() * rowPosition; miniBoxIndex < getRowSize() * (rowPosition + 1); miniBoxIndex++) {
			miniBoxes[miniBoxIndex].print();
		}
	}
	
	/*
	 * isFull method
	 * 
	 * Purpose: The isFull method checks if the mini board is too full for any more plays to occurr by
	 * checking if all the boxes in the mini board are occupied by players.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The status of whether the mini board is full or not is returned.
	 */

	@Override
	public boolean isFull() {
		
		//Check each box of the mini board to determine if it is full
		
		for(int miniBoxIndex = 0; miniBoxIndex < (getRowSize() * getColumnSize()); miniBoxIndex++) {
			
			//If at least one box is available for play, the mini board it not full
			
			if(miniBoxes[miniBoxIndex].isAvailable()) {
				return false;
			}
		}
		
		//If no available boxes were detected, then the mini board is full
		
		return true;
	}
	
	/*
	 * makeMove method
	 * 
	 * Purpose: The makeMove method allows the MiniBoard to change the place holder of a box given box selection
	 * of the player currently participating.
	 * 
	 * Parameters: The current player's mark and the index of the box within the mini board that will be modified
	 * are passed into this method.
	 * 
	 * Return Value: The status of whether a move can be made on that box is returned.
	 */

	public boolean makeMove(String player, int miniBoxIndex) {
		
		//If a player can make a move on this box of the mini board, then its placeholder will change
		//to indicate the player's associated mark
		
		if(miniBoxes[miniBoxIndex].setPlaceHolder(player)) {
			return true;
		}
		
		//Otherwise, the box is unavailable for play and a move cannot be made
		
		else {
			return false;
		}
	}
}
