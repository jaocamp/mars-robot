package gov.nasa.marsrobot.validator;

import gov.nasa.marsrobot.domain.Orientation;
import gov.nasa.marsrobot.exception.PositionDoesNotValidException;
import gov.nasa.marsrobot.model.Position;
import org.junit.Before;
import org.junit.Test;

public class PositionValidatorTest {

    private PositionValidator positionValidator;

    @Before
    public void setup() {
        positionValidator = new PositionValidator();
        positionValidator.setLandHeight(5);
        positionValidator.setLandWidth(5);
    }

    @Test
    public void shouldBeValid() {
        positionValidator.isValid(createPosition());
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void shouldBeInvalidPositive() {
        Position position = createPosition();
        position.setX(7);

        positionValidator.isValid(position);
    }

    @Test(expected = PositionDoesNotValidException.class)
    public void shouldBeInvalidNegative() {
        Position position = createPosition();
        position.setY(-2);

        positionValidator.isValid(position);
    }

    private Position createPosition() {
        return new Position(5, 5, Orientation.NORTH);
    }
}