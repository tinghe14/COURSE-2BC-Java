/**
 * Coin is a Money subclass, to represent one US coin
 * that has a denomination (US value in pennies), and standard weight.
 * @author: Ting He
 * @JHID: the14 
 */
public class Coin extends Money {
   
   /**
    * Create a Coin ojbect, initializing the denomination of the 
    * currency unit and setting its weight according to the list below.
    * @param pennies the value of the Coin in pennies
    */     
   public Coin(int pennies) {
      super((double)pennies, 0);
      if (pennies == 1) {
         super.weight = 2.5;
      }
      else if (pennies == 5) {
         super.weight = 5;
      }
      else if (pennies == 10) {
         super.weight = 2.268;
      }
      else if (pennies == 25) {
         super.weight = 5.67;
      }
      else if (pennies == 100) {
         super.weight = 8.1;
      }
      else {
         throw new IllegalArgumentException("invalid US coin denomination");
      }
   }
   
    /**
     * Find the Coin's value in US dollar.
     * @return the US equivalent value
     */ 
   @Override
   public double value() {
      double temp;
      temp = this.denomination() / 100.0;
      return temp;
   }
}