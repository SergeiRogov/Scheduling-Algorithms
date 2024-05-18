/**
 * @file SchedulingAlgorithm.java
 * @brief This file contains the SchedulingAlgorithm enum.
 */
package scheduling_algorithms;

/**
 * @enum SchedulingAlgorithm
 * @brief Enum representing the available scheduling algorithms.
 */
public enum SchedulingAlgorithm {
    FCFS("First-come, first-served"),
    SJF("Shortest-job-first"),
    PRIORITY("Priority scheduling"),
    RR("Round-robin"),
    PRIORITY_RR("Priority with round-robin");

	/**
     * @brief A name of the scheduling algorithm.
     */
    private final String name;

    /**
     * @constructor SchedulingAlgorithm
     * @brief Constructor to initialize the enum with a name.
     * @param name A name of the scheduling algorithm.
     */
    SchedulingAlgorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * @method fromOrdinal
     * @brief Converts an ordinal to the corresponding SchedulingAlgorithm enum value.
     * @param ordinal The ordinal of the algorithm.
     * @return The corresponding SchedulingAlgorithm enum value.
     */
    public static SchedulingAlgorithm fromOrdinal(int ordinal) {
        if (ordinal >= 0 && ordinal < values().length) {
            return values()[ordinal];
        } else {
            throw new IllegalArgumentException("Invalid ordinal: " + ordinal);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
