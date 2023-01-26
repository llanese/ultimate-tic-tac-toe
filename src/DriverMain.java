public class DriverMain {
	public static void main(String[] args) {
		TTTGame game = new TTTGame();
		
		//This is a test of the Computer vs. Computer feature
		
		game.setPlayer(new ComputerPlayer("PlayerX", "X"), new ComputerPlayer("PlayerO", "O"));
		
		//This is a test of the Human vs. Computer feature
		
		//game.setPlayer(new HumanPlayer("PlayerX", "X"), new ComputerPlayer("PlayerO", "O"));
		
		//This is a test of the Human vs. Human feature
		
		//game.setPlayer(new HumanPlayer("PlayerX", "X"), new HumanPlayer("PlayerO", "O"));
		
    game.start();
	}
}
