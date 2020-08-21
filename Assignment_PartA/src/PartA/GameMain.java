import java.util.Scanner;				// Scanner required for player input
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The main class for the game Tic-Tac-Toe.
 * Controls the flow of the game, allowing each player to enter an option until the game ends.
 */

public class GameMain extends JFrame implements ActionListener, KeyListener {
	private static Scanner scanner = new Scanner(System.in);  // Scanner for input

	private Grid grid;					// The game board
	private boolean gameOver;			// Whether game is playing or over
	private Player winner;				// Winner of the game
	private Player currentPlayer;		// Current player (enum)
    
	private final static Color BACKGROUND_COLOUR = Color.WHITE;
	private final static int TIMER_DELAY = 5;
	private final static int BALL_MOVEMENT_SPEED = 1;
	private final static int POINTS_TO_WIN = 3;
	private final static int SCORE_TEXT_X = 100;
	private final static int SCORE_TEXT_Y = 100;
	private final static int SCORE_FONT_SIZE = 50;
	private final static String SCORE_FONT_FAMILY = "Serif";
	private final static int WINNER_TEXT_X = 200;
	private final static int WINNER_TEXT_Y = 200;
	private final static int WINNER_FONT_SIZE = 40;
	private final static String WINNER_FONT_FAMILY = "Serif";
	private final static String WINNER_TEXT = "WIN!";

	
   /**
    * Constructor
    * Sets up the game. Creates the grid and sets the values of the variables before calling the play method.
    */
   public GameMain() {
	setBackground(BACKGROUND_COLOUR);
	Timer timer = new Timer(TIMER_DELAY, this);
    timer.start();
    addKeyListener(this);
    setFocusable(true);
	   // Create the grid

	   // TODO: Create a new instance of the "Grid"class

	   // Reset the game variables to their defaults

	   // TODO: Assign the default values for currentPlayer (Player.X), gameOver (false), and winner (null)

	   // Begin playing the game

	   // TODO: Call the "play()" method
   }

   /**
    * Controls the game play, rotates between player turns until a winner is decided.
    */
   public void play() {
	   do {
	         playerMove(currentPlayer);			// Have the player perform their move
	         grid.display();					// Display the current game board
	         checkForWinner(currentPlayer);		// Checks if the game has been won

	         // Display results if game is over
	         if(gameOver) {
	        	 if(winner == Player.X) {
		        	 System.out.println("Player X wins!");
		         }
	        	 else if(winner == Player.O) {
			        	 System.out.println("Player O wins!");
		         }
	        	 else if(winner == null) {
				        	 System.out.println("DRAW!");
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
        	 // TODO: Inform Player 'O' to enter their move
         }

         // Obtains input from the player for both row and column
         int row = scanner.nextInt();
         int col = scanner.nextInt();

         // Decrease the value entered by 1 to compensate for the array index starting at 0
         row--;
         col--;

         // Verify the values the player entered are valid (position is valid and empty)
         if (row >= 0 && row < Grid.ROWS && col >= 0 && col < Grid.COLUMNS && grid.board[row][col].content == Player.EMPTY) {
        	 grid.board[row][col].content = turnPlayer;
        	 grid.currentRow = row;
        	 grid.currentCol = col;
        	 validInput = true;
         } else {
        	 System.out.println("Invalid Move, please re-enter");

        	 // TODO: Display an error message that the move was not valid.
         }

      } while (!validInput);   // Repeat until input is valid
   }

   /**
    * Checks if the game has ended
    */
   public void checkForWinner(Player turnPlayer) {
      if (grid.hasWon(turnPlayer)) {

    	  // TODO: Set gameOver and winner appropriately

      } else if (grid.isDraw()) {

    	  // TODO: Set gameOver and winner appropriately
      }
   }

   /**
    * The main() method
    */
   public static void main(String[] args) {

	   // TODO: Add a loop to restart the game once it has finished

	   // TODO: Then update the loop to ask the player if they want to play again, exit if they do not
       
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
} 