package gov.nasa.marsrobot.service;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.exception.CommandDoesNotValidException;
import gov.nasa.marsrobot.exception.PositionDoesNotValidException;
import gov.nasa.marsrobot.model.Position;
import gov.nasa.marsrobot.model.Robot;
import gov.nasa.marsrobot.parse.ParseActions;
import gov.nasa.marsrobot.validator.PositionValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import static org.junit.Assert.assertEquals;


public class RobotServiceTest {

    private RobotService robotService;

    @Mock
    private Environment environment;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        PositionValidator positionValidator = new PositionValidator();
        positionValidator.setLandWidth(5);
        positionValidator.setLandHeight(5);

        robotService = new RobotService();
        robotService.setParseActions(new ParseActions());
        robotService.setPositionValidator(positionValidator);
    }

    @Test
    public void shouldMoveTo2x0ySouthOrientation() {
        robotService.setRobot(createRobot());
        Robot robot = robotService.goTo("MMRMMRMM");

        assertEquals("(2, 0, S)", robot.getPosition().toString());
    }

    @Test
    public void shouldMoveTo0x2yWestOrientation() {
        robotService.setRobot(createRobot());
        Robot robot = robotService.goTo("MML");

        assertEquals("(0, 2, W)", robot.getPosition().toString());
    }

    @Test
    public void shouldMoveTo2x2yNorthOrientation() {
        robotService.setRobot(createRobot());
        Robot robot = robotService.goTo("MMRMML");

        assertEquals("(2, 2, N)", robot.getPosition().toString());
    }

    @Test
    public void shouldMoveTo4x2yEastOrientation() {
        robotService.setRobot(createRobot());
        Robot robot = robotService.goTo("MMRMMMM");

        assertEquals("(4, 2, E)", robot.getPosition().toString());
    }

    @Test(expected = CommandDoesNotValidException.class)
    public void shouldValidateInvalidCommand() {
        robotService.setRobot(createRobot());
        robotService.goTo("AAA");
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void shouldValidateInvalidPosition() {
        robotService.setRobot(createRobot());
        robotService.goTo("MMMMMMMMMMM");
    }

    private Robot createRobot() {
        return new Robot("Bit", createPosition());
    }

    private Position createPosition() {
        return new Position(0, 0, Orientation.NORTH);
    }

}