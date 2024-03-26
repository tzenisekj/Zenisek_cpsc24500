package a6;

/*
 * Class "Nodes" is a class object that holds an ArrayList of INodes which can be either x,y or x,y,z nodes. This class contains all logic in handling the list.
 * 
 * 1 default constructor which initiates an empty list
 * 
 * Method "fill" which takes in a number meant to be the size of the array list. The function randomly generates a number between 0 and the passed integer to determine how many x,y nodes are added to the list and the remainder being x,y,z nodes. The arrayList is then filled.
 * 
 * Method "clear" simply clears the array list completely
 * 
 * Method "countNodes" loops through the array list counting up all nodes of the type x,y and returning that number.
 * 
 * Method "countThreeDNodes" loops through the array list counting up all nodes of the type x,y,z and returning that number.
 * 
 * Method "toString" returns a String of all nodes in the list and their respective coordinates on a new line.
 * 
 * Method "sort" uses the private class "Sorter" which implements comparator in order to use the java Collections object to sort the array list in ascending order based on the sum of the nodes coordinates.
 * 
 * PRIVATE CLASS "Sorter" implements Comparator
 * - Necessary for the sort method in Collections to define how sorting an array list of a non primitive type is handled. this way the array list of nodes can be sorted.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random; 

import a5.Node;

public class Nodes {
    private ArrayList<INode> list; 

    /**
     * initiates an empty array list of type <INode>
	 */
    public Nodes() {
        list = new ArrayList<INode>(); 
    }

    /**
     * @param size integer value for size of list
     * @throws Exception for out of bounds creation of new nodes
	 */
    public void fill(int size) throws Exception {
        if (list.isEmpty())
            list.clear();

        // randomly generates number between 0 and size
        // number is number of x,y nodes to create and add to list
        Random r = new Random();
		int numNodes = r.nextInt(size);

        // create and fill list of x,y nodes
        for (int i = 0; i < numNodes; i++) {
            list.add(NodeFactory.getNode()); 
        }
 
        // create and fill list of x,y,z nodes
        for (int i = numNodes; i < size; i++) { 
            list.add(NodeFactory.getThreeDNode()); 
        }
    }

    /**
     * @return integer of x,y nodes found in list
	 */
    public int countNodes() {
        int result = 0; 

        if (list.isEmpty()) {
            return result; 
        }

        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i) instanceof ThreeDNode)) {
                result += 1; 
            }
        }

        return result; 
    }

    /**
     * @return integer of x,y,z nodes found in list
	 */
    public int countThreeDNodes() {
        int result = 0; 

        if (list.isEmpty()) {
            return result; 
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof ThreeDNode) {
                result += 1; 
            }
        }

        return result; 
    }

    /**
     * method clears the list setting it back to 0
	 */
    public void clear() {
        list.clear();
    }

    /**
     * @return string object where each line is a node found in list
	 */
    public String toString() {
        String result = ""; 

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof ThreeDNode) {
                result += String.valueOf(i + 1) + ". ThreeDNode -> " + list.get(i).toString() + "\n"; 
            }
            else {
                result += String.valueOf(i + 1) + ". Node -> " + list.get(i).toString() + "\n";
            }
        }

        return result; 
    }

    /**
     * method sorts the list using class Sorter
	 */
    public void sort() {
        Collections.sort(list, new Sorter());
    }

    // private class uses comparator to define how list should be sorted
    private class Sorter implements Comparator {
        /**
         * @return integer difference of 2 objects
         * - method checks 2 objects for all combinations of Node or ThreeDNode and handles returning the sum values of each object
         */
        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof ThreeDNode && o2 instanceof ThreeDNode) {
                ThreeDNode n1 = (ThreeDNode) o1; 
                ThreeDNode n2 = (ThreeDNode) o2;

                return (n1.getX() + n1.getY() + n1.getZ()) - (n2.getX() + n2.getY() + n2.getZ()); 
            }
            else if (o1 instanceof ThreeDNode && !(o2 instanceof ThreeDNode)) {
                ThreeDNode n1 = (ThreeDNode) o1; 
                Node n2 = (Node) o2;

                return (n1.getX() + n1.getY() + n1.getZ()) - (n2.getX() + n2.getY());
            }
            else if (!(o1 instanceof ThreeDNode) && o2 instanceof ThreeDNode) {
                Node n1 = (Node) o1; 
                ThreeDNode n2 = (ThreeDNode) o2;

                return (n1.getX() + n1.getY()) - (n2.getX() + n2.getY() + n2.getZ());
            }
            else {
                Node n1 = (Node) o1; 
                Node n2 = (Node) o2;

                return (n1.getX() + n1.getY()) - (n2.getX() + n2.getY());
            }
        }
        
    }
}
