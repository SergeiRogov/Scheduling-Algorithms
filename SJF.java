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
		
		int taskCounter = tasks.size();
		int responseTimeSum = 0;
		int waitingTimeSum = 0;
		int turnaroundTimeSum = 0;
		int currentTime = 0; // Current time in the CPU schedule
		
		while (!tasks.isEmpty()) {
	            Task task = pickNextTask(tasks);
	            if (task != null) {

	            	
	                CPU.run(task);
	                currentTime += task.getCpuBurst();

	                
	            }
	        }
		
		if (taskCounter > 0) {
	            System.out.println("\nAverage Waiting Time = " + Double.valueOf(waitingTimeSum / taskCounter) +
	                    ", Average Turnaround Time = " + Double.valueOf(turnaroundTimeSum / taskCounter) +
	                    ", Average Response Time = " + Double.valueOf(responseTimeSum / taskCounter));
		}
	
		System.out.println("Completed!");
		
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
			if (tasks.get(i).getCpuBurst() < smallestTask.getCpuBurst()) {
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
