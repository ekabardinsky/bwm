package ru.bwm.mapper.core.transformer.output;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public interface OutputTransformStrategy {
    Object transform(Object output) throws Exception;
}
