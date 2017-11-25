package ru.bwm.mapper.core.evaluator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.Reader;
import java.util.Map;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public class JSEvaluator implements EvaluateStrategy {
    private String script;
    private ScriptEngine engine;

    private JSEvaluator() {
        ScriptEngineManager manager = new ScriptEngineManager();
        this.engine = manager.getEngineByName("JavaScript");
    }

    public JSEvaluator(String script) {
        this();
        //there is little trick to get evaluate result from var
        this.script = "var result = " + script;
    }


    @Override
    public Object evaluate(Map<String, Object> variables) throws ScriptException {
        if (script != null && !"".equals(script)) {
            initVars(variables);
            engine.eval(script);
            return engine.get("result");
        } else {
            throw new IllegalStateException("Script is null or empty");
        }
    }

    private void initVars(Map<String, Object> variables) {
        //check vars
        if (variables == null) {
            throw new IllegalArgumentException("Variables not specified");
        }

        //put vars
        for (String name : variables.keySet()) {
            engine.put(name, variables.get(name));
        }
    }


}
