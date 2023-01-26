public abstract class ABoard {
	private int rowSize;
	private int columnSize;
	private int totalSize;
	
	/*
	 * getRowSize method
	 * 
	 * Purpose: The getRowSize method is an accessor that fetches the row size of a board.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The row size of the board is returned.
	 */
	
	public int getRowSize() {
		return rowSize;
	}
	
	/*
	 * setRowSize method
	 * 
	 * Purpose: The setRowSize method is a mutator that modifies the row size of a board.
	 * 
	 * Parameter: The row size of the board is passed into this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}
	
	/*
	 * getColumnSize method
	 * 
	 * Purpose: The getColumnSize method is an accessor that fetches the column size of a board.
	 * 
	 * Parameters: Nothing is passed into this method.
	 * 
	 * Return Value: The column size of the board is returned.
	 */
	
	public int getColumnSize() {
		return columnSize;
	}
	
	/*
	 * setColumnSize method
	 * 
	 * Purpose: The setColumnSize method is a mutator that modifies the column size of a board.
	 * 
	 * Parameter: The column size of the board is passed into this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}
	
	/*
	 * getTotalSize method
	 * 
	 * Purpose: The getTotalSize method is an accessor that fetches the total size (row size x column size) of
	 * a board.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The total size of the board is returned.
	 */
	
	public int getTotalSize() {
		return totalSize;
	}
	
	/*
	 * setTotalSize method
	 * 
	 * Purpose: The setTotalSize method is a mutator that modifies the total size (row size x column size) of
	 * a board.
	 * 
	 * Parameter: The board's total size is passed into this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	//isFull is an abstract method that must be overrided by the MiniBoard and LargeBoard classes
	
	public abstract boolean isFull();
}
