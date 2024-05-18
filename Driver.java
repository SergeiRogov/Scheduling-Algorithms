/**
 * @file Driver.java
 * @brief This file contains the Driver class.
 */
package scheduling_algorithms;

import java.util.ArrayList;

/**
 * @class Driver
 * @brief Contains the main function that kick-starts
 * 		  the Scheduling-Algorithms application.
 */
public class Driver {
	
	/**
	 * @method main
	 * @brief The main method to start the Scheduling-Algorithms application.
	 */
	public static void main(String[] args) {
		ArrayList<Task> tasks = TaskReader.readTasks();
		
		System.out.println("Scheduling-Algorithms Driver");
		System.out.println(tasks);
	}

}
