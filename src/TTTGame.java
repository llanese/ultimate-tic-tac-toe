public class TTTGame {
	private APlayer[] players = new APlayer[2];
	private LargeBoard board;
	private int rowSize;
	private int columnSize;
	private int currentPlayerIndex = -1;
	private int currentMiniBoxSelection = -1;
	private int scoreToWin = 3;
	private int currentPlayCount = 0;
	private final int MAX_NUMBER_OF_PLAYS = 81;
	
	/*
	 * TTTGame default constructor
	 * 
	 * Purpose: This default constructor initialize the tracked row and column sizes of all boards and boxes
	 * in the ultimate TTT game to three. It uses the parameterized constructor to perform this.
	 * 
	 * Parameters: There are no parameters to this constructor.
	 * 
	 * Return Value: Nothing is returned from a constructor.
	 */
	
	public TTTGame() {
		this(3, 3);
	}
	
	/*
	 * TTTGame parameterized constructor
	 * 
	 * Purpose: This parameterized constructor initializes the tracked row and column sizes of all boards and
	 * boxes in the ultimate TTT game.
	 * 
	 * Parameters: The tracked row and column sizes are passed into this constructor.
	 * 
	 * Return Value: Nothing is returned from a constructor.
	 */
	
	public TTTGame(int rowSize, int columnSize) {
		this.rowSize = rowSize;
		this.columnSize = columnSize;
		setBoard();
	}
	
	/*
	 * setBoard method
	 * 
	 * Purpose: The setBoard method dynamically allocates a LargeBoard object with the given row and column
	 * sizes.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setBoard() {
		this.board = new LargeBoard(rowSize, columnSize);
	}
	
	/*
	 * setPlayer method
	 * 
	 * Purpose: The setPlayer method allows dynamic allocation of the type of players that will be playing
	 * the ultimate TTT game.
	 * 
	 * Parameters: The APlayer objects are passed into this method, where each of the two players may be
	 * represented as a human or computer.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void setPlayer(APlayer player1, APlayer player2) {
		players[0] = player1;
		players[1] = player2;
	}
	
	/*
	 * start method
	 * 
	 * Purpose: The start method initiates the ultimate TTT game. It continues running until a victory by
	 * one of the players or a tie occurs.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	public void start() {
		System.out.println("\t\t\t||||| THE ULTIMATE TIC-TAC-TOE GAME |||||");
		board.print();
		
		//Make players take turns in capturing boxes of the large board until a winner of the ultimate TTT
		//game has been found and the game is officially concluded
		
		do {
			
			//Switch from one player to another
			
			switchPlayer();
			
			//Prompt the current player to make their mini board (large box) and box selections
			
			int largeBoxSelection = promptLargeBox();
			currentMiniBoxSelection = promptMiniBox(largeBoxSelection);
			
			//Print the large board again after the player made ther turn
			
			board.print();
			currentPlayCount++;
			
			//Provide an update on the game progress by displaying each mini board's status
			
			for(int largeBoxIndex = 0; largeBoxIndex < board.getTotalSize(); largeBoxIndex++) {
				updateGameStatus(largeBoxIndex);
			}
			
			System.out.println();
			
		} while(!gameOver());
	}
	
	/*
	 * gameOver method
	 * 
	 * Purpose: The gameOver method checks if a win or tie has occurred in the ultimate TTT game. If a win or
	 * tie occurs, this method forces the game to stop. Otherwise, the ultimate TTT game continues.
	 * 
	 * Parameters: Nothing is returned from this method.
	 * 
	 * Return Value: The ultimate TTT game's status of being over or not is returned.
	 */
	
	private boolean gameOver() {
		
		//If a player won the ultimate TTT game, then report this information
		
		if(isWinner()) {
			System.out.println("Ultimate Tic-Tac-Toe Game Winner: " + players[currentPlayerIndex].getName());
			return true;
		}
		
		//If all boxes have been played on the large board and no player has been concluded as the winner,
		//then report that ultimate TTT game ends it a tie
		
		else if(currentPlayCount == MAX_NUMBER_OF_PLAYS) {
			System.out.println("There is a tie in this Ultimate Tic-Tac-Toe game!");
			return true;
		}
		
		//Otherwise, the ultimate TTT game is not over and must continue
		
		else {
			return false;
		}
	}
	
	/*
	 * updateGameStatus method
	 * 
	 * Purpose: The updateGameStatus method reports the progress of the ultimate TTT game by providing updates
	 * on the statuses of the mini boards. This makes it feasible to trace the end result of the game back
	 * to the previous turns of the players.
	 * 
	 * Parameter: The index of the mini board within the large board is passed into this method.
	 * 
	 * Return Value: The status of any updates (wins or ties) to a particular mini board is returned.
	 */
	
	private boolean updateGameStatus(int largeBoxIndex) {
		
		//If any player won a particular mini board (large box) in the ultimate TTT game, report this
		//information
		
		if(isWinner(largeBoxIndex, players[0]) || isWinner(largeBoxIndex, players[1])) {
			return true;
		}
		
		//If the mini board is full and the board has not been won by any player, then report that a tie
		//has occurred on this mini board
		
		else if(board.isBoxFull(largeBoxIndex) && (board.getBoxWinStatus(largeBoxIndex)).equals("-")) {
			System.out.println("There is a tie for BOARD#" + largeBoxIndex);
			return true;
		}
		
		//Otherwise, there is no victory or tie that has occurred on this mini board
		
		else {
			return false;
		}
	}
	
	/*
	 * isWinner method (large board)
	 * 
	 * Purpose: This isWinner method checks if a player has won three mini boards (large boxes) in a row,
	 * columm, or diagonal on the large board, resulting in a victory in the ultimate TTT game.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The presence of whether a win on the large board has occurred is returned.
	 */
	
	private boolean isWinner() {
		String currentPlayerMark = players[currentPlayerIndex].getMark();
		
		//If a player won a row, column, or diagonal of the large board, then this player is reported to the
		//console as the winner of the ultimate TTT game
		
		if(checkRow(currentPlayerMark) || checkColumn(currentPlayerMark) || checkDiagonalRL(currentPlayerMark) ||
		   checkDiagonalLR(currentPlayerMark)) {
			return true;
		}
		
		//Otherwise, the player did not win the ultimate TTT game
		
		else {
			return false;
		}
	}
	
	/*
	 * isWinner method (mini board)
	 * 
	 * Purpose: This isWinner method checks if a player has won three boxes in a row, column, or diagonal
	 * on a mini board. If there is, a player has won this partuclar mini board.
	 * 
	 * Parameters: The mini board's index and the player being assessed on a win are passed into this method.
	 * 
	 * Return Value: The presence of whether a win on a particlar mini board has occurred is returned.
	 */
	
	private boolean isWinner(int largeBoxIndex, APlayer player) {
		String currentPlayerMark = player.getMark();
		
		//If a player won a row, column, or diagonal of a mini board (large box), then this player is reported
		//to the console as the winner of the particular mini board
		
		if(checkRow(currentPlayerMark, largeBoxIndex) || checkColumn(currentPlayerMark, largeBoxIndex) ||
		   checkDiagonalRL(currentPlayerMark, largeBoxIndex) || checkDiagonalLR(currentPlayerMark, largeBoxIndex)) {
			System.out.println(player.getName() + " is the winner of BOARD#" + largeBoxIndex);
			return true;
		}
		
		//Otherwise, the player did not win the mini board
		
		else {
			return false;
		}
	}
	
	/*
	 * checkRow method (large board)
	 * 
	 * Purpose: This checkRow method determines if a player has won three mini boards along a row of the large board.
	 * 
	 * Parameter: The player currently playing has their mark passed into this method.
	 * 
	 * Return Value: The presence of whether a win occurred along a row of the large board is returned.
	 */
	
	private boolean checkRow(String currentPlayerMark) {
		
		//Check row column of the large board to determine if all of the mini boards (large boxes) on that row
		//of the large board are won by a player
		
		for(int largeRowIndex = 0; largeRowIndex < rowSize; largeRowIndex++) {
			int largeMarkCount = 0;
			
			//Check each column of the current row being analyzed to determine if a box is conquered by a player
			
			for(int largeColumnIndex = 0; largeColumnIndex < columnSize; largeColumnIndex++) {
				
				//If the player's mark matches with the mini board's win status, then the player has conquered
				//that board
				
				if(currentPlayerMark.equals(board.getBoxWinStatus((rowSize * largeRowIndex) + largeColumnIndex))) {
					largeMarkCount++;
				}
			}
			
			//If a player won each mini board in the large board's row, then the player is declared as the
			//winner of the ultimate TTT game
			
			if(largeMarkCount == scoreToWin) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * checkRow method (mini board)
	 * 
	 * Purpose: This checkRow method determines if a player has won three boxes along a row of a mini board.
	 * 
	 * Parameters: The current player's mark and the index of the mini board being checked are passed into this method.
	 * 
	 * Return Value: The presence of wheter a win occured along a row of a particular mini board is returned.
	 */
	
	private boolean checkRow(String currentPlayerMark, int largeBoxIndex) {
		
		//Check each row of the mini board (large box) to determine if all of the boxes on that row of the
		//mini board are won by a player
		
		for(int miniRowIndex = 0; miniRowIndex < rowSize; miniRowIndex++) {
			int miniMarkCount = 0;
			
			//Check each column of the current row being analyzed to determine if a box is conquered by a player
			
			for(int miniColumnIndex = 0; miniColumnIndex < columnSize; miniColumnIndex++) {
				
				//If the player's mark matches with the box's placeholder, then the player has conquered that
				//box
				
				if(currentPlayerMark.equals(board.getBoxMark(largeBoxIndex, (rowSize * miniRowIndex) + miniColumnIndex))) {
					miniMarkCount++;
				}
			}
			
			//If a player won each box on the mini board's row and nobody has won this mini board yet, then
			//the current player is declared as the winner of the board
			
			if(miniMarkCount == scoreToWin && (board.getBoxWinStatus(largeBoxIndex)).equals("-")) {
				board.setBoxWinStatus(largeBoxIndex, currentPlayerMark);
				return true;
			}
			
			//If a player won each box on the mini board's row but the player has already won the mini board,
			//then simply report again that the player won this board
			
			else if(miniMarkCount == scoreToWin && (board.getBoxWinStatus(largeBoxIndex)).equals(currentPlayerMark)) {
				return true;
			}
		}
		
		//The player did not capture any row of boxes
		
		return false;
	}
	
	/*
	 * checkColumn method (large board)
	 * 
	 * Purpose: This checkColumn method determines if a player has won three mini boards along a column of the large board.
	 * 
	 * Parameter: The player currently playing has their mark passed into this method.
	 * 
	 * Return Value: The presence of whether a win occurred along a column of the large board is returned.
	 */
	
	private boolean checkColumn(String currentPlayerMark) {
		
		//Check each column of the large board to determine if all of the mini boards (large boxes) on that
		//column of the large board are won by a player
		
		for(int largeColumnIndex = 0; largeColumnIndex < columnSize; largeColumnIndex++) {
			int largeMarkCount = 0;
			
			//Check each row of the current column being analyzed to determine if a box is conquered by a player
			
			for(int largeRowIndex = 0; largeRowIndex < columnSize; largeRowIndex++) {
				
				//If the player's mark matches with the mini board's win status, then the player has conquered
				//that board
				
				if(currentPlayerMark.equals(board.getBoxWinStatus((rowSize * largeRowIndex) + largeColumnIndex))) {
					largeMarkCount++;
				}
			}
			
			//If a player won each mini board in the large board's column, then the player is declared as the
			//winner of the ultimate TTT game
			
			if(largeMarkCount == scoreToWin) {
				return true;
			}
		}
		
		//The player did not win any large board column
		
		return false;
	}
	
	/*
	 * checkColumn method (mini board)
	 * 
	 * Purpose: This checkColumn method determines if a player has won three boxes along a column of a mini board.
	 * 
	 * Parameters: The current player's mark and mini board's index are passed into this method.
	 * 
	 * Return Value: The presence of whether a win occurred along a column of a particular mini board is returned.
	 */
	
	private boolean checkColumn(String currentPlayerMark, int largeBoxIndex) {
		
		//Check each column of the mini board (large box) to determine if all of the boxes on that column of
		//the mini board are won by a player
		
		for(int miniColumnIndex = 0; miniColumnIndex < columnSize; miniColumnIndex++) {
			int miniMarkCount = 0;
			
			//Check each row of the current column being analyzed to determine if a box is conquered by a player
			
			for(int miniRowIndex = 0; miniRowIndex < columnSize; miniRowIndex++) {
				
				//If the player's mark matches with the box's placeholder, then the player has conquered that
				//box
				
				if(currentPlayerMark.equals(board.getBoxMark(largeBoxIndex, (rowSize * miniRowIndex) + miniColumnIndex))) {
					miniMarkCount++;
				}
			}
			
			//If a player won each box on the mini board's column and nobody has won this mini board yet, then
			//the current player is declared as the winner of the board
			
			if(miniMarkCount == scoreToWin && (board.getBoxWinStatus(largeBoxIndex)).equals("-")) {
				board.setBoxWinStatus(largeBoxIndex, currentPlayerMark);
				return true;
			}
			
			//If a player won each box on the mini board's column but the player has already won the mini board,
			//then simply report again that the player won this board
			
			else if(miniMarkCount == scoreToWin && (board.getBoxWinStatus(largeBoxIndex)).equals(currentPlayerMark)) {
				return true;
			}
		}
		
		//The player did not capture any column of boxes
		
		return false;
	}
	
	/*
	 * checkDiagonalRL method (large board)
	 * 
	 * Purpose: This checkDiagonalRL method determines if a player has won three mini boards along the right-to-left
	 * diagonal of the large board.
	 * 
	 * Parameter: The current player's mark is returned.
	 * 
	 * Return Value: The presence of whether a win occured along this diagonal on the large board is returned.
	 */
	
	private boolean checkDiagonalRL(String currentPlayerMark) {
		int largeMarkCount = 0;
		
		//Check the right-to-left diagonal of the large board to determine if all of the mini boards (large boxes)
		//on that diagonal of the large board are won by a player
		
		for(int largeRowIndex = 0, largeColumnIndex = (columnSize - 1); largeRowIndex < rowSize && largeColumnIndex >= 0; largeRowIndex++, largeColumnIndex--) {
			
			//If the player's mark matches with the mini board's win status, then the player has conquered
			//that board
			
			if(currentPlayerMark.equals(board.getBoxWinStatus((rowSize * largeRowIndex) + largeColumnIndex))) {
				largeMarkCount++;
			}
		}
		
		//If a player won each mini board of the large board's right-to-left diagonal, then the player is declared
		//winner of the ultimate TTT game
		
		if(largeMarkCount == scoreToWin) {
			return true;
		}
		
		//The player did not win the large board's right-to-left column
		
		else {
			return false;
		}
	}
	
	/*
	 * checkDiagonalRL method (mini board)
	 * 
	 * Purpose: This checkDiagonalRL method detemines if a player has won three boxes along the right-to-left diagonal
	 * of a particular mini board.
	 * 
	 * Parameters: The current player's mark and the index of the mini board being evaluated are passed into this method.
	 * 
	 * Return Value: The presence of whether a win occurred on this diagonal of a mini board is returned.
	 */
	
	private boolean checkDiagonalRL(String currentPlayerMark, int largeBoxIndex) {
		int miniMarkCount = 0;
		
		//Check the right-to-left diagonal of the mini board (large box) to determine if all of the boxes on
		//that diagonal of the mini board are won by the player
		
		for(int miniRowIndex = 0, miniColumnIndex = (columnSize - 1); miniRowIndex < rowSize && miniColumnIndex >= 0; miniRowIndex++, miniColumnIndex--) {
			
			//If the player's mark matches with the current box's placeholder, then the player has conquered
			//that box
			
			if(currentPlayerMark.equals(board.getBoxMark(largeBoxIndex, (rowSize * miniRowIndex) + miniColumnIndex))) {
				miniMarkCount++;
			}
		}
		
		//If a player won each box on the mini board's right-to-left diagonal and nobody has won the mini board
		//yet, then the current player is declared winner of the board
		
		if(miniMarkCount == scoreToWin && (board.getBoxWinStatus(largeBoxIndex)).equals("-")) {
			board.setBoxWinStatus(largeBoxIndex, currentPlayerMark);
			return true;
		}
		
		//If a player won each box on the mini board's right-to-left diagonal but the player has already won
		//the mini board, then simply report again that the player won this board
		
		else if(miniMarkCount == scoreToWin && (board.getBoxWinStatus(largeBoxIndex)).equals(currentPlayerMark)) {
			return true;
		}
		
		//Otherwise, the player did not capture the right-to-left diagonal
		
		else {
			return false;
		}
	}
	
	/*
	 * checkDiagonalLR method (large board)
	 * 
	 * Purpose: This checkDiagonalLR method determines if a player has won three mini boards along the left-to-right
	 * diagonal of the large board.
	 * 
	 * Parameter: The current player's mark is returned.
	 * 
	 * Return Value: The presence of whether a win occured along this diagonal on the large board is returned.
	 */
	
	private boolean checkDiagonalLR(String currentPlayerMark) {
		int largeMarkCount = 0;
		
		//Check the left-to-right diagonal of the mini board (large box) to determine if all of the boxes on
		//that diagonal of the mini board are won by the player
		
		for(int largeRowIndex = 0, largeColumnIndex = 0; largeRowIndex < rowSize && largeColumnIndex < columnSize; largeRowIndex++, largeColumnIndex++) {
			
			//If the player's mark matches with the mini board's win status, then the player has conquered
			//that board
			
			if(currentPlayerMark.equals(board.getBoxWinStatus((rowSize * largeRowIndex) + largeColumnIndex))) {
				largeMarkCount++;
			}
		}
		
		//If a player won each mini board of the large board's left-to-right diagonal, then the player is declared
		//winner of the ultimate TTT game
		
		if(largeMarkCount == scoreToWin) {
			return true;
		}
		
		//The player did not win the large board's left-to-right column
		
		else {
			return false;
		}
	}
	
	/*
	 * checkDiagonalLR method (mini board)
	 * 
	 * Purpose: This checkDiagonalLR method detemines if a player has won three boxes along the left-to-right diagonal
	 * of a particular mini board.
	 * 
	 * Parameters: The current player's mark and the index of the mini board being evaluated are passed into this method.
	 * 
	 * Return Value: The presence of whether a win occurred on this diagonal of a mini board is returned.
	 */
	
	private boolean checkDiagonalLR(String currentPlayerMark, int largeBoxIndex) {
		int miniMarkCount = 0;
		
		//Check each left-to-right diagonal of the mini board (large box) to determine of all of the boxes on
		//that diagonal of the mini board are won by the player
		
		for(int miniRowIndex = 0, miniColumnIndex = 0; miniRowIndex < rowSize && miniColumnIndex < columnSize; miniRowIndex++, miniColumnIndex++) {
			
			//If the player's mark matches with the current box's placeholder, then the player has conquered
			//that box
			
			if(currentPlayerMark.equals(board.getBoxMark(largeBoxIndex, (rowSize * miniRowIndex) + miniColumnIndex))) {
				miniMarkCount++;
			}
		}
		
		//If a player won each box on the mini board's left-to-right diagonal and nobody has won the mini board
		//yet, then the current player is declared winner of the board
		
		if(miniMarkCount == scoreToWin && (board.getBoxWinStatus(largeBoxIndex)).equals("-")) {
			board.setBoxWinStatus(largeBoxIndex, currentPlayerMark);
			return true;
		}
		
		//If a player won each box on the mini board's left-to-right diagonal but the player has already won
		//the mini board, then simply report again that the player won this board
		
		else if(miniMarkCount == scoreToWin && (board.getBoxWinStatus(largeBoxIndex)).equals(currentPlayerMark)) {
			return true;
		}
		
		//Otherwise, the player did not capture the left-to-right diagonal
		
		else {
			return false;
		}
	}
	
	/*
	 * switchPlayer method
	 * 
	 * Purpose: The switchPlayer method allows one player to have a turn in participating in the game after
	 * another player has already went.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: Nothing is returned from this method.
	 */
	
	private void switchPlayer() {
		
		//If it's the beginning of the ultimate TTT game or the previous player was the second player, then
		//it's the first player's turn to play
		
		if(currentPlayerIndex == -1 || currentPlayerIndex == 1) {
			currentPlayerIndex = 0;
		}
		
		//Otherwise, it's the second player's turn to play
		
		else {
			currentPlayerIndex = 1;
		}
	}
	
	/*
	 * promptLargeBox method
	 * 
	 * Purpose: The promptLargeBox method either allows the player to select which mini board (large box) to
	 * play on or forces the player to play on the mini board dictated by the previous player's box selection.
	 * If the player is allowed to choose, then a list of legal moves is provided to the player. It also
	 * error-checks on inputs outside of legal moves.
	 * 
	 * Parameters: There are no parameters to this method.
	 * 
	 * Return Value: The player's selection on which mini board to play on is returned.
	 */
	
	private int promptLargeBox() {
		
		//If it's the beginning of the ultimate TTT game or the mini board (large box) that the current
		//player is forced to is full, then allow the current player to select which mini board to play on
		
		if(currentMiniBoxSelection == -1 || board.isBoxFull(currentMiniBoxSelection)) {
			
			//Provide a list of legal mini boards that are available for play
			
			System.out.print("Available Boards for Play: ");
			
			for(int largeBoxIndex = 0; largeBoxIndex < board.getTotalSize(); largeBoxIndex++) {
				if(!board.isBoxFull(largeBoxIndex)) {
					System.out.print(largeBoxIndex + " ");
				}
				else {
					continue;
				}
			}
			
			System.out.println();
			
			//Let the current player select which mini board they would like to play on
			
			int largeBoxSelection = players[currentPlayerIndex].selectLargeBox(board.getTotalSize());
			
			//If the current player is selecting a board that is already full, force them to provide another
			//input until a legal move has been made
			
			while(board.isBoxFull(largeBoxSelection)) {
				largeBoxSelection = players[currentPlayerIndex].selectLargeBox(board.getTotalSize());
			}
			
			//Report which mini board that the player chose play on
			
			System.out.println("Selected Board: " + largeBoxSelection);
			
			return largeBoxSelection;
		}
		
		//Otherwise, force the player to play on a board dictated by the previous player's box selection
		
		else {
			System.out.println("Automatically Selected Board: " + currentMiniBoxSelection);
			return currentMiniBoxSelection;
		}
	}
	
	/*
	 * promptMiniBox method
	 * 
	 * Purpose: The promptMiniBox method allows the current player to which box of a mini board (large box) to
	 * play. A list of legal moves are provided to the player for reference. It also error-checks on inputs
	 * outside of legal moves.
	 * 
	 * Parameters: The index of the mini board that the player will play on is returned.
	 * 
	 * Return Value: The player's selection of which box to play on is returned.
	 */
	
	private int promptMiniBox(int largeBoxSelection) {
		int numMiniBoxes = board.getNumPlayableBoxes() / board.getTotalSize();
		
		//Provide a list of legal boxes that are available for play
		
		System.out.print("Available Boxes for Play: ");
		
		for(int miniBoxIndex = 0; miniBoxIndex < numMiniBoxes; miniBoxIndex++) {
			if((board.getBoxMark(largeBoxSelection, miniBoxIndex)).equals(Integer.toString(miniBoxIndex))) {
				System.out.print(miniBoxIndex + " ");
			}
			else {
				continue;
			}
		}
		
		System.out.println();
		
		//Let the current player select which box they would like to play on
		
		int playerSelection = players[currentPlayerIndex].selectMiniBox(numMiniBoxes);
		
		//If the current player is selecting a box that is already full, force them to provide another input
		//until a legal move has been made
		
		while(!board.makeMove(players[currentPlayerIndex].getMark(), largeBoxSelection, playerSelection)) {
			playerSelection = players[currentPlayerIndex].selectMiniBox(numMiniBoxes);
		}
		
		//Report which box that the player chose to play on
		
		System.out.println("Selected Box: " + playerSelection);
		
		return playerSelection;
	}
}
