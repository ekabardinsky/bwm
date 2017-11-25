package ru.bwm.mapper;

import ru.bwm.mapper.core.Variable;
import ru.bwm.mapper.core.evaluator.EvaluateStrategy;
import ru.bwm.mapper.core.transformer.input.InputTransformStrategy;
import ru.bwm.mapper.core.transformer.TransformerFabric;
import ru.bwm.mapper.core.type.CommonType;
import ru.bwm.mapper.core.type.MimeType;
import ru.bwm.mapper.core.type.TypeFactory;

import java.util.*;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class Mapper {
    private CommonType outputMimeType;
    private EvaluateStrategy evaluateStrategy;

    public Mapper(EvaluateStrategy evaluateStrategy, CommonType outputMimeType) {
        this.evaluateStrategy = evaluateStrategy;
        this.outputMimeType = outputMimeType;
    }

    public Object map() throws Exception {
        return map(new ArrayList<Variable>());
    }

    public Object map(Object body) throws Exception {
        return map(body, MimeType.java);
    }

    public Object map(Object body, MimeType type) throws Exception {
        return map(body, type, new ArrayList<>());
    }

    public Object map(Object body, MimeType type, List<Variable> vars) throws Exception {
        Variable bodyVar = new Variable();
        bodyVar.setName("body");
        bodyVar.setValue(body);
        bodyVar.setType(TypeFactory.createInputType(type));

        ArrayList<Variable> variables = new ArrayList<>();
        variables.add(bodyVar);

        return map(variables);
    }

    private Object map(List<Variable> vars) throws Exception {
        //check minimal evaluate conditions
        if (outputMimeType == null) {
            throw new IllegalStateException("Output mime type not specified. Please, specify output mime type firstly");
        } else if (vars == null) {
            throw new IllegalArgumentException("Not initialized vars Map");
        }


        Object evaluateResult = evaluateStrategy.evaluate(transformVars(vars));

        return TransformerFabric
                .createOutputTransformStrategy(outputMimeType)
                .transform(evaluateResult);
    }

    private HashMap<String, Object> transformVars(List<Variable> vars) {
        try {
            //transform all vars
            HashMap<String, Object> varsMap = new HashMap<>();
            for (Variable variable : vars) {
                InputTransformStrategy inputTransformStrategy = TransformerFabric.createInputTransformStrategy(variable.getType());
                Object transformedValue = inputTransformStrategy.transform(variable.getValue());
                varsMap.put(variable.getName(), transformedValue);
            }

            return varsMap;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
