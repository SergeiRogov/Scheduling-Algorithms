package scheduling_algorithms;

import java.util.ArrayList;

class SchedulingStatistics {

    private final ArrayList<Task> tasksCopy;
    private int currentTime;
    
    public SchedulingStatistics(final ArrayList<Task> tasksCopy) {
    	this.tasksCopy = tasksCopy;
    	this.currentTime = 0;
    }

    public void updateTaskTimes(final Task task) {
    	
    	printTimestamp(); 
    	
    	if (task.getIsFirstRun()) {
            task.setResponseTime(currentTime - task.getOriginalArrivalTime());
            task.setIsFirstRun(false);
        }
    	
    	task.setQuantumWaitingTime(currentTime - task.getQuantumArrivalTime());
        task.setTotalWaitingTime(task.getTotalWaitingTime() + task.getQuantumWaitingTime());
        
        currentTime += task.getCurrentBurst();
        
        task.setTurnaroundTime(currentTime - task.getOriginalArrivalTime());

    }
    
    public int getCurrentTime() {
        return this.currentTime;
    }
    
    public void printTimestamp() {
    	System.out.println("------------------------------" + currentTime + "------------------------------");
    }
    
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
    
    public String toStringAverages() {
    	
    	int tasksCount = tasksCopy.size();

        if (tasksCount < 1) {
        	return "No tasks were provided";
        } 
        
        int responseTimeSum = 0;
        int waitingTimeSum = 0;
        int turnaroundTimeSum = 0;
       
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
