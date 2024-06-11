package scheduling_algorithms;

import java.util.ArrayList;

class SchedulingStatistics {
	
    private int responseTimeSum;
    private int waitingTimeSum;
    private int turnaroundTimeSum;
    private int tasksCount;
    
    public SchedulingStatistics(final ArrayList<Task> tasks) {
    	this.tasksCount = tasks.size();
    	System.out.println("------------------------------" + 0 + "------------------------------");
    }

    public void updateTaskTimes(final Task task, final int currentTime, final boolean isFirstRun) {
    	
    	if (isFirstRun) {
            task.setResponseTime(currentTime - task.getOriginalArrivalTime());
        }
    	
    	task.setQuantumWaitingTime(currentTime - task.getQuantumArrivalTime());
        task.setTotalWaitingTime(task.getTotalWaitingTime() + task.getQuantumWaitingTime());
        
        task.setTurnaroundTime(currentTime + task.getCpuBurst() - task.getOriginalArrivalTime());
        
        System.out.println("------------------------------" + currentTime + "------------------------------");
        
    }
    
    public void printAverages() {
        if (tasksCount > 0) {
            System.out.println("\nAverage Waiting Time = " + (double) waitingTimeSum / tasksCount +
                    "\nAverage Turnaround Time = " + (double) turnaroundTimeSum / tasksCount +
                    "\nAverage Response Time = " + (double) responseTimeSum / tasksCount);
        }
    }
}
