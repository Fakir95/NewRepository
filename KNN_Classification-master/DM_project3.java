import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DM_project3 {

   
    public static void main(String[] args) throws FileNotFoundException {

     File file = new File("iris.train");
     Scanner scn = new Scanner(file);
       
    //First line contains the number of attributes, the number of instances, and the number of classes. The number of attributes also contains the class attribute.
    //Last element always contains the class attribute of that instance.
     String str = scn.nextLine();
     String[] ar = str.split(" ");
     int columns = Integer.parseInt(ar[0]);
     int rows = Integer.parseInt(ar[1]);  
     int classes = Integer.parseInt(ar[2]);
     
    //Training dataset 
    Dataset X = new Dataset(columns,rows,classes);
    
    
        for(int i = 0;i< rows;i++){
        String tempval = scn.nextLine();
        String[] temparr = tempval.split(",");
        double[] array = Arrays.asList(temparr).stream().mapToDouble(Double::parseDouble).toArray();
        int k = 0;
            for(int j = 0;j<columns;j++){
        double value = array[k];
        X.dataSet[i][j] = value;
        k++;
  }
        }
        
    System.out.println("The training dataset is as follows:");
    X.readMatrix();
    X.fillInstances();
    X.fillAttributes();
    
    File filetest = new File("iris.test");
    Scanner scntest = new Scanner(filetest);
    
    String strtest = scntest.nextLine();
    String[] artest = strtest.split(" ");
    int columns_test = Integer.parseInt(artest[0]);
    int rows_test = Integer.parseInt(artest[1]);  
    int classes_test = Integer.parseInt(artest[2]);
    
    //Dataset to be tested(Test Dataset)
    Dataset Y = new Dataset(columns_test,rows_test,classes_test);
    
    for(int i = 0;i< rows_test;i++){
        String tempval = scntest.nextLine();
        String[] temparr = tempval.split(",");
        double[] array = Arrays.asList(temparr).stream().mapToDouble(Double::parseDouble).toArray();
        int k = 0;
            for(int j = 0;j<columns_test;j++){
        double value = array[k];
        Y.dataSet[i][j] = value;
        k++;
  }
        }
    
    System.out.println("and the test dataset is as follows:");
    Y.readMatrix();
    Y.fillInstances();
    Y.fillAttributes();
    
    System.out.println();
    
    if(Y.numberOfInstances != X.numberOfInstances){
        
        System.out.println("The train and test datasets attributes are not of the same size and incompatible. Please try with different sets of data. ");
        System.out.println("The program will terminate itself. Please re-run with compatible sets for KNN to run. ");
        System.exit(0);
    }
    
    Scanner input = new Scanner(System.in);
     int k_val;
     System.out.print("For K-NN algorithm to run, please enter K value number in integer to look for nearest neighbors : ");
     k_val = input.nextInt();
     
     if(k_val <= 0){
         
         System.out.println("K value should be larger than 0!");
         return;
     }
     
     if(k_val > rows){
         
         System.out.println("K value should not be bigger than the number of training sets instances!Please try again with a lower value. (Lower than " + X.numberOfAttributes + ")");
         return;
         
     }
    
    KNN knn = new KNN(X,k_val);
    TestItem[] items = knn.KNN_Algorithm(Y);
    
    System.out.println("For " + k_val + " nearest neighbors, K-NN algorithms stats for the training set is as follows:");
    
    System.out.println();
    
    System.out.println("Total accuracy :% " + knn.totalAccuracy(items));
    System.out.println("The accuracy percentange of each class : " + Arrays.toString(knn.classAccuracy(items)));
    System.out.println("And finally, the confusion matrix is: ");
    knn.confusionMatrix(items);

        } 
    }
