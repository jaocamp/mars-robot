package gov.nasa.marsrobot.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrientationTest {

    @Test
    public void shouldBeWestToTheLeftOfNorth() {
        Orientation orientation = Orientation.NORTH.left();

        assertEquals(Orientation.WEST, orientation);
    }

    @Test
    public void shouldBeEastToTheRightOfNorth() {
        Orientation orientation = Orientation.NORTH.right();

        assertEquals(Orientation.EAST, orientation);
    }

    @Test
    public void shouldBeEastToTheLeftOfSouth() {
        Orientation orientation = Orientation.SOUTH.left();

        assertEquals(Orientation.EAST, orientation);
    }

    @Test
    public void shouldBeWestToTheRightOfSouth() {
        Orientation orientation = Orientation.SOUTH.right();

        assertEquals(Orientation.WEST, orientation);
    }

    @Test
    public void shouldBeNorthToTheLeftOfEast() {
        Orientation orientation = Orientation.EAST.left();

        assertEquals(Orientation.NORTH, orientation);
    }

    @Test
    public void shouldBeSouthToTheRightOfEast() {
        Orientation orientation = Orientation.EAST.right();

        assertEquals(Orientation.SOUTH, orientation);
    }

    @Test
    public void shouldBeSouthToTheLeftOfWest() {
        Orientation orientation = Orientation.WEST.left();

        assertEquals(Orientation.SOUTH, orientation);
    }

    @Test
    public void shouldBeNorthToTheRightOfWest() {
        Orientation orientation = Orientation.WEST.right();

        assertEquals(Orientation.NORTH, orientation);
    }

    @Test
    public void shouldValidateQuantityToIncreaseInNorthAxis() {
        Integer quantityToIncreaseInX = Orientation.NORTH.getQuantityToIncreaseInXAxis();
        Integer quantityToIncreaseInY = Orientation.NORTH.getQuantityToIncreaseInYAxis();

        assertEquals(Integer.valueOf(0), quantityToIncreaseInX);
        assertEquals(Integer.valueOf(1), quantityToIncreaseInY);
    }

    @Test
    public void shouldValidateQuantityToIncreaseInSouthAxis() {
        Integer quantityToIncreaseInX = Orientation.SOUTH.getQuantityToIncreaseInXAxis();
        Integer quantityToIncreaseInY = Orientation.SOUTH.getQuantityToIncreaseInYAxis();

        assertEquals(Integer.valueOf(0), quantityToIncreaseInX);
        assertEquals(Integer.valueOf(-1), quantityToIncreaseInY);
    }

    @Test
    public void shouldValidateQuantityToIncreaseInEastAxis() {
        Integer quantityToIncreaseInX = Orientation.EAST.getQuantityToIncreaseInXAxis();
        Integer quantityToIncreaseInY = Orientation.EAST.getQuantityToIncreaseInYAxis();

        assertEquals(Integer.valueOf(1), quantityToIncreaseInX);
        assertEquals(Integer.valueOf(0), quantityToIncreaseInY);
    }

    @Test
    public void shouldValidateQuantityToIncreaseInWestAxis() {
        Integer quantityToIncreaseInX = Orientation.WEST.getQuantityToIncreaseInXAxis();
        Integer quantityToIncreaseInY = Orientation.WEST.getQuantityToIncreaseInYAxis();

        assertEquals(Integer.valueOf(-1), quantityToIncreaseInX);
        assertEquals(Integer.valueOf(0), quantityToIncreaseInY);
    }

    @Test
    public void shouldValidateValueNorth() {
        String value = Orientation.NORTH.getValue();

        assertEquals("N", value);
    }

    @Test
    public void shouldValidateValueSouth() {
        String value = Orientation.SOUTH.getValue();

        assertEquals("S", value);
    }

    @Test
    public void shouldValidateValueEast() {
        String value = Orientation.EAST.getValue();

        assertEquals("E", value);
    }

    @Test
    public void shouldValidateValueWest() {
        String value = Orientation.WEST.getValue();

        assertEquals("W", value);
    }
}