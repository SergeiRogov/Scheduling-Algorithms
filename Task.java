/**
 * @file Task.java
 * @brief This file contains a Task Class.
 */
package scheduling_algorithms;

/**
 * @class Task
 * @brief A task to be scheduled.
 * 		  Has the form [task name] [priority] [CPU burst]
 */
public class Task {
	
	private String taskName;
    private int priority;
    private int cpuBurst;
    private int arrivalTime; 
    private int waitingTime; 
    private int responseTime; 
    private int turnaroundTime; 
    
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
    	setWaitingTime(0);
		setArrivalTime(0);
		setResponseTime(0);
		setTurnaroundTime(0);
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
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @method setArrivalTime Sets the arrival time of the task.
     * @param arrivalTime The arrival time of the task.
     */
    public void setArrivalTime(final int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @method getWaitingTime Gets the waiting time of the task.
     * @return The waiting time of the task.
     */
    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * @method setWaitingTime Sets the waiting time of the task.
     * @param waitingTime The waiting time of the task.
     */
    public void setWaitingTime(final int waitingTime) {
        this.waitingTime = waitingTime;
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


    /**
     * @method toString Representation a task as a string.
     * @return String representation of a task.
     */
    @Override
    public String toString() {
        return "\nTask [taskName=" + this.taskName + ", priority=" + this.priority + ", cpuBurst=" + this.cpuBurst + "]";
    }
}
