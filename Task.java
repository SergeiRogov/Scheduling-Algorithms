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
    
    /**
     * @constructor Task To initialize a Task with the given name, priority, and CPU burst.
     * @param taskName The name of the task.
     * @param priority The priority of the task.
     * @param cpuBurst The CPU burst time of the task.
     */
    public Task(String taskName, int priority, int cpuBurst) {
    	setTaskName(taskName);
    	setPriority(priority);
    	setCpuBurst(cpuBurst);
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
    public void setTaskName(String taskName) {
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
    public void setPriority(int priority) {
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
    public void setCpuBurst(int cpuBurst) {
        this.cpuBurst = cpuBurst;
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
