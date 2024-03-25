package a6;

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
		int z = INode.UPPER_LIMIT + r.nextInt(INode.UPPER_LIMIT-  INode.LOWER_LIMIT+1);
		Node node = getNode();
	    return new ThreeDNode(node.getX(),node.getY(),z);
	}
	
	public static Node getNode() throws Exception {
		Random r = new Random();
		int x = INode.UPPER_LIMIT + r.nextInt(INode.UPPER_LIMIT-  INode.LOWER_LIMIT+1);
		int y = INode.UPPER_LIMIT + r.nextInt(INode.UPPER_LIMIT-  INode.LOWER_LIMIT+1);
		return new Node(x,y);
	}
}
