package a7;

public class Complex implements Comparable {
    private double a,b; 
    
    Complex() {
        a = 0; 
        b = 0; 
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
        return a; 
    }

    public String getImaginaryPart() {
        return String.valueOf(b) + "i"; 
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
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(3.5, 5.5); 
        Complex c2 = new Complex(-3.5, 1.0); 

        c1.add(c2); 
        System.out.println(c1.toString()); 
    }
}
