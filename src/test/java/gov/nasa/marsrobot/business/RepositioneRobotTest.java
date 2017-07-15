package gov.nasa.marsrobot.business;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepositioneRobotTest {

    private RepositioneRobot repositioneRobot;

    @Before
    public void setup() {
        repositioneRobot = new RepositioneRobot();
    }

    @Test
    public void shouldIncrementYWhenNorth() {
        Position position = createPosition(Orientation.NORTH);
        repositioneRobot.repositione(position);

        assertEquals(Integer.valueOf(2), position.getX());
        assertEquals(Integer.valueOf(3), position.getY());
    }

    @Test
    public void shouldDecreaseYWhenSouth() {
        Position position = createPosition(Orientation.SOUTH);
        repositioneRobot.repositione(position);

        assertEquals(Integer.valueOf(2), position.getX());
        assertEquals(Integer.valueOf(1), position.getY());
    }

    @Test
    public void shouldIncrementXWhenEast() {
        Position position = createPosition(Orientation.EAST);
        repositioneRobot.repositione(position);

        assertEquals(Integer.valueOf(3), position.getX());
        assertEquals(Integer.valueOf(2), position.getY());
    }

    @Test
    public void shouldDecreaseXWhenWest() {
        Position position = createPosition(Orientation.WEST);
        repositioneRobot.repositione(position);

        assertEquals(Integer.valueOf(1), position.getX());
        assertEquals(Integer.valueOf(2), position.getY());
    }

    private Position createPosition(Orientation orientation) {
        return new Position(2, 2, orientation);
    }
}