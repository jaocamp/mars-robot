package gov.nasa.marsrobot.service;

import gov.nasa.marsrobot.business.Action;
import gov.nasa.marsrobot.factory.RobotFactory;
import gov.nasa.marsrobot.model.Robot;
import gov.nasa.marsrobot.parse.ParseActions;
import gov.nasa.marsrobot.validator.PositionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotService {

    private RobotFactory robotFactory;
    private ParseActions parseActions;
    private PositionValidator positionValidator;

    public Robot goTo(String route) {
        List<Action> actions = parseActions.parse(route);
        Robot robot = robotFactory.create();

        actions.stream().forEach(action -> action.execute(robot));
        positionValidator.isValid(robot.getPosition());

        return robot;
    }

    @Autowired
    public void setRobotFactory(RobotFactory robotFactory) {
        this.robotFactory = robotFactory;
    }

    @Autowired
    public void setParseActions(ParseActions parseActions) {
        this.parseActions = parseActions;
    }

    @Autowired
    public void setPositionValidator(PositionValidator positionValidator) {
        this.positionValidator = positionValidator;
    }
}