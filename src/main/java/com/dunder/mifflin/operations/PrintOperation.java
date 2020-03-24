package com.dunder.mifflin.operations;

import com.dunder.mifflin.exceptions.InvalidOperandsException;

// TODO: Handle variables
public class PrintOperation implements Operation {
    private String string = null;
    private String operands;

    public PrintOperation(String operands) throws InvalidOperandsException {
        this.operands = operands;
        this.parseAndInitialize(operands);
    }

    @Override
    public void parseAndInitialize(String operands) throws InvalidOperandsException {
        if (operands.startsWith("\"") && operands.endsWith("\"")) {
            this.string = operands.substring(1, operands.length() - 1);
        } else {
            throw new InvalidOperandsException();
        }
    }

    @Override
    public void process() {
        System.out.println(string);
    }

    @Override
    public boolean isBlockStarter() {
        return false;
    }

    @Override
    public String getOperands() {
        return this.operands;
    }
}
