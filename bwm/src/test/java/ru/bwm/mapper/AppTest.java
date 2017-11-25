package ru.bwm.mapper;


import com.google.gson.Gson;
import org.junit.Test;
import ru.bwm.mapper.core.type.MimeType;
import ru.bwm.mapper.dsl.MapperBuilder;
import ru.bwm.mapper.dto.HiItWorkDTO;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void someTest() throws Exception {

        Object map = new MapperBuilder()
                .invokeScript("C:\\Users\\ekabardinsky\\Documents\\bwm\\bwm\\src\\test\\resources\\script.bwm")
                .toJava().toMap()
                .build().map("{\"ft\":\"123\"}", MimeType.java);

        System.out.println(new Gson().toJson(map));
    }


    public int someMethod() {
        return 4;
    }
}
