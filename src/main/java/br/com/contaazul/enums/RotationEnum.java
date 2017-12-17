package br.com.contaazul.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by paulosalum on 17/12/17.
 */
public enum RotationEnum {
    LEFT("L",-90),
    RIGHT("R",90);

    private final String rotationlSimbol;
    private final int rotationValue;
    private static final Map<String, RotationEnum> rotationMap;
    static {
        rotationMap = new HashMap<>();
        for(RotationEnum rotationSimbol: RotationEnum.values()){
            rotationMap.put(rotationSimbol.getRotationSimbol(), rotationSimbol);
        }
    }

    RotationEnum(String simbol, int value) {
        this.rotationlSimbol = simbol;
        this.rotationValue = value;
    }

    public String getRotationSimbol() {
        return this.rotationlSimbol;
    }

    public int getRotationValue() {
        return this.rotationValue;
    }

    public static RotationEnum findByKey(String simbol){
        return rotationMap.get(simbol);
    }


}
