package gov.nasa.marsrobot.exception;

public class PositionDoesNotValidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PositionDoesNotValidException() {
        super();
    }

    public PositionDoesNotValidException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PositionDoesNotValidException(final String message) {
        super(message);
    }

    public PositionDoesNotValidException(final Throwable cause) {
        super(cause);
    }
}
