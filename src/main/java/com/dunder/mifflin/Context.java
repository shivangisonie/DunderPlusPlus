package com.dunder.mifflin;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
    private Stack<String> declaredVariablesStack;
    private Map<String, String> variablesMap;
    private Stack<String> tempValuesStack;

    public Context() {
        this.declaredVariablesStack = new Stack<>();
        this.variablesMap = new HashMap<>();
    }

    public void declareVariable(String variable) {
        this.declaredVariablesStack.push(variable);
        this.variablesMap.put(variable, null);
    }

    public String getVariable(String variable) {
        return this.variablesMap.get(variable);
    }

    public String getDeclaredVariable() {
        return this.declaredVariablesStack.peek();
    }

    public void assignVariable(String value) {
        String variable = this.declaredVariablesStack.pop();
        this.variablesMap.put(variable, value);
    }

    public void initializeVariable(String variable, String value) {
        this.variablesMap.put(variable, value);
    }

    public String getTempValue() {
        return this.tempValuesStack.pop();
    }
}
