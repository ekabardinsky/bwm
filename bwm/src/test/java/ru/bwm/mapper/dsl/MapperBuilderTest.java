package ru.bwm.mapper.dsl;

import org.junit.Test;
import ru.bwm.mapper.dto.HiItWorkDTO;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class MapperBuilderTest {
    @Test
    public void makeFewMappers() throws Exception {
        new MapperBuilder()
                .invoke("{hi: 'I work!'}")
                .toJava().toClass(HiItWorkDTO.class)
                .build();
        new MapperBuilder()
                .invoke("1+1")
                .toJava().toMap()
                .build();
    }
}
