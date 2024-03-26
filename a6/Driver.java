package a6;
/*
 * This class "Driver" is the class that contains all the directional code for handling the created nodes of x,y or x,y,z coordinates.
 * 
 * 1 default constructor holds the code to handle the menu prompt and all logic on what to do with the list of nodes that is created
 * 
 * 1 - Fill list with new random  nodes
 * 2 - Clear all nodes
 * 3 - Get all nodes of x,y
 * 4 - Get all nodes of x,y,z
 * 5 - Sorts all nodes in ascending order based on sum total of coords
 * 6 - Displays all nodes
 * 7 - Exits the Driver
 * 
 * All code that handles this logic with nodes is found in other classes
 */

import java.util.Scanner;

public class Driver {
    private Nodes n = new Nodes();
    private Scanner scan = new Scanner(System.in); 

    /**
     * @throws Exception if error ever occurs
	 */
    Driver () throws Exception {
        int choice = 0; 

        // handles program execution
        while (choice != 7) {
            display(); 
            
            try {
                System.out.print("~ "); 
                choice = scan.nextInt();
            }
            catch(Exception e) {
                // catches bad user input
                scan.nextLine();    
            }

            switch (choice) {
                case 1:
                    fillNodes();
                    break; 
                case 2: 
                    clearNodes();
                    break; 
                case 3:
                    getNodes();
                    break; 
                case 4: 
                    getThreeDNodes();
                    break; 
                case 5: 
                    System.out.println("\nSorting...");
                    n.sort();
                    break; 
                case 6: 
                    System.out.println("\n"); 
                    System.out.println(n.toString()); 
                    break;
                case 7: 
                    break;
                default:
                    System.out.println("\nInput invalid...");
                    break; 
            }
        } 
    }

    /**
     * 
     * @throws exception when error occurs
     * - gets users input for size of new list and creates random nodes to fill the list
	 */
    private void fillNodes() throws Exception {
        int num = 0; 

        // handles user input and error handling
        while (true) {
            System.out.print("\nInput number of nodes to fill.\n~  ");
            try {
                num = scan.nextInt();
                break; 
            } 
            catch (Exception e) {
                System.out.print("Invalid input...");
                scan.nextLine();
            }
        }

        System.out.println("\nFilling nodes..."); 
        n.fill(num);
    }

    /**
     * Simply clears the list of Nodes
	 */
    private void clearNodes() {
        System.out.println("\nClearing nodes...\n");
        n.clear();
    }

    /**
     * outputs the number of x,y nodes in list
	 */
    private void getNodes() {
        System.out.println("\nNumber of Nodes-> " + String.valueOf(n.countNodes())); 
    }

    /*
     * outputs the number of x,y,z nodes in list
     */
    private void getThreeDNodes() {
        System.out.println("\nNumber of ThreeDNodes-> " + String.valueOf(n.countThreeDNodes()));
    }

    /*
     * Displays menu prompt for user
     */
    private void display() {
        System.out.println("1. Fill");
        System.out.println("2. Clear");
        System.out.println("3. Count Nodes");
        System.out.println("4. Count ThreeDNodes");
        System.out.println("5. Sort");
        System.out.println("6. Display");
        System.out.println("7. Exit");
    }
}
