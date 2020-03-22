package com.dunder.mifflin.operations;

import com.dunder.mifflin.exceptions.InvalidOperandsException;

public class PrintOperation implements Operation {
    private String string = null;
    private String operands = null;

    public void parseAndInitialize(String operands) throws InvalidOperandsException {
        this.operands = operands;
        if (operands.startsWith("\"") && operands.endsWith("\"")) {
            this.string = operands.substring(1, operands.length() - 1);
        } else {
            throw new InvalidOperandsException();
        }
    }

    public void process() {
        System.out.println(string);
    }

    public boolean isBlockStarter() {
        return false;
    }

    public String getOperands() {
        return this.operands;
    }
}
