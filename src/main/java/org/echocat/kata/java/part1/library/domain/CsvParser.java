package org.echocat.kata.java.part1.library.domain;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CsvParser {

    private static final String DEFAULT_DELIMITER = ";";
    private static final int HEADER_SIZE = 1;


    List<String[]> parse(String filePath) {
        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            return lines
                    .skip(HEADER_SIZE)
                    .map(this::parseLine)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            // TODO[TASK-ID]: add better logging method
            System.err.println(e.toString());
        }
        return Collections.emptyList();
    }

    private String[] parseLine(String line) {
        return line.split(DEFAULT_DELIMITER);
    }

}
