package gov.nasa.marsrobot.parse;

import gov.nasa.marsrobot.business.Action;
import gov.nasa.marsrobot.business.LeftRotateRobot;
import gov.nasa.marsrobot.business.MoveRobot;
import gov.nasa.marsrobot.business.RightRotateRobot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParseActions {

    public List<Action> parse(String route) {
        List<Action> actions = new ArrayList<>();

        route.chars().mapToObj(command -> (char) command)
            .forEach(command -> {
                Action action = getAction(command);
                actions.add(action);
            });

        return actions;
    }

    private Action getAction(char command) {
        switch (command) {
            case 'L':
                return new LeftRotateRobot();
            case 'R':
                return new RightRotateRobot();
            case 'M':
                return new MoveRobot();
            default:
                return null;
        }
    }
}
