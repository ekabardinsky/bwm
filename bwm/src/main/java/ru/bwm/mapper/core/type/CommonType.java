package ru.bwm.mapper.core.type;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public abstract class CommonType {
    private MimeType type;

    public MimeType getType() {
        return type;
    }

    public void setType(MimeType type) {
        this.type = type;
    }
}
