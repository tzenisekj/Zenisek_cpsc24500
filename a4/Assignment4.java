/*
 * Name:        Tyler Zenisek
 * Class:       OOP
 * Assignment:  Assignment 4: Jaggad 2D Array
 * 
 * - Program usses a txt file of numerical values passed to the main function 
 * - and creates a jaggad 2D array to mimic the txt file. This 2D array is used 
 * - to check things like the longest row of the file or the largest value found in the file. 
 */
package a4;

import java.util.Scanner;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
   
public class Assignment4 {

	/**
	 *
	 * @param filename
	 * @return number of lines in a text file
	 * @throws Exception
	 */
	public static int getNoLines(String filename) throws Exception{
		try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
			return (int) fileStream.count();
		} 
	}

	/**
	 * 
	 * @param filename source file
	 * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
	 * the length of each row depends on the number of values in each line of the file.
	 * @throws Exception
	 */
	public static int[][] create2DArray(String filename) throws Exception {
		if (getNoLines(filename) == 0) {
            throw new Exception("Empty file passed"); 
        }
 
        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(filename)); 
            String line = reader.readLine();

            int arr[][] = new int[getNoLines(filename)][]; 
            for (int i = 0; i < getNoLines(filename); i++) {
                if (line == null) break; 

                String[] values = line.split(" ");
                arr[i] = new int[values.length]; 
                for (int j = 0; j < values.length; j++) {
                    arr[i][j] = Integer.parseInt(values[j]); 
                }
                line = reader.readLine(); 
            }

            reader.close();
            return arr;
        }
        catch(Exception e) { 
            throw e; 
        }
	}

    /**
	 * 
	 * @param arr 2D array
	 * @return integer index of the row in the 2D array that has the longest length. Returns the longest row in the 2D array
	 * @throws Exception
	 */
    public static int findLongestRow(int[][] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception("Empty array passed.");
        } 

        int max = 0; 
        int index = 0; 
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > max) {
                max = arr[i].length;
                index = i;  
            }
        }

        return index; 
    }
	
    /**
	 * 
	 * @param arr 2D array
     * @param index passed index for row to check in 2D array
	 * @return the largest value found in the row within the passed 2D array given by the passed index
	 * @throws Exception
	 */
    public static int findMaxInRow(int[][] arr, int index) throws Exception {
        if (arr.length == 0) {
            throw new Exception("Empty array passed.");
        }
        if (index >= arr.length) {
            throw new Exception("Passed index is out of bounds of array");
        }

        int value = 0; 

        for (int i = 0; i < arr[index].length; i++) {
            if (arr[index][i] > value) {
                value = arr[index][i]; 
            }
        }
        return value; 
    }

    /**
	 * 
	 * @param arr 2D array 
	 * @return the largest value found in the passed 2D array
	 * @throws Exception
	 */
    public static int findMax(int[][] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception("Empty array passed.");
        }

        int value = 0; 
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > value) {
                    value = arr[i][j];
                }
            }
        }

        return value; 
    }
	public static void main(String[] args) {
		String filename = null;
		if (args.length <1) {
			System.out.println("usage: Assignment4 inputFilename ");
			System.exit(0);
			
		}
		filename = args[0];
		int arr[][] = null;
		try {
			System.out.println("Number of lines in the file ="+ getNoLines(filename));
			arr = create2DArray(filename);
			int longestRow = findLongestRow(arr);
			System.out.println("Longest row in the file is: "+ (longestRow+1 )+" ,with length of: "
			                      +arr[longestRow].length);
			System.out.println("Max value in first row = "+ findMaxInRow(arr, 0));
			System.out.println("Max value in file = "+ findMax(arr));
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
