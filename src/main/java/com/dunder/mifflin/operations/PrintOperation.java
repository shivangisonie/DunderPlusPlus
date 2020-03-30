package com.dunder.mifflin.operations;

import com.dunder.mifflin.Scope;
import com.dunder.mifflin.exceptions.InvalidOperandsException;
import com.dunder.mifflin.exceptions.MifflinException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintOperation implements Operation {
    private String operands;
    private boolean isVariable = false;

    public PrintOperation(String operands) throws InvalidOperandsException {
        this.parseAndInitialize(operands);
    }

    @Override
    public void parseAndInitialize(String operands) throws InvalidOperandsException {
        String quoteValue = parseQuotes(operands);

        if (!quoteValue.equals(operands)) {
            this.operands = quoteValue;
            this.isVariable = false;
        } else {
            // Check if operand is a number
            if (isNumber(quoteValue)) {
                this.operands = quoteValue;
                this.isVariable = false;
            } else if (!operands.isEmpty()) {
                this.operands = operands;
                this.isVariable = true;
            } else {
                throw new InvalidOperandsException();
            }
        }
    }

    @Override
    public Scope process(Scope scope) {
        try {
            String value = operands;
            if (this.isVariable) {
                value = scope.getContext().getVariable(operands);
                value = parseQuotes(value);
            }
            System.out.println(value);
        } catch (NullPointerException e) {
            throw new MifflinException("Variable \"" + operands + "\" might not have been initialised");
        }
        return scope;
    }

    private String parseQuotes(String value) {
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    private boolean isNumber(String value) {
        try {
            Matcher matcher = Pattern.compile("[+-]?(\\d+(?:\\.\\d+)?)").matcher(value);
            if (matcher.find() && matcher.group().equals(value)) {
                return true;
            }
        } catch(IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
        return false;
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
