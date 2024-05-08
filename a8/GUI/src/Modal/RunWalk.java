/**
 * file: RunWalk
 * 
 * Class extends Exercise acting as a subclass of Exercise
 * 
 * MEMBERS
 * - distance	(double), (as miles)
 * * Plus members from Exercise 
 * 
 * CONSTRUCTORS
 * 
 * METHODS
 * **getters
 * - getDistance()
 * 
 * **setters
 * - setDistance()
 * 
 * OVERRIDE METHODS
 * - getType()
 * - toStringCustomInfo()
 * - getCaloriesBurned()
 */
package Modal;

import java.util.Date;

public class RunWalk extends Exercise {
    private double distance;	// holds number for miles ran/walked

    /**
     * 
     * @param name
     * @param date
     * @param duration
     * @param distance
     * @param comment
     * 
     * Constructor uses parent constructor to set all fields except for distance
     */
    public RunWalk(String name, Date date, double duration, double distance, String comment) {
        super(name, date, duration, comment);
        setDistance(distance);
    } 
    
    /**
     * 
     * @param name
     * @param date
     * @param duration
     * @param distance
     * @param comment
     * 
     * Constructor uses parent constructor to set all fields except for distance
     */
    public RunWalk(String name, String date, double duration, double distance, String comment) {
        super(name, date, duration, comment);
        setDistance(distance);
    } 

    /**
     * 
     * @param name
     * @param date
     * @param duration
     * @param distance
     * @param comment
     * 
     * Constructor uses parent constructor to set all fields except for distance
     */
    public RunWalk(String name, Date date, double duration, double distance) {
        super(name, date, duration);
        setDistance(distance);
    }
    
    /**
     * 
     * @param name
     * @param date
     * @param duration
     * @param distance
     * @param comment
     * 
     * Constructor uses parent constructor to set all fields except for distance
     */
    public RunWalk(String name, String date, double duration, double distance) {
        super(name, date, duration);
        setDistance(distance);
    }

    /**
     * 
     * @return	(distance value as double)
     */
    public double getDistance() { return distance; }

    /**
     * 
     * @param distance
     * 
     * setter for distance member value
     */
    public void setDistance(double distance) { this.distance = distance; }

    
    /**
     * @return	(returns calories burned as double)
     * 
     * Calculates by distance (as miles) / duration (as minutes) * 9000
     */
    @Override
    public double getCaloriesBurned() {
        return (distance / this.getDuration()) * 9000; 
    }

    /**
     * @return	(returns the object type as String)
     */
    @Override
    public String getType() {
        return "Run/Walk";
    }
    
    /**
     * @return	(returns string of RunWalk unique info. that being the distance)
     */
    @Override
    public String toStringCustomInfo() {
    	return String.valueOf(getDistance());
    }
}