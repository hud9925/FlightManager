package Entities.User;

public class FlightNotFoundException extends Exception {
    /**
     * This exception is thrown iff the flight is not found.
     */
    public FlightNotFoundException(String message) {
        super(message);
    }
}
