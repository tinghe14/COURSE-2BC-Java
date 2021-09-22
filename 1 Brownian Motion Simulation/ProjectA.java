import java.util.Scanner; 
import java.util.Random;

/** 
 * Homework.
 * This program simulate the Brownian Motion, given the num 
 * of particle and num of step per walk and will generate the 
 * accumulated minimum walk length and maximum walk length 
 * 
 * EN.500.132 Bootcamp Java, Fall 2021
 * Project A Brownian Motion
 * @Author: Ting He
 * @JHED: the14
 * @Date: 0915,2021
 */
public class ProjectA {

   /** 
    * Main method.
    * @param args not used
    */
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      Random rand = new Random();
      
      int red;
      int green;
      int blue;
      int angle;
      int length;
      double total;
      double min;
      double max;
      int numParticles;
      int totalSteps;
      int stepCount;
      double x0;
      double y0;
      double x1;
      double y1;
      
      // fixed-value "constants" needed by the program
      final int COLORMAX = 256;
      final int CANVASCOORDINATEMAX = 256;
      final int STEPMIN = 5;
      final int STEPRANGE = 11; // number of values between 5 and 15, inclusive
      
      // prompt for and collect parameter from the user
      System.out.print("Enter number of particles to simulate: ");
      numParticles = scnr.nextInt();
      System.out.print("Enter number of steps per walk: ");
      totalSteps = scnr.nextInt();
      
      // Adjust the scale of the canvas; (0,0) is now in center
      StdDraw.setScale(-CANVASCOORDINATEMAX, CANVASCOORDINATEMAX);
      
      // ******************************
      // My code
      //*******************************
      
      StdDraw.setXscale(-256.0, 256.0); // Canvas X and Y scale (-256,256)
      StdDraw.setYscale(-256.0, 256.0);
      min = (STEPRANGE + STEPMIN - 1) * totalSteps;
      max = 0.0;
      
      // Generate new point at random
      for (int i = 1; i <= numParticles; ++i) {
         // Assign fixed color for point
         red = rand.nextInt(COLORMAX);
         green = rand.nextInt(COLORMAX);
         blue = rand.nextInt(COLORMAX);
         StdDraw.setPenColor(red, green, blue);
         x0 = 0;
         y0 = 0; // Original point
         total = 0; 
         
         for (stepCount = 0; stepCount < totalSteps; ++stepCount) {
            // Assign randomed angle for this step
            angle = rand.nextInt(360) + 0; 
            // Assign randomed length of step for this step (between 5 and 15)
            length = rand.nextInt(STEPRANGE) + STEPMIN;  
            // Caculate new coordinates for this step        
            x1 = Math.cos(Math.toRadians(angle)) * length + x0; 
            y1 = Math.sin(Math.toRadians(angle)) * length + y0;
            
            // Draw the path for this step
            StdDraw.line(x0, y0, x1, y1); 
            x0 = x1;
            y0 = y1;
            // Accumulated walk length
            total = total + length; 
         }
         
         if (total > max) {
            max = total;
         }
         if (total < min) {
            min = total;
         }        

      }
      
      
      System.out.println("Minimum walk length: " + min);
      System.out.println("Maximum walk length: " + max);
      
   }
}