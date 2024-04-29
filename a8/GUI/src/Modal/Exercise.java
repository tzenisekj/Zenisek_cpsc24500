package Modal;

import java.util.Date;

public abstract class Exercise implements Comparable<Exercise>{
    private String name; 
    private String comment; 
    private double duration;  
    private Date date; 

    Exercise(String name, double duration, Date date) {
        this.name = name; 
        this.duration = duration;
        this.comment = ""; 
        this.date = date; 
    }

    Exercise(String name, String comment, double duration, Date date) {
        this.name = name; 
        this.duration = duration;
        this.comment = comment; 
        this.date = date; 
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

    public abstract double getCaloriesBurned();
    public abstract Object getType(); 

    public String toString() {
        return ""; 
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