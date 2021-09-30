/**
 * Cell represents a single tile of a maze.
 *
 * STUDENT WILL NEED TO COMPLETE THIS CLASS AS INDICATED BELOW
 * @author: Ting He
 * @JHED: the14
 * @Date: Sept 27, 2-21
 *
 */
public class Cell {

   /** This counter is used to number the cells in a maze; we give
       it package-level (not private or public) access on purpose. */
   static int count = 0;

   /** The number of the cell in the grid, counting left to right,
       top to bottom, starting at 0. */
   private int num;
   /** The data stored in the cell (ie, it's displayed label). */
   private String data;
   
   // TODO: ADD MORE PRIVATE INSTANCE VARIABLES AS NEEDED 
   // TO COMPLETE THE CLASS DEFINITION, BASED ON METHODS BELOW
   private boolean nW = true;
   private boolean sW = true;
   private boolean wW = true;
   private boolean eW = true;



   
   /**
    * Construct a cell that has all four walls by default, and
    * which is given a String value that matches the uniquely-
    * assigned number of the Cell.
    */
   public Cell() {
      this.num = count++;
      this.data = String.valueOf(this.num);
      // TODO: COMPLETE THIS CONSTRUCTOR (no need to edit lines above)
      this.nW = true;
      this.sW = true;
      this.wW = true;
      this.eW = true;    
   }
   
   /**
    * Cell constructor with explicit wall parameters, and
    * which is given a String value that matches the uniquely-
    * assigned number of the Cell.
    * @param n true if north side of the cell should have a wall
    * @param s true if south side of the cell should have a wall
    * @param w true if west side of the cell should have a wall
    * @param e true if east side of the cell should have a wall
    */
   public Cell(boolean n, boolean s, boolean e, boolean w) {
      // TODO: REPLACE THIS STUB
      this.num = count++;
      this.data = String.valueOf(this.num);
      this.nW = n;
      this.sW = s;
      this.eW = e;
      this.wW = w;                                                
   }
   
   /**
    * Use a "bit" string in NESW (north-east-south-west) order to 
    * represent and set the walls of this cell. A 1 bit indicates 
    * that the wall exists, a 0 (or anything else) means no wall.
    * The given string is assumed to have length at least 4; any 
    * characters in it beyond the first four will be ignored.
    * @param walls the bit string to parse
    */
   public void setWalls(String walls) {
      // TODO: REPLACE THIS STUB
      if (walls.charAt(0) == '1') {
         this.nW = true;
      }
      else {
         this.nW = false;
      }
      if (walls.charAt(1) == '1') {
         this.eW = true;
      }
      else {
         this.eW = false;
      }
      if (walls.charAt(2) == '1') {
         this.sW = true;
      }
      else {
         this.sW = false;
      }
      if (walls.charAt(3) == '1') {
         this.wW = true;
      }
      else {
         this.wW = false;
      }     
   }

   /**
    * Get a "bit string" representation of this cell's walls, in 
    * NESW (north-east-south-west) order.
    * A 1 represents that a wall exists, and a 0 represents no wall.
    * For example, "1001" is returned when only the north and west
    * walls exist for a cell.
    * @return the 4-character "bit string"
    */
   public String toString() {
      // TODO: REPLACE THIS STUB
      if (this.nW == true & this.eW == true & this.sW == true & this.wW == true) {
         return this.data = "1111";
      }
      else if (this.nW == true & this.eW == false & this.sW == false & this.wW == false) {
         return this.data = "1000";
      }
      else if (this.nW == false & this.eW == true & this.sW == false & this.wW == false) {
         return this.data = "0100";
      }
      else if (this.nW == false & this.eW == false & this.sW == true & this.wW == false) {
         return this.data = "0010";
      }
      else if (this.nW == false & this.eW == false & this.sW == false & this.wW == true) {
         return this.data = "0001";
      }
      else if (this.nW == true & this.eW == true & this.sW == false & this.wW == false) {
         return this.data = "1100";
      }
      else if (this.nW == true & this.eW == false & this.sW == true & this.wW == false) {
         return this.data = "1010";
      }
      else if (this.nW == true & this.eW == false & this.sW == false & this.wW == true) {
         return this.data = "1001";
      }
      else if (this.nW == false & this.eW == true & this.sW == true & this.wW == false) {
         return this.data = "0110";
      }
      else if (this.nW == false & this.eW == true & this.sW == false & this.wW == true) {
         return this.data = "0101";
      }
      else if (this.nW == false & this.eW == false & this.sW == true & this.wW == true) {
         return this.data = "0011";
      }
      else if (this.nW == true & this.eW == true & this.sW == true & this.wW == false) {
         return this.data = "1110";
      }
      else if (this.nW == true & this.eW == true & this.sW == false & this.wW == true) {
         return this.data = "1101";
      }
      else if (this.nW == true & this.eW == false & this.sW == true & this.wW == true) {
         return this.data = "1011";
      }
      else if (this.nW == false & this.eW == true & this.sW == true & this.wW == true) {
         return this.data = "0111";
      }
      else {
         return this.data = "0000";
      }      
   }

   /**
    * Return whether this cell's north wall exists.
    * @return true if and only if the north wall exists
    */
   public boolean hasNorth() {
      //return false;  // TODO: REPLACE THIS STUB
      if (this.nW == true) {
         return true;
      }
      else {
         return false;
      }
   }

   /**
    * Return whether this cell's east wall exists.
    * @return true if and only if the east wall exists
    */
   public boolean hasEast() {
      //return false;  // TODO: REPLACE THIS STUB
      if (this.eW == true) {
         return true;
      }
      else {
         return false;
      }      
   }

   /**
    * Return whether this cell's south wall exists.
    * @return true if and only if the south wall exists
    */
   public boolean hasSouth() {
      //return false;  // TODO: REPLACE THIS STUB
      if (this.sW == true) {
         return true;
      }
      else {
         return false;
      }         
   }

   /**
    * Return whether this cell's west wall exists.
    * @return true if and only if the west wall exists
    */
   public boolean hasWest() {
      //return false;  // TODO: REPLACE THIS STUB
      if (this.wW == true) {
         return true;
      }
      else {
         return false;
      }       
      
   }


   /** 
    * Return the String data stored in this cell.
    * @return the data value
    */
   public String getData() {
      //return "not yet implemented";  // TODO: REPLACE THIS STUB
      return this.data;
   }

   /** 
    * Set the String contents of this cell.
    * @param contents the cell's new data
    * @return the original contents
    */
   public String setData(String contents) {
      String temp = this.data;
      this.data = contents;
      return temp;  // TODO: REPLACE THIS STUB
   }

   /**
    * Get the cell number in the grid.
    * @return the number
    */
   public int getNumber() {
      //return -1;  // TODO: REPLACE THIS STUB
      return this.num;
      //System.out.print(num);
   }

   /**
    * Check if two cells are the same in a grid, based on number only.
    * @param other the other cell to compare to this
    * @return true if same, false otherwise
    */
   public boolean equals(Cell other) {
      //return false;  // TODO: REPLACE THIS STUB
      if (this.getNumber() == other.getNumber()) {
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
    * Check if an Object is same as this cell, based on number only. 
    * If the Object is not a cell, then return false.
    * THIS METHOD IS COMPLETE; STUDENT SHOULD NOT MODIFY IT.
    * @param other the other cell to compare to this
    * @return true if same, false otherwise
    */
   public boolean equals(Object other) {
      if (!(other instanceof Cell)) {
         return false;
      }
      // now other must be a cell, so we can call the other equals method
      return this.equals((Cell) other);
   }

}
