package br.com.contaazul.controllers;

import br.com.contaazul.services.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by paulosalum on 17/12/17.
 */
@RestController
public class RobotController {
    private final RobotService robotService;

    @Autowired
    public RobotController(RobotService robotService){
        this.robotService = robotService;

    }

    @RequestMapping(value = "/rest/mars/{instruction}", method = RequestMethod.POST)
    public ResponseEntity<String> instruction(@PathVariable("instruction") String instruction) {
        return robotService.executeInstructions(instruction);
    }
}
