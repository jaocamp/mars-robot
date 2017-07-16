package gov.nasa.marsrobot.model;

import gov.nasa.marsrobot.domain.Orientation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PositionTest {

    @Test
    public void shouldBePossibleToInstantiateWithoutParams() {
        Position position = new Position();

        assertNotNull(position);
    }

    @Test
    public void shouldBePossibleToSetAttributes() {
        Position position = new Position();
        position.setX(2);
        position.setY(2);
        position.setOrientation(Orientation.NORTH);

        assertEquals(Integer.valueOf(2), position.getX());
        assertEquals(Integer.valueOf(2), position.getY());
        assertEquals(Orientation.NORTH, position.getOrientation());
    }

    @Test
    public void shouldBePossibleToPrintToString() {
        Position position = new Position(0, 0, Orientation.NORTH);

        assertEquals("(0, 0, N)", position.toString());
    }
}