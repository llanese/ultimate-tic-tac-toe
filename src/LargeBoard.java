public class LargeBoard extends ABoard{
	private int numPlayableBoxes;
	private MiniBoard[] largeBoxes;
	
	/*
	 * LargeBoard default constructor
	 * 
	 * Purpose: This default constructor initializes the row and column sizes of the large board to three
	 * mini boards. It does this by invoking the parameterized constructor.
	 * 
	 * Parameters: There are no parameters to this constructor.
	 * 
	 * Return Value: Nothing is returned from a constructor.
	 */
	
	public LargeBoard() {
		this(3, 3);
	}
	
	/*
	 * LargeBoard parameterized constructor
	 * 
	 * Purpose: This parameterized constructor intializes the row size, column size, total size, and number
	 * of playable boxes of the large board.
	 * 
	 * Parameters: The large board's row and column sizes are passed into this constructor.
	 * 
	 * Return Value: Nothing is returned from a constructor.
	 */
	
	public LargeBoard(int rowSize, int columnSize) {
		this.setColumnSize(columnSize);
		this.setRowSize(rowSize);
		this.setTotalSize(columnSize * rowSize);
		this.initializeLargeBoard();
		this.setNumPlayableBoxes(getTotalSize() * largeBoxes[0].getTotalSize());
	}
	
	/*
	 * initializeLargeBoard method
	 * 
	 * Purpose: The initiallizeLargeBoard method sets up all of the mini boards within the large board and
	 * provides each mini board with their row and column sizes;
	 * 
	 * Parameters: there are no parameters to this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	private void initializeLargeBoard() {
		
		//Dynamically allocate each playable mini board on the large board. For a 3x3 large board, dynamically
		//allocate nine mini boards.
		
		largeBoxes = new MiniBoard[getRowSize() * getColumnSize()];
		
		//Provide each mini board on the large board with its row size and column size
		
		for(int i = 0; i < largeBoxes.length; i++) {
			MiniBoard b = new MiniBoard(getRowSize(), getColumnSize());
			largeBoxes[i] = b;
		}
	}
	
	/*
	 * getNumPlayableBoxes method
	 * 
	 * Purpose: The getNumPlayableBoxes method is an accessor that fetches the number of playable boxes that
	 * are on the large board.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The number of playable boxes is returned from this method.
	 */
	
	public int getNumPlayableBoxes() {
		return this.numPlayableBoxes;
	}
	
	/*
	 * setNumPlayableBoxes method
	 * 
	 * Purpose: The setNumPlayableBoxes method is a mutator that modifies the number of playable boxes that
	 * are on the large board.
	 * 
	 * Parameter: The number of playable boxes on the large board is passed into this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setNumPlayableBoxes(int numPlayableBoxes) {
		this.numPlayableBoxes = numPlayableBoxes;
	}
	
	/*
	 * setBoxWinStatus method
	 * 
	 * Purpose: The setBoxWinStatus changes the status of a mini board (large box) of whether a win occurred
	 * or not.
	 * 
	 * Parameters: The mini board that will have its status changed and the current player's mark are passed
	 * into this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setBoxWinStatus(int largeBoxIndex, String playerMark) {
		largeBoxes[largeBoxIndex].setWinStatus(playerMark);
	}
	
	/*
	 * getBoxMark method
	 * 
	 * Purpose: The getBoxMark method extracts the place holder held by a box on a mini board of the large board.
	 * 
	 * Parameters: The mini board and box indices are passed into this method.
	 * 
	 * Return Value: The box's place holder is returned from this method.
	 */
	
	public String getBoxMark(int largeBoxIndex, int miniBoxIndex) {
		return largeBoxes[largeBoxIndex].getMark(miniBoxIndex);
	}
	
	/*
	 * getBoxWinStatus method
	 * 
	 * Purpose: The getBoxWinStatus method fetches which player won a mini board within the large board.
	 * 
	 * Parameter: The index of the particular mini board in question is passed into this method.
	 * 
	 * Return Value: The box's win status is returned.
	 */
	
	public String getBoxWinStatus(int largeBoxIndex) {
		return largeBoxes[largeBoxIndex].getWinStatus();
	}
	
	/*
	 * isFull method
	 * 
	 * Purpose: This isFull method determines if the large board is full by checking if each of the mini boards
	 * within the large board are full.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The status of whether the large board is full or not is returned.
	 */

	@Override
	public boolean isFull() {
		
		//Check each mini board of the large board to determine if it is full
		
		for(int largeBoxIndex = 0; largeBoxIndex < (getRowSize() * getColumnSize()); largeBoxIndex++) {
			
			//If there is at least one mini board that is not full, then the large board is not full
			
			if(!largeBoxes[largeBoxIndex].isFull()) {
				return false;
			}
		}
		
		//If all the mini boards are full, then the large board is full
		
		return true;
	}
	
	/*
	 * isBoxFull method
	 * 
	 * Purpose: The isBoxFull method checks if an individual mini board within the large board is full.
	 * 
	 * Parameters: The index of the mini board in question is passed into this method.
	 * 
	 * Return Value: That status of whether this mini board is full or not is returned.
	 */
	
	public boolean isBoxFull(int largeBoxIndex) {
		return largeBoxes[largeBoxIndex].isFull();
	}
	
	/*
	 * print method
	 * 
	 * Purpose: The print method displays the large board onto the console by individually printing each
	 * row of three mini boards within a row of the large board.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void print() {
		System.out.println();
		System.out.println("Updating ultimate board info...");
		
		//Individually print each row of mini boards to display a visualization of the large board. Since there
		//are three mini boards in each of the three rows of the large board, there will be nine apparent
		//lines of output for the large board.
		
		for(int totalRowIndex = 0; totalRowIndex < getRowSize() * largeBoxes[0].getRowSize(); totalRowIndex++) {
			
			//Print one row for each mini board that is on the large board row being analyzed
			
			for(int largeColumnIndex = 0; largeColumnIndex < getColumnSize(); largeColumnIndex++) {
				
				//Print one row for a mini board that is on the current large board row being analyzed
				
				int largeBoardIndex = getRowSize() * (totalRowIndex / 3) + largeColumnIndex;
				System.out.print("   BOARD#" + largeBoardIndex);
				largeBoxes[largeBoardIndex].printRow(totalRowIndex % 3);
			}
			
			System.out.println();
			
			//If a row of three mini boards is completely printed, then add a new line in the console
			//to separate each mini board for better readability
			
			if((totalRowIndex + 1) % 3 == 0) {
				System.out.println();
			}
		}
	}
	
	/*
	 * makeMove method
	 * 
	 * Purpose: The makeMove method allows the large board to modify a box's place holder inside a particular 
	 * mini board by using the current player's selections.
	 * 
	 * Parameters: The current player's mark, mini board (large box) selection, and mini box selection are
	 * passed into this method.
	 * 
	 * Return Value: The status of whether a move can be made on that box is returned.
	 */
	
	public boolean makeMove(String player, int largeBoxIndex, int miniBoxIndex) {
		
		//If a player can make a move on a certain box of a mini board on this large board, then the box's
		//placeholder will change to to indicate the player's associated mark
		
		if(largeBoxes[largeBoxIndex].makeMove(player, miniBoxIndex)) {
			return true;
		}
		
		//Otherwise, the box is unavailable for play and a move cannot be made
		
		else {
			return false;
		}
	}
}
