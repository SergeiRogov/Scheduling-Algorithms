/**
 * @file SJF.java
 * @brief This file contains a class for Shortest-Job-First algorithm.
 */
package scheduling_algorithms;

import java.util.ArrayList;

/**
 * @class SJF
 * @brief Implementation of Shortest-Job-First scheduling algorithm.
 */
public class SJF implements Algorithm {

	/**
	 * @method schedule
	 * @brief Implementation of a SJF scheduling algorithm.
	 */
	@Override
	public void schedule(ArrayList<Task> tasks) {
		
		System.out.println("\nScheduling with SJF...");
		
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
	 * @brief Selects the next task to be scheduled with SJF algorithm.
	 */
	@Override
	public Task pickNextTask(ArrayList<Task> tasks) {
		
		if (tasks.isEmpty()) {
			return null;
		}
		
		Task smallestTask = tasks.get(0);

		for (int i=1; i<tasks.size(); i++) {
			if (tasks.get(i).getRemainingBurst() < smallestTask.getRemainingBurst()) {
				smallestTask = tasks.get(i);
			}
		}
		
		tasks.remove(smallestTask);
		
		return smallestTask;
		
	}
	
	/**
     * @method toString Representation an algorithm as a string.
     * @return String representation of an algorithm.
     */
    @Override
    public String toString() {
        return "SJF algorithm";
    }
}
