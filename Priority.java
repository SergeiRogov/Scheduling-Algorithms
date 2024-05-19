/**
 * @file Priority.java
 * @brief This file contains a class for Priority algorithm.
 */
package scheduling_algorithms;

import java.util.ArrayList;

/**
 * @class SJF
 * @brief Implementation of Priority scheduling algorithm.
 */
public class Priority implements Algorithm {

	/**
	 * @method schedule
	 * @brief Implementation of a Priority scheduling algorithm.
	 */
	@Override
	public void schedule(ArrayList<Task> tasks) {
		System.out.println("\nScheduling with Priority...");
		
		int taskCounter = tasks.size();
		int responseTimeSum = 0;
		int waitingTimeSum = 0;
		int turnaroundTimeSum = 0;
		int currentTime = 0; // Current time in the CPU schedule
		
		while (!tasks.isEmpty()) {
	            Task task = pickNextTask(tasks);
	            if (task != null) {
	            	task.setWaitingTime(currentTime - task.getArrivalTime());
	            	
	            	if (task.getResponseTime() == 0) {
	                    task.setResponseTime(currentTime - task.getArrivalTime());
	                }
	            	
	            	
	                CPU.run(task);
	                currentTime += task.getCpuBurst();
	                
	                
	                task.setTurnaroundTime(currentTime-task.getArrivalTime());
	                
	        		responseTimeSum += task.getResponseTime();
	        		waitingTimeSum += task.getWaitingTime();
	        		turnaroundTimeSum += task.getTurnaroundTime();
	                
	                System.out.println("Task " + task.getTaskName() + ": Waiting Time = " + task.getWaitingTime() +
	                        ", Turnaround Time = " + task.getTurnaroundTime() +
	                        ", Response Time = " + task.getResponseTime());
	            }
	        }
		
		if (taskCounter != 0) {
	            System.out.println("\nAverage Waiting Time = " + Double.valueOf(waitingTimeSum / taskCounter) +
	                    ", Average Turnaround Time = " + Double.valueOf(turnaroundTimeSum / taskCounter) +
	                    ", Average Response Time = " + Double.valueOf(responseTimeSum / taskCounter));
		}
		
		System.out.println("Completed!");
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
