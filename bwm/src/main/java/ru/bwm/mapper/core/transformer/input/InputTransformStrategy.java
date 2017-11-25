package ru.bwm.mapper.core.transformer.input;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public interface InputTransformStrategy {
   Object transform(Object input) throws Exception;
}
