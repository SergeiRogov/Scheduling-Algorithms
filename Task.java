/**
 * @file Task.java
 * @brief This file contains a Task Class.
 */
package scheduling_algorithms;

/**
 * @class Task
 * @brief A task to be scheduled.
 * 
 * @details Has the form [task name]             - task nickname (final)
 * 						 [priority]              - 1-10, 10 is top-priority (final)
 * 						 [original CPU burst]    - initial total CPU burst time (final)
 * 
 * And additional fields [original arrival time] - initial arrival time (final)
 * 						 [quantum arrival time]  - last arrival in a ready queue (changes)
 * 						 [remaining CPU burst]   - remaining time for a task to be fully executed
 *           		     [current CPU burst]     - CPU will run a task for this time in a current run (changes)
 *           			 [total waiting time]    - cumulative waiting time of a task 
 *           			 [quantum waiting time]  - waiting time between last arrival in a ready queue and start of a current run
 *       			     [response time]         - time between initial arrival in a ready queue and start of the first run
 *       				 [turnaround time]       - time between initial arrival in a ready queue and full completion of a task
 *      				 [isFirstRun]            - boolean to indicate if a current run of a task is a first one or not
 */
public class Task {
	
	final private String taskName;
    final private int priority;
    final private int originalCpuBurst;
    
    final private int originalArrivalTime; 
    private int quantumArrivalTime; 
    
    private int remainingBurst;
    private int currentBurst;
  
    private int totalWaitingTime; 
    private int quantumWaitingTime;
    
    private int responseTime; 
    private int turnaroundTime; 
    
    private boolean isFirstRun; 
    
    /**
     * @constructor Task To initialize a Task with the given name, priority, and CPU burst.
     * @param taskName The name of the task.
     * @param priority The priority of the task.
     * @param cpuBurst The CPU burst time of the task.
     */
    public Task(final String taskName, final int priority, final int cpuBurst) {
    	
    	this.taskName = taskName;
    	this.priority = priority;
    	this.originalCpuBurst = cpuBurst;
    	
    	this.originalArrivalTime = 0;
    	setQuantumArrivalTime(0);
    	
    	setRemainingBurst(cpuBurst);
    	setCurrentBurst(0);
    	
    	setTotalWaitingTime(0);
    	setQuantumWaitingTime(0);
    	
    	setResponseTime(0);
    	setTurnaroundTime(0);

		setIsFirstRun(true); // initially it's a first run
    }
    
    /**
     * @method getTaskName Gets the name of the task.
     * @return The name of the task.
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @method getPriority Gets the priority of the task.
     * @return The priority of the task.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @method getOriginalCpuBurst Gets the original CPU burst time of the task.
     * @return The initial CPU burst time of the task.
     */
    public int getOriginalCpuBurst() {
        return originalCpuBurst;
    }
    
    /**
     * @method getOriginalArrivalTime Gets the original arrival time of the task.
     * @return The initial arrival time of the task.
     */
    public int getOriginalArrivalTime() {
        return originalArrivalTime;
    }
    
    /**
     * @method getQuantumArrivalTime Gets the time of last arrival in the ready queue.
     * @return The time of last arrival in the ready queue.
     */
    public int getQuantumArrivalTime() {
        return quantumArrivalTime;
    }

    /**
     * @method setQuantumArrivalTime Sets the time of last arrival in the ready queue.
     * @param arrivalTime The time of last arrival in the ready queue.
     */
    public void setQuantumArrivalTime(final int arrivalTime) {
        this.quantumArrivalTime = arrivalTime;
    }
    
    /**
     * @method getRemainingBurst Gets the remaining execution time of a task.
     * @return The remaining burst time.
     */
    public int getRemainingBurst() {
        return remainingBurst;
    }

    /**
     * @method setRemainingBurst Sets the remaining CPU burst time of the task.
     * @param cpuBurst The remaining CPU burst time of the task (it decreases with the work of scheduling algorithms).
     */
    public void setRemainingBurst(final int cpuBurst) {
        this.remainingBurst = cpuBurst;
    }
    
