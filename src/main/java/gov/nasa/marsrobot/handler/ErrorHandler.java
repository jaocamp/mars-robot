package gov.nasa.marsrobot.handler;

import gov.nasa.marsrobot.controller.RobotController;
import gov.nasa.marsrobot.exception.CommandDoesNotValidException;
import gov.nasa.marsrobot.exception.PositionDoesNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandler {

    private Logger logger = LoggerFactory.getLogger(RobotController.class);

    private Environment env;

    public ResponseEntity<?> handler(Exception exception) {

        if (exception instanceof CommandDoesNotValidException) {
            logger.error("Command does not valid.");
            String message = env.getProperty("mars_robot.error.command_not_valid");

            return ResponseEntity.badRequest().body(message);
        } else if (exception instanceof PositionDoesNotValidException) {
            logger.error("Position does not valid.");
            String message = env.getProperty("mars_robot.error.position_not_valid");

            return ResponseEntity.badRequest().body(message);
        } else {
            logger.error("Unexpected error occurred.", exception);
            String message = env.getProperty("mars_robot.error.unknown");

            return ResponseEntity.badRequest().body(message);
        }
    }

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }
}
