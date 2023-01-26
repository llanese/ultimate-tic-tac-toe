
public class ComputerPlayer extends APlayer {
	
	public ComputerPlayer() {
		
	}
	
	/*
	 * ComputerPlayer parameterized constructor
	 * 
	 * Purpose: This parameterized constructor invokes the superclass (APlayer) constructor to initialize the
	 * computer player's name and mark.
	 * 
	 * Parameters: The computer player's name and mark are passed into this method.
	 * 
	 * Return Value: Nothing is returned from a constructor
	 */

	public ComputerPlayer(String name, String mark) {
		super(name, mark);
	}
	
	/*
	 * randomNumber method
	 * 
	 * Purpose: The randomNumber method allows the computer to randomly choose a number in a given range for
	 * future "selection".
	 * 
	 * Parameter: The range is passed into this method, which puts a constraint on what numbers that the
	 * computer can randomly chooose.
	 * 
	 * Return Value: The random number result is returned.
	 */
	
	private int randomNumber(int range) {
		return (int) (Math.random() * range);
	}
	
	/*
	 * selectLargeBox method
	 * 
	 * Purpose: The selectLargeBox method allows the computer to choose which mini board (large box) to play
	 * on in a given range.
	 * 
	 * Parameters: The range is passed into this method, which is the number of mini boards in the large board.
	 * 
	 * Return Value: The computer player's selection on which mini board to play on is returned.
	 */
	
	@Override
	public int selectLargeBox(int range) {
		return randomNumber(range);
	}
	
	/*
	 * selectMiniBox method
	 * 
	 * Purpose: The selectMiniBox method allows the computer to choose which box to play on in a given range.
	 * 
	 * Parameter: The range is passed into this method, which is the amount of boxes in a mini board.
	 * 
	 * Return Value: The computer player's selection on which box to play on is returned.
	 */
	
	@Override
	public int selectMiniBox(int range) {
		return randomNumber(range);
	}
}
