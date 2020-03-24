package com.dunder.mifflin;

import com.dunder.mifflin.exceptions.DunderException;
import com.dunder.mifflin.exceptions.InstructionNotFoundException;
import com.dunder.mifflin.operations.DeclareOperation;
import com.dunder.mifflin.operations.Operation;
import com.dunder.mifflin.operations.PrintOperation;
import com.dunder.mifflin.operations.SumOperation;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Instructions {
    private static Map<String, Class<? extends Operation>> instructionMap = new HashMap<>();

    static {
        instructionMap.put("PRINT OUT", PrintOperation.class);
        instructionMap.put("I DECLARE", DeclareOperation.class);
        instructionMap.put("SUM OF", SumOperation.class);
    }

    public static Operation get(String instruction, String operand) throws DunderException {
        if (instructionMap.containsKey(instruction)) {
            try {
                Class<? extends Operation> className = instructionMap.get(instruction);
                Constructor<?> ctor = className.getConstructor(String.class);
                return (Operation) ctor.newInstance(new Object[] { operand });
            } catch (ReflectiveOperationException e) {
                throw new DunderException(e);
            }
        } else {
            throw new InstructionNotFoundException("Instruction " + instruction + " not found.");
        }
    }

}
