/*
 * File: Exercise
 * 
 * This class acts as the parent class for different types of exercises somebody can enter to keep track of their exercises they perform. Currently
 * RunWalk, WeightLifting, and RockClimbing are the subclass exercise types that extend exercise.
 * 
 * Exercise implements Comparable in order to define how sorting can be done with Exercise objects
 * 
 * Members
 * - name: String
 * - comment: String
 * - duration: Double
 * - date: Date (this uses date formatter to format mm/dd/yyyy
 * - simpleDateFormat: SimpleDateFormat class
 * 
 * Constructors
 * - PUBLIC	
 * - Exercise(name, date (as Date), duration)
 * - Exercise(name, date (as String), duration)
 * - Exercise(name, date (as Date), duration, comment)
 * - Exercise(name, date (as String), duration, comment)
 * 
 * Methods
 * - getters for all members
 * - settings for all members
 * * Added toString setter for Date as string format and not Date object
 * 
 * Abstract Methods
 * - toStringCustomInfo()
 * - getCaloriesBurned()
 * - getType()
 * 
 * Overridable Methods
 * - toString()
 * - comapare() ** overrides comparable method to define comparing exercises
 * 
 * Sub Class CompareByCaloriesBurned implementing Comparable
 * ** needed to define comparing exercises by calories burned
 */
package Modal;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Exercise implements Comparable<Exercise>{
    private String name; 
    private String comment; 
    private double duration; 	// holds value for duration exercise is performed in minutes
    private Date date; 
    private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    
    /**
     * 
     * @param name 
     * @param date as Date Ojbect
     * @param duration
     * 
     * Constructor without a comment with date as Date object
     */
    public Exercise(String name, Date date, double duration) {
    	setName(name);
        setDuration(duration);
        this.comment = ""; 
        setDate(date);
    }
    
    /**
     * 
     * @param name
     * @param date as String
     * @param duration
     * 
     * Constructor without comment with date as String
     */
    public Exercise(String name, String date, double duration) {
    	setName(name);
    	setDuration(duration);
    	this.comment = "";
    	setDate(date);
    }
    
    /**
     * 
     * @param name
     * @param date
     * @param duration
     * @param comment
     * 
     * Constructor like others but to set comment field as well
     */
    public Exercise(String name, String date, double duration, String comment) {
        setName(name);
        setDuration(duration);
        setComment(comment); 
        setDate(date); 
    }

    /**
     * 
     * @param name
     * @param date
     * @param duration
     * @param comment
     * 
     * Constructor like others but to set comment field as well
     */
    public Exercise(String name, Date date, double duration, String comment) {
    	setName(name);
        setDuration(duration);
        setComment(comment); 
        setDate(date); 
    }

    // getters
    /**
     * 
     * @return (exercise name as String)
     */
    public String getName() { return name; }
    /**
     * 
     * @return (exercise comment as String)
     */
    public String getComment() { return comment; }
    /**
     * 
     * @return (exercise duration as double)
     */
    public double getDuration() { return duration; }
    /**
     * 
     * @return (exercise date as Date object)
     */
    public Date getDate() { return date; }

    // setters
    /**
     * 
     * @param name
     * 
     * setter for name value
     */
    public void setName(String name) { this.name = name; }
    /**
     * 
     * @param comment
     * 
     * setter for comment field
     */
    public void setComment(String comment) { this.comment = comment; }
    /**
     * 
     * @param duration
     * 
     * setter for duration field
     */
    public void setDuration(double duration) { this.duration = duration; }
    /**
     * 
     * @param date
     * 
     * setter for date field with Date object
     */
    public void setDate(Date date) { this.date = date; }
    /**
     * used to set date with todays date
     */
    public void setDate() {
    	this.date = new Date();
    }
    /**
     * 
     * @param date
     * 
     * sets date using String format of date
     */
    public void setDate(String date) {
		try {
			this.date = df.parse(date);
		} catch (Exception ex) {
			this.date = new Date(); // now
		}
	}
    
    /**
     * 
     * @return (returns date as string in format (mm,dd,yyyy))
     */
    public String getDateAsString() {
    	return df.format(date);
    }
    
    // abstract methods (see details in sub classes
    public abstract double getCaloriesBurned();
    public abstract String getType(); 
    public abstract String toStringCustomInfo();
	
    /**
     * Method overrides toString to define a tab delimeted toString for each exercise
     */
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%.2f\t%s\t%.2f\t%s", name,getType(),getDateAsString(),duration,toStringCustomInfo(),getCaloriesBurned(),comment);
	}

	/**
	 * method overrides compareTo from comparable to define how to compare two exercises by date
	 */
    @Override
    public int compareTo(Exercise o) {
        return (int) (getDate().getTime() - o.getDate().getTime());
    }

    /**
     * class needed to override compareTo defining comparing exercises by calories burned
     */
	private class ExerciseCompareByCalories implements Comparable<Exercise> {

        @Override
        public int compareTo(Exercise o) {
            return (int) (getCaloriesBurned() - o.getCaloriesBurned());
        }

    }
}