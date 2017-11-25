package ru.bwm.mapper.dsl;

import ru.bwm.mapper.Mapper;
import ru.bwm.mapper.core.evaluator.EvaluateStrategy;
import ru.bwm.mapper.core.evaluator.JSEvaluator;
import ru.bwm.mapper.core.type.CommonType;
import ru.bwm.mapper.core.type.JavaOutputType;
import ru.bwm.mapper.core.type.MimeType;
import ru.bwm.mapper.core.type.TypeFactory;
import ru.bwm.mapper.dsl.to.ToJavaTypeBuilder;
import ru.bwm.mapper.dsl.to.ToJsonTypeBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class MapperBuilder {
    private CommonType outputMimeType;
    private String script;
    private EvaluateStrategy evaluateStrategy;

    //supported to types
    public ToJavaTypeBuilder toJava() {
        return new ToJavaTypeBuilder(this);
    }

    public ToJsonTypeBuilder toJson() {
        return new ToJsonTypeBuilder(this);
    }

    //common methods
    public MapperBuilder invoke(String script) {
        this.script = script;
        return this;
    }

    public MapperBuilder invokeScript(String filePath) throws IOException {
        this.script = new String(Files.readAllBytes(Paths.get(filePath)));
        return this;
    }

    public Mapper build() {
        if (script != null) {
            evaluateStrategy = new JSEvaluator(script);
        } else {
            throw new IllegalStateException("Script not specified");
        }

        return build(evaluateStrategy);
    }

    public Mapper build(EvaluateStrategy evaluateStrategy) {
        //default return type
        if (outputMimeType == null) {
            outputMimeType = new JavaOutputType();
        }

        if (evaluateStrategy != null) {
            return new Mapper(evaluateStrategy, outputMimeType);
        } else {
            throw new IllegalStateException("Did you specify evaluate strategy?");
        }
    }

    public MapperBuilder to(CommonType type) {
        this.outputMimeType = type;
        return this;
    }

    public MapperBuilder to(MimeType type) {
        return to(TypeFactory.createOutputType(type));
    }

    public MapperBuilder to(String type) {
        return to(MimeType.getMimeTypeByString(type));
    }


    //setters
    void setOutputMimeType(CommonType outputMimeType) {
        this.outputMimeType = outputMimeType;
    }
}
