package gov.nasa.marsrobot.factory;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.model.Position;
import gov.nasa.marsrobot.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RobotFactory {

    private PositionFactory positionFactory;

    public Robot create() {
        Position position = positionFactory.create();
        return new Robot("Bit", position);
    }

    @Autowired
    public void setPositionFactory(PositionFactory positionFactory) {
        this.positionFactory = positionFactory;
    }
}
