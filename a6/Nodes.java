package a6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import a5.Node; 

public class Nodes {
    private ArrayList<INode> list; 

    public Nodes() {
        list = new ArrayList<INode>(); 
    }

    public void fill(int size) throws Exception {
        if (list.isEmpty())
            list.clear();

        Random r = new Random();
		int numNodes = size + r.nextInt(size - 1);

        for (int i = 0; i < numNodes; i++) {
            list.add(NodeFactory.getNode()); 
        }

        for (int i = numNodes; i < size; i++) {
            list.add(NodeFactory.getThreeDNode()); 
        }
    }

    public int countNodes() {
        int result = 0; 

        if (list.isEmpty()) {
            return result; 
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Node) {
                result += 1; 
            }
        }

        return result; 
    }

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

    public void clear() {
        list.clear();
    }

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

    public void sort() {

    }

    private class Sorter implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'compare'");
        }
        
    }
}
