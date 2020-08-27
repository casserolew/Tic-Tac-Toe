import java.util.Scanner;				// Scanner required for player input

/**
 * The main class for the game Tic-Tac-Toe.
 * Controls the flow of the game, allowing each player to enter an option until the game ends.
 */

public class Main {
	private static Scanner scanner = new Scanner(System.in);  // Scanner for input

	private Grid grid;					// The game board
	private boolean gameOver;			// Whether game is playing or over
	private Player winner;				// Winner of the game
	private Player currentPlayer;		// Current player (enum)


   /**
    * Constructor
    * Sets up the game. Creates the grid and sets the values of the variables before calling the play method.
    */
   public Main() {
	   grid = new Grid(); // Create the grid
	   currentPlayer = Player.X;	   // Reset the game variables to their defaults
	   gameOver = false;
	   winner = null;
	   play();	   // Begin playing the game
   }

   /**
    * Controls the game play, rotates between player turns until a winner is decided.
    */
   public  void play() {
	   Grid.init();  // clear the board contents
	  
	   do {
	         playerMove(currentPlayer);			// Have the player perform their move
	         grid.display();					// Display the current game board
	         checkForWinner(currentPlayer);		// Checks if the game has been won

	         // Display results if game is over
	         if(gameOver) {
	        	 if(winner == Player.X) {
		        	 System.out.println("Player X wins!");
		        	 int choice;
		        	 System.out.println("If you would Like to continue playing enter 1. If you would like to Exit the program enter 2.");
		        	 choice = scanner.nextInt();
		        	 switch(choice) {
		        	 case 1:
		        		 main(null);
		        	 break;
		        	 case 2:
		        		 break;
		         }
	       }
	        	 else if(winner == Player.O) {
		        	 System.out.println("Player O wins!");
		        	 int choice;
		        	 System.out.println("If you would Like to continue playing enter 1. If you would like to Exit the program enter 2.");
		        	 choice = scanner.nextInt();
		        	 switch(choice) {
		        	 case 1:
		        		 main(null);
		        	 break;
		        	 case 2:
		        		 break;
		         }
	         }
        	      else if(winner == null) {
			         System.out.println("DRAW!");
			         int choice;
		        	 System.out.println("If you would Like to continue playing enter 1. If you would like to Exit the program enter 2.");
		        	 choice = scanner.nextInt();
		        	 switch(choice) {
		        	 case 1:
		        		 main(null);
		        	 break;
		        	 case 2:
		        		 break;
		         }
        	 }
         }

	         // Switch turn to the next player
	         if(currentPlayer == Player.X) {
	        	 currentPlayer = Player.O;
	         } else {
	        	 currentPlayer = Player.X;
	         }


	      } while (!gameOver);  // repeat until game-over
   }

   /** 
    * Handles the player making their move, checks if the move is valid before making it.
    */
   public void playerMove(Player turnPlayer) {

      boolean validInput = false;

      do {

    	  // Display instructions to the player
         if (turnPlayer == Player.X) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
        	 System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
         }

         // Obtains input from the player for both row and column
         int row = scanner.nextInt();
         int col = scanner.nextInt();

         // Decrease the value entered by 1 to compensate for the array index starting at 0
         row--;
         col--;

         // Verify the values the player entered are valid (position is valid and empty)
         if (row >= 0 && row < Grid.ROWS && col >= 0 && col < Grid.COLUMNS && Grid.board[row][col].content == Player.EMPTY) {
        	 Grid.board[row][col].content = turnPlayer;
        	 grid.currentRow = row;
        	 grid.currentCol = col;
        	 validInput = true;
         } else {
        	 System.out.println("Your move at (" + (row + 1) + "," + (col + 1)
                     + ") is not valid. Try again...");
                 }

      } while (!validInput);   // Repeat until input is valid
   }

   /**
    * Checks if the game has ended
    */
   public void checkForWinner(Player turnPlayer) {
      if (grid.hasWon(turnPlayer)) {
    	  
    	  winner = turnPlayer;
    	  gameOver= true;

    	  // TODO: Set gameOver and winner appropriately

      } else if (grid.isDraw()) {
    	  gameOver = true;

    	  // TODO: Set gameOver and winner appropriately
      }
   }

   /**
    * The main() method
    */

   public static void main(String[] args) {
	   new Main();

	   }

	}
 
   