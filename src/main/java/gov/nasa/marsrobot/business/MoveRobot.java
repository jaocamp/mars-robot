package gov.nasa.marsrobot.business;

import gov.nasa.marsrobot.model.Robot;

public class MoveRobot implements Action {

    @Override
    public void execute(Robot robot){
        move(robot);
    }

    private void move(Robot robot){
        new RepositioneRobot().repositione(robot.getPosition());
    }


}