package ru.bwm.mapper.core.transformer.input;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import ru.bwm.mapper.core.type.JsonInputType;

import java.io.OutputStream;
import java.util.Map;

/**
 * Created by ekabardinsky on 25.11.2017.
 */
public class JsonInputTransformer implements InputTransformStrategy {
    private JsonInputType type;
    private Gson gson;

    public JsonInputTransformer(JsonInputType type) {
        this.type = type;
        this.gson = new Gson();
    }

    @Override
    public Object transform(Object input) throws Exception {
        if (input instanceof String) {
            return gson.fromJson((String) input, Map.class);
        } else if (input instanceof JsonElement) {
            return gson.fromJson((JsonElement) input, Map.class);
        } else {
            //try to get json string
            return gson.fromJson(input.toString(), Map.class);
        }
    }
}
