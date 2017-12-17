package br.com.contaazul.domain;

import br.com.contaazul.Exception.RobotBadRequestException;
import org.springframework.stereotype.Component;

/**
 * Created by paulosalum on 17/12/17.
 */
@Component
public class Terrain {
    private final int MIN = 0;
    private final int MAX = 4;
    private final String regex = "^[LRM]*";


    public void validateInstruction(String instruction) throws RobotBadRequestException {
        if(!instruction.matches(regex))
            throw new RobotBadRequestException();

    }
    public void validateCoords(int x, int y) throws RobotBadRequestException {
        if(!(x <= MAX && x >= MIN && y <= MAX && y >= MIN ))
            throw new RobotBadRequestException();


    }

}
