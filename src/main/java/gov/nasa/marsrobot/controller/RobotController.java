package gov.nasa.marsrobot.controller;

import gov.nasa.marsrobot.model.Position;
import gov.nasa.marsrobot.service.RobotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/robot")
public class RobotController {

    private Logger logger = LoggerFactory.getLogger(RobotController.class);

    private RobotService robotService;

    @RequestMapping(value="/go/{route}", method= RequestMethod.POST)
    public ResponseEntity<?> goTo(@PathVariable String route) {
        try {

            Position position = robotService.goTo(route);
            return ResponseEntity.ok(position);

        } catch (Exception e) {
            logger.error("{GenericController.update} - Unexpected error occurred while going to route.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Autowired
    public void setRobotService(RobotService robotService) {
        this.robotService = robotService;
    }
}