package gov.nasa.marsrobot.validator;

import gov.nasa.marsrobot.exception.PositionDoesNotValidException;
import gov.nasa.marsrobot.model.Position;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PositionValidator {

    @Value("${mars_robot.land_width}")
    private Integer landWidth;

    @Value("${mars_robot.land_height}")
    private Integer landHeight;

    public void isValid(Position position) {
        if (position.getX() < 0
                || position.getY() < 0
                || position.getX() > landWidth
                || position.getY() > landHeight) {
            throw new PositionDoesNotValidException();
        }
    }
}
