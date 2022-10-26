/**
 * Runtime Exception used by grep
 * @author Davin An
 * @version 1.0
 */
public class InvalidSearchStringException extends RuntimeException {

    /**
     * Constructor
     * @param message Message to print
     */
    public InvalidSearchStringException(String message) {
        super(message);
    }
}