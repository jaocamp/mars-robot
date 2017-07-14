package gov.nasa.marsrobot.business;

import gov.nasa.marsrobot.model.Position;
import gov.nasa.marsrobot.model.Robot;
import org.springframework.stereotype.Component;

@Component
public class MoveRobot implements Action {

    @Override
    public void execute(Robot robot){
        robot.getPosition().getOrientation().move(robot.getPosition());
    }
}