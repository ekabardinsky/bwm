package ru.bwm.mapper.core.type;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class JsonOutputType extends CommonType {
    private boolean toTree = false;

    public JsonOutputType() {
        setType(MimeType.json);
    }


    public boolean isToTree() {
        return toTree;
    }

    public void setToTree(boolean toTree) {
        this.toTree = toTree;
    }
}
