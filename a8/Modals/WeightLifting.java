package a8.Modals;

import java.util.Date;

public class WeightLifting extends Exercise {
    private double amountLifted; 

    WeightLifting(String name, String comment, double amountLifted, double duration, Date date) {
        super(name, comment, duration, date);
        this.amountLifted = amountLifted;
    }

    WeightLifting(String name, double amountLifted, double duration, Date date) {
        super(name, duration, date);
        this.amountLifted = amountLifted;
    }
    
    public double getAmountLifted() { return amountLifted; }

    public void setAmountLifted(double amountLifted) { this.amountLifted = amountLifted; }

    @Override
    public double getCaloriesBurned() {
        return (amountLifted / this.getDuration()) * 50; 
    }

    @Override
    public Object getType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }
}
