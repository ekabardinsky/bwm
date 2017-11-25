package ru.bwm.mapper.core.type;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class JavaInputType extends CommonType {
    private boolean toMap = false;

    public JavaInputType() {
        setType(MimeType.java);
    }

    public JavaInputType(boolean toMap) {
        this.toMap = toMap;
    }


    public Boolean isToMap() {
        return toMap;
    }

    public void setToMap(boolean toMap) {
        this.toMap = toMap;
    }
}