    /**
     * @method getCurrentBurst Gets the current CPU burst - the time a task is executed in a current run.
     * @return The current CPU burst time of the task.
     */
    public int getCurrentBurst() {
        return currentBurst;
    }

    /**
     * @method setCurrentBurst Sets the current CPU burst time of the task.
     * @param cpuBurst The current CPU burst time of the task.
     */
    public void setCurrentBurst(final int cpuBurst) {
        this.currentBurst = cpuBurst;
    }

    /**
     * @method getTotalWaitingTime Gets the cumulative waiting time of the task.
     * @return The cumulative waiting time of the task.
     */
    public int getTotalWaitingTime() {
        return totalWaitingTime;
    }

    /**
     * @method setTotalWaitingTime Sets the cumulative waiting time of the task.
     * @param waitingTime The cumulative waiting time of the task.
     */
    public void setTotalWaitingTime(final int waitingTime) {
        this.totalWaitingTime = waitingTime;
    }
    
    /**
     * @method getQuantumWaitingTime Gets the waiting time between 
     * the last arrival in a ready queue and start of a current run.
     * @return The current "quantum" waiting time of the task.
     */
    public int getQuantumWaitingTime() {
        return quantumWaitingTime;
    }

    /**
     * @method setWaitingTime Sets the waiting time between 
     * the last arrival in a ready queue and start of a current run.
     * @param waitingTime The current "quantum" waiting time of the task.
     */
    public void setQuantumWaitingTime(final int waitingTime) {
        this.quantumWaitingTime = waitingTime;
    }

    /**
     * @method getTurnaroundTime Gets the turnaround time of the task.
     * @return The turnaround time of the task.
     */
    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    /**
     * @method setTurnaroundTime Sets the turnaround time of the task.
     * @param turnaroundTime The turnaround time of the task.
     */
    public void setTurnaroundTime(final int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    /**
     * @method getResponseTime Gets the response time of the task.
     * @return The response time of the task.
     */
    public int getResponseTime() {
        return responseTime;
    }

    /**
     * @method setResponseTime Sets the response time of the task.
     * @param responseTime The response time of the task.
     */
    public void setResponseTime(final int responseTime) {
        this.responseTime = responseTime;
    }
    
    /**
     * @method getIsFirstRun Gets the indicator (is a current run of a task is a first one).
     * @return The boolean indicator of the first/not first run.
     */
    public boolean getIsFirstRun() {
        return isFirstRun;
    }

    /**
     * @method setIsFirstRun Sets the indicator (is a current run of a task is a first one).
     * @param isFirstRun The boolean indicator of the first/not first run.
     */
    public void setIsFirstRun(final boolean isFirstRun) {
        this.isFirstRun = isFirstRun;
    }

    /**
     * @method toString Representation a task as a string with base initial characteristics.
     * @return String representation of a task.
     */
    @Override
    public String toString() {
        return "\nTask [taskName=" + getTaskName() 
        		+ ", priority=" + getPriority() 
        		+ ", cpuBurst=" + getOriginalCpuBurst() + "]";
    }
    
    /**
     * @method toStringRunning Representation a running task as a string with 
     * current CPU burst (CPU will run a task for this time in a current run)
     * and current waiting time (between last arrival in a ready queue and start of a current run)
     * @return String representation of a running task with current characteristics.
     */
    public String toStringRunning() {
        return "Running Task [taskName=" + getTaskName() 
        		+ ", priority=" + getPriority() 
        		+ ", cpuBurst=" + getCurrentBurst() 
                + ", Waiting=" + getQuantumWaitingTime() + "]";
    }
    
    /**
     * @method toStringStats Representation a task as a string after the work of scheduling algorithm 
     * Includes total waiting time, response time and turnaround time of a task.
     * @return String representation of a task with time statistics.
     */
    public String toStringStats() {
        return "Task [taskName=" + getTaskName() 
                + ", Waiting=" + getTotalWaitingTime() 
                + ", Response=" + getResponseTime()
                + ", Turnaround=" + getTurnaroundTime() + "]";
    }
}
