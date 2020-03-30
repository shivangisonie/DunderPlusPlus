package com.dunder.mifflin;

import com.dunder.mifflin.exceptions.DunderException;
import com.dunder.mifflin.exceptions.MifflinException;
import com.dunder.mifflin.operations.Operation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DunderPlusPlus {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: dunder++ <sourceFile>");
            return;
        }

        try {
            String fileName = getFileNameFromArgs(args);
            readFile(fileName);
        } catch (MifflinException e) {
            System.err.println("Exception: " + e.getMessage());
        } catch (DunderException e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String getFileNameFromArgs(String[] args) {
        for (String arg: args) {
            if (arg.endsWith("." + Constants.MIFFLIN_FILE_EXTENSION)) {
                return arg;
            }
        }
        throw new MifflinException("Source file not found in arguments.");
    }

    private static void readFile(String fileName) throws MifflinException, DunderException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            int lineNumber = 0;
            Scope scope = new Scope();
            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;
                // Check if line is a comment
                if (line.trim().startsWith("#") || line.trim().isEmpty()) {
                    continue;
                }
                try {
                    Operation operation = LineParser.parse(line);
                    if (!operation.isBlockStarter()) {
                        scope = operation.process(scope);
                    }
                } catch (DunderException e) {
                    System.err.println(line + "\n" + e.getClass().toString().substring(6) + ": " + e.getMessage() + "(" + fileName + ":" + lineNumber + ")");
                    e.printStackTrace();
                    break;
                } catch (MifflinException e) {
                    System.err.println(line + "\n" + e.getClass().toString().substring(6) + ": " + e.getMessage() + "(" + fileName + ":" + lineNumber + ")");
                    break;
                }
            }
        } catch (FileNotFoundException | NoSuchFileException fne) {
            throw new MifflinException("File " + fileName + " not found");
        } catch (IOException e) {
            throw new DunderException(e);
        }
    }
}
