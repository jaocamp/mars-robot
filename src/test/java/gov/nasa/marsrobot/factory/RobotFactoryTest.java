package gov.nasa.marsrobot.factory;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.model.Robot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class RobotFactoryTest {

    @Mock
    private Environment environment;

    private RobotFactory robotFactory;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        PositionFactory positionFactory = new PositionFactory();
        positionFactory.setEnv(environment);

        robotFactory = new RobotFactory();
        robotFactory.setName("Bit");
        robotFactory.setPositionFactory(positionFactory);
    }

    @Test
    public void shouldCreateRobot() {
        Integer x = 0;
        Integer y = 0;
        Orientation orientation = Orientation.NORTH;

        when(environment.getProperty("mars_robot.init_orientation", Orientation.class))
                .thenReturn(orientation);
        when(environment.getProperty("mars_robot.init_x", Integer.class))
                .thenReturn(x);
        when(environment.getProperty("mars_robot.init_y", Integer.class))
                .thenReturn(y);

        Robot robot = robotFactory.create();

        assertEquals("Bit", robot.getName());
        assertNotNull(robot.getPosition());
        assertEquals(x, robot.getPosition().getX());
        assertEquals(y, robot.getPosition().getY());
        assertEquals(orientation, robot.getPosition().getOrientation());
    }

}