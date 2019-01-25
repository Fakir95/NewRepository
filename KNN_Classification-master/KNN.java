
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//KNN algorithm,used for classification

public class KNN {
    
    protected Dataset dataset_train; //training set
    protected int k;
    protected double mostFreqClass;

    public KNN(Dataset dataset) {
        this.dataset_train = dataset;
    }

    public KNN(Dataset dataset, int k) {
        this.dataset_train = dataset;
        this.k = k;
    }
    
    
    public double euclidianDistance(Instance a,Instance b){
       
        if(a.values.length != b.values.length){
          
            System.out.println("The given instances are not of the same type!");
            return -1;
        }
        
        double sum = 0;
        
        for(int i = 0;i < a.values.length - 1;i++){
            
            sum += Math.pow(a.values[i] - b.values[i], 2);
            
        }
        
       double distance = Math.sqrt(sum);
        
       return distance;
               
    }
    
    public TestItem[] KNN_Algorithm(Dataset test){
        
        TestItem[] testResults = new TestItem[test.numberOfAttributes];
        TrainItem[] trainSet = new TrainItem[dataset_train.numberOfAttributes];
        
        for(int i = 0; i < test.numberOfAttributes;i++){
            
            testResults[i] = new TestItem(test.allInstances.get(i).values);

        for(int j = 0; j < dataset_train.numberOfAttributes;j++){
            
            trainSet[j] = new TrainItem(dataset_train.allInstances.get(j).values);
            trainSet[j].setDistance(euclidianDistance(dataset_train.allInstances.get(j),test.allInstances.get(i)));

        }

        Arrays.sort(trainSet, Comparator.comparing((trainItem) -> trainItem.getDistance()));
        TrainItem[] temp = Arrays.copyOf(trainSet, k);
        double predictedClass = findMostFreqClass(temp);
        testResults[i].setPredictedLabel(predictedClass);
        
        }
        
        return testResults;
    }
    
    public double totalAccuracy(TestItem[] testResults){
        
        //classification accuracy = correct predictions / total predictions * 100
        double correctPredictions = 0;
        double totalPredictions = testResults.length;
        
        for(int i = 0;i < testResults.length;i++){
            
            if(testResults[i].classLabel == testResults[i].predictedLabel){
                correctPredictions = correctPredictions + 1;
            }
        }
        
        double classificationAccuracy = (correctPredictions / totalPredictions) * 100;
        return classificationAccuracy;
    }
    
    public double[] classAccuracy(TestItem[] testResults){
        
        double[] totalPredictions = new double[dataset_train.numberOfAttributes];
        double[] correctPredictions = new double[dataset_train.numberOfAttributes];
        
        for(int i = 0;i < testResults.length;i++){
            
            totalPredictions[(int)testResults[i].classLabel] += 1;
            
            if(testResults[i].classLabel == testResults[i].predictedLabel){
                
                correctPredictions[(int)testResults[i].predictedLabel] += 1;
            }
            }
        
        double[] classAccuracies = new double[dataset_train.noOfClasses];
        
        for(int j = 0;j < classAccuracies.length;j++){
            
            classAccuracies[j] = (correctPredictions[j] / totalPredictions[j]) * 100;
        }
        
        return classAccuracies;
        }
    
    public void confusionMatrix(TestItem[] testResults){

        String str = "      ";
        double[] classAccuracies = classAccuracy(testResults);
        
        for(int i = 0; i < dataset_train.noOfClasses;i++){
            
            str += "Class" + i + " ";
        }
        
        System.out.println(str);
        
        String str2 = "";
        
       for(int i = 0;i < classAccuracies.length;i++){
           
           int[] misClassified = new int[classAccuracies.length];

              for(int j = 0;j < testResults.length;j++){ //testResults.length = 75
 
                  if(testResults[j].classLabel == i){
                      if(testResults[j].predictedLabel != i)
                          misClassified[(int)testResults[j].predictedLabel] += 1;
                      else
                          misClassified[i] += 1;
              }
              }
              
              str2 += "Class" + i + "    " + misClassified[0] + "    " + misClassified[1] + "    " + misClassified[2]; 
              System.out.println(str2);
           
           str2 = "";
       }
        
    }
    
    
    public double findMostFreqClass(){
    
        //looks at the most freq class in training set
        //if there's equal amount of 2 or more classes, returns one of them.
        
        double freq = 0;
        int[] classCount = new int[dataset_train.noOfClasses]; //numerics representing the classes go as 0,1,2...etc
        
        for(int i = 0;i < dataset_train.numberOfAttributes;i++){
           
            double classType = dataset_train.allInstances.get(i).values[dataset_train.numberOfInstances - 1];
            classCount[(int)classType] += 1;
            
        }
    
        int max = 0;
        double placeOfMax = 0;
        
        for(int j = 0;j < classCount.length;j++){
            
            if(classCount[j] > max){
                max = classCount[j];
                placeOfMax = j;
            }
        }
        
        return placeOfMax;
}
    
    public double findMostFreqClass(TrainItem[] item){
    
        //looks at the most freq class in K area of the training set
        //if there's equal amount of 2 or more classes, returns one of them.
        
        double freq = 0;
        int[] classCount = new int[dataset_train.noOfClasses]; //numerics representing the classes go as 0,1,2...etc
        
        for(int i = 0;i < item.length;i++){
           
            double classType = item[i].getValues()[item[i].values.length - 1];
            classCount[(int)classType] += 1;
            
        }
    
        int max = 0;
        double placeOfMax = 0;
        
        for(int j = 0;j < classCount.length;j++){
            
            if(classCount[j] > max){
                max = classCount[j];
                placeOfMax = j;
            }
        }
        
        return placeOfMax;
}
    
    public int numberOfEachClass(double classValue,TestItem[] testResults){
        
        int numberOfClass = 0;
        
        for(int i = 0;i < testResults.length;i++){
            
            if(classValue == testResults[i].classLabel)
                numberOfClass += 1;
            
        }
        
        return numberOfClass;
        
    }
    }
    

    

