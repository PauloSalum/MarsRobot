package br.com.contaazul.enums;

import br.com.contaazul.Exception.RobotBadRequestException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by paulosalum on 17/12/17.
 */
public enum OrientationEnum {
    NORTH("N", 0),
    SOUTH("S", 180),
    WEST("W", 270),
    EAST("E",90);

    private final String cardinalSimbol;
    private final int cardinalValue;
    private static final Map<String, OrientationEnum> orientationMap;
    static {
        orientationMap = new HashMap<>();
        for(OrientationEnum orientationEnum: OrientationEnum.values()){
            orientationMap.put(orientationEnum.getCardinalSimbol(), orientationEnum);
        }
    }

    OrientationEnum(String simbol, int value) {
        this.cardinalSimbol = simbol;
        this.cardinalValue = value;
    }

    public String getCardinalSimbol() {
        return this.cardinalSimbol;
    }

    public int getCardinalValue() {
        return this.cardinalValue;
    }

    public static OrientationEnum getFinalOrientation(OrientationEnum orientationEnum, int rotationValue) throws RobotBadRequestException {

        int finalOrientationValue = orientationEnum.cardinalValue + rotationValue;
        OrientationEnum finalOrientation = null;

        if(finalOrientationValue < 0){
            finalOrientationValue += 360;
        }else if(finalOrientationValue > 270){
            finalOrientationValue -= 360;
        }

        switch (finalOrientationValue){
            case 0:
                finalOrientation = OrientationEnum.NORTH;
                break;
            case 180:
                finalOrientation = OrientationEnum.SOUTH;
                break;
            case 270:
                finalOrientation = OrientationEnum.WEST;
                break;
            case 90:
                finalOrientation = OrientationEnum.EAST;
                break;
            default:
                throw new RobotBadRequestException();

        }
        return  finalOrientation;
    }
    public static OrientationEnum findByKey(String simbol){
        return orientationMap.get(simbol);
    }


}
