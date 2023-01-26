import java.util.*;

public class HumanPlayer extends APlayer{
	private Scanner input = new Scanner(System.in);
	
	public HumanPlayer() {
		
	}
	
	/*
	 * HumanPlayer parameterized constructor
	 * 
	 * Purpose: This parameterized constructor invokes the superclass (APlayer) constructor to initialize
	 * the human player's name and mark.
	 * 
	 * Parameters: The human player's name and mark are passed into this method.
	 * 
	 * Return Value: Nothing is returned from a constructor.
	 */
	
	public HumanPlayer(String name, String mark) {
		super(name, mark);
	}
	
	/*
	 * selectLargeBox method
	 * 
	 * Purpose: The selectLargeBox method allows the human player to choose which mini board (large box)
	 * they would like to play on. Error-checking will be done on user input to ensure that the user provided
	 * an in-range integer.
	 * 
	 * Parameter: A range is passed into this method, which is the amount of mini boards in the large board.
	 * 
	 * Return Value: The player selection of which mini board to play on is returned.
	 */
	
	@Override
	public int selectLargeBox(int range) {
		int largeBoxSelection = -1;
		boolean isValidInteger = false;
		
		//Perform error-checking until the human player enters an integer that fits into the range of
		//playable large boxes
		
		do {
			System.out.print(this.getName() + ", please select a valid board: ");
			
			//If the input is not detected as an integer by the Scanner object, then the human player
			//is notified that an integer input must be provided
			
			if(!input.hasNextInt()) {
				System.out.println("Try again! Enter only an integer value.");
				input.next();
			}
			
			//At this point, the Scanner object does detect an integer input from the human player
			
			else {
				largeBoxSelection = input.nextInt();
				
				//If the human player's input is not in range (0-8), then the human player is notified
				//that an in-range integer must be provided
				
				if(largeBoxSelection < 0 || largeBoxSelection >= 9) {
					System.out.println("Try again! Enter an in-range integer.");
				}
				
				//Otherwise, the human player provided a valid input and it can serve as the large box
				//selection
				
				else {
					isValidInteger = true;
				}
			}
			
		} while(!isValidInteger);
		
		return largeBoxSelection;
	}
	
	/*
	 * selectMiniBox method
	 * 
	 * Purpose: The selectMiniBox method allows the human player to choose which box they would like to play
	 * on. Error-checking will be performed to ensure that the user provided an in-range integer.
	 * 
	 * Parameter: A range is passed into this method, which is the amount of boxes on the mini board.
	 * 
	 * Return Value: The player selection of which box to play on is returned.
	 */
	
	@Override
	public int selectMiniBox(int range) {
		int miniBoxSelection = -1;
		boolean isValidInteger = false;
		
		//Perform error-checking until the human playerenters an integer that fits into the range of
		//playable mini boxes
		
		do {
			System.out.print(this.getName() + ", please select a valid box: ");
			
			//If the input is not detected as an integer by the Scanner object, then the human player
			//is notified that an integer input must be provided
			
			if(!input.hasNextInt()) {
				System.out.println("Try again! Enter only an integer value.");
				input.next();
			}
			
			//At this point, the Scanner object does detect an integer input from the human player
			
			else {
				miniBoxSelection = input.nextInt();
				
				//If the human player's input is not in range (0-8), then the human player is notified
				//that an in-range integer must be provided
				
				if(miniBoxSelection < 0 || miniBoxSelection >= 9) {
					System.out.println("Try again! Enter an in-range value.");
				}
				
				//Otherwise, the human player provided a valid input and it can serve as the mini box
				//selection
				
				else {
					isValidInteger = true;
				}
			}
			
		} while(!isValidInteger);
		
		return miniBoxSelection;
	}
}
