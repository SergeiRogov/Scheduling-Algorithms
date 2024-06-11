/**
 * @file Task.java
 * @brief This file contains a Task Class.
 */
package scheduling_algorithms;

/**
 * @class Task
 * @brief A task to be scheduled.
 * 		  Has the form [task name] [priority] [CPU burst]
 * 		  And additional fields [original arrival time] 
 * 								[quantum arrival time]
 *           					[total waiting time] 
 *           					[quantum waiting time] 
 *       					    [response time] 
 *       						[turnaround time]
 *      						[isFirstRun]
 */
public class Task {
	
	private String taskName;
    private int priority;
    private int cpuBurst;
    
    final private int originalArrivalTime; 
    private int quantumArrivalTime; 
    
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
    	
    	setTaskName(taskName);
    	setPriority(priority);
    	setCpuBurst(cpuBurst);

    	originalArrivalTime = 0;
    	setQuantumArrivalTime(0);
    	
    	setTotalWaitingTime(0);
    	setQuantumWaitingTime(0);
    	
    	setTurnaroundTime(0);
		setResponseTime(0); 
		
		setIsFirstRun(true);	
    }
    
    /**
     * @method getTaskName Gets the name of the task.
     * @return The name of the task.
     */
    public String getTaskName() {
        return taskName;
    }
    
    /**
     * @method setTaskName Sets the name of the task.
     * @param taskName The name of the task.
     */
    public void setTaskName(final String taskName) {
        this.taskName = taskName;
    }

    /**
     * @method getPriority Gets the priority of the task.
     * @return The priority of the task.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @method setPriority Sets the priority of the task.
     * @param priority The priority of the task.
     */
    public void setPriority(final int priority) {
        this.priority = priority;
    }

    /**
     * @method getCpuBurst Gets the CPU burst time of the task.
     * @return The CPU burst time of the task.
     */
    public int getCpuBurst() {
        return cpuBurst;
    }

    /**
     * @method setCpuBurst Sets the CPU burst time of the task.
     * @param cpuBurst The CPU burst time of the task.
     */
    public void setCpuBurst(final int cpuBurst) {
        this.cpuBurst = cpuBurst;
    }

    /**
     * @method getArrivalTime Gets the arrival time of the task.
     * @return The arrival time of the task.
     */
    public int getOriginalArrivalTime() {
        return originalArrivalTime;
    }
    
    /**
     * @method getArrivalTime Gets the arrival time of the task.
     * @return The arrival time of the task.
     */
    public int getQuantumArrivalTime() {
        return quantumArrivalTime;
    }

    /**
     * @method setArrivalTime Sets the arrival time of the task.
     * @param arrivalTime The arrival time of the task.
     */
    public void setQuantumArrivalTime(final int arrivalTime) {
        this.quantumArrivalTime = arrivalTime;
    }

    /**
     * @method getWaitingTime Gets the waiting time of the task.
     * @return The waiting time of the task.
     */
    public int getTotalWaitingTime() {
        return totalWaitingTime;
    }

    /**
     * @method setWaitingTime Sets the waiting time of the task.
     * @param waitingTime The waiting time of the task.
     */
    public void setTotalWaitingTime(final int waitingTime) {
        this.totalWaitingTime = waitingTime;
    }
    
    public int getQuantumWaitingTime() {
        return quantumWaitingTime;
    }

    /**
     * @method setWaitingTime Sets the waiting time of the task.
     * @param waitingTime The waiting time of the task.
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
     * @method getArrivalTime Gets the arrival time of the task.
     * @return The arrival time of the task.
     */
    public int getResponseTime() {
        return responseTime;
    }

    /**
     * @method setArrivalTime Sets the arrival time of the task.
     * @param arrivalTime The arrival time of the task.
     */
    public void setResponseTime(final int responseTime) {
        this.responseTime = responseTime;
    }
    
    public boolean getIsFirstRun() {
        return isFirstRun;
    }

    public void setIsFirstRun(final boolean isFirstRun) {
        this.isFirstRun = isFirstRun;
    }

    /**
     * @method toString Representation a task as a string.
     * @return String representation of a task.
     */
    @Override
    public String toString() {
        return "\nTask [taskName=" + this.taskName 
        		+ ", priority=" + this.priority 
        		+ ", cpuBurst=" + this.cpuBurst + "]";
    }
    
    /**
     * @method toStringRunning Representation a running task as a string.
     * @return String representation of a running task.
     */
    public String toStringRunning() {
        return "Running Task [taskName=" + getTaskName() 
        		+ ", priority=" + getPriority() 
        		+ ", cpuBurst=" + getCpuBurst() 
                + ", Waiting=" + getQuantumWaitingTime() + "]";
    }
    
    
    public String toStringStats() {
        return "Task [taskName=" + getTaskName() 
                + ", Waiting=" + getTotalWaitingTime() 
                + ", Response=" + getResponseTime()
                + ", Turnaround=" + getTurnaroundTime() + "]";
    }
}
