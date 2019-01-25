/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ENE
 * According to nearest distances on training set, predicts a class label for the instance.
 */
public class TestItem extends Instance {
    
    protected double predictedLabel;

    public TestItem(double[] values) {
        super(values);
    }

    public TestItem(double predictedLabel, double[] values) {
        super(values);
        this.predictedLabel = predictedLabel;
    }

    public double getPredictedLabel() {
        return predictedLabel;
    }

    public void setPredictedLabel(double predictedLabel) {
        this.predictedLabel = predictedLabel;
    }
    
    
    
}
