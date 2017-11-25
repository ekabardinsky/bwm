package ru.bwm.mapper.core.type;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public enum MimeType {
    json, xml, java, csv;

    public static MimeType getMimeTypeByString(String type) {
        MimeType mimeType = MimeType.valueOf(type);
        if (mimeType != null) {
            return mimeType;
        } else {
            switch (type) {
                case "application/json":
                    return MimeType.json;
                case "application/java":
                    return MimeType.java;
                case "application/xml":
                    return MimeType.xml;
                case "application/csv":
                    return MimeType.csv;
                default:
                    throw new IllegalArgumentException("Not supported mime type supplied: " + mimeType);
            }
        }
    }
}
