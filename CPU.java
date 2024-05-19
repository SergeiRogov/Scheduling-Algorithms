/**
 * @file CPU.java
 * @brief This file contains the CPU class.
 */
package scheduling_algorithms;

/**
 * @class CPU
 * @brief Simulates the execution of tasks.
 */
public class CPU {

    /**
     * @method run
     * @brief Simulates running a task on the CPU.
     * @param task The task to run.
     */
    public static void run(Task task) {
        System.out.println("Running task: " + task);
        // Simulate task execution with a sleep (just for demonstration purposes)
        try {
            Thread.sleep(task.getCpuBurst() * 50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
