package gov.nasa.marsrobot.factory;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PositionFactory {

    private Environment env;

    public Position create() {
        Orientation orientation =
                env.getProperty("mars_robot.init_orientation", Orientation.class);

        Integer x = env.getProperty("mars_robot.init_x", Integer.class);
        Integer y = env.getProperty("mars_robot.init_y", Integer.class);

        return new Position(x, y, orientation);
    }

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }
}
