package gov.nasa.marsrobot.controller;

import gov.nasa.marsrobot.MarsRobotApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarsRobotApplication.class)
@WebAppConfiguration
public class RobotControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private Environment env;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldMoveTo2x0ySouthOrientation() throws Exception {
        mockMvc.perform(post("/robot/go/MMRMMRMM"))
                .andExpect(status().isOk())
                .andExpect(content().string("(2, 0, S)"));
    }

    @Test
    public void shouldMoveTo0x2yWestOrientation() throws Exception {
        mockMvc.perform(post("/robot/go/MML"))
                .andExpect(status().isOk())
                .andExpect(content().string("(0, 2, W)"));
    }

    @Test
    public void shouldMoveTo2x2yNorthOrientation() throws Exception {
        mockMvc.perform(post("/robot/go/MMRMML"))
                .andExpect(status().isOk())
                .andExpect(content().string("(2, 2, N)"));
    }

    @Test
    public void shouldMoveTo4x2yEastOrientation() throws Exception {
        mockMvc.perform(post("/robot/go/MMRMMMM"))
                .andExpect(status().isOk())
                .andExpect(content().string("(4, 2, E)"));
    }

    @Test
    public void shouldValidateInvalidCommand() throws Exception {
        String messageError = env.getProperty("mars_robot.error.command_not_valid");

        mockMvc.perform(post("/robot/go/AAA"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(messageError));
    }

    @Test
    public void shouldValidateInvalidPosition() throws Exception {
        String messageError = env.getProperty("mars_robot.error.position_not_valid");

        mockMvc.perform(post("/robot/go/MMMMMMMMMMM"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(messageError));
    }
}