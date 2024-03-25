/*
 * Name:        Tyler Zenisek
 * Class:       OOP
 * Assignment:  Assignment 5: Node class
 * 
 * - Program provides a class called Node which stores an x and y coordinate. These 
 * - coordinates cannot be out of the numerical range [-100, 100] and are integer whole numbers.  
 */
package a5;

public class Assignment5Node {
    // global variables
    private static final int MAX_X = 100; 
    private static final int MAX_Y = 100;
    private static final int MIN_X = -100; 
    private static final int MIN_Y = -100; 

    private int x_cord; 
    private int y_cord; 

    // constructors
    Assignment5Node() throws Exception {
        setX(0);
        setY(0);
    }

    /**
     * @param x integer passed to update x_coord
     * @param y integer passed to update y_coord
     * @throws exception
	 */
    Assignment5Node(int x, int y) throws Exception {
        if (x > MAX_X || x < MIN_X || y > MAX_Y || y < MIN_Y) {
            throw new Exception("Invalid arguments passed.");
        }

        setX(x);
        setY(y);
    }

    /**
     * @param n Node to copy values to current node via constructor
	 */
    Assignment5Node(Assignment5Node n) throws Exception {
        setX(n.getX());
        setY(n.getY());
    }

    // getters
    /**
	 * @return value stored in the x_coord variable
	 */
    public int getX() { return x_cord; }

    /**
	 * @return value stored in the y_coord variable
	 */
    public int getY() { return y_cord; }

    // setters
    /**
     * @param x integer value passed to update x_coord
	 * @throws exception
	 */
    public void setX(int x) throws Exception {
        if (x > MAX_X || x < MIN_X) {
            throw new Exception("Passed value is out of bounds of -100 to 100."); 
        }

        x_cord = x; 
    }

    /**
     * @param y integer value passed to update y_coord
	 * @throws exception
	 */
    public void setY(int y ) throws Exception {
        if (y > MAX_X || y < MIN_X) {
            throw new Exception("Passed value is out of bounds of -100 to 100."); 
        }

        y_cord = y;
    }

    /**
     * @param n Node passed by the caller to add to the caller node
	 * @throws exception
	 */
    public void add(Assignment5Node n) throws Exception {
        if (x_cord + n.getX() > MAX_X || x_cord + n.getX() < MIN_X || y_cord + n.getY() > MAX_Y || y_cord + n.getY() < MIN_Y) {
            throw new Exception("Resulting addition is out of bounds of -100 and 100 on either or both coordinates.");
        }

        setX(getX() + n.getX());
        setY(getY() + n.getY());
    }

    /**
     * @return string
	 */
    public String toString() {
        return "X = " + String.valueOf(x_cord) + ", Y = " + String.valueOf(y_cord) + "."; 
    }

    /**
     * @return boolean
	 */
    public boolean equals(Assignment5Node n) {
        if (n.getX() == x_cord && n.getY() == y_cord) {
            return true; 
        }
        else {
            return false; 
        }
    }

    public static void main(String[] args) throws Exception {
        Assignment5Node n = new Assignment5Node(); 
        Assignment5Node n2; 
        try {
            n2 = new Assignment5Node(100,-99); 
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            n2 = new Assignment5Node();  
        }
        Assignment5Node n3 = new Assignment5Node(n2); 

        System.out.println(n.toString()); 
        try {
            n2.add(n3);
        }
        catch (Exception e) {
            System.out.println(e.getMessage()); 
        }

        System.out.println(n2.toString());
    }
}