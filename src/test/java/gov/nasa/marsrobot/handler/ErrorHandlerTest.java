package gov.nasa.marsrobot.handler;

import gov.nasa.marsrobot.exception.CommandDoesNotValidException;
import gov.nasa.marsrobot.exception.PositionDoesNotValidException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ErrorHandlerTest {

    @Mock
    private Environment environment;

    private ErrorHandler errorHandler;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        errorHandler = new ErrorHandler();
        errorHandler.setEnv(environment);
    }

    @Test
    public void shouldHandleCommandDoesNotValidException() {
        String errorMessage = "Command not valid message";
        when(environment.getProperty("mars_robot.error.command_not_valid"))
                .thenReturn(errorMessage);

        ResponseEntity responseEntity = errorHandler.handler(new CommandDoesNotValidException());

        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(responseEntity.getBody(), errorMessage);
    }

    @Test
    public void shouldHandlePositionDoesNotValidException() {
        String errorMessage = "Position not valid message";
        when(environment.getProperty("mars_robot.error.position_not_valid"))
                .thenReturn(errorMessage);

        ResponseEntity responseEntity = errorHandler.handler(new PositionDoesNotValidException());

        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(responseEntity.getBody(), errorMessage);
    }

    @Test
    public void shouldHandleUnknownException() {
        String errorMessage = "Unknown error message";
        when(environment.getProperty("mars_robot.error.unknown"))
                .thenReturn(errorMessage);

        ResponseEntity responseEntity = errorHandler.handler(new Exception());

        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(responseEntity.getBody(), errorMessage);
    }


}