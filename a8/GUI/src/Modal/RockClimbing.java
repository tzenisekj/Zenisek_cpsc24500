package Modal;

import java.util.Date;

public class RockClimbing extends Exercise {
    private int repititions; 
    private double heightOfWall; 

    RockClimbing(String name, String comment, double heightOfWall, int repititions, double duration, Date date) {
        super(name, comment, duration, date);
        this.heightOfWall = heightOfWall; 
        this.repititions = repititions; 
    }

    RockClimbing(String name, double heightOfWall, int repititions, double duration, Date date) {
        super(name, duration, date);
        this.heightOfWall = heightOfWall; 
        this.repititions = repititions; 
    }

    public int getRepititions() { return repititions; }
    public double getHeightOfWall() { return heightOfWall; }

    public void setRepititions(int repititions) { this.repititions = repititions; }
    public void setHeightOfWall(double heightOfWall) { this.heightOfWall = heightOfWall; }

    @Override
    public double getCaloriesBurned() {
        return ((heightOfWall * repititions) / this.getDuration()) * 100; 
    }

    @Override
    public Object getType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }
}
