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
	FCFS(new FCFS()),
    SJF(new SJF()),
    PRIORITY(new Priority()),
    RR(new RR()),
    PRIORITY_RR(new Priority_RR());

	/**
     * @brief Algorithm instance.
     */
	private final Algorithm algorithm;

    /**
     * @constructor SchedulingAlgorithm
     * @brief Constructor to initialize the algorithm
     * @param algorithm Scheduling algorithm.
     */
	SchedulingAlgorithm(final Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * @method getAlgorithm Gets the algorithm.
     * @return An instance of the algorithm.
     */
	public Algorithm getAlgorithm() {
        return algorithm;
    }
	
	/**
     * @method getName
     * @brief Gets the name of the scheduling algorithm.
     * @return The name of the scheduling algorithm.
     */
    public String getName() {
        return name();
    }

    /**
     * @method fromOrdinal
     * @brief Converts an ordinal to the corresponding SchedulingAlgorithm enum value.
     * @param ordinal The ordinal of the algorithm.
     * @return The corresponding SchedulingAlgorithm enum value.
     */
    public static SchedulingAlgorithm fromOrdinal(final int ordinal) {
        if (ordinal >= 0 && ordinal < values().length) {
            return values()[ordinal];
        } else {
            throw new IllegalArgumentException("Invalid ordinal: " + ordinal);
        }
    }
    
    /**
     * @method toString Representation an algorithm as a string.
     * @return String representation of an algorithm.
     */
    @Override
    public String toString() {
        return name();
    }

}
