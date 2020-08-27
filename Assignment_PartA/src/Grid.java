import javax.swing.JFrame;

/**
 * The grid represents the game board.
 */

public class Grid extends JFrame{
	// Define the amount of rows and columns
	final static int ROWS = 3;			// Rows
	final static int COLUMNS = 3;		// Columns

	static Box[][] board;					    // Represents the game board as a grid
	int currentRow;								// Row that was played last
	int currentCol;								// Column that was played last
	
	/**
	 * Constructor
	 */

   public Grid() {
	   //Initializes the grid
	   
      board = new Box[ROWS][COLUMNS];
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            board[row][col] = new Box(row, col);
         }
      }
   }
   /** Initialize (or re-initialize) the contents of the game board */
   public static void init() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            board[row][col].clear();  // clear the cell content
         }
      }
   }
 

   /**
    * Checks if the game has ended in a draw
    * One way to do this is to check that there are no empty positions left
    */
   public boolean isDraw() {
	   
	   for (int row = 0; row < ROWS; ++row) {
		   for(int col = 0; col < COLUMNS; ++col) {
			   board[row][col].clear(); {
				  return false; //not empty
				   
			   }
		   }
	   }
	return true; // no empty cell, it's a draw
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

	   // Diagonal check (check both directions
	   if(board[0][0].content == player && board[1][1].content == player && board[2][2].content == player) {
		   return true;
	   }
	   if(board[0][2].content == player && board[1][1].content == player && board[2][0].content == player) {
		   return true;
	   }

	   // No one has won yet
	   return false;
   }

   /**
    * Draws the tic-tac-toe board to the screen
    */
   public void display() {
	     for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLUMNS; ++col) {
	            board[row][col].display();   // each cell paints itself
	            if (col < COLUMNS - 1) System.out.print("|");
	         }
	         System.out.println();
	         if (row < ROWS - 1) {
	            System.out.println("-----------");
	         }
	      }
	   }
	}