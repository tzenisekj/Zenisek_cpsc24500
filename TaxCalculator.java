/*
 * Name:        Tyler Zenisek
 * Class:       OOP
 * Assignment:  Assignment 2: Tax Calculator
 * 
 * - Program takes in an employee's name and their salary and 
 *   calculates their taxed income. All data is then displayed. 
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaxCalculator {
    public static String employeeName; 
    public static int employeeIncome; 
    public static int employeeTax = 0; 

    public static void main(String[] args) {
        // initialize Scanners
        Scanner scanName = new Scanner(System.in);
        Scanner scanIncome = new Scanner(System.in); 

        // get user input
        System.out.print("Input employee's name:\n~ ");
        employeeName = scanName.nextLine(); 

        // check for proper name
        for (int i = 0; i < employeeName.length(); i++) {
            if (Character.isDigit(employeeName.charAt(i))) {
                System.out.println("Employee Name invalid...");

                // close scanners
                scanIncome.close();
                scanName.close();

                // exit program
                return; 
            } 
        }

        // try catch handles when a user doesn't input a number
        try {
            System.out.print("\nInput employee's income:\n~ ");
            employeeIncome = scanIncome.nextInt();

            // program execution
            if (employeeIncome >= 0) {
                calcTax(); 
                System.out.println("\nName: " + employeeName);
                System.out.println(employeeName + "'s Income: " + employeeIncome);
                System.out.println(employeeName + "'s Income Tax: " + employeeTax); 
            }
            else {
                // runs when user input is less than 0
                System.out.println("Invalid input, income should be zero or more");
            }
        }
        catch(InputMismatchException e) {
            System.out.println("Invalid input, income should be zero or more"); 
        }

        // close scanners
        scanName.close();
        scanIncome.close();
    }

    /*
     * Class method calcTax
     * - Paramenters: None
     * - Returns:     None
     * 
     * - Method uses employee's income to calculate the amount of tax they owe at the end of the year based off their salary. 
     */
    public static void calcTax() {
        if (employeeIncome != 0) {
            double hold = employeeIncome;   // variable used to keep track of income based on each calculation of taxed income

            // handles tax free income
            hold -= 4000; 
            if (hold <= 0) return;

            // calculates first percent tax at 10%
            if (hold > 1500) {
                employeeTax += 1500 * .10;
                hold -= 1500;  
            }
            else {
                if (hold <= 0) return;
                employeeTax += hold * .10; 
                return; 
            }

            // calculates second percent tax at 20%
            if (hold > 28000) {
                employeeTax += 28000 * .20;
                hold -= 28000;  
            }
            else {
                if (hold <= 0) return;
                employeeTax += hold * .20; 
                return; 
            }

            // calculates final percent tax at 40%
            if (hold <= 0) return;
            employeeTax += hold * .40; 
            return; 
        }
    }
}