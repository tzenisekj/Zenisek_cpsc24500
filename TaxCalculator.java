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
    public  String employeeName; 
    public  int employeeIncome = 0; 
    public  int employeeTax = 0; 

    /*
     * Class method calcTax
     * - Paramenters: None
     * - Returns:     None
     * 
     * - Method uses employee's income to calculate the amount of tax they owe at the end of the year based off their salary. 
     */
    public void calcTax() {
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
    
    public static void main(String[] args) {
        // initializes tax calculator
        TaxCalculator calculator = new TaxCalculator();

        // initialize Scanners
        Scanner scanName = new Scanner(System.in);
        Scanner scanIncome = new Scanner(System.in); 

        // get user input
        System.out.print("Input employee's name:\n~ ");
        calculator.employeeName = scanName.nextLine(); 

        // check for proper name
        for (int i = 0; i < calculator.employeeName.length(); i++) {
            if (Character.isDigit(calculator.employeeName.charAt(i))) {
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
            calculator.employeeIncome = scanIncome.nextInt();

            // program execution
            if (calculator.employeeIncome >= 0) {
                calculator.calcTax(); 
                System.out.println("\nName: " + calculator.employeeName);
                System.out.println(calculator.employeeName + "'s Income: " + calculator.employeeIncome);
                System.out.println(calculator.employeeName + "'s Income Tax: " + calculator.employeeTax); 
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
}