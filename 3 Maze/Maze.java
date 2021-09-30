import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Implement a basic maze.
 * EN.500.132 Bootcamp Java
 */
public class Maze {

   /** Default maze size (rows and columns), set to 8. */
   private static final int SIZE = 8;

   /** The grid of cells. */
   private Cell[][] grid;

   /** How many rows are in the maze. */
   private int rows;

   /** How many columns are in the maze. */
   private int cols;


   /** Create the internal structure of a maze of a default size. */
   public Maze() {
      // TODO: REPLACE THIS STUB
      this.init(this.SIZE, this.SIZE);
   }

   /**
    * Create the internal structure a maze of a specified size. 
    * @param r the desired number of rows in the maze
    * @param c the desired number of columns in the maze 
    */
   public Maze(int r, int c) {
      // TODO: REPLACE THIS STUB
      this.init(r, c);

   }


   /** 
    * Initialize the internal structure for a maze of a specific size.
    * This is a helper method which is called from all class constructors. 
    * @param r the number of rows
    * @param c the number of columns 
    */
   private void init(int r, int c) {
      // TODO: REPLACE THIS STUB
      this.rows = r;
      this.cols = c;
      this.grid = new Cell[r][c];      
   }


   /**
    * Create and return one (long) string that
    * contains the row and column dimensions of the maze, then a
    * newline, followed by the string representation of each cell,
    * one row at a time, with each cell separated from the next with
    * one space and each row separated from the next by a newline
    * ('\n').
    * @return the string representation
    */
   public String toString() {
      // TODO: REPLACE THIS STUB
      String result = "";
      result.concat(String.valueOf(this.rows));
      result.concat(" ");
      result.concat((String.valueOf(this.cols)));
      for (int i = 0; i < this.rows; ++i) {
         result.concat("\n");
         for (int j = 0; j < this.cols; ++j) {
            result.concat(this.grid[i][j].getData());
            result.concat(" ");
         }
      }
      return result;
   }

   /**
    * Read a maze from a plain text file whose name is supplied as
    * a parameter to this method, and validate the mazes's wall structure.
    * This method assumes the specified file exists.
    * The first line in the text file must contain the number of rows and
    * columns, respectively. Each subsequent line provides the wall
    * information for the cells in a single row, using a 4-character 
    * string ("bit string") in NESW (north-east-south-west) order for
    * each cell. A 1 "bit" indicates the wall exists, a 0 "bit" (or any
    * character other than 1) means no wall.
    * @param s is the external name of the file to read
    * @return true if a valid maze is created, false otherwise
    * @throws IOException if file is not well-formatted
    */
   public boolean readMaze(String s) throws IOException {
      // TODO: REPLACE THIS STUB
      Scanner in = new Scanner(new FileReader(s));
      // read file into arraylist<>
      ArrayList<String> lS = new ArrayList<>();
      while (in.hasNextLine()) {
         lS.add(in.nextLine());
      }
      in.close();  
      // split first line on spaces
      String[] parts = lS.get(0).split("\\s+");
      this.rows = Integer.parseInt(parts[0]);
      this.cols = Integer.parseInt(parts[1]);
      // iterate line by line
      for (int i = 0; i < this.rows; ++i) {
         String[] rS = lS.get(i + 1).split("\\s+");
         for (int j = 0; j < this.cols; ++j) {
            this.grid[i][j] = new Cell();
            this.grid[i][j].setWalls(rS[j]);
         } 
      } if (this.isValid()) {
         return true;
      } return false;
   }

   /**
    * Validate the cells of a maze as being consistent with respect
    * to neighboring internal walls. For example, suppose some cell
    * C has an east wall. Then for the maze to be valid, the cell
    * to C's east must have a west wall. (This method does not consider
    * external walls.) This method does not check for solvability
    * of the maze.
    * @return true if valid, false otherwise
    */
   public boolean isValid() {
      // TODO: REPLACE THIS STUB
      for (int i = 1; i < this.rows - 1; ++i) {
         for (int j = 1; j < this.cols - 1; ++j) {          
            if (this.grid[i][j].hasNorth()) {
               if (!(this.grid[i - 1][j].hasSouth())) {
                  return false;
               }
            } else if (this.grid[i][j].hasEast()) {
               if (!(this.grid[i][j + 1].hasWest())) {
                  return false;
               }
            } else if (this.grid[i][j].hasSouth()) {
               if (!(this.grid[i + 1][j].hasNorth())) {
                  return false;
               }
            } else if (this.grid[i][j].hasWest()) {
               if (!(this.grid[i][j - 1].hasEast())) {
                  return false;
               }
            } else {
               if (this.grid[i][j - 1].hasSouth() || this.grid[i + 1][j].hasWest() || this.grid[i][j + 1 ].hasNorth() || this.grid[i - 1][j].hasEast()) {
                  return false;
               }
            } 
         
         }
      } return true;
   }
                


   /**
    * Return the Cell object stored at the given (row, column) position.
    * This method assumes its arguments describe a legal position.
    * @param r the row position of the Cell in the Maze object
    * @param c the column position of the Cell in the Maze object
    * @return the Cell object that is at the specified position
    */
   public Cell getCellAt(int r, int c) {
      // TODO: REPLACE THIS STUB
      return this.grid[r][c];
   }


   /**
    * Set the contents of a Cell in a given (row, column) position.
    * This method assumes its arguments describe a legal position.
    * @param r the row position of the Cell in the Maze object
    * @param c the column position of the Cell in the Maze object
    * @param d the data String to store at the specified position
    * @return the former contents of the cell
    */
   public String setCellAt(int r, int c, String d) {
      // TODO: REPLACE THIS STUB
      return this.grid[r][c].setData(d);
   }


   /**
    * Get the number of rows in the maze.
    * @return the number of rows in the maze
    */
   public int getNumRows() {
      return this.rows;  // THIS METHOD IS COMPLETE
   }

   /**
    * Get the number of columns in the maze.
    * @return the number of columns in the maze
    */
   public int getNumCols() {
      return this.cols;  // THIS METHOD IS COMPLETE
   }


   /**
    * Solve the maze, assuming start in top left cell and finish
    * in bottom right cell. This method changes data values inside
    * explored cells, so that cells which are determined to be part
    * of the final path ("the solution") through the maze will now
    * contain the string "P" as their data, while cells which 
    * were explored but not selected as part of the solution path 
    * will now contain "x" as their data. If no complete solution path
    * in the maze exists, no cells' data will be permanently changed
    * to "P", but many may now contain "x". 
    * @return true if solved, false if fails
    */
   public boolean solve() {
      // TODO: REPLACE THIS STUB
      if (this.solve(0, 0, (this.rows - 1), (this.cols - 1))) {
         return true;
      } else {
         return false;
      }
   }
   
   /**
    * Solve the maze from a given starting point to ending cell.
    * This method changes data inside explored cells,
    * so that cells which are part of the final path through the
    * maze contain "P" as their data, while cells which were explored
    * but not selected as part of the solution path contain "x" as
    * their data. If no complete solution path in the maze exists, 
    * no cells' data will be permanently changed to "P", but many may
    * now contain "x". 
    * @param srow the start row index
    * @param scol the start col index
    * @param erow the end row index
    * @param ecol the end col index
    * @return true if solved, false otherwise
    */
   public boolean solve(int srow, int scol, int erow, int ecol) {
      // TODO: REPLACE THIS STUB
      if (this.grid[srow][scol].getData().equals("P") || this.grid[srow][scol].getData().equals("x")) {
         return false;
      }
      
      this.grid[srow][scol].setData("P");
      
      
      if (this.grid[srow][scol].equals(this.grid[erow][ecol])) {
         return true;
      } else {
         if (!(this.grid[srow][scol].hasNorth()) && !(this.grid[srow - 1][scol].getData().equals("P"))) {
            if (this.solve(srow - 1, scol, erow, ecol)) {
               return true;
            }
         }
         if (!(this.grid[srow][scol].hasEast()) && !(this.grid[srow][scol + 1].getData().equals("P"))) {
            if (this.solve(srow, scol + 1, erow, ecol)) {
               return true;
            }
         }
         if (!(this.grid[srow][scol].hasSouth()) && !(this.grid[srow + 1][scol].getData().equals("P"))) {
            if (this.solve(srow + 1, scol, erow, ecol)) {
               return true;
            }
         }
         if (!(this.grid[srow][scol].hasWest()) && !(this.grid[srow][scol - 1].getData().equals("P"))) {
            if (this.solve(srow, scol - 1, erow, ecol)) {
               return true;
            }
         } 
         this.grid[srow][scol].setData("x");
      } 
      
      return false; 
   } 

}
