package baseball.enums;

import java.util.HashMap;
import java.util.Map;

public enum RestartType {
    START("1"),
    CLOSE("2");

    private static final Map<String, RestartType> valueAndTypeMap = new HashMap<>();
    private String value;

    static {
        for (RestartType type : values()) {
            valueAndTypeMap.put(type.value, type);
        }
    }

    RestartType(String value) {
        this.value = value;
    }

    public static RestartType findByValue(String value) {
        return valueAndTypeMap.get(value);
    }
}
