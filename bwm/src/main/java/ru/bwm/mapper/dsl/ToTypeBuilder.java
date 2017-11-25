package ru.bwm.mapper.dsl;

import ru.bwm.mapper.core.type.CommonType;
import ru.bwm.mapper.dsl.MapperBuilder;
import ru.bwm.mapper.dsl.TypeBuilder;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public abstract class ToTypeBuilder extends TypeBuilder {
    public ToTypeBuilder(MapperBuilder mapperBuilder, CommonType type) {
        super(mapperBuilder, type);
    }

    public MapperBuilder compile() {
        mapperBuilder.setOutputMimeType(type);
        return mapperBuilder;
    }
}
