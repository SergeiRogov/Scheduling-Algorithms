/**
 * @file RR.java
 * @brief This file contains a class for Round-Robin algorithm.
 */
package scheduling_algorithms;

import java.util.ArrayList;

/**
 * @class RR
 * @brief Implementation of Round-Robin scheduling algorithm.
 */
public class RR implements Algorithm {
	
	private static final int TIME_QUANTUM = 10;

	/**
	 * @method schedule
	 * @brief Implementation of a RR scheduling algorithm.
	 */
	@Override
	public void schedule(ArrayList<Task> tasks) {
		
		System.out.println("\nScheduling with RR...");
		
		ArrayList<Task> tasksCopy = new ArrayList<>(tasks);
		SchedulingStatistics stats = new SchedulingStatistics(tasksCopy);
		
		while (!tasks.isEmpty()) {
			
            Task task = pickNextTask(tasks);
            if (task != null) {
        
            	if (task.getRemainingBurst() <= TIME_QUANTUM) {

            		task.setCurrentBurst(task.getRemainingBurst());
            		stats.updateTaskTimes(task);
            		CPU.run(task);
    
            	} else {
            		       
                    task.setCurrentBurst(TIME_QUANTUM);
                    task.setRemainingBurst(task.getRemainingBurst() - TIME_QUANTUM);

                    stats.updateTaskTimes(task);
            		CPU.run(task);
            		
            		task.setQuantumArrivalTime(stats.getCurrentTime());
            		tasks.add(task);
            	}
            	
            	
            }
        }
		stats.printTimestamp();
		stats.printStatistics();
	}

	/**
	 * @method pickNextTask
	 * @brief Selects the next task to be scheduled with RR algorithm.
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
        return "RR algorithm";
    }

}
