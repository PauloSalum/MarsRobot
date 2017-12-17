package br.com.contaazul;

import br.com.contaazul.services.RobotService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by paulosalum on 17/12/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotInstructionTest {
    @Autowired
    RobotService robotService;

    @Test
    public void executeCmdMMRMMRMM(){
        String instruction = "MMRMMRMM";
        ResponseEntity<String> responseEntity = robotService.executeInstructions(instruction);

        Assert.assertEquals(responseEntity.getBody(), "(2,0,S)");
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }
    @Test
    public void executeCmdMML(){
        String instruction = "MML";
        ResponseEntity<String> responseEntity = robotService.executeInstructions(instruction);

        Assert.assertEquals(responseEntity.getBody(), "(0,2,W)");
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
    @Test
    public void executeCmdAAA(){
        String instruction = "AAA";
        ResponseEntity<String> responseEntity = robotService.executeInstructions(instruction);

        Assert.assertEquals(responseEntity.getBody(), "400 Bad Request");
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
    @Test
    public void executeCmdMMMMMMMMMMMMMMMMMMMMMMMM(){
        String instruction = "MMMMMMMMMMMMMMMMMMMMMMMM";
        ResponseEntity<String> responseEntity = robotService.executeInstructions(instruction);

        Assert.assertEquals(responseEntity.getBody(), "400 Bad Request");
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

}
