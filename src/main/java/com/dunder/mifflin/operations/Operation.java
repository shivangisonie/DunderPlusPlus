package com.dunder.mifflin.operations;

import com.dunder.mifflin.Scope;
import com.dunder.mifflin.exceptions.InvalidOperandsException;

public interface Operation {
    void parseAndInitialize(String operands) throws InvalidOperandsException;
    boolean isBlockStarter();
    Scope process(Scope scope);
    String getOperands();
}
