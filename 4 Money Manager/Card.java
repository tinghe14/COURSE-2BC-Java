/**
 * Card is a Money subclass, to represent a credit or debit card
 * that has a starting value, the name of the issuing company, 
 * and weighs 5 grams.
 * @author: Ting He
 * @JHID: the14 
 */
public class Card extends Money {

   /** The issuing company name (Visa, Starbucks, etc.). */
   // ADD THIS
   protected String name;
   
   /**
    * Create a Card object, initializing the starting value and
    * name, and setting its weight to 5 grams.
    * @param amount the face value of the Card
    * @param name the issuing company
    */
   public Card(double amount, String name) {  // GIVEN COMPLETE
      super(amount, 5);
      this.name = name;
   }
   
   /** 
    * Find out the Card's issuing company's name.
    * @return the name
    */
   public String name() {    // GIVEN COMPLETE
      return this.name;
   }
      
   /**
    * Find out the Card's value in US dollars.
    * @return the US equivalent value
    */
   @Override
   public double value() {   // GIVEN COMPLETE
      return this.denomination;
   }
   
   /**
    * Buy something that costs the given amount, if current value is enough.
    * @param amount the cost of the purchase 
    * @return true if successful, false otherwise
    * @throws IllegalArgumentException if the amount is negative
    */
   public boolean buy(double amount) {   // WRITE THIS
      double tempV;
      if (amount > 0) {
         tempV = this.value() - amount;
         if (this.value() >= amount) {
            System.out.println("true " + tempV);
            this.denomination = tempV;
            return true;
         } else {
            System.out.println("false " + this.value());
            this.denomination = this.value();
            return false;
         }
      }
      else {
         throw new IllegalArgumentException("amount is negative");
      }     
   } 
   
   /**
    * Add some amount to the funds available on the card.
    * @param amount how much to add, must not be negative
    * @throws IllegalArgumentException if the amount is negative
    */
   public void refill(double amount) {   // WRITE THIS
      if (amount >= 0) {
         this.denomination = this.denomination + amount;
         System.out.println("true " + amount);
      } 
      else {
         throw new IllegalArgumentException("amount is negative");
      }
   } 
   
   /**
    * Create a String representation of this Card,
    * formatted as US dollars, including the company name.
    * @return the string representation
    */
   @Override
   public String toString() {   // WRITE THIS
      String temp;
      temp = super.toString().concat(" on ");
      temp = temp.concat(this.name());
      return temp;
   } 
   
   /**
    * Check for Card equality, but with case insensitive name comparison.
    * @param other the object to compare to this
    * @return true if this is equivalent to other, false otherwise
    */
   @Override
   public boolean equals(Object other) {  // WRITE THIS
      if (! (other.getClass().equals(this.getClass()))) {
         return false;
      }
      Card n = (Card) other;
      return this.denomination == n.denomination && this.name.equals(n.name) && 
               this.weight == n.weight;
   } 
   
}