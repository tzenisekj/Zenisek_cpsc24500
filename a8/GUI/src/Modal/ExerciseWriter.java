package Modal;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ExerciseWriter {
	public static boolean writeToFile(ArrayList<Exercise> exerciseList, File selectedFile) {
		System.out.println("writing exercises to file"); 
		try {
			FileWriter writter = new FileWriter(selectedFile);
			writter.flush();
			
			for (Exercise e: exerciseList) {
				writter.write(e.toString() + "\n");
			}
			writter.close();
			return true; 
		}
		catch (Exception e) {
			return false; 
		}
	}
	
	public static void writeToScreen(ArrayList<Exercise> exerciseList) {
		System.out.println("\nAll Exercises");
		System.out.println("-------------------");
		for (Exercise e : exerciseList) {
			System.out.println(e.toString());
		}
	}
	
	public static String tabulateSummary(ArrayList<Exercise> exerciseList) {
		String tabSummary = "Name\tType\tDate\tCalories Burned\n=====================================================\n"; 
		
		for (Exercise e: exerciseList) {
			tabSummary += e.getName() + "\t" + e.getType() + "\t" + e.getDateAsString() + "\t" + e.getCaloriesBurned() + "\n";
		}
		
		return tabSummary; 
	}
}
