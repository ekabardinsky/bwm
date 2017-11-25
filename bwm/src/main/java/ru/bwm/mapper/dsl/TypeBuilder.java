package ru.bwm.mapper.dsl;

import ru.bwm.mapper.core.type.CommonType;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class TypeBuilder {
    protected MapperBuilder mapperBuilder;
    protected CommonType type;

    public TypeBuilder(MapperBuilder mapperBuilder, CommonType type) {
        this.mapperBuilder = mapperBuilder;
        this.type = type;
    }
}
