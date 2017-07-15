package gov.nasa.marsrobot;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRobotApplicationTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    private static final String SPRING_STARTUP = "root of context hierarchy";

    @Test
    public void shouldInitApplication() throws Exception {
        MarsRobotApplication.main(new String[0]);
        assertThat(getOutput()).contains(SPRING_STARTUP);
    }

    private String getOutput() {
        return this.outputCapture.toString();
    }
}