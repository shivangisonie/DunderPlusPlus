package com.dunder.mifflin;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
    private Stack<String> declaredVariablesStack;
    private Map<String, String> variablesMap;

    public Context() {
        this.declaredVariablesStack = new Stack<>();
        this.variablesMap = new HashMap<>();
    }

    /**
     * Add the variable name to the declared variable stack.
     * Will not initialize the declared variable.
     * @param variable
     */
    public void declareVariable(String variable) {
        this.declaredVariablesStack.push(variable);
        this.variablesMap.put(variable, null);
    }

    /**
     * Get variable value
     * @param variable
     * @return the value of variable
     */
    public String getVariable(String variable) {
        return this.variablesMap.get(variable);
    }

    /**
     * Get the variable from top of declared variable stack.
     * @return variable name
     */
    public String getDeclaredVariable() {
        return this.declaredVariablesStack.peek();
    }

    /**
     * Assign value to the variable at top of declared variable stack.
     * @param value
     */
    public void assignVariable(String value) {
        String variable = this.declaredVariablesStack.pop();
        this.variablesMap.put(variable, value);
    }

    /**
     * Declare and initialize variable at the same time.
     * @param variable variable name
     * @param value value of variable
     */
    public void initializeVariable(String variable, String value) {
        this.variablesMap.put(variable, value);
    }
}
