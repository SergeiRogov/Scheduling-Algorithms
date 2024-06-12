/**
 * @file SchedulingStatistics.java
 * @brief This file contains the SchedulingStatistics class.
 */
package scheduling_algorithms;

import java.util.ArrayList;

/**
 * @class SchedulingStatistics
 * @brief A class for calculating and collecting time statistics
 * 		  of tasks during the execution of scheduling algorithms.
 */
class SchedulingStatistics {

    private final ArrayList<Task> tasksCopy; // copy of initial tasks
    private int currentTime; // represents current "live" time
    
    /**
     * @constructor SchedulingStatistics To initialize an instance for collecting statistics.
     * @param tasksCopy The name of the task.
     */
    public SchedulingStatistics(final ArrayList<Task> tasksCopy) {
    	this.tasksCopy = tasksCopy; // copy of initial tasks
    	this.currentTime = 0; // initialize live time to be 0 (starting point of an algorithm)
    }

    /**
     * @method updateTaskTimes Makes changes to the time statistics of a task.
     * @param task The task currently executed. Its time statistics are changed here.
     */
    public void updateTaskTimes(final Task task) {
    	
    	printTimestamp(); 
    	
    	// response time is only relevant to the first execution of a task
    	if (task.getIsFirstRun()) {
    		
    		// response = first start - arrival
            task.setResponseTime(currentTime - task.getOriginalArrivalTime()); 
            
            // now the task is no longer on its first run
            task.setIsFirstRun(false); 
        }
    	
    	// waiting = start - arrival in the ready queue
    	task.setQuantumWaitingTime(currentTime - task.getQuantumArrivalTime());
    	
    	// cumulate total waiting time of a task
        task.setTotalWaitingTime(task.getTotalWaitingTime() + task.getQuantumWaitingTime());
        
        // live time increment
        currentTime += task.getCurrentBurst(); 
        
        // turnaround time gets updated every time a task runs. 
        // only last change makes a correct statistic
        // turnaround = finish - arrival
        task.setTurnaroundTime(currentTime - task.getOriginalArrivalTime());

    }
 
    /**
     * @method printTimestamp Prints a current "live" time in an algorithm execution.
     */
    public void printTimestamp() {
    	System.out.println("------------------------------" + currentTime + "------------------------------");
    }
    
    /**
     * @method getCurrentTime Gets the current "live" time.
     * @return The current "live" time.
     */
    public int getCurrentTime() {
        return this.currentTime;
    }
    
    /**
     * @method printStatistics Displays algorithm's time statistics after its execution.
     * @brief Prints waiting time, turnaround time, and response time of each task, 
     * 		  as well as the averages of those metrics.
     */
    public void printStatistics() {
    	System.out.println("\nCompleted!");
    	
    	if (tasksCopy.size() < 1) {
    		System.out.println("No tasks were provided");
        	return;
        } 
		
		System.out.println("\nTasks statistics:\n");
		for (Task task : tasksCopy) {
			System.out.println(task.toStringStats());
        }
		
		System.out.println(toStringAverages());
    }
    
    /**
     * @method toStringAverages Computes average statistics.
     * @brief Calculates average waiting time, turnaround time, and response time.
     * @return A string representing average statistics.
     */
    public String toStringAverages() {
    	
    	int tasksCount = tasksCopy.size();

        if (tasksCount < 1) {
        	return "No tasks were provided";
        } 
        
        int responseTimeSum = 0;
        int waitingTimeSum = 0;
        int turnaroundTimeSum = 0;
       
        // accumulate sums
        for (Task task : tasksCopy) {
        	responseTimeSum += task.getResponseTime();
        	waitingTimeSum += task.getTotalWaitingTime();
        	turnaroundTimeSum += task.getTurnaroundTime();
    	}
        
        return "\nAverage Waiting Time = " + waitingTimeSum * 1.0 / tasksCount +
                "\nAverage Turnaround Time = " + turnaroundTimeSum * 1.0 / tasksCount +
                "\nAverage Response Time = " + responseTimeSum * 1.0 / tasksCount;
    }
}
