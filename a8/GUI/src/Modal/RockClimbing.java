package Modal;

import java.util.Date;

public class RockClimbing extends Exercise {
    private int repititions; 
    private double heightOfWall; 

    public RockClimbing(String name, String date, double duration, double heightOfWall, int repititions, String comment) {
        super(name, date, duration, comment);
        setHeightOfWall(heightOfWall);
        setRepititions(repititions);     
    }
    
    public RockClimbing(String name, Date date, double duration, double heightOfWall, int repititions, String comment) {
        super(name, date, duration, comment);
        setHeightOfWall(heightOfWall);
        setRepititions(repititions);     
    }

    public RockClimbing(String name, String date, double heightOfWall, int repititions, double duration) {
        super(name, date, duration);
        setHeightOfWall(heightOfWall);
        setRepititions(repititions); 
    }
    
    public RockClimbing(String name, Date date, double heightOfWall, int repititions, double duration) {
        super(name, date, duration);
        setHeightOfWall(heightOfWall);
        setRepititions(repititions); 
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
    public String getType() {
        return "Rock Climbing";
    }
    
    @Override
    public String toStringCustomInfo() {
    	return "";
    }
}
