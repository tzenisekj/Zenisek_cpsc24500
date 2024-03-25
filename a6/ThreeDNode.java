package a6;

import a5.Node;

public class ThreeDNode extends Node {
    private int z; 

    public ThreeDNode() throws Exception {
        setX(DEFAULT_X);
        setY(DEFAULT_Y); 
        setZ(DEFAULT_Z); 
    }

    public ThreeDNode(int x, int y, int z) throws Exception {
        setX(x);
        setY(y);
        setZ(z);
    }

    public ThreeDNode(ThreeDNode n) throws Exception {
        setX(n.getX()); 
        setY(n.getY()); 
        setZ(n.getZ()); 
    }

    public int getZ() {
        return z; 
    }

    public void setZ(int val) throws Exception {
        if (val >= LOWER_LIMIT && val <= UPPER_LIMIT) {
            z = val; 
        }
        else {
            throw new Exception("Value passed is out of bounds of ["+LOWER_LIMIT+","+UPPER_LIMIT+"]"); 
        }
    }

    private boolean isValidX(int x) {
		if (x<=UPPER_LIMIT && x>=LOWER_LIMIT)
			return true;
		return false;
	}
	private boolean isValidY(int y) {
		if (y<=UPPER_LIMIT && y>=LOWER_LIMIT)
			return true;
		return false;
	}
    private boolean isValidZ(int z) {
        if (z<=UPPER_LIMIT && z>=LOWER_LIMIT) 
            return true; 
        return false;
    }

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

    @Override
    public String toString() {
        return "X: " + String.valueOf(getX()) + ", Y: " + String.valueOf(getY()) + ", Z: " + String.valueOf(getZ()); 
    }

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
