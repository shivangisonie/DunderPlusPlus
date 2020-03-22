package com.dunder.mifflin;

import com.dunder.mifflin.exceptions.InstructionNotFoundException;
import com.dunder.mifflin.operations.PrintOperation;
import com.dunder.mifflin.operations.Operation;

import java.util.HashMap;
import java.util.Map;

public class Instructions {
    private static Map<String, Operation> instructionMap = new HashMap<>();

    static {
        instructionMap.put("PRINT OUT", new PrintOperation());
    }

    public static Operation get(String instruction) throws InstructionNotFoundException {
        if (instructionMap.containsKey(instruction)) {
            return instructionMap.get(instruction);
        } else {
            throw new InstructionNotFoundException("Instruction " + instruction + " not found.");
        }
    }

}
