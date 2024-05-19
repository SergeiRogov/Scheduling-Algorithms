/**
 * @file Driver.java
 * @brief This file contains the Driver class.
 */
package scheduling_algorithms;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @class Driver
 * @brief Contains the main function that kick-starts
 * 		  the Scheduling-Algorithms application.
 */
public class Driver {
	
	/**
     * @method selectSchedulingAlgorithm
     * @brief Prompts the user to select a scheduling algorithm.
     * @return The name of selected scheduling algorithm.
     */
    public static Algorithm selectSchedulingAlgorithm() {
        Scanner scanner = new Scanner(System.in);
        Algorithm selectedAlgorithm = null;

        while (selectedAlgorithm == null) {
            System.out.println("\nPlease select a scheduling algorithm:\n");
            for (int i = 0; i < SchedulingAlgorithm.values().length; i++) {
                System.out.println((i + 1) + ") " + SchedulingAlgorithm.values()[i].getName());
            }
            System.out.print("\nEnter the number corresponding to your choice: ");

            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input) - 1; // Convert to zero-based index
                selectedAlgorithm = SchedulingAlgorithm.fromOrdinal(choice).getAlgorithm();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        scanner.close(); 
        
        return selectedAlgorithm;
    }
	
	/**
	 * @method main
	 * @brief The main method to start the Scheduling-Algorithms application.
	 */
	public static void main(String[] args) {
		
		ArrayList<Task> tasks = TaskReader.readTasks();
		System.out.println("Tasks:");
		System.out.println(tasks);
		
		Algorithm selectedAlgorithm = selectSchedulingAlgorithm();
		System.out.println("\nYou picked: " + selectedAlgorithm);
		
		selectedAlgorithm.schedule();
		
	}

}
