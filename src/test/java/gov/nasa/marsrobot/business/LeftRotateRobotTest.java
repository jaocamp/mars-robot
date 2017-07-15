package gov.nasa.marsrobot.business;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.model.Position;
import gov.nasa.marsrobot.model.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeftRotateRobotTest {

    private LeftRotateRobot leftRotateRobot;

    @Before
    public void setup() {
        leftRotateRobot = new LeftRotateRobot();
    }

    @Test
    public void shouldRotateWestWhenNorth() {
        Robot robot = createRobot(Orientation.NORTH);

        leftRotateRobot.execute(robot);

        assertEquals(Orientation.WEST, robot.getPosition().getOrientation());
    }

    @Test
    public void shouldRotateEastWhenSouth() {
        Robot robot = createRobot(Orientation.SOUTH);

        leftRotateRobot.execute(robot);

        assertEquals(Orientation.EAST, robot.getPosition().getOrientation());
    }

    @Test
    public void shouldRotateNorthWhenEast() {
        Robot robot = createRobot(Orientation.EAST);

        leftRotateRobot.execute(robot);

        assertEquals(Orientation.NORTH, robot.getPosition().getOrientation());
    }

    @Test
    public void shouldRotateSouthWhenWest() {
        Robot robot = createRobot(Orientation.WEST);

        leftRotateRobot.execute(robot);

        assertEquals(Orientation.SOUTH, robot.getPosition().getOrientation());
    }

    private Robot createRobot(Orientation orientation) {
        return new Robot("Bit", createPosition(orientation));
    }

    private Position createPosition(Orientation orientation) {
        return new Position(0, 0, orientation);
    }
}