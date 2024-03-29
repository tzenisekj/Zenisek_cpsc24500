package a6;

/*
 * Factor class for creating new nodes randomly
 * 
 * Had to fix the code for randomly generating numbers between ranges specified in INode.
 */
import java.util.Random;

import a5.Node;

public class NodeFactory {
	/**
	 * Create a ThreeDNode according to the given parameters, if parameters are invalid
	 * return a default ThreeDNode 
	 * @return
	 * @throws Exception 
	 */
	public static ThreeDNode getThreeDNode() throws Exception {
		Random r = new Random();
		int z = r.nextInt(INode.UPPER_LIMIT - INode.LOWER_LIMIT) + INode.LOWER_LIMIT;
		Node node = getNode();
	    return new ThreeDNode(node.getX(),node.getY(),z);
	}
	
	/**
	 * Creates a Node according to the given parameters, if parameters are invalid
	 * return a default Node
	 * @return
	 * @throws Exception
	 */
	public static Node getNode() throws Exception {
		Random r = new Random();
		int x = r.nextInt(INode.UPPER_LIMIT - INode.LOWER_LIMIT) + INode.LOWER_LIMIT; 
		int y = r.nextInt(INode.UPPER_LIMIT - INode.LOWER_LIMIT) + INode.LOWER_LIMIT;
		return new Node(x,y);
	}
}
