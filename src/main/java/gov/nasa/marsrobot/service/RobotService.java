package gov.nasa.marsrobot.service;

import gov.nasa.marsrobot.business.Action;
import gov.nasa.marsrobot.factory.RobotFactory;
import gov.nasa.marsrobot.model.Position;
import gov.nasa.marsrobot.model.Robot;
import gov.nasa.marsrobot.parse.ParseActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotService {

    private RobotFactory robotFactory;
    private ParseActions parseActions;

    public Position goTo(String route) {
        Robot robot = robotFactory.create();
        List<Action> actions = parseActions.parse(route);

        actions.stream().forEach(action -> action.execute(robot));

        return robot.getPosition();
    }

    @Autowired
    public void setRobotFactory(RobotFactory robotFactory) {
        this.robotFactory = robotFactory;
    }

    @Autowired
    public void setParseActions(ParseActions parseActions) {
        this.parseActions = parseActions;
    }
}