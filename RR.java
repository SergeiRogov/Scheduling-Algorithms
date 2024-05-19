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
		
		int taskCounter = tasks.size();
		int waitingTimeSum = 0;
		int turnaroundTimeSum = 0;
		int currentTime = 0; // Current time in the CPU schedule
		int currentTask = 0;
		
		int[] bursts = new int[tasks.size()];
		
		for (int i = 0; i < tasks.size(); i++) {
			bursts[i] = tasks.get(i).getCpuBurst();
		}
		
		while (!tasks.isEmpty()) {
	            Task task = pickNextTask(tasks);
	            if (task != null) {
	            	if (task.getCpuBurst() <= TIME_QUANTUM) {
	            		CPU.run(task);
	            		currentTime += task.getCpuBurst();
	            		task.setTurnaroundTime(currentTime-task.getArrivalTime());
	            		turnaroundTimeSum += task.getTurnaroundTime();
	            		
	            		// Waiting time = Turn Around Time - Burst time 
	            		task.setWaitingTime(task.getTurnaroundTime() - bursts[currentTask]);
	            		waitingTimeSum += task.getWaitingTime();
	            		currentTask++;
	            		
	                    System.out.println("Task " + task.getTaskName() + ": Waiting Time = " + task.getWaitingTime() +
	                            ", Turnaround Time = " + task.getTurnaroundTime());
	            	} else {
	            		CPU.run(new Task(task.getTaskName(), task.getPriority(), TIME_QUANTUM));
	            		currentTime += TIME_QUANTUM;
	            		task.setCpuBurst(task.getCpuBurst() - TIME_QUANTUM);
	            		tasks.add(task);
	            	}
	                
	            }
	        }
		
		if (taskCounter != 0) {
	            System.out.println("\nAverage Waiting Time = " + Double.valueOf(waitingTimeSum / taskCounter) +
	                    ", Average Turnaround Time = " + Double.valueOf(turnaroundTimeSum / taskCounter));
		}
		
		System.out.println("Completed!");
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
