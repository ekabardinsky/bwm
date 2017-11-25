package ru.bwm.mapper.core.evaluator;

import javax.script.ScriptException;
import java.util.Map;

/**
 * Created by ekabardinsky on 24.11.2017.
 */
public interface EvaluateStrategy {
    Object evaluate(Map<String, Object> variables) throws ScriptException;

}
