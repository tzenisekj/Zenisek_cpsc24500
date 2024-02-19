package Exercises;

import java.util.Scanner;

public class InputValidation {
    public static int readIntInRange(int a, int b) throws Exception {
        if (a>b) {
            throw new Exception("First number passed for range is larger than second number passed resulting in unknown range of values.");
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a value in ["+a+","+b+"]: "); 
        int value = 0;
        do {
            value = in.nextInt();
            // check for valid numerical input
            if () {

            }
            // check for valid input in range
            if (value > b || value < a) {
                System.out.print("Please enter a value in ["+a+","+b+"]: "); 
            }
            else {
                break; 
            }
        } while(true);

        in.close();
        return value; 
    }

    public static void main(String[] args) {
        try {
            readIntInRange(5, 10);
        }
        catch(Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
