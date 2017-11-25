package ru.bwm.mapper.core.transformer.output;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import ru.bwm.mapper.core.type.JavaOutputType;
import ru.bwm.mapper.core.utils.TypeHelper;

import java.util.Map;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class JavaOutputTransformer implements OutputTransformStrategy {
    private Object target;
    private JavaOutputType type;

    public JavaOutputTransformer(JavaOutputType type) {
        this.type = type;
        init();
    }

    public void init() {
        if (type == null) {
            throw new IllegalArgumentException("Empty target type. Please specify correct Class");
        } else if (type.isToClass()) {
            try {
                this.target = type.getTargetClass().newInstance();
            } catch (Exception e) {
                throw new IllegalArgumentException("Constructor which takes no arguments does not exists. Please create constructor without arguments");
            }
        }
    }

    @Override
    public Object transform(Object output) throws Exception {
        if (output == null) {
            return null; //TODO: Is it possible ot has null response?
        }

        //make related transforms
        if (!(type.isToClass() || type.isToMap())) {
            return output;
        } else if (type.isToClass()) {
            //is it already this class?
            if (output.getClass().equals(type.getTargetClass())) {
                return output;
            } else if (output instanceof Map) {

                //populate to instance
                BeanUtils.populate(target, (Map) output);
                return target;
            } else {
                throw new IllegalArgumentException("Required target class is " + type.getTargetClass().getCanonicalName() + ". Actual result is " + output.getClass().getCanonicalName());
            }
        } else {
            //no need transforms?
            if (output instanceof Map || TypeHelper.isSimpleType(output.getClass())) {
                return output;
            } else {//or use wrapper?
                return new BeanMap(output);
            }
        }

    }
}
