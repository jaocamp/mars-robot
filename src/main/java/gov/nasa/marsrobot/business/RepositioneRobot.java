package gov.nasa.marsrobot.business;

import gov.nasa.marsrobot.model.Position;

public class RepositioneRobot {

    public void repositione(Position position) {
        repositioneXAxis(position);
        repositioneYAxis(position);
    }

    private void repositioneYAxis(Position position) {
        Integer quantity = position.getOrientation().getQuantityToIncreaseInYAxis();
        position.setY(position.getY() + quantity);
    }

    private void repositioneXAxis(Position position) {
        Integer quantity = position.getOrientation().getQuantityToIncreaseInXAxis();
        position.setX(position.getX() + quantity);
    }
}
