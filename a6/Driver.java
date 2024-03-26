package a6;

import java.util.Scanner;

public class Driver {
    private Nodes n;
    private Scanner scan = new Scanner(System.in); 

    Driver () {
        n = new Nodes(); 
    }

    private void fillNodes() throws Exception {
        int num = 0; 

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

    private void clearNodes() {
        System.out.println("\nClearing nodes...\n");
        n.clear();
    }

    private void getNodes() {
        System.out.println("\nNumber of Nodes-> " + String.valueOf(n.countNodes())); 
    }

    private void getThreeDNodes() {
        System.out.println("\nNumber of ThreeDNodes-> " + String.valueOf(n.countThreeDNodes()));
    }

    private void display() {
        System.out.println("1. Fill");
        System.out.println("2. Clear");
        System.out.println("3. Count Nodes");
        System.out.println("4. Count ThreeDNodes");
        System.out.println("5. Sort");
        System.out.println("6. Display");
        System.out.println("7. Exit");
    }
    public void set() throws Exception {
        int choice = 0; 

        while (choice != 7) {
            display(); 
            
            try {
                System.out.print("~ "); 
                choice = scan.nextInt();
            }
            catch(Exception e) {
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

    public static void main(String[] args) throws Exception {
        Driver d = new Driver(); 
        
        d.set(); 
    }
}
