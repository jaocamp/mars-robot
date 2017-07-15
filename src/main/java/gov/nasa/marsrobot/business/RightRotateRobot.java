package gov.nasa.marsrobot.business;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.model.Robot;

public class RightRotateRobot implements Action {

    @Override
    public void execute(Robot robot) {
        Orientation orientation = robot.getPosition().getOrientation().right();
        robot.getPosition().setOrientation(orientation);
    }
}
