import javax.swing.JFrame;

/**
 * The grid represents the game board.
 */

public class Grid extends JFrame{
	// Define the amount of rows and columns
	final static int ROWS = 3;			// Rows
	final static int COLUMNS = 3;		// Columns

	Box[][] board;								// Represents the game board as a grid
	int currentRow;								// Row that was played last
	int currentCol;								// Column that was played last
	
	/**
	 * Constructor
	 */
	private final static String WINDOW_TITLE = "Tic Tac Toe";
	private final static int WINDOW_WIDTH = 800;
	private final static int WINDOW_HEIGHT = 600;
	public static final Grid Initialising = null;

   public Grid() {
	   
      // TODO: Initialize the board array using ROWS and COLUMNS

      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            board[row][col] = new Box(row, col);
         }
      }
   }

   /**
    * Checks if the game has ended in a draw
    * One way to do this is to check that there are no empty positions left
    */
   public boolean isDraw() {
	   boolean isFull = true;
	   
	   for (int row = 0; row< 3;row++) {
		   for(int col = 0;col < 3; col++) {
			   if (board[row][col] == null) {
				   isFull = false;
				   
			   }
		   }
	   }
	   return isFull;


	   // TODO: Check whether the game has ended in a draw. 
	   // Hint: Use a nested loop (see the constructor for an example). Check whether any of the Boxes in the board grid are Player.Empty. If they are, it is not a draw.
	   // Hint: Return false if it is not a draw, return true if there are not empty positions left


   }

   /**
    * Return true if the turn player has won after making their move at the coordinate given
    */
   public boolean hasWon(Player player) {
	   // Row check
	   for(currentRow = 0; currentRow < ROWS; currentRow++) {
	   if(board[currentRow][0].content == player && board[currentRow][1].content == player && board[currentRow][2].content == player) {
		   return true;
	        }
	   }
	   // Column check
	   for(currentCol = 0; currentCol < COLUMNS; currentCol++) {
		   if(board[0][currentCol].content == player && board[1][currentCol].content == player && board[2][currentCol].content == player) {
			  return true;
		   }
	   }
	   // TODO: Check if the currentCol is filled.
	   // Hint: Use the row code above as a starting point, remember that it goes board[row][column].
       
	   // Diagonal check (check both directions
	   if(board[0][0].content == player && board[1][1].content == player && board[2][2].content == player) {
		   return true;
	   }

	   // TODO: Check the diagonal in the other direction

	   // No one has won yet
	   return false;
   }

   /**
    * Draws the tic-tac-toe board to the screen
 * @return 
    */
   public String display() {
	   String startGrid = " ";
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
             // Draw the vertical line
        	 if (col != COLUMNS - 1)
        	     startGrid += board[row][col] + "|";
        	 else 
        		 startGrid += board[row][col];
    	    }
         // Draw the horizontal line
         if(row != COLUMNS -1)
        startGrid += "\n--------------\n";
         }
      return startGrid;
   }
} 