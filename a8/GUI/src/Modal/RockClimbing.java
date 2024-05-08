/**
 * file: RockClimbing
 * 
 * Class acts as subclass of Exercise which it extends
 * 
 * MEMBERS
 * - heightOfWall	(in feet)
 * - repititions	(how many times the wall was climbed)
 * 
 * CONSTRUCTORS
 * ** Same as Exercise constructors
 * ** Sets values for repititions and height of wall values
 * 
 * METHODS
 * GETTERS
 * - getHeightOfWall()
 * - getRepititions()
 * 
 * SETTERS
 * - setHeightOfWall()
 * - setRepititions()
 * 
 * OVERRIDE METHODS
 * - getType()
 * - getCustomStringInfo()
 * - getCaloriesBurned()
 */
package Modal;

import java.util.Date;

public class RockClimbing extends Exercise {
    private int repititions; 		// holds how many times the wall was scaled
    private double heightOfWall; 	// holds height of wall in feet

    /**
     * 
     * @param name
     * @param date
     * @param duration
     * @param heightOfWall
     * @param repititions
     * @param comment
     * 
     * uses parent constructor to set all values except for repititions and height of wall which is done here
     */
    public RockClimbing(String name, String date, double duration, double heightOfWall, int repititions, String comment) {
        super(name, date, duration, comment);
        setHeightOfWall(heightOfWall);
        setRepititions(repititions);     
    }
    
    /**
     * 
     * @param name
     * @param date
     * @param duration
     * @param heightOfWall
     * @param repititions
     * @param comment
     * 
     * uses parent constructor to set all values except for repititions and height of wall which is done here
     */
    public RockClimbing(String name, Date date, double duration, double heightOfWall, int repititions, String comment) {
        super(name, date, duration, comment);
        setHeightOfWall(heightOfWall);
        setRepititions(repititions);     
    }

    /**
     * 
     * @param name
     * @param date
     * @param duration
     * @param heightOfWall
     * @param repititions
     * @param comment
     * 
     * uses parent constructor to set all values except for repititions and height of wall which is done here
     */
    public RockClimbing(String name, String date, double heightOfWall, int repititions, double duration) {
        super(name, date, duration);
        setHeightOfWall(heightOfWall);
        setRepititions(repititions); 
    }
    
    /**
     * 
     * @param name
     * @param date
     * @param duration
     * @param heightOfWall
     * @param repititions
     * @param comment
     * 
     * uses parent constructor to set all values except for repititions and height of wall which is done here
     */
    public RockClimbing(String name, Date date, double heightOfWall, int repititions, double duration) {
        super(name, date, duration);
        setHeightOfWall(heightOfWall);
        setRepititions(repititions); 
    }

    /**
     * 
     * @return	(repititions as integer value)
     */
    public int getRepititions() { return repititions; }
    
    /**
     * 
     * @return	(height of wall as double value)
     */
    public double getHeightOfWall() { return heightOfWall; }

    /**
     * 
     * @param repititions
     * 
     * sets repititions value to hold how many times wall was scaled as integer
     */
    public void setRepititions(int repititions) { this.repititions = repititions; }
    
    /**
     * 
     * @param heightOfWall
     * 
     * sets height of wall value as double value representing how tall the wall is in feet
     */
    public void setHeightOfWall(double heightOfWall) { this.heightOfWall = heightOfWall; }

    /**
     * @return	(calculated calories burned as double)
     * 
     * calculated by taking the height of the wall (in feet) * repititions (how many times the wall was scaled) / duration (minutes exercsie took)
     */
    @Override
    public double getCaloriesBurned() {
        return ((heightOfWall * repititions) / this.getDuration()) * 100; 
    }

    /**
     * @return	(returns Exercise type as String)
     */
    @Override
    public String getType() {
        return "Rock Climbing";
    }
    
    /**
     * @return	(returns String of custom exercise values. Consists of wall height in feet and repititions of wall scaled)
     */
    @Override
    public String toStringCustomInfo() {
    	return String.valueOf(getHeightOfWall()) + "\t" + String.valueOf(getRepititions());
    }
}
