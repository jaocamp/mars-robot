package gov.nasa.marsrobot.exception;

public class CommandDoesNotValidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CommandDoesNotValidException() {
        super();
    }

    public CommandDoesNotValidException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CommandDoesNotValidException(final String message) {
        super(message);
    }

    public CommandDoesNotValidException(final Throwable cause) {
        super(cause);
    }
}
