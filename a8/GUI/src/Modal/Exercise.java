package Modal;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Exercise implements Comparable<Exercise>{
    private String name; 
    private String comment; 
    private double duration;  
    private Date date; 
    private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    
    public Exercise(String name, Date date, double duration) {
    	setName(name);
        setDuration(duration);
        this.comment = ""; 
        setDate(date);
    }
    
    public Exercise(String name, String date, double duration) {
    	setName(name);
    	setDuration(duration);
    	this.comment = "";
    	setDate(date);
    }
    
    public Exercise(String name, String date, double duration, String comment) {
        setName(name);
        setDuration(duration);
        setComment(comment); 
        setDate(date); 
    }

    public Exercise(String name, Date date, double duration, String comment) {
    	setName(name);
        setDuration(duration);
        setComment(comment); 
        setDate(date); 
    }

    // getters
    public String getName() { return name; }
    public String getComment() { return comment; }
    public double getDuration() { return duration; }
    public Date getDate() { return date; }

    // setters
    public void setName(String name) { this.name = name; }
    public void setComment(String comment) { this.comment = comment; }
    public void setDuration(double duration) { this.duration = duration; }
    public void setDate(Date date) { this.date = date; }
    public void setDate() {
    	this.date = new Date();
    }
    public void setDate(String date) {
		try {
			this.date = df.parse(date);
		} catch (Exception ex) {
			this.date = new Date(); // now
		}
	}
    
    private String getDateAsString() {
    	return df.format(date);
    }
    
    // abstract methods
    public abstract double getCaloriesBurned();
    public abstract String getType(); 
    public abstract String toStringCustomInfo();
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%.2f\t%s\t%.2f\t%s", name,getType(),getDateAsString(),duration,toStringCustomInfo(),getCaloriesBurned(),comment);
	}

    @Override
    public int compareTo(Exercise o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    private class ExerciseCompareByCalories implements Comparable<Exercise> {

        @Override
        public int compareTo(Exercise o) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
        }

    }
}