/**
 * File: ExerciseWriter
 * 
 * This is a static class in order to write a list of exercises to a file. Write a list of exercises in a summarized format and a tab delimited detailed format
 * 
 * NO CONSTRUCTORS
 * 
 * STATIC METHODS
 * - writeToFile()
 * - writeToScreen()
 * - tabulateSummary()
 */
package Modal;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ExerciseWriter {
	/**
	 * 
	 * @param exerciseList	(list of exercises)
	 * @param selectedFile	(file to save exercises to)
	 * @return				(true if successfully updated to file, false with error)
	 */
	public static boolean writeToFile(ArrayList<Exercise> exerciseList, File selectedFile) {
		System.out.println("writing exercises to file"); 
		try {
			// writing to file
			FileWriter writter = new FileWriter(selectedFile);
			writter.flush();
			
			for (Exercise e: exerciseList) {
				writter.write(e.toString() + "\n");
			}
			writter.close();
			return true; 
		}
		catch (Exception e) {
			// failed to write to file
			return false; 
		}
	}
	
	/**
	 * 
	 * @param exerciseList	(list of exercises)
	 * 
	 * displays to the console the list of exercises
	 */
	public static void writeToScreen(ArrayList<Exercise> exerciseList) {
		System.out.println("\nAll Exercises");
		System.out.println("-------------------");
		for (Exercise e : exerciseList) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * 
	 * @param exerciseList	(list of exercises)
	 * @return				(returns the list of exercises summarized by name, type, date, calories burned in a table format with String)
	 */
	public static String tabulateSummary(ArrayList<Exercise> exerciseList) {
		String tabSummary = "Name\tType\tDate\tCalories Burned\n=====================================================\n"; 
		
		for (Exercise e: exerciseList) {
			tabSummary += e.getName() + "\t" + e.getType() + "\t" + e.getDateAsString() + "\t" + e.getCaloriesBurned() + "\n";
		}
		
		return tabSummary; 
	}
}
