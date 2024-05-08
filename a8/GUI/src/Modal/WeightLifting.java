/**
 * file: WeightLifting
 * 
 * Class acts as subclass of extended Exercise class
 * 
 * MEMBERS
 * - amountLifted	(in pounds)
 * 
 * CONSTRUCTORS
 * ** same as exercise constructors
 * ** sets amount lifted for each 
 * 
 * METHODS
 * **GETTERS
 * 	- getAmountLifted()
 * 
 * **SETTERS
 * - setAmountLifted()
 * 
 * OVERRIDE METHODS
 * - getType()
 * - getCustomStringInfo()
 * - getCaloriesBurned()
 */
package Modal;

import java.util.Date;

public class WeightLifting extends Exercise {
    private double amountLifted; 

    /**
     * 
     * @param name
     * @param date
     * @param amountLifted
     * @param duration
     * @param comment
     * 
     * sets all fields from exercise super class plus amount lifted
     */
    public WeightLifting(String name, String date, double amountLifted, double duration, String comment) {
        super(name, date, duration, comment);
        setAmountLifted(amountLifted);
    }
    
    /**
     * 
     * @param name
     * @param date
     * @param amountLifted
     * @param duration
     * @param comment
     * 
     * sets all fields from exercise super class plus amount lifted
     */
    public WeightLifting(String name, Date date, double amountLifted, double duration, String comment) {
        super(name, date, duration, comment);
        setAmountLifted(amountLifted);
    }

    /**
     * 
     * @param name
     * @param date
     * @param amountLifted
     * @param duration
     * @param comment
     * 
     * sets all fields from exercise super class plus amount lifted
     */
    public WeightLifting(String name, Date date, double amountLifted, double duration) {
        super(name, date, duration);
        setAmountLifted(amountLifted); 
    }
    
    /**
     * 
     * @param name
     * @param date
     * @param amountLifted
     * @param duration
     * @param comment
     * 
     * sets all fields from exercise super class plus amount lifted
     */
    public WeightLifting(String name, String date, double amountLifted, double duration) {
        super(name, date, duration);
        setAmountLifted(amountLifted); 
    }
    
    /**
     * 
     * @return	(amount lifted as double)
     */
    public double getAmountLifted() { return amountLifted; }

    /**
     * 
     * @param amountLifted
     * 
     * setter for amount lifted value
     */
    public void setAmountLifted(double amountLifted) { this.amountLifted = amountLifted; }

    /**
     * @return	(calories burned as double)
     * 
     * calculates calories burned by taking amount lifted (as pounds) / duration (as minutes) * 50
     */
    @Override
    public double getCaloriesBurned() {
        return (amountLifted / this.getDuration()) * 50; 
    }

    /**
     * @return	(returns exercise type as String)
     */
    @Override
    public String getType() {
        return "Weight Lifting";
    }
    
    /**
     * @return	(returns String of weight lifting custom info. Consists of amount lifted)
     */
    @Override
    public String toStringCustomInfo() {
    	return String.valueOf(getAmountLifted());
    }
}
