import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;

/** 
 * Homework.
 * This program is to implement a simplified perceptron. given 
 * the training dataset and its ouputs, I will generate the
 * weight matrix and validate it at validation set by showing 
 * some statistical numbers.
 * 
 * EN.500.132 Bootcamp Java, Fall 2021
 * Project B Perceptron
 * @Author: Ting He
 * @JHED: the14
 * @Date: 0922,2021
 */
 
public class ProjectB {
   
   /** 
    * dimension method.
    * Get dimension of matrix
    * @param name
    *        (name of the file, string)
    * @return row
    *         (num of row in this file, int)
    *         col
    *         (num of column in  this file, int)
    */  
   public static int[] dimension(String name) {
      int dim[] = new int[2];
      int row; 
      int col;
      // read file
      try {
         URI uri = ProjectB.class.getClassLoader().getResource(name).toURI();
         List<String> lines = Files.readAllLines(
                              Paths.get(uri), Charset.defaultCharset()); 
         // get row num
         row = lines.size();
         // get column num
         String line = lines.get(0);
         String splitStr[] = line.split("\\s+");
         col = splitStr.length;
         dim[0] = row;
         dim[1] = col;
      } catch (URISyntaxException uri) {
         throw new RuntimeException("URI Exception", uri);
      }
      catch (IOException ioException) {
         throw new RuntimeException("IO Exception", ioException);
      }   
      return dim;
   }
    
   /**
    * readFile method.
    * load file into double[][]
    * @param row
    *        (number of row, int)
    * @param col
    *        (number of column, int)
    * @param file
    *        (filename, string)
    * @return fileArray
    *         (file in 2-d array, double[][])
    */
   public static double[][] readFile(int row, int col, String file) {
      double[][] fileArray = new double[row][col];
      try {
         BufferedReader reader;
         reader = new BufferedReader(new FileReader(file));
         for (int i = 0; i < row; i++) {
            String[] line;
            line = reader.readLine().split(" ");  
            for (int j = 0; j < col; j++) {
               fileArray[i][j] = Double.parseDouble(line[j]);
            }
         }

      } catch (IOException ioException) {
         throw new RuntimeException("IO Exception", ioException);
      }    
      return fileArray; 
   }
    
   /**
    * convertY method.
    * convert y into -1 and 1 classes
    * @param file
    *        (2-d array of file, double[][])
    * @param colNum
    *        (index of the column needs to be converted, int)
    * @param row
    *        (number of row in the file, int)
    * @return newFile[][]
    *         (converted new file, double)
    */
   public static double[][] convertY(int colNum, int row, double[][] file) {
    
      // copy a 2-d array
      double[][] newFile = new double[file.length][1];
      // convert y
      for (int i = 0; i < row; i++) {
         if (file[i][colNum] == 0) {
            newFile[i][0] = 1.0;
         }
         if (file[i][colNum] == 1) {
            newFile[i][0] = -1.0;
         } 
         
      }
      return newFile;
   }
    
   /**
    * WeightM method.
    * To compute perceptron weight
    * @param input
    *        (original 2-d matrix, double[][])
    * @param row
    *        (number of row in the file, int)
    * @param col
    *        (number of column in the file, int)
    * @param last
    *        (convered last column)
    * @return weightprecision
    *        ( num of rows as input
    *          num of rols as input -1, String[][])
    */
   public static String[][] weightM(double[][] input, int row, int col, double[][] last) {
      // seperate the input file into X and Y
      // copy a 2-d array as input without last col
      double[][] trainX = new double[row][col - 1];
      for (int i = 0; i < row; i++) {
         for (int j = 0; j < (col - 1); j++) {
            trainX[i][j] = input[i][j];
         }
      }
      // copy last col from input 
      double[][] trainY = new double[row][1];
      for (int i = 0; i < row; i++) {
         trainY[i][0] = input[i][col - 1];
      }
      // inititate a weight matrix
      double singleWeight = 0.0;
      double result = 0;
      double weight[][] = new double[row][col - 1];
      // core of simplifed perceptron algorithm
      for (int i = 0; i < row; i++) {
         double sum = 0.0;
         // compute classification given x and weight as 0 default
         for (double value : trainX[i]) {
            sum = sum + value * singleWeight;
         }
         if (sum <= 0) {
            result = -1.0;
         }
         else {
            result = 1.0;
         }
         // update the weight matrix
         if ((int) result != (int) last[i][0]) {
            for (int j = 0; j < (col - 1); j++) {
               weight[i][j] = trainX[i][j] * last[i][0]; 
            }
         } else {
            for (int j = 0; j < (col - 1); j++) {
               weight[i][j] = 0.0;     
            }
         }           
      }
   
   // keep 5 digits as precision
      String[][] weightprecision = new String[row][col - 1];
      double[][] add = new double[row][col - 1];
      for (int j = 0; j < (col - 1); j++) {
         for (int i = 0; i < row; i++) {   
            DecimalFormat dec = new DecimalFormat("#.00000");
            if (i == 0) {
               add[i][j] = weight[i][j];
            }
            else {
               add[i][j] = add[i - 1][j] + weight[i][j];
            }
            weightprecision[i][j] = dec.format(add[i][j]);            
         }
      }
      return weightprecision;
   }
   
   /**
    * PredictTest method.
    * @param validate
    *        (validate file, double[][])
    * @param weight
    *        (weight matrix, String[][])
    * @param row
    *        (num of row for validate data)
    * @param col
    *        (num of col for validate data)
    * @return predictResult
    *        (predict resullt, double[][]
    *         num of rows as validate row
    *         num of cols as 1)
    */
   public static double[][] predictTest(double validate[][], 
                                       String weight[][], int row, int col) {
      // seperate the input file into X and Y
      // copy a 2-d array as input without last col
      double[][] testX = new double[row][col - 1];
      for (int i = 0; i < row; i++) {
         for (int j = 0; j < (col - 1); j++) {
            testX[i][j] = validate[i][j];
         }
      }
      // copy last col from input 
      double[][] testY = new double[row][1];
      for (int i = 0; i < row; i++) {
         testY[i][0] = validate[i][col - 1];
      }
      // get last row of weight matrix
      int lastWeight = weight.length;
      double wMatrix[][] = new double[1][col - 1];
      for (int j = 0; j < (col - 1); j++) {
         wMatrix[0][j] = Double.parseDouble(weight[lastWeight - 1][j]);
      }
      // caculate predict y based on weight matrix
      double temp[][] = new double[row][col - 1];
      double predictY[][] = new double[row][1];
      double result = 0.0;
      for (int i = 0; i < row; i++) {
         double sum = 0.0;
         for (int j = 0; j < (col - 1); j++) {
            temp[i][j] = testX[i][j] * wMatrix[0][j];
            sum = sum + temp[i][j];
         }
         if (sum <= 0) {
            result = -1.0;
         }
         else {
            result = 1.0;
         }
         predictY[i][0] = result; 
      }
      return predictY;
   }
        
   /** 
    * Main method.
    * @param args not used
    */  
   public static void main(String[] args) {
      ProjectB homework = new ProjectB();
      // get dimension of file
      int[] dimTrain = homework.dimension("training.txt");
      int[] dimTest = homework.dimension("validate.txt");
      int rowTrain = dimTrain[0];
      int colTrain = dimTrain[1];
      int rowTest = dimTest[0];
      int colTest = dimTest[1];
      // get array[][] of file
      double[][] fileArrayTrain = homework.readFile(
                                  rowTrain, colTrain, "training.txt");
      double[][] fileArrayTest = homework.readFile(
                                 rowTest, colTest, "validate.txt");
      // convert the last column of file
      int lastColTrain = colTrain - 1;
      int lastColTest = colTest - 1;
      double[][] train = homework.convertY(
                         lastColTrain, rowTrain, fileArrayTrain);
      double[][] test = homework.convertY(
                        lastColTest, rowTest, fileArrayTest);
      // calculate the weight matrix based on training sert
      String[][] weight = homework.weightM(fileArrayTrain, rowTrain, colTrain, train);
      // predict validate dataset
      double[][] output = homework.predictTest(
                          fileArrayTest, weight, rowTest, colTest); 
      // compare results and generate statistics
      double[][] testYY = new double[rowTest][1];
      int correctCase = 0;
      int incorrectCase = 0;
      double precentage = 0.0;
      for (int i = 0; i < rowTest; i++) {
         //System.out.print(output[i][0]);
         //System.out.print(" ");
         //System.out.print(test[i][0]);
         //System.out.print("\n");
         if (output[i][0] == test[i][0]) {
            correctCase++;
         }
         else {
            incorrectCase++; 
         }
      }
      System.out.println("Num of correct prediction: " + correctCase);
      System.out.println("Num of incorrect prediction: " + incorrectCase);
      precentage = (double) correctCase / (correctCase + incorrectCase);
      System.out.println("correct precentage: " + precentage);
      // write weight matrix into file
      try {
         BufferedWriter writer = new BufferedWriter(
                     new FileWriter("weights.txt"));
         for (int i = 0; i < rowTrain; i++) {
            for (int j = 0; j < (colTrain - 1); j++) {
               String s = String.valueOf(weight[i][j]);
               writer.write(s);
               writer.write(" ");
            }
            writer.write("\n");
         }
         writer.close();
      } catch (IOException ioException) {
         throw new RuntimeException("IO Exception", ioException);
      }
      // write predict matrix into file
      try {
         BufferedWriter writer = new BufferedWriter(
                     new FileWriter("predict.txt"));
         for (int i = 0; i < rowTest; i++) {
            String s = String.valueOf(output[i][0]);
            writer.write(s);
            writer.write("\n");
         }
         writer.close();
      } catch (IOException ioException) {
         throw new RuntimeException("IO Exception", ioException);
      }
  
   }

}
 
