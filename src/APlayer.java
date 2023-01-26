public abstract class APlayer {
	private String name;
	private String mark;
	
	APlayer() {
		
	}
	
	/*
	 * APlayer parameterized constructor
	 * 
	 * Purpose: This parameterized constructor initializes a player's name and mark.
	 * 
	 * Parameters: The player's name and mark are passed into this method.
	 * 
	 * Return Value: Nothing is returned from a constructor.
	 */
	
	APlayer(String name, String mark) {
		this.setName(name);
		this.setMark(mark);
	}
	
	/*
	 * getName method
	 * 
	 * Purpose: The getName method is an accessor that fetches the player's name.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The player's name is returned.
	 */
	
	public String getName() {
		return name;
	}
	
	/*
	 * setName method
	 * 
	 * Purpose: The setName method is a mutator that modifies the player's name.
	 * 
	 * Parameter: The player's name is passed into this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * getMark method
	 * 
	 * Purpose: The getMark method is an accessor that fetches a player's mark.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The player's mark is returned.
	 */
	
	public String getMark() {
		return mark;
	}
	
	/*
	 * setMark method
	 * 
	 * Purpose: The setMark method is a mutator that modifies the player's mark.
	 * 
	 * Parameter: The player's mark is passed into this method
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	//selectLargeBox and selectMiniBox are abstract methods that is overried in the HumanPlayer and 
	//ComputerPlayer classes
	
	public abstract int selectLargeBox(int range);
	public abstract int selectMiniBox(int range);
}
