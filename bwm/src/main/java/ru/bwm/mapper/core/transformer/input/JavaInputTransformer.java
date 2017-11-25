package ru.bwm.mapper.core.transformer.input;

import org.apache.commons.beanutils.BeanMap;
import ru.bwm.mapper.core.transformer.input.InputTransformStrategy;
import ru.bwm.mapper.core.type.JavaInputType;

import java.util.Map;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class JavaInputTransformer implements InputTransformStrategy {
    private JavaInputType type;

    public JavaInputTransformer(JavaInputType type) {
        this.type = type;
    }

    @Override
    public Object transform(Object input) {
        //is null?
        if (input == null) {
            throw new IllegalArgumentException("Expected not null object");
        }
        //is it a map?
        if (input instanceof Map) {
            return input;
        } else {
            if (type.isToMap()) {
                //wrap input to map
                return new BeanMap(input);
            } else {
                return input;
            }
        }
    }
}
