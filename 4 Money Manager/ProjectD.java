import java.util.Scanner;

/**
 * Menu-driven program to work with (and test) the money-related classes.
9
 * @author: Ting He
 * @JHID: the14 
 */
public class ProjectD {

   static final Scanner SCNR = new Scanner(System.in);
   static final String PROMPT = "Enter the number of your choice -> ";
   static final String ERROR = "invalid data, try again";

   public static void main(String[] args) { // GIVEN COMPLETE
      int choice;
      
      do {
         System.out.println("0) Quit the program");
         System.out.println("1) MoneyBag testing");
         System.out.println("2) Wallet testing");
         System.out.print(PROMPT);
         choice = SCNR.nextInt();
         switch (choice) {
            case 0: 
               break;
            case 1: bagTest(); 
               break;         
            case 2: walletTest(); 
               break;
            default: System.out.println(ERROR);
         }
      } while (choice != 0);
   }
   
   /** 
    * Print the common menu operations.
    */
   public static void menuOps() {  // GIVEN COMPLETE
      System.out.println();
      System.out.println("0) Return to main menu");
      System.out.println("1) Create a new MoneyBag/Wallet");
      System.out.println("2) Display the weight limit");
      System.out.println("3) Display the size");
      System.out.println("4) Display the total weight");
      System.out.println("5) Display the total value");
      System.out.println("6) Add money"); 
      System.out.println("7) Remove a random Money item"); 
      System.out.println("8) Report the location of a Money item"); 
      System.out.println("9) Display the contents");
   }
   
   /**
    * Process the common operations.
    * @param mbag the money container to process
    * @param choice the operation to execute
    */
   public static void process(MoneyBag mbag, int choice) { // WRITE SOME
      Money mny = null;
      boolean success; 
      
      switch (choice) {        
         case 2: 
            // System.out.println("STUDENT MUST IMPLEMENT"); 
            System.out.println(mbag.limit());            
            break;
         case 3: 
            System.out.println(mbag.size()); 
            break;
         case 4: 
            // System.out.println("STUDENT MUST IMPLEMENT"); 
            System.out.println(mbag.weight());            
            break;
         case 5: 
            System.out.println(mbag.value()); 
            break;
         case 6:
            // System.out.println("STUDENT MUST IMPLEMENT"); 
            try {
               Money temp = getMoney();
               mbag.add(temp);           
               System.out.println("true"); 
            } catch (ContainerFullException e) {
               System.out.println(e);
               break;
            }  
            break;
         case 7: 
            // System.out.println("STUDENT MUST IMPLEMENT"); 
            try {
               Money temp = mbag.remove();
               System.out.println(temp);
            } catch (InsufficientFundsException e) {
               System.out.println(e);
               break;
            }  
            break;
         case 8: 
            mny = null;
            mny = getMoney();
            System.out.println("location of " + mny + 
                              " is " + mbag.whereIs(mny));
            break;
         case 9: 
            System.out.println(mbag); 
            break;
         default:
            System.out.println(ERROR);
      }
   }
   
   /** 
    * Test the MoneyBag operations, starting with a MoneyBag that
    * has weight limit of 10 grams as a default.
    */
   public static void bagTest() {       // GIVEN COMPLETE
      MoneyBag mbag = new MoneyBag(10);
      int choice;
      
      do {
         menuOps();
         System.out.print(PROMPT);
         choice = SCNR.nextInt();
         if (choice >= 2 && choice <= 9) {
            process(mbag, choice);
         }
         else { 
            switch (choice) {
               case 0: 
                  return;
               case 1: 
                  System.out.print("Weight limit (grams)? ");
                  mbag = new MoneyBag(SCNR.nextDouble()); 
                  break; 
               default:
                  System.out.println(ERROR);
            }
         }
      } while (choice != 0);
   }
   
