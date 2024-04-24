package a8.Modals;

import java.util.Date;

public class RunWalk extends Exercise {
    private double distance;

    RunWalk(String name, String comment, double duration, double distance, Date date) {
        super(name, comment, duration, date);
        this.distance = distance; 
    } 

    RunWalk(String name, double duration, double distance, Date date) {
        super(name, duration, date);
        this.distance = distance; 
    }

    public double getDistance() { return distance; }

    public void setDistance(double distance) { this.distance = distance; }

    @Override
    public double getCaloriesBurned() {
        return (distance / this.getDuration()) * 9000; 
    }

    @Override
    public Object getType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }
}
