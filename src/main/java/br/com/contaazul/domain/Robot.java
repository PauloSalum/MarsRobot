package br.com.contaazul.domain;

import br.com.contaazul.Exception.RobotBadRequestException;
import br.com.contaazul.enums.OrientationEnum;
import br.com.contaazul.enums.RotationEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import static br.com.contaazul.enums.OrientationEnum.NORTH;

/**
 * Created by paulosalum on 17/12/17.
 */
@Component
@Scope(scopeName="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Robot {
    private OrientationEnum orientationEnum;

    private int xCoord;
    private int yCoord;


    public Robot(){
        setxCoord(0);
        setyCoord(0);
        setOrientationEnum(NORTH);

    }

    public void rotate(RotationEnum rotationEnum) throws RobotBadRequestException {
        this.orientationEnum = OrientationEnum.getFinalOrientation(this.orientationEnum, rotationEnum.getRotationValue());
    }

    public void move() {
        switch (this.orientationEnum){
            case NORTH:
                this.yCoord++;
                break;
            case SOUTH:
                this.yCoord--;
                break;
            case EAST:
                this.xCoord++;
                break;
            case WEST:
                this.xCoord--;
                break;

        }
    }

    public OrientationEnum getOrientationEnum() {
        return orientationEnum;
    }

    public void setOrientationEnum(OrientationEnum orientationEnum) {
        this.orientationEnum = orientationEnum;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}
