/**
 * @file Algorithm.java
 * @brief This file contains a generic scheduling Algorithm interface.
 */
package scheduling_algorithms;

import java.util.ArrayList;

/**
 * @interface Algorithm
 * @brief Generic scheduling algorithm interface. 
 * 
 * @details Contains 2 methods:
 *        	1) 	schedule() method for obtaining 
 *        		the next task to be run on the CPU.
 *        
 *        	2) 	pickNextTask() method pick next task 
 *        		to be executed.
 */
public interface Algorithm {
	
	/**
	 * @method schedule
	 * @brief Implementation of a scheduling algorithm.
	 */
	public void schedule(ArrayList<Task> tasks);
	
	/**
	 * @method pickNextTask
	 * @brief Selects the next task to be scheduled.
	 */
	public Task pickNextTask(ArrayList<Task> tasks);
	
}
