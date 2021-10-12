/** 
 * Create an exception for when not enough funds exist for an operation.
 * @author: Ting He
 * @JHID: the14 
 */
public class InsufficientFundsException extends RuntimeException {
   
   /**
    * Create default exception object.
    */
   public InsufficientFundsException() {
      super("Insufficient Funds");
   }
    
   /**
    * Create an exception with a custom message.
    * @param msg customized error message
    */
   public InsufficientFundsException(String msg) {
      super(msg);
   }
   
}