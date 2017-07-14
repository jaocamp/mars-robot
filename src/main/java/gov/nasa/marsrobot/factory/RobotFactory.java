package gov.nasa.marsrobot.factory;

import gov.nasa.marsrobot.model.Position;
import gov.nasa.marsrobot.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RobotFactory {

    private PositionFactory positionFactory;

    private String name;

    public Robot create() {
        Position position = positionFactory.create();
        return new Robot(name, position);
    }

    @Autowired
    public void setPositionFactory(PositionFactory positionFactory) {
        this.positionFactory = positionFactory;
    }

    @Value("${mars_robot.name}")
    public void setName(String name) {
        this.name = name;
    }
}
