import java.util.Random;

/** 
 * A collection of money that only holds Bills and Cards, with limited
 * capacity for each.
 * @author: Ting He
 * @JHID: the14 
 */
public class Wallet extends MoneyBag { 
   /** The random value generator to use. */
   private static Random randy = new Random();
   /** How many bills the Wallet can hold. */
   private int maxBills;
   /** How many cards the Wallet can hold. */
   private int maxCards;
   
   // === ADD MORE INSTANCE VARIABLES AS NEEDED ===
   /** How many bills the Wallet actually holds. */
   private int numBills;
   /** How many cards the Wallet actually hold. */
   private int numCards;


   /** 
    * Create a wallet for money, with limits for what it can hold.
    * @param bills the maximum number of Bills that can go in
    * @param cards the maximum number of Cards that can go in
    */
   public Wallet(int bills, int cards) {  // GIVEN COMPLETE
      super(MAXWEIGHT);
      this.maxBills = bills;
      this.maxCards = cards;
   }
   
   /**
    * Add a Money item to this Wallet, if it doesn't exceed the 
    * Bills or Cards max, and satisfies the inherited add properties.
    * @param m the Money object to add if possible
    * @return true if it was added
    * @throws ContainerFullException if adding would exceed a limit
    * @throws IllegalArgumentException if adding something other than 
    * a Bill or Card
    */
   @Override
   public boolean add(Money m) {    // WRITE THIS
      int tempBills;
      int tempCards;
      if (m instanceof Bill) {
         tempBills = this.numBills + 1;
         if (tempBills <= this.maxBills) {
            this.numBills += 1;
            super.add(m);
            return true;
         } else {
            throw new ContainerFullException("limited space, no bill anymore");
         }
      } else if (m instanceof Card) {
         tempCards = this.numCards + 1;
         if (tempCards <= this.maxCards) {
            this.numCards += 1;
            super.add(m);
            return true;
         } else {
            throw new ContainerFullException("limited space, no card anymore");
         }
      } else {
         throw new IllegalArgumentException("Wallet can add bill, card only");
         }
   }
   
   
   /**
    * Remove a specific Money object from the Wallet, if found. 
    * @param m the Money object to search for and remove
    * @return true if successful, false otherwise
    * @throws InsufficentFundsException if the MoneyBag is empty
    */
   public boolean remove(Money m) {   // GIVEN COMPLETE
      if (this.size == 0) {
         throw new InsufficientFundsException("MoneyBag is empty");
      }
       
      int which = this.whereIs(m);
      if (which > -1 && which < this.size()) { // found
         this.monies[which] = this.monies[--this.size];
         this.weight -= m.weight();
         this.value -= m.value();
         if (m instanceof Bill) {
            this.numBills--;
         } else {
            this.numCards--;
         }
         return true;
      }
      return false;
   }
   
    /**
    * Randomly choose a Money object and remove it from the Bag,
    * being careful not to leave "holes" in the underlying container (array). 
    * @return the Money object removed, if successful
    * @throws InsufficentFundsException if the MoneyBag is empty
    */
   @Override
   public Money remove() {    // WRITE THIS
      if (this.size != 0) {
         int which = randy.nextInt(this.size);
         Money m = this.monies[which];
         this.monies[which] = this.monies[--this.size];
         this.weight -= m.weight();
         this.value -= m.value();
         if (m instanceof Bill) {
            --this.numBills;
         } else {      
            --this.numCards;
         }   
         return m;
      } else {
         throw new InsufficientFundsException("MoneyBag is empty");
      }

   }
   
   /** 
    * Sort the Wallet in ascending order based on value.
    * Choose whichever type of sort algorithm you want to implement.
    */
   public void sort() {    // WRITE THIS
      for (int tempI = 0; tempI < this.size - 1; ++tempI) {
         int indexSmallest = tempI;
         for (int tempJ = tempI + 1; tempJ < this.size; ++tempJ) {
            if (this.monies[tempJ].denomination() < this.monies[indexSmallest].denomination()) {
               indexSmallest = tempJ;
            }
         }
         Money[] temp = new Money[1];
         temp[0] = this.monies[tempI];
         this.monies[tempI] = this.monies[indexSmallest];
         this.monies[indexSmallest] = temp[0];
      }
   }
  
   /**
    * Create a String listing all Money objects contained, 
    * in ascending order by value, separated by line breaks.
    * @return the string listing
    */
   @Override
   public String toString() {    // WRITE THIS
      String result = "";
      this.sort();
      for (int i = 0; i < this.size - 1; i++) {
         result += this.monies[i] + "\n";
      } 
      if (this.size > 0) {
         result += this.monies[this.size - 1];
      }
      return result;
   }
     
}