package gov.nasa.marsrobot.business;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.model.Position;
import gov.nasa.marsrobot.model.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveRobotTest {

    private MoveRobot moveRobot;

    @Before
    public void setUp() {
        moveRobot = new MoveRobot();
    }

    @Test
    public void shouldMoveIncreasingYWhenNorth() {
        Robot robot = createRobot(Orientation.NORTH);
        moveRobot.execute(robot);

        assertEquals(Integer.valueOf(2), robot.getPosition().getX());
        assertEquals(Integer.valueOf(3), robot.getPosition().getY());
    }

    @Test
    public void shouldMoveDecreasingYWhenSouth() {
        Robot robot = createRobot(Orientation.SOUTH);
        moveRobot.execute(robot);

        assertEquals(Integer.valueOf(2), robot.getPosition().getX());
        assertEquals(Integer.valueOf(1), robot.getPosition().getY());
    }

    @Test
    public void shouldMoveIncreasingXWhenEast() {
        Robot robot = createRobot(Orientation.EAST);
        moveRobot.execute(robot);

        assertEquals(Integer.valueOf(3), robot.getPosition().getX());
        assertEquals(Integer.valueOf(2), robot.getPosition().getY());
    }

    @Test
    public void shouldMoveDecreasingXWhenWest() {
        Robot robot = createRobot(Orientation.WEST);
        moveRobot.execute(robot);

        assertEquals(Integer.valueOf(1), robot.getPosition().getX());
        assertEquals(Integer.valueOf(2), robot.getPosition().getY());
    }

    private Robot createRobot(Orientation orientation) {
        return new Robot("Bit", createPosition(orientation));
    }

    private Position createPosition(Orientation orientation) {
        return new Position(2, 2, orientation);
    }
}