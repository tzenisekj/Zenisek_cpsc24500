package Modal;

import java.util.ArrayList;

public class ExerciseWriter {
	public static boolean writeToFile(ArrayList<Exercise> exerciseList) {
		System.out.println("writing exercises to file"); 
		
		return true; 
	}
	
	public static void writeToScreen(ArrayList<Exercise> exerciseList) {
		System.out.println("\nAll Exercises");
		System.out.println("-------------------");
		for (Exercise e : exerciseList) {
			System.out.println(e.toString());
		}
	}
	
	public static void tabulateSummary(ArrayList<Exercise> exerciseList) {
		System.out.println("\nExercise Summary"); 
		System.out.println("---------------------");
		System.out.println("Name\tType\tDate\tCalories Burned");
		System.out.println("-------------------------------------");
		
		for (Exercise e : exerciseList) {
			System.out.println(e.getName() + "\t" + e.getType() + "\t" + e.getDate().toString() + "\t" + e.getCaloriesBurned());
		}
	}
}
