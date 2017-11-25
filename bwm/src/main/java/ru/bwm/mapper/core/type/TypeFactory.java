package ru.bwm.mapper.core.type;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class TypeFactory {
    public static CommonType createInputType(MimeType type) {
        switch (type) {
            case java:
                return new JavaInputType();
            case json:
                return new JsonInputType();
            default:
                throw new NotImplementedException();
        }
    }

    public static CommonType createOutputType(MimeType type) {
        switch (type) {
            case java:
                return new JavaOutputType();
            case json:
                return new JsonOutputType();
            default:
                throw new NotImplementedException();
        }
    }
}
