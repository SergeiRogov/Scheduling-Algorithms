/**
 * @file FCFS.java
 * @brief This file contains a class for First-Come,First-Served algorithm.
 */
package scheduling_algorithms;

import java.util.ArrayList;

/**
 * @class FCFS
 * @brief Implementation of First-Come,First-Served scheduling algorithm.
 */
public class FCFS implements Algorithm {

	/**
	 * @method schedule
	 * @brief Implementation of a FCFS scheduling algorithm.
	 */
	@Override
	public void schedule(ArrayList<Task> tasks) {
		System.out.println("Scheduling with FCFS...");
		
		int tasksCount = tasks.size();
		
		SchedulingStatistics stats = new SchedulingStatistics(tasks);
        int currentTime = 0; // Current time in the CPU schedule
		
		while (!tasks.isEmpty()) {
            Task task = pickNextTask(tasks);
            if (task != null) {
            	boolean isFirstRun = task.getIsFirstRun();
            	
            	stats.updateTaskTimes(task, currentTime, isFirstRun);
	            	
                CPU.run(task);
                currentTime += task.getCpuBurst();     
                
                if (isFirstRun) {
        			task.setIsFirstRun(false);
        		}
            }
	    }
		
		if (tasksCount > 0) {
			stats.printAverages();
		}
		
		System.out.println("Completed!");
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
