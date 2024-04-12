package a7;

/*
 * Class "Complex" is a class representation for a complex number in the form (a + bi).
 * 
 * Complex inherites Comparable for compareTo function
 * 
 * two double variables hold the values of a and b where "i" stands for imaginary
 * 
 * 4 Constructors
 * - Default Constructor: Complex()
 *      * Sets a and b = 0.0
 * - 1 param Constructor: Complex(double a)
 *      * Takes in double value for a and sets a = to that value
 *      * b is set = to 0.0
 * - 2 param Constructor: Complex(double a, double b)
 *      * Takes in two parameters for a and b and sets those 
 *        values accordingly
 * - Copy Construcotr: Complex(Complex cNum)
 *      * cNum is another complex number to copy the values of a
 *        and b from
 * 
 * Methods
 * - getRealPart()
 *      * Returns the value of a
 * - getImaginaryPart()
 *      * Returns the value of b as a string in the form of (bi)
 *        where "i" is put in place to stand for the imaginary
 *        number
 * - add(Complex cNum)
 *      * takes in another complex number and returns a new 
 *        complex number as a result of doing complex number
 *        addition with the passed complex number and the called
 *        instance
 *      * Returns a new Complex Number
 * - subtract(Complex cNum)
 *      * takes in another complex number and returns a new 
 *        complex number as a result of doing complex number
 *        subtraction with the passed complex number and the 
 *        called instance
 *      * Returns a new Complex Number
 * - multiply(Complex cNum)
 *      * takes in another complex number and returns a new 
 *        complex number as a result of doing complex number
 *        multiplication with the passed complex number and the
 *        called instance
 *      * Returns a new Complex Number
 * - divide(Complex cNum)
 *      * takes in another complex number and returns a new 
 *        complex number as a result of doing complex number
 *        division with the passed complex number and the called
 *        instance
 *      * Returns a new Complex Number
 * - abs()
 *      * Returns the double value from calculating the absolute
 *        value of the given complex number
 * - toString()
 *      * Returns the String representation of the complex
 *        number in the format (a + bi)
 * - @Override
 * - compareTo(Complex cNum)
 *      * Override compareTo function from comparable to proide
 *        sorting logic and comparison between two complex 
 *        numbers using their absolute values. 
 *      * Returns the differene of the two absolute values given
 *        by the two complex numbers being compared
 */

import java.util.Scanner;

public class Complex implements Comparable<Complex> {
    private double a,b; 
    
    /**
     * Default constructor
     * sets a and b to 0.0
     **/
    Complex() {
        this.a = 0; 
        this.b = 0; 
    }

    /**
     * constructor to only set a value
     * @param a double value for real part of complex number
     */
    Complex(double a) {
        this.a = a; 
        this.b = 0.0; 
    }

    /**
     * constructor to set both a and b values
     * @param a double value for real part of complex number
     * @param b double value for imaginary part of complex num
     */
    Complex(double a, double b) {
        this.a = a; 
        this.b = b; 
    }

    /**
     * copy constructor
     * @param cNum complex number to copy values of a and b from
     */
    Complex(Complex cNum) {
        this.a = cNum.a; 
        this.b = cNum.b; 
    }

    /**
     * provides real part of the complex number
     * @return a value as double
     */
    public double getRealPart() {
        return this.a; 
    }

    /**
     * provides the imaginary part of the complex number
     * @return b value as String to tack on "i" to number
     */
    public String getImaginaryPart() {
        return String.valueOf(this.b) + "i"; 
    }

    /**
     * method performs complex number addittion
     * @param cNum another complex number
     * @return a new complex number from complex number addittion
     */
    public Complex add(Complex cNum) {
        Complex c = new Complex(); 
        c.a = this.a + cNum.a; 
        c.b = this.b + cNum.b; 
        return c; 
    }

    /**
     * method performs complex number subtraction
     * @param cNum another complex number
     * @return a new complex number from complex number subtraction
     */
    public Complex subtract(Complex cNum) {
        Complex c = new Complex(); 
        c.a = this.a - cNum.a; 
        c.b = this.b - cNum.b; 
        return c; 
    }

    /**
     * method performs complex number multiplication
     * @param cNum another complex number
     * @return a new complex number from complex number multiplication
     */
    public Complex multiply(Complex cNum) {
        Complex c = new Complex(); 
        c.a = (this.a * cNum.a) - (this.b * cNum.b); 
        c.b = (this.b * cNum.a) + (this.a * cNum.b); 
        return c; 
    }

    /**
     * method performs complex number division
     * @param cNum another complex number
     * @return a new complex number from complex number division
     */
    public Complex divide(Complex cNum) {
        Complex c = new Complex(); 
        c.a = ((this.a * cNum.a + this.b * cNum.b) / (cNum.a * cNum.a + cNum.b * cNum.b));
        c.b = ((this.b * cNum.a - this.a * cNum.b) / (cNum.a * cNum.a + cNum.b * cNum.b));
        return c; 
    }

    /**
     * method calculates the aboslute value of the complex number
     * @return double value of absolute value of complex number
     */
    public double abs() {
        return Math.sqrt((a * a) + (b * b)); 
    }

    /**
     * @return String representation of complex number in form (a + bi)
     * if complex number has b value of 0.0 then String representation is in the form of (a)
     */
    public String toString() {
        if (b == 0)
            return "(" + String.valueOf(a) + ")"; 
        else
            return "(" + String.valueOf(a) + " + " + String.valueOf(b) + "i)";  
    }

    /** method overrides compareTo from Comparable 
     * - Needed for complex number sorting and comparisons
     * @return differenc of two complex numbers based on their abolute values
     */
    @Override
    public int compareTo(Complex c) {
        return (int)this.abs() - (int)c.abs(); 
    }

    /**
     * 
     * @param args array of possible arguments for main function
     * function main handles test program
     * - program uses scanner to get a users input for two complex numbers
     * - program then displays all operations and class methods for two complex numbers
     */
    public static void main(String[] args) {
        // variables 
        double input1 = 0, input2 = 0, input3 = 0, input4 = 0; 
        Scanner s = new Scanner(System.in); 
        
        // gets user input
        // catches if user inputs none numerical value
        try{
            System.out.print("Input first number number.\n~"); 
            input1 = s.nextDouble(); 
            System.out.print("Input second imaginary number.\n~"); 
            input2 = s.nextDouble(); 

            System.out.print("\nInput first number number.\n~"); 
            input3 = s.nextDouble(); 
            System.out.print("Input second imaginary number.\n~"); 
            input4 = s.nextDouble();
        }
        catch (Exception e) {
            // exists code with error
            System.out.println("\nError found"); 
            System.exit(-1);
            s.close();
        }

        // object initialization using variable constructor
        Complex c1 = new Complex(input1, input2); 
        Complex c2 = new Complex(input3, input4); 
    
        // displays first complex number and each part of it
        System.out.println("\nFirst Complex Number: " + c1.toString()); 
        System.out.println("Real number part of first Complex Number: " + c1.getRealPart()); 
        System.out.println("Imaginary number part of First Complex Number: " + c1.getImaginaryPart());
        
        // displays second complex number and each part of it
        System.out.println("\nSecond Complex Number: " + c2.toString()); 
        System.out.println("Real number part of second Complex Number: " + c2.getRealPart()); 
        System.out.println("Imaginary number part of second Complex Number: " + c2.getImaginaryPart());

        // displays each operation of complex numbers and their returned values
        System.out.println("\n" + c1.toString() + " + " + c2.toString() + " = " + c1.add(c2).toString()); 
        System.out.println(c1.toString() + " - " + c2.toString() + " = " + c1.subtract(c2).toString());
        System.out.println(c1.toString() + " * " + c2.toString() + " = " + c1.multiply(c2).toString());
        System.out.println(c1.toString() + " / " + c2.toString() + " = " + c1.divide(c2).toString()); 

        // displays the absolute values of each complex number
        System.out.println("\nAbsolute value of " + c1.toString() + " = " + c1.abs());
        System.out.println("Asbolute value of " + c2.toString() + " = " + c2.abs() + "\n"); 
 
        // processes comparison functionality with complex numbers
        if (c1.compareTo(c2) >= 0) {
            System.out.println(c1.toString() + " is greater than " + c2.toString()); 
        }
        else {
            System.out.println(c2.toString() + " is greater than " + c1.toString());
        }

        // closes scanner
        s.close();
    }
}
