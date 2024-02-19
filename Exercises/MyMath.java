package Exercises;

public class MyMath {
     
    public double convertCelToFahr(int temp) {
        return (temp * 1.8 + 32); 
    }

    public double convertFahrToCelc(int temp) {
        return (temp - 32) / 1.8; 
    }

    public static void main(String[] args) {
        MyMath ref = new MyMath(); 

        System.out.println(ref.convertCelToFahr(10));
    }
}
