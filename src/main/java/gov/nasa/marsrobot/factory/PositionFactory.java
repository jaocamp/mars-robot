package gov.nasa.marsrobot.factory;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.model.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionFactory {

    public Position create() {
        return new Position(0, 0, Orientation.NORTH);
    }
}
