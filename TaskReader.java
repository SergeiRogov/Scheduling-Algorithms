/**
 * @file TaskReader.java
 * @brief This file contains the TaskReader class.
 */
package scheduling_algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @class TaskReader
 * @brief Contains utility methods to read tasks from a file.
 */
public class TaskReader {

	/**
     * @method readTasks
     * @brief Reads in the schedule of tasks from a schedule.txt file 
     *        and inserts each task into a Java ArrayList.
     * @return ArrayList of tasks.
     */
    public static ArrayList<Task> readTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        String fileName = "schedule.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String taskName = parts[0];
                    int priority = Integer.parseInt(parts[1]);
                    int cpuBurst = Integer.parseInt(parts[2]);
                    Task task = new Task(taskName, priority, cpuBurst);
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return tasks;
    }
}
