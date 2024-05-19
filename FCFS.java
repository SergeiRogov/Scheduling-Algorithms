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
				System.out.println("\nScheduling with FCFS...");
		
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
	                
	        		System.out.println("Running Task [taskName=" + task.getTaskName() + ", priority=" + task.getPriority() + ", cpuBurst=" 
	                        + task.getCpuBurst() + ", Waiting Time=" + task.getWaitingTime() + ", Turnaround Time = " 
	                        + task.getTurnaroundTime() + ", Response Time = " + task.getResponseTime() + "]");
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
