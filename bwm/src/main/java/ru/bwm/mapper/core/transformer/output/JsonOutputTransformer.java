package ru.bwm.mapper.core.transformer.output;

import com.google.gson.Gson;
import ru.bwm.mapper.core.type.JsonOutputType;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class JsonOutputTransformer implements OutputTransformStrategy {
    private Gson gson;
    private JsonOutputType type;

    public JsonOutputTransformer(JsonOutputType jsonOutputType) {
        this.type = jsonOutputType;
        this.gson = new Gson();
    }

    @Override
    public Object transform(Object output) throws Exception {
        if (output == null) {
            return null; //TODO: Is it possible ot has null response?
        }

        if (type.isToTree()) {
            return gson.toJsonTree(output);
        } else {
            return gson.toJson(output);
        }
    }
}
