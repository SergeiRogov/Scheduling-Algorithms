/**
 * @file Algorithm.java
 * @brief This file contains a generic scheduling Algorithm interface.
 */
package scheduling_algorithms;

/**
 * @interface Algorithm
 * @brief Generic scheduling algorithm interface. 
 * 
 *        Contains 2 methods:
 *        	1) 	schedule() method for obtaining 
 *        		the next task to be run on the CPU.
 *        
 *        	2) 	pickNetTask() method pick next task 
 *        		to be executed.
 */
public interface Algorithm {
	
	/**
	 * @method schedule
	 * @brief Implementation of a scheduling algorithm.
	 */
	public void schedule();
	
	/**
	 * @method pickNetTask
	 * @brief Selects the next task to be scheduled.
	 */
	public Task pickNextTask();
	
}
