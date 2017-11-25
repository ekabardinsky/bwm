package ru.bwm.mapper.dsl.to;

import ru.bwm.mapper.core.type.JavaOutputType;
import ru.bwm.mapper.dsl.MapperBuilder;
import ru.bwm.mapper.dsl.ToTypeBuilder;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class ToJavaTypeBuilder extends ToTypeBuilder {
    public ToJavaTypeBuilder(MapperBuilder mapperBuilder) {
        super(mapperBuilder, new JavaOutputType());
    }

    public MapperBuilder toMap() {
        getType().setToMap(true);
        return compile();
    }

    public MapperBuilder toClass(Class targetType) {
        getType().setTargetClass(targetType);
        return compile();
    }

    private JavaOutputType getType() {
        return (JavaOutputType) this.type;
    }
}
