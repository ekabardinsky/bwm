package ru.bwm.mapper.core;

import ru.bwm.mapper.core.type.CommonType;
import ru.bwm.mapper.core.type.MimeType;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class Variable {
    private String name;
    private CommonType type;
    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonType getType() {
        return type;
    }

    public void setType(CommonType type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
