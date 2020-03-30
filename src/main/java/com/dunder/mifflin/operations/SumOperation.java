package com.dunder.mifflin.operations;

import com.dunder.mifflin.Scope;
import com.dunder.mifflin.exceptions.InvalidOperandsException;
import com.dunder.mifflin.exceptions.MifflinException;

public class SumOperation implements Operation {
    private String result;

    // Constant
    private final String OP = "AND";

    public SumOperation(String operands) throws InvalidOperandsException {
        this.parseAndInitialize(operands);
    }

    @Override
    public void parseAndInitialize(String operands) throws InvalidOperandsException {
        if (operands.contains(OP)) {
            this.result = this.sum(operands.split(OP));
        } else {
            throw new InvalidOperandsException("Missing " + OP + " in declaration statement");
        }
    }

    @Override
    public Scope process(Scope scope) {
        scope.getContext().assignVariable(result);
        return scope;
    }

    @Override
    public boolean isBlockStarter() {
        return false;
    }

    @Override
    public String getOperands() {
        return this.result;
    }

    // TODO: Handle string and float. Maybe boolean?. Create/Handle exceptions while parsing.
    private String sum(String... operands) throws MifflinException {
        int sum = 0;
        for (String op: operands) {
            sum += Integer.parseInt(op.trim());
        }
        return "" + sum;
    }
}
