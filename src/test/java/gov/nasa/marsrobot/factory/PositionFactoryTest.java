package gov.nasa.marsrobot.factory;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.model.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PositionFactoryTest {

    @Mock
    private Environment environment;

    private PositionFactory positionFactory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        positionFactory = new PositionFactory();
        positionFactory.setEnv(environment);
    }

    @Test
    public void shouldCreatePosition() {
        Integer x = 0;
        Integer y = 0;
        Orientation orientation = Orientation.NORTH;

        when(environment.getProperty("mars_robot.init_orientation", Orientation.class))
                .thenReturn(orientation);
        when(environment.getProperty("mars_robot.init_x", Integer.class))
                .thenReturn(x);
        when(environment.getProperty("mars_robot.init_y", Integer.class))
                .thenReturn(y);

        Position position = positionFactory.create();

        assertEquals(x, position.getX());
        assertEquals(y, position.getY());
        assertEquals(orientation, position.getOrientation());
    }
}