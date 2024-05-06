package Modal;

import java.util.Date;

public class WeightLifting extends Exercise {
    private double amountLifted; 

    public WeightLifting(String name, String date, double amountLifted, double duration, String comment) {
        super(name, date, duration, comment);
        setAmountLifted(amountLifted);
    }
    
    public WeightLifting(String name, Date date, double amountLifted, double duration, String comment) {
        super(name, date, duration, comment);
        setAmountLifted(amountLifted);
    }

    public WeightLifting(String name, Date date, double amountLifted, double duration) {
        super(name, date, duration);
        setAmountLifted(amountLifted); 
    }
    
    public WeightLifting(String name, String date, double amountLifted, double duration) {
        super(name, date, duration);
        setAmountLifted(amountLifted); 
    }
    
    public double getAmountLifted() { return amountLifted; }

    public void setAmountLifted(double amountLifted) { this.amountLifted = amountLifted; }

    @Override
    public double getCaloriesBurned() {
        return (amountLifted / this.getDuration()) * 50; 
    }

    @Override
    public String getType() {
        return "Weight Lifting";
    }
    
    @Override
    public String toStringCustomInfo() {
    	return "";
    }
}
