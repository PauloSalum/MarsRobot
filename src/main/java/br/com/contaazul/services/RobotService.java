package br.com.contaazul.services;

import br.com.contaazul.Exception.RobotBadRequestException;
import br.com.contaazul.domain.Robot;
import br.com.contaazul.domain.Terrain;
import br.com.contaazul.enums.RotationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by paulosalum on 17/12/17.
 */
@Service
public class RobotService {
    private Robot robot;
    private Terrain terrain;

    @Autowired
    public RobotService(Terrain t, Robot r){
        this.robot = r;
        this.terrain = t;
    }

    public ResponseEntity<String> executeInstructions(String instructions) throws RobotBadRequestException {

        try{
            terrain.validateInstruction(instructions);

            String [] comand = instructions.split("");
            Arrays.stream(comand).forEach(c -> {
                if(c.equals("M")){
                    robot.move();
                }else{
                    robot.rotate(RotationEnum.findByKey(c));
                }
            });
            terrain.validateCoords(robot.getxCoord(), robot.getyCoord());
            String coords =  "("+robot.getxCoord()+","+robot.getyCoord()+","+robot.getOrientationEnum().getCardinalSimbol()+")";
            return new ResponseEntity<>(coords, HttpStatus.OK);
        }catch (RobotBadRequestException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
}
