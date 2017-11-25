package ru.bwm.mapper.core.transformer;

import ru.bwm.mapper.core.transformer.input.InputTransformStrategy;
import ru.bwm.mapper.core.transformer.input.JavaInputTransformer;
import ru.bwm.mapper.core.transformer.input.JsonInputTransformer;
import ru.bwm.mapper.core.transformer.output.JavaOutputTransformer;
import ru.bwm.mapper.core.transformer.output.JsonOutputTransformer;
import ru.bwm.mapper.core.transformer.output.OutputTransformStrategy;
import ru.bwm.mapper.core.type.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class TransformerFabric {
    public static InputTransformStrategy createInputTransformStrategy(CommonType type) {
        switch (type.getType()) {
            case java:
                return new JavaInputTransformer((JavaInputType) type);
            case json:
                return new JsonInputTransformer((JsonInputType) type);
            default:
                throw new NotImplementedException();
        }
    }

    public static OutputTransformStrategy createOutputTransformStrategy(CommonType type) {
        switch (type.getType()) {
            case java:
                return new JavaOutputTransformer((JavaOutputType) type);
            case json:
                return new JsonOutputTransformer((JsonOutputType) type);
            default:
                throw new NotImplementedException();
        }
    }
}
