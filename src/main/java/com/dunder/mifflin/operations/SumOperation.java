package com.dunder.mifflin.operations;

import com.dunder.mifflin.exceptions.InvalidOperandsException;

// TODO: Implement Sum
public class SumOperation implements Operation {
    private String string = null;
    private String operands;

    public SumOperation(String operands) throws InvalidOperandsException {
        this.operands = operands;
        this.parseAndInitialize(operands);
    }

    @Override
    public void parseAndInitialize(String operands) throws InvalidOperandsException {
        this.string = operands;
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
