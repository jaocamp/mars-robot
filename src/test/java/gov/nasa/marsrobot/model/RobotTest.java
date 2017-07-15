package gov.nasa.marsrobot.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RobotTest {

    @Test
    public void shouldBePossibleToInstantiateWithoutAttributes() {
        Robot robot = new Robot();

        assertNotNull(robot);
    }

    @Test
    public void shouldBePossibleToSetAttributes() {
        Robot robot = new Robot();
        robot.setName("Bit");
        robot.setPosition(new Position());

        assertEquals("Bit", robot.getName());
        assertNotNull(robot.getPosition());
    }

    @Test
    public void shouldBePossibleToPrintToString() {
        Robot robot = new Robot("Bit", new Position());

        assertEquals("Robot{name='Bit'}", robot.toString());
    }
}