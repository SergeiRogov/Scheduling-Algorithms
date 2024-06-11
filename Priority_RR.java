/**
 * @file Priority_RR.java
 * @brief This file contains a class for Priority with Round-Robin algorithm.
 */
package scheduling_algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @class Priority_RR
 * @brief Implementation of Priority with Round-Robin scheduling algorithm.
 */
public class Priority_RR implements Algorithm {
	
	// Time quantum for round-robin scheduling
	private static final int TIME_QUANTUM = 10;
	
	// Map to store priority queues of tasks
	private Map<Integer, Queue<Task>> priorityQueueMap = new HashMap<>();
	
	// Map to store the original sizes of queues for each priority
	private Map<Integer, Integer> originalQueueSizes = new HashMap<>();
	
	// Current priority being processed
    private int currentPriority;

	/**
	 * @method schedule
	 * @brief Implementation of a Priority_RR scheduling algorithm.
	 */
	@Override
	public void schedule(ArrayList<Task> tasks) {
		
		System.out.println("\nScheduling with Priority_RR...");
		
		groupTasksByPriority(tasks);
		
		ArrayList<Task> tasksCopy = new ArrayList<>(tasks);
		SchedulingStatistics stats = new SchedulingStatistics(tasksCopy);
		
		while (!priorityQueueMap.isEmpty()) {
	
            Task task = pickNextTask(tasks); 
            if (task != null) {
            	
            	boolean isFirstRun = task.getIsFirstRun();
            	
            	if (task.getCpuBurst() <= TIME_QUANTUM || originalQueueSizes.get(task.getPriority()) <= 1) {
            		
            		stats.updateTaskTimes(task, isFirstRun);
            		CPU.run(task);
          		
            	} else {
            		
            		int remainingCPUburst = task.getCpuBurst() - TIME_QUANTUM;
                    task.setCpuBurst(TIME_QUANTUM);

            		stats.updateTaskTimes(task, isFirstRun);
            		CPU.run(task);
            		
            		task.setCpuBurst(remainingCPUburst);
            		task.setQuantumArrivalTime(stats.getCurrentTime());
            		
                    // Re-add the task to the end of the appropriate priority queue
                    priorityQueueMap.get(task.getPriority()).add(task);
            	} 
            	
            	if (isFirstRun) {
        			task.setIsFirstRun(false);
        		}
            }
        }
		stats.printTimestamp();
		stats.printStatistics();
	}

	/**
	 * @method pickNextTask
	 * @brief Selects the next task to be scheduled with Priority_RR algorithm.
	 * @param tasks List of tasks to be scheduled.
     * @return The next task to be scheduled.
	 */
	@Override
	public Task pickNextTask(ArrayList<Task> tasks) {
        if (priorityQueueMap.isEmpty()) {
            return null;
        }

        // Get the queue for the current highest priority
        Queue<Task> queue = priorityQueueMap.get(currentPriority);

        // If the current queue is empty, find the next highest priority with tasks
        while (queue.isEmpty()) {
            priorityQueueMap.remove(currentPriority);
            if (priorityQueueMap.isEmpty()) {
                return null;
            }
            currentPriority = findHighestPriority();
            queue = priorityQueueMap.get(currentPriority);
        }

        // Return the next task from the current priority queue
        return queue.poll();
    }
	
	/**
     * @method groupTasksByPriority
     * @brief Groups tasks by priority and initializes original queue sizes.
     * @param tasks List of tasks to be scheduled.
     */
	private void groupTasksByPriority(ArrayList<Task> tasks) {
	        for (Task task : tasks) {
	            if (!priorityQueueMap.containsKey(task.getPriority())) {
	                priorityQueueMap.put(task.getPriority(), new LinkedList<>());
	                originalQueueSizes.put(task.getPriority(), 0);
	            }
	            priorityQueueMap.get(task.getPriority()).add(task);
	            originalQueueSizes.put(task.getPriority(), originalQueueSizes.get(task.getPriority()) + 1);
	        }
	       
	        currentPriority = findHighestPriority();
			
	}
	
	/**
     * @method findHighestPriority
     * @brief Finds the highest priority among the existing priority queues.
     * @return The highest priority.
     */
	private int findHighestPriority() {
		int highestPriority = 1;
        for (int priority : priorityQueueMap.keySet()) {
            if (priority > highestPriority) {
            	highestPriority = priority;
            }
        }
        return highestPriority;
        
    }
	
	/**
     * @method 
     * @brief toString Representation an algorithm as a string.
     * @return String representation of an algorithm.
     */
    @Override
    public String toString() {
        return "Priority_RR algorithm";
    }

}
