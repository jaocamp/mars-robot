package gov.nasa.marsrobot.parse;

import gov.nasa.marsrobot.business.Action;
import gov.nasa.marsrobot.business.LeftRotateRobot;
import gov.nasa.marsrobot.business.MoveRobot;
import gov.nasa.marsrobot.business.RightRotateRobot;
import gov.nasa.marsrobot.exception.CommandDoesNotValidException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParseActionsTest {

    private ParseActions parseActions;

    @Before
    public void setUp() {
        parseActions = new ParseActions();
    }

    @Test
    public void shouldContainLeftRotateRobotAction() throws Exception {
        List<Action> actions = parseActions.parse("L");

        assertTrue(actions.get(0) instanceof LeftRotateRobot);
    }

    @Test
    public void shouldContainRightRotateRobotAction() throws Exception {
        List<Action> actions = parseActions.parse("R");

        assertTrue(actions.get(0) instanceof RightRotateRobot);
    }

    @Test
    public void shouldContainMoveRobotAction() throws Exception {
        List<Action> actions = parseActions.parse("M");

        assertTrue(actions.get(0) instanceof MoveRobot);
    }

    @Test
    public void shouldContainThreeActions() throws Exception {
        List<Action> actions = parseActions.parse("MLR");

        assertEquals(actions.size(), 3);
    }

    @Test(expected = CommandDoesNotValidException.class)
    public void shouldContainInvalidCommand() throws Exception {
        parseActions.parse("MLARM");
    }
}