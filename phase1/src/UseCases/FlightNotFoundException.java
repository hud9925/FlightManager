package UseCases;

/* A Use Case exception that arises when a non-existing flight (a flight that isn't
 * present in FlightTracker) is referenced. */

public class FlightNotFoundException extends Exception {

    /**
     * This exception is thrown if and only if the flight is not found.
     * @param message the exception message
     */
    public FlightNotFoundException(String message) {
        super(message);
    }
}
