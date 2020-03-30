package com.dunder.mifflin.operations;

import com.dunder.mifflin.Scope;
import com.dunder.mifflin.exceptions.InvalidOperandsException;

public class DeclareOperation implements Operation {
    private String operand;
    private String variableName;

    // flag if assignment is to be done in next line
    private boolean isAssignedInNextLine = true;

    // Constant
    private final String OP = "AS";

    public DeclareOperation(String operands) throws InvalidOperandsException {
        this.parseAndInitialize(operands);
    }

    @Override
    public void parseAndInitialize(String operands) throws InvalidOperandsException {
        if (operands.contains(OP)) {
            String[] operandSplit = operands.split(OP);
            if (operandSplit.length > 2) {
                throw new InvalidOperandsException("Too many declaration parameters");
            } else if (operandSplit.length == 2) {
                // If declaration has assignment on the same line then add the assignment to operand value
                this.isAssignedInNextLine = false;
                this.operand = operandSplit[1].trim();
                this.variableName = operandSplit[0].trim();
            } else {
                // If declaration has assignment on next line(s) then set flag true
                this.isAssignedInNextLine = true;
                this.variableName = operandSplit[0].trim();
                this.operand = null;
            }
        } else {
            throw new InvalidOperandsException("Missing " + OP + " in declaration statement");
        }
    }

    @Override
    public Scope process(Scope scope) {
        if (this.isAssignedInNextLine) {
            scope.getContext().declareVariable(this.variableName);
        } else {
            scope.getContext().initializeVariable(this.variableName, this.operand);
        }
        return scope;
    }


    @Override
    public boolean isBlockStarter() {
        return false;
    }

    @Override
    public String getOperands() {
        return this.operand;
    }
}
