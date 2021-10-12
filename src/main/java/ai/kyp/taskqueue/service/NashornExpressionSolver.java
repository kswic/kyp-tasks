package ai.kyp.taskqueue.service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Solver for basic arithmetic expressions based on Nashorn engine.
 * @deprecated With the release of Java 11, Nashorn is deprecated, and has been removed from JDK 15 onwards.
 */
@Deprecated
public class NashornExpressionSolver implements ExpressionSolver {

    public static final String SCRIPT_ENGINE_NAME = "JavaScript";

    @Override
    public Double solve(String expression) {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName(SCRIPT_ENGINE_NAME);

        try {
            return Double.parseDouble(engine.eval(expression).toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return null;
    }
}
