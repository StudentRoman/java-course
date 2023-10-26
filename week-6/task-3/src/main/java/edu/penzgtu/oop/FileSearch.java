package edu.penzgtu.oop;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileSearch {
    public Collection<Path> findFiles(String searchDirectory, PathMatcher matcher) throws IOException {
        try (Stream<Path> files = Files.walk(Paths.get(searchDirectory))) {
            return files.filter(matcher::matches).collect(Collectors.toList());
        }
    }

    public boolean isContentExistsInFile(Path file, String text) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            return lines.anyMatch(content -> content.contains(text));
        }
    }
}