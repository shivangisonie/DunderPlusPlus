package com.dunder.mifflin;

import com.dunder.mifflin.exceptions.DunderException;
import com.dunder.mifflin.operations.Operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineParser {

    // Pattern to split operator and operand
    private static Pattern pattern = Pattern.compile("[a-z]|\\d|\"|'|\\+|-");

    public static Operation parse(String line) throws DunderException {
        int opIndex = getOperandIndex(line);

        String instruction = line.substring(0, opIndex).trim();
        String operand = line.substring(opIndex).trim();

        return Instructions.get(instruction, operand);
    }

    private static int getOperandIndex(String line) {
        Matcher matcher = pattern.matcher(line);
        int index = matcher.find() ? matcher.start() : -1;

        if (index>=0) return index;
        return line.length();
    }
}
