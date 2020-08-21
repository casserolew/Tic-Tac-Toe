/**
 * The Box class models each individual box of the Grid
 */
public class Box {

   Player content;			// The move this box holds (Empty, X, or O)
   int row, col; 			// Row and column of this box (Not currently used but possibly useful in future updates)

   /**
    * Constructor
    */
   public Box(int row, int col) {

	   // TODO: Initialise the variables row, col, and content

   }

   /**
    * Clear the box content to EMPTY
    */
   public void clear() {

      // TODO: Set the value of content to EMPTY (Remember this is an enum)

   }

   /**
    * Display the content of the box
    */
   public void display() {

	   // TODO: Print the content of this box (" X " if it Player.X, " O " for Player.O and "   " for Player.Empty)
	   // Hint: Can use an if-else or switch statement

   }
} 