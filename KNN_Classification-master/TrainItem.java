/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ENE
 * Calculates the distances of the train dataset values with the test set.
 */
public class TrainItem extends Instance{
    
    protected double distance;

    public TrainItem(double[] values) {
        super(values);
    }

    public TrainItem(double distance, double[] values) {
        super(values);
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "TrainItem{" + "distance=" + distance + '}';
    }
    
    
}
