package com.dunder.mifflin;

import com.dunder.mifflin.exceptions.DunderException;
import com.dunder.mifflin.operations.Operation;

public class LineParser {

    public static Operation parse(String line) throws DunderException {
        char[] splitters = new char[] {'\"', '\''};
        int lineIndex = firstVariableIndex(line);

        // Find the index of first splitter to occur in line
        for (int i = 0 ; i < splitters.length ; i++) {
            int sIndex = line.indexOf(splitters[i]);
            if (sIndex >= 0) {
                if (lineIndex > sIndex) {
                    lineIndex = sIndex;
                }
            }
        }

        String instruction = line.substring(0, lineIndex).trim();
        String operand = line.substring(lineIndex).trim();

        Operation operation = Instructions.get(instruction);
        operation.parseAndInitialize(operand);

        return operation;
    }

    private static int firstVariableIndex(String line) {
        return line.length();
    }
}
