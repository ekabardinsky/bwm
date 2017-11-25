package ru.bwm.mapper.core.type;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class JavaOutputType extends CommonType {
    private boolean toMap = false;
    private boolean toClass = false;
    private Class targetClass;

    public JavaOutputType() {
        setType(MimeType.java);
    }

    public JavaOutputType(boolean toMap) {
        this.toMap = toMap;
    }

    public boolean isToMap() {
        return toMap;
    }

    public void setToMap(boolean toMap) {
        this.toMap = toMap;
    }

    public boolean isToClass() {
        return toClass;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
        this.targetClass = targetClass;
        this.toClass = true;
    }
}
