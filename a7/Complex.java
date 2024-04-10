package a7;

import java.util.Scanner;

public class Complex implements Comparable<Complex> {
    private double a,b; 
    
    Complex() {
        this.a = 0; 
        this.b = 0; 
    }

    Complex(double a) {
        this.a = a; 
    }

    Complex(double a, double b) {
        this.a = a; 
        this.b = b; 
    }

    Complex(Complex cNum) {
        this.a = cNum.a; 
        this.b = cNum.b; 
    }

    public double getRealPart() {
        return this.a; 
    }

    public String getImaginaryPart() {
        return String.valueOf(this.b) + "i"; 
    }

    public Complex add(Complex cNum) {
        Complex c = new Complex(); 
        c.a = this.a + cNum.a; 
        c.b = this.b + cNum.b; 
        return c; 
    }

    public Complex subtract(Complex cNum) {
        Complex c = new Complex(); 
        c.a = this.a - cNum.a; 
        c.b = this.b - cNum.b; 
        return c; 
    }

    public Complex multiply(Complex cNum) {
        Complex c = new Complex(); 
        c.a = (this.a * cNum.a) - (this.b * cNum.b); 
        c.b = (this.b * cNum.a) + (this.a * cNum.b); 
        return c; 
    }

    public Complex divide(Complex cNum) {
        Complex c = new Complex(); 
        c.a = ((this.a * cNum.a + this.b * cNum.b) / (cNum.a * cNum.a + cNum.b * cNum.b));
        c.b = ((this.b * cNum.a - this.a * cNum.b) / (cNum.a * cNum.a + cNum.b * cNum.b));
        return c; 
    }

    public double abs() {
        return Math.sqrt((a * a) + (b * b)); 
    }

    public String toString() {
        if (b == 0)
            return "(" + String.valueOf(a) + ")"; 
        else
            return "(" + String.valueOf(a) + " + " + String.valueOf(b) + "i)";  
    }

    @Override
    public int compareTo(Complex c) {
        return (int)this.abs() - (int)c.abs(); 
    }

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
        System.out.println("Asbolute value of " + c2.toString() + " = " + c2.abs()); 
 
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
