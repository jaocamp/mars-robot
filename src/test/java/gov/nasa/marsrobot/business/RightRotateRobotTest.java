package gov.nasa.marsrobot.business;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.model.Position;
import gov.nasa.marsrobot.model.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RightRotateRobotTest {

    private RightRotateRobot rightRotateRobot;

    @Before
    public void setup() {
        rightRotateRobot = new RightRotateRobot();
    }

    @Test
    public void shouldRotateEastWhenNorth() {
        Robot robot = createRobot(Orientation.NORTH);

        rightRotateRobot.execute(robot);

        assertEquals(Orientation.EAST, robot.getPosition().getOrientation());
    }

    @Test
    public void shouldRotateWestWhenSouth() {
        Robot robot = createRobot(Orientation.SOUTH);

        rightRotateRobot.execute(robot);

        assertEquals(Orientation.WEST, robot.getPosition().getOrientation());
    }

    @Test
    public void shouldRotateSouthWhenEast() {
        Robot robot = createRobot(Orientation.EAST);

        rightRotateRobot.execute(robot);

        assertEquals(Orientation.SOUTH, robot.getPosition().getOrientation());
    }

    @Test
    public void shouldRotateNorthWhenWest() {
        Robot robot = createRobot(Orientation.WEST);

        rightRotateRobot.execute(robot);

        assertEquals(Orientation.NORTH, robot.getPosition().getOrientation());
    }

    private Robot createRobot(Orientation orientation) {
        return new Robot("Bit", createPosition(orientation));
    }

    private Position createPosition(Orientation orientation) {
        return new Position(0, 0, orientation);
    }
}