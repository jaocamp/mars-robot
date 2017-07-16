package gov.nasa.marsrobot.service;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.exception.CommandDoesNotValidException;
import gov.nasa.marsrobot.exception.PositionDoesNotValidException;
import gov.nasa.marsrobot.factory.PositionFactory;
import gov.nasa.marsrobot.factory.RobotFactory;
import gov.nasa.marsrobot.model.Robot;
import gov.nasa.marsrobot.parse.ParseActions;
import gov.nasa.marsrobot.validator.PositionValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class RobotServiceTest {

    private RobotService robotService;

    @Mock
    private Environment environment;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockEnvironments();
        setRobotService();
    }

    @Test
    public void shouldMoveTo2x0ySouthOrientation() {
        Robot robot = robotService.goTo("MMRMMRMM");

        assertEquals("(2, 0, S)", robot.getPosition().toString());
    }

    @Test
    public void shouldMoveTo0x2yWestOrientation() {
        Robot robot = robotService.goTo("MML");

        assertEquals("(0, 2, W)", robot.getPosition().toString());
    }

    @Test
    public void shouldMoveTo2x2yNorthOrientation() {
        Robot robot = robotService.goTo("MMRMML");

        assertEquals("(2, 2, N)", robot.getPosition().toString());
    }

    @Test
    public void shouldMoveTo4x2yEastOrientation() {
        Robot robot = robotService.goTo("MMRMMMM");

        assertEquals("(4, 2, E)", robot.getPosition().toString());
    }

    @Test(expected = CommandDoesNotValidException.class)
    public void shouldValidateInvalidCommand() {
        robotService.goTo("AAA");
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void shouldValidateInvalidPosition() {
        robotService.goTo("MMMMMMMMMMM");
    }

    private void setRobotService() {
        robotService = new RobotService();
        robotService.setParseActions(new ParseActions());
        robotService.setPositionValidator(getPositionValidator());
        robotService.setRobotFactory(getRobotFactory());
    }

    private RobotFactory getRobotFactory() {
        RobotFactory robotFactory = new RobotFactory();
        robotFactory.setPositionFactory(getPositionFactory());
        return robotFactory;
    }

    private PositionFactory getPositionFactory() {
        PositionFactory positionFactory = new PositionFactory();
        positionFactory.setEnv(environment);
        return positionFactory;
    }

    private PositionValidator getPositionValidator() {
        PositionValidator positionValidator = new PositionValidator();
        positionValidator.setLandWidth(5);
        positionValidator.setLandHeight(5);
        return positionValidator;
    }

    private void mockEnvironments() {
        when(environment.getProperty("mars_robot.init_orientation", Orientation.class))
                .thenReturn(Orientation.NORTH);
        when(environment.getProperty("mars_robot.init_x", Integer.class))
                .thenReturn(0);
        when(environment.getProperty("mars_robot.init_y", Integer.class))
                .thenReturn(0);
    }
}