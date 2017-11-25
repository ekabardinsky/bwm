package ru.bwm.mapper.dsl.to;

import ru.bwm.mapper.core.type.JsonOutputType;
import ru.bwm.mapper.core.type.MimeType;
import ru.bwm.mapper.core.type.TypeFactory;
import ru.bwm.mapper.dsl.MapperBuilder;
import ru.bwm.mapper.dsl.ToTypeBuilder;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class ToJsonTypeBuilder extends ToTypeBuilder {
    public ToJsonTypeBuilder(MapperBuilder mapperBuilder) {
        super(mapperBuilder, TypeFactory.createOutputType(MimeType.json));
    }

    public MapperBuilder toTree() {
        ((JsonOutputType) type).setToTree(true);
        return compile();
    }
}
