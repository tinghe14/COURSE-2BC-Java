import java.util.Random;

/** 
 * A collection of money that has a total weight limit, 
 * but no limit to how many Money objects it holds, or their total value.
 *
 * You must not use ArrayList or other Java API collection classes in
 * completing this class definition. 
 * @author: Ting He
 * @JHID: the14 
 */
public class MoneyBag {

   /** The maximum weight that any MoneyBag can hold, in grams. */
   public static final double MAXWEIGHT = 500000; 
   /** The random value generator to use. */
   private static Random randy = new Random();

   /** The collection of Money objects it holds. */
   protected Money[] monies;

   // === ADD MORE INSTANCE VARIABLES AS NEEDED ===
   /** value in US dollar in MoneyBag. */
   protected double value;
   /** size in MoneyBag. */
   protected int size;
   /** weight in MoneyBag. */
   protected double weight;
   
   /** How much weight this MoneyBag can hold in grams. */
   private double limit;

   /** 
    * Create a container for money, with a specified weight limit and 
    * initial size of 5, meaning it can hold 5 Money objects.
    * @param weightLimit the total amount of weight the bag can hold
    * @throws IllegalArgumentException if weightLimit is too high
    */
   public MoneyBag(double weightLimit) {  // GIVEN COMPLETE
      this.size = 0;
      this.monies = new Money[5];
      if (weightLimit <= MAXWEIGHT) {
         this.limit = weightLimit;
      } else {
         throw new IllegalArgumentException("too much weight");
      }
      this.weight = 0;
   }
   
   /** 
    * Find out what the weight limit for this MoneyBag is.
    * @return the weight limit
    */
   public double limit() {   // GIVEN COMPLETE
      return this.limit;
   }

   /**
    * Find out how many Money objects the MoneyBag currently holds.
    * @return the amount
    */
   public int size() {    // WRITE THIS
      return this.size;
   } 
      
   /**
    * Find out the total weight of all the Money objects in this MoneyBag.
    * @return the weight, in grams
    */
   public double weight() {   // GIVEN COMPLETE
      return this.weight;
   } 
   
   /**
    * Add a Money item to this MoneyBag, if it doesn't exceed the weight limit,
    * doubling the container capacity if room for more objects is needed.
    * @param m the Money object to add if possible
    * @return true if it was added
    * @throws ContainerFullException if adding would exceed the weight limit
    */
   public boolean add(Money m) {    // GIVEN COMPLETE
      if (m.weight() + this.weight <= this.limit) {
         if (this.size >= this.monies.length) {
            Money[] temp = new Money[this.monies.length * 2];
            for (int i = 0; i < size; i++) {
               temp[i] = this.monies[i];
            }
            this.monies = temp;
         }
         //this.size = this.size + 1;
         this.monies[this.size++] = m;
         this.weight += m.weight();
         this.value += m.value();
         return true;
      }
      else {
         throw new ContainerFullException("MoneyBag weight issue");
      }
   }
   
   /**
    * Determine if this MoneyBag contains a particular Money object.
    * @param m the money object to find
    * @return the first index where it is found, or -1 if no match
    */
   public int whereIs(Money m) {        // WRITE THIS
      for (int i = 0; i < this.size; i++) {
         if (this.monies[i].equals(m)) {
            return i;
         }
      } return -1;
   }
   
   
   /** 
    * Determine the total value of contents, expressed in US dollars.
    * @return the total value
    */
   public double value() {      // WRITE THIS
      return this.value;
   }
   
   /**
    * Randomly choose a Money object and remove it from the Bag,
    * being careful not to leave "holes" in the underlying container (array). 
    * @return the Money object removed, if successful
    * @throws InsufficentFundsException if the MoneyBag is empty
    */
   public Money remove() {    // WRITE THIS
      if (this.size >= 1) {
         int tempIndex = this.randy.nextInt(this.size);
         Money[] temp = new Money[this.size - 1];
         Money[] delTemp = new Money[1];
         for (int i = 0, k = 0; i < this.size; ++i) {
            if (i == tempIndex) {
               delTemp[0] = this.monies[tempIndex];
               continue;
            }
            temp[k++] = this.monies[i];
         }
         this.size = this.size - 1;
         this.value = this.value - monies[tempIndex].value();
         this.weight = this.weight - monies[tempIndex].weight();
         this.monies = temp;
         return delTemp[0];
      } else {
         throw new InsufficientFundsException("MoneyBag is empty");
      }
   }
  
   /**
    * Create a String listing all Money objects this contains, 
    * in no particular order, separated by line breaks.
    * @return the string listing
    */
   public String toString() {    // GIVEN COMPLETE
      String result = "";
      for (int i = 0; i < this.size - 1; i++) {
         result += this.monies[i] + "\n";
      } 
      if (this.size > 0) {
         result += this.monies[this.size - 1];
      }
      return result;
   }
 
}