package ru.bwm.mapper.core.utils;

import org.apache.commons.lang3.ClassUtils;

import java.awt.*;

/**
 * Created by ekabardinsky on 26.11.2017.
 */
public class TypeHelper {
    public static boolean isSimpleType(Class type) {
        if (type == null) {
            throw new IllegalArgumentException("Try to check type with null");
        } else if (type.equals(String.class)) {
            return true;
        } else {
            return ClassUtils.isPrimitiveOrWrapper(type);
        }
    }
}
