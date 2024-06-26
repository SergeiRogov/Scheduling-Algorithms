/**
 * @file FCFS.java
 * @brief This file contains a class for First-Come, First-Served algorithm.
 */
package scheduling_algorithms;

import java.util.ArrayList;

/**
 * @class FCFS
 * @brief Implementation of First-Come,First-Served scheduling algorithm.
 * @details It executes tasks one by one in the order of their arrival
 *  		in the ready queue, without preemption.
 */
public class FCFS implements Algorithm {

	/**
	 * @method schedule
	 * @brief Implementation of a FCFS scheduling algorithm.
	 */
	@Override
	public void schedule(ArrayList<Task> tasks) {
		
		System.out.println("\nScheduling with FCFS...");
		
		ArrayList<Task> tasksCopy = new ArrayList<>(tasks);
		SchedulingStatistics stats = new SchedulingStatistics(tasksCopy);
		
		while (!tasks.isEmpty()) {
			
            Task task = pickNextTask(tasks);
            if (task != null) {
             
            	task.setCurrentBurst(task.getRemainingBurst());
                stats.updateTaskTimes(task);
                CPU.run(task);    
                
            }
	    }
		
		stats.printTimestamp();
		stats.printStatistics();
	}

	/**
	 * @method pickNextTask
	 * @brief Selects the next task to be scheduled with FCFS algorithm.
	 */
	@Override
	public Task pickNextTask(ArrayList<Task> tasks) {
		
		if (tasks.isEmpty()) {
			return null; // No task available
		}
		
		return tasks.remove(0); // Pick the first task in the list
	}
	
	/**
     * @method toString Representation an algorithm as a string.
     * @return String representation of an algorithm.
     */
    @Override
    public String toString() {
        return "FCFS algorithm";
    }

}              
