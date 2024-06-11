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
		int tasksCount = tasks.size();
		
		ArrayList<Task> tasksCopy = new ArrayList<>(tasks);
		
		SchedulingStatistics stats = new SchedulingStatistics(tasks);
        int currentTime = 0; // Current time in the CPU schedule
		
		while (!tasks.isEmpty()) {
			
            Task task = pickNextTask(tasks);
   
            if (task != null) {
            	
            	boolean isFirstRun = task.getIsFirstRun();
 
            	if (task.getCpuBurst() <= TIME_QUANTUM) {
            		
            		stats.updateTaskTimes(task, currentTime, isFirstRun);

            		CPU.run(task);
            		currentTime += task.getCpuBurst();
            		
            	} else {
            		       
                    int remainingCPUburst = task.getCpuBurst() - TIME_QUANTUM;
                    task.setCpuBurst(TIME_QUANTUM);
                    
                    stats.updateTaskTimes(task, currentTime, isFirstRun);
                    
                    
            		CPU.run(task);
            		currentTime += TIME_QUANTUM;
            		
            		task.setCpuBurst(remainingCPUburst);
            		task.setQuantumArrivalTime(currentTime);
            		
            		tasks.add(task);
            	}
            	
            	if (isFirstRun) {
        			task.setIsFirstRun(false);
        		}
            }
        }
		
		if (tasksCount > 0) {
			for (Task task : tasksCopy) {
				System.out.println(task.toStringStats());
	        }
			stats.printAverages();
		}
		
		System.out.println("\nCompleted!");
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
		
		return tasks.remove(0);
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
