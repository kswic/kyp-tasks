package ai.kyp.taskqueue;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExpressionSolver implements ExpressionSolver {

    @Override
    public Double solve(String expression) {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("JavaScript");

        try {
            return Double.parseDouble(engine.eval(expression).toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return null;
    }
}
