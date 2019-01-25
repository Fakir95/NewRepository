/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Dataset {
    
    protected int numberOfInstances; //no of rows
    protected int numberOfAttributes; //no of columns
    protected double dataSet[][];
    protected ArrayList<Attribute> allAttributes = new ArrayList<>();
    protected ArrayList<Instance> allInstances = new ArrayList<>();
    protected int noOfClasses;

    public Dataset(int numberOfInstances,int numberOfAttributes) {
        this.numberOfAttributes = numberOfAttributes;
        this.numberOfInstances = numberOfInstances;
        dataSet = new double[numberOfAttributes][numberOfInstances];
    }

    public Dataset(int numberOfInstances, int numberOfAttributes, int noOfClasses) {
        this.numberOfInstances = numberOfInstances;
        this.numberOfAttributes = numberOfAttributes;
        dataSet = new double[numberOfAttributes][numberOfInstances];
        this.noOfClasses = noOfClasses;
    }
    
    
    
    public void readMatrix(){
    for(int i=0;i<dataSet.length;i++)
{
    for(int j=0; j<dataSet[0].length; j++)
        System.out.print(dataSet[i][j]+ " ");
    System.out.println();
}
    }
    
    public void fillInstances(){
       
        double[] temp;
        
        for(int i = 0;i < numberOfAttributes;i++){
            
            temp = new double[numberOfInstances];
            allInstances.add(new Instance(temp));
            
            for(int j = 0;j<numberOfInstances;j++){
                
                temp[j] = dataSet[i][j];
            }
        } 
    }
    
    public void fillAttributes(){
       
        double[] temp;
        
        for(int i = 0;i < numberOfInstances;i++){
            
            temp = new double[numberOfAttributes];
            allAttributes.add(new Attribute(temp));
            
            for(int j = 0;j<numberOfAttributes;j++){
                
                temp[j] = dataSet[j][i];
            }
        } 
    }
    
    public double maxOfAttribute(Attribute a){
        
        double max = 0;
        
        for(int i = 0;i < a.values.length;i++){
            
            if(a.values[i] > max)
                max = a.values[i];
        }
        
        return max;
    }
    
    public double minOfAttribute(Attribute a){
        
        double min = Double.MAX_VALUE - 1;
        
        for(int i = 0;i < a.values.length;i++){
            
            if(a.values[i] < min)
                min = a.values[i];
        }
        
        return min;
    }
    
    public double meanValue(Attribute a){
        
      double sum = 0;
      double mean;
      
      for(int i = 0;i < a.values.length;i++){
            
            sum += a.values[i];
        }
        
      mean = sum / numberOfAttributes;
      return mean;
    }
    
    public double standartDeviation(Attribute a){
        
     double sum = 0;
     double mean = meanValue(a);
     double value = 0;
     
     for(int i = 0;i < a.values.length;i++){
         
         sum += Math.pow((a.values[i] - mean), 2);
     }
        value = sum / (numberOfAttributes - 1);
        value = Math.sqrt(value);
        return value;
    }
    
    public double[][] covarianceMatrix(){
        
      double[][] covarianceMatrix = new double[numberOfInstances][numberOfInstances];
      //ArrayList<double[]> covarianceMatrix = new ArrayList<>();
      double[] means = new double[numberOfInstances];
      double[] cov1;
      double[] cov2;
      //double[] row = new double[numberOfInstances];
      int N = numberOfAttributes - 1;
      
      for(int k = 0;k < numberOfInstances;k++){
          
         means[k] = meanValue(allAttributes.get(k));
          
      }
      
      for(int i = 0;i < numberOfInstances;i++){
          
          cov1 = allAttributes.get(i).values;
          
      for(int j = 0;j < numberOfInstances;j++){
          
          cov2 = allAttributes.get(j).values;
          covarianceMatrix[i][j] = cov(cov1,cov2,means[i],means[j]);
          
      }
      }
       
      return covarianceMatrix;
    }
    
    public double cov(double[]x,double[]y,double meanx,double meany){
        
      double sum = 0;
      int N = numberOfAttributes - 1;
      double value = 0;
      
      for(int i = 0;i < numberOfAttributes;i++){
        
          sum += (x[i] - meanx) * (y[i] - meany);
          
      }
          value = sum / N;
          return value;
      }
        
        
    }
