package a6;
/*
 * class ThreeDNode extends the Node class from package a5 inheriting the x,y coordinates but adding the z coordinate to an object of type INode.
 * 
 * private attribute z as integer
 * 
 * Extends Node from a5
 * 
 * Contains 3 constructors
 * - Default constructor setting x,y,z to 0
 * - Constructor of x,y,z which are passed as parameters and set
 * - Copy constructor copying the x,y,z contents of a ThreeDNode to the current ThreeDNode
 * 
 * Getter and Setter for Z
 * 
 * Private methods to check that any integers passed for x,y,z are within the bounds [-100,100]
 * 
 * Method "add" which adds the x,y,z of a ThreeDNode to the current ThreeDNode
 * 
 * Method "toString" hich verrides the toString method in Node from a5 
 * 
 * Method "equals" which overrides the equals method in Node from a5
 */
import a5.Node;

public class ThreeDNode extends Node {
    private int z; 

    /**
     * 
     * @throws Exception
     * - default constructor
     */
    public ThreeDNode() throws Exception {
        setX(DEFAULT_X);
        setY(DEFAULT_Y); 
        setZ(DEFAULT_Z); 
    }

    /**
     * @param x integer in bounds of [-100,100]
     * @param y integer in bounds of [-100,100]
     * @param z integer in bounds of [-100,100]
     * @throws Exception when any integer is out of bounds
     */
    public ThreeDNode(int x, int y, int z) throws Exception {
        setX(x);
        setY(y);
        setZ(z);
    }

    /**
     * 
     * @param n another ThreeDNode
     * @throws Exception
     * 
     * copy constructor
     */
    public ThreeDNode(ThreeDNode n) throws Exception {
        setX(n.getX()); 
        setY(n.getY()); 
        setZ(n.getZ()); 
    }

    /**
     * 
     * @return value of z
     */
    public int getZ() {
        return z; 
    }

    /**
     * 
     * @param val integer in bounds of [-100,100]
     * @throws Exception when val is out of bounds
     */
    public void setZ(int val) throws Exception {
        if (val >= LOWER_LIMIT && val <= UPPER_LIMIT) {
            z = val; 
        }
        else {
            throw new Exception("Value passed is out of bounds of ["+LOWER_LIMIT+","+UPPER_LIMIT+"]"); 
        }
    }

    /**
     * 
     * @param x integer in bounds of [-100,100]
     * @return true when in bounds and false otherwise
     */
    private boolean isValidX(int x) {
		if (x<=UPPER_LIMIT && x>=LOWER_LIMIT)
			return true;
		return false;
	}

    /**
     * 
     * @param y integer in bounds of [-100,100]
     * @return  true when in bounds and false otherwise
     */
	private boolean isValidY(int y) {
		if (y<=UPPER_LIMIT && y>=LOWER_LIMIT)
			return true;
		return false;
	}

    /**
     * 
     * @param z integer in bounds of [-100,100]
     * @return true when in bounds and false otherwise
     */
    private boolean isValidZ(int z) {
        if (z<=UPPER_LIMIT && z>=LOWER_LIMIT) 
            return true; 
        return false;
    }

    /**
     * 
     * @param n another ThreeDNode to add the values of to current ThreeDNode
     * @throws Exception when addition causes an out of bounds exception
     */
    public void add(ThreeDNode n) throws Exception {
        if (isValidX(getX() + n.getX()) && isValidY(getY() + n.getY()) && isValidZ(getZ() + n.getZ())) {
            setX(getX() + n.getX());
            setY(getY() + n.getY()); 
            setZ(getZ() + n.getZ()); 
        }
        else {
            throw new Exception("Resulting addition excedes the bounds of ["+LOWER_LIMIT+","+UPPER_LIMIT+"]");
        }
    }

    /**
     * @return string of x,y,z values
     */
    @Override
    public String toString() {
        return "(" + String.valueOf(getX()) + "," + String.valueOf(getY()) + "," + String.valueOf(getZ()) + ")"; 
    }

    /**
     * @param obj is ThreeDNode
     * @return true if x,y,z of both passed ThreeDNode and current node are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        //to restrict call with only objects of type Node
		if (obj instanceof ThreeDNode) {
			ThreeDNode ref = (ThreeDNode) obj;
			if (getX() == ref.getX() && getY() == ref.getX() && getZ() == ref.getZ())
				return true;
			return false;
		}
		return false;
    }
}
