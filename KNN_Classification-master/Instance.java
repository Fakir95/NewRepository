
import java.util.Arrays;


public class Instance {
    
    protected double[] values;
    protected double classLabel; //numeric value representing the class. True class value.

    public Instance(double[] values) {

        this.values = values;
        this.classLabel = values[values.length - 1];
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }
    
    @Override
    public String toString(){
        
       return (Arrays.toString(this.values));
    }    

    public double getClassLabel() {
        return classLabel;
    }

    public void setClassLabel(double classLabel) {
        this.classLabel = classLabel;
    }
    
    
}
