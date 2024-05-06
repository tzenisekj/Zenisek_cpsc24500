package Modal;

import java.util.Date;

public class RunWalk extends Exercise {
    private double distance;

    public RunWalk(String name, Date date, double duration, double distance, String comment) {
        super(name, date, duration, comment);
        setDistance(distance);
    } 
    
    public RunWalk(String name, String date, double duration, double distance, String comment) {
        super(name, date, duration, comment);
        setDistance(distance);
    } 

    public RunWalk(String name, Date date, double duration, double distance) {
        super(name, date, duration);
        setDistance(distance);
    }
    
    public RunWalk(String name, String date, double duration, double distance) {
        super(name, date, duration);
        setDistance(distance);
    }

    public double getDistance() { return distance; }

    public void setDistance(double distance) { this.distance = distance; }

    
    @Override
    public double getCaloriesBurned() {
        return (distance / this.getDuration()) * 9000; 
    }

    @Override
    public String getType() {
        return "Run/Walk";
    }
    
    @Override
    public String toStringCustomInfo() {
    	return "";
    }
}