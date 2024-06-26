/**
 * @file Priority.java
 * @brief This file contains a class for Priority algorithm.
 */
package scheduling_algorithms;

import java.util.ArrayList;

/**
 * @class SJF
 * @brief Implementation of Priority scheduling algorithm.
 * @detail Executes tasks in order of their priority (top-priority tasks first).
 *		 
 */
public class Priority implements Algorithm {

	/**
	 * @method schedule
	 * @brief Implementation of a Priority scheduling algorithm.
	 */
	@Override
	public void schedule(ArrayList<Task> tasks) {
		
		System.out.println("\nScheduling with Priority...");

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
	 * @brief Selects the next task to be scheduled with Priority algorithm.
	 */
	@Override
	public Task pickNextTask(ArrayList<Task> tasks) {
		
		if (tasks.isEmpty()) {
			return null;
		}
		
		Task topPriorityTask = tasks.get(0);

		for (int i=1; i<tasks.size(); i++) {
			if (tasks.get(i).getPriority() > topPriorityTask.getPriority()) {
				topPriorityTask = tasks.get(i);
			}
		}
		
		tasks.remove(topPriorityTask);
		
		return topPriorityTask;
	}
	
	/**
     * @method toString Representation an algorithm as a string.
     * @return String representation of an algorithm.
     */
    @Override
    public String toString() {
        return "Priority algorithm";
    }

}
