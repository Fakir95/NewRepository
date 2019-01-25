import java.util.Arrays;

public class Attribute {
    
    protected String name;
    protected double[] values;
    
    public Attribute(String name, double[] values) {
        this.name = name;
        this.values = values;
    }

    public Attribute(double[] values) {
        
        this.values = values;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

   
}