   /** 
    * Test the Wallet operations, starting with a Wallet that
    * has Bill limit 15 and Card limit 5 as a default.
    * Reuse other methods as much as possible! 
    */
   public static void walletTest() {   // WRITE THIS
      Money mw1 = null;
      Money mw2 = null;
      Wallet mwallet = new Wallet(15, 5);
      int choice;
      do {
         menuOps();
         System.out.print("10) Remove a specific Money item");
         System.out.print(PROMPT);
         choice = SCNR.nextInt();
         if (choice >= 2 && choice <= 10) {
            switch (choice) {
               case 2:
                  System.out.println(mwallet.limit());            
                  break;
               case 3:
                  System.out.println(mwallet.size()); 
                  break;
               case 4:
                  System.out.println(mwallet.weight());            
                  break;
               case 5:
                  System.out.println(mwallet.value()); 
                  break;
               case 6:
                  try {
                     Money temp = getMoney();
                     mwallet.add(temp);
                     System.out.println("true"); 
                  } catch (ContainerFullException e) {
                     System.out.println(e);
                     break;
                  } catch (IllegalArgumentException e) {
                     System.out.println(e);
                     break;
                  }
                  break;
               case 7:
                  try {
                     Money temp = mwallet.remove();
                     System.out.println(temp);
                  } catch (InsufficientFundsException e) {
                     System.out.println(e);
                     break;
                  }  
                  break;
               case 8:
                  mw1 = null;
                  mw1 = getMoney();
                  System.out.println("location of " + mw1 + 
                                    " is " + mwallet.whereIs(mw1));
                  break;
               case 9:
                  System.out.println(mwallet); 
                  break;
               case 10:
                  mw2 = null;
                  mw2 = getMoney();
                  try {
                     boolean temptf = mwallet.remove(mw2);
                  } catch (IllegalArgumentException e) {
                     System.out.println(e);
                     break;
                  }  
                  break;
               default:
                  System.out.println(ERROR);
            } 
         } else {
            switch (choice) {
               case 0: 
                  return;
               case 1: 
                  System.out.print("Bill limits & card limits? ");
                  mwallet = new Wallet(SCNR.nextInt(), SCNR.nextInt()); 
                  break; 
               default:
                  System.out.println(ERROR);
            }
         }

      } while (choice != 0);

   }
   
   /**
    * Create and test Money objects.
    * @return the generated Money
    */
   public static Money getMoney() {  // GIVEN COMPLETE
      int choice = 1;
      Bill bill = null;
      Coin coin = null;
      Card card = null;
   
      do {
         System.out.println("1) Get a Bill");
         System.out.println("2) Get a Coin");
         System.out.println("3) Get a Card");
         System.out.print(PROMPT);
         choice = SCNR.nextInt();
         switch (choice) {
            case 1:
               System.out.print("Enter Bill denomination: ");
               bill = new Bill(SCNR.nextDouble());
               System.out.println(bill.value());
               return bill;
            case 2:
               do {
                  try {
                     System.out.print("Enter Coin denomination (in pennies): ");
                     coin = new Coin(SCNR.nextInt());
                  } catch (IllegalArgumentException e) {
                     System.out.println(e);
                     coin = null;  // just making sure
                  }
               } while (coin == null);
               System.out.println(coin.value());
               return coin;
            case 3:
               System.out.print("Enter Card denomination & company name: ");
               card = new Card(SCNR.nextDouble(), SCNR.nextLine().substring(1));
               System.out.println(card.value());
               testCard(card);
               return card;
            default:  System.out.println(ERROR);    
         }
      } while (true);
   }
   
   /** 
    * Work with a new Card, printing menu and processing operations.
    * @param crd the Card to manipulate
    */
   public static void testCard(Card crd) {  // WRITE THIS
      int choice;
      int amount;
      do {
         System.out.println("1) Return Card");
         System.out.println("2) Buy something");
         System.out.println("3) Refill card");
         System.out.print(PROMPT);
         choice = SCNR.nextInt();
         switch (choice) {
            case 1:
               return;
            case 2:
               try {
                  System.out.println("enter amount:");
                  amount = SCNR.nextInt();
                  crd.buy(amount);
               } catch (IllegalArgumentException e) {
                  System.out.println(e.getMessage());
               }
               break;
            case 3:
               try {
                  System.out.println("enter amount:");
                  amount = SCNR.nextInt();
                  crd.refill(amount);
               } catch (IllegalArgumentException e) {
                  System.out.println(e.getMessage());
               }
               break;
            default: System.out.println(ERROR);
         }
      } while (choice != 1);

   
   }

}