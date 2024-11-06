package org.exercise;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (var lines = Files.lines(Paths.get(args[0]))) {
            List<Candidate> candidates = lines.skip(1).map(Candidate::mapFromData).toList();
            Map<String, List<DuplicatedEntry>> duplicatedEntriesMap = CandidateService.getDuplicatedMap(candidates);
            List<String> resultCSV = CandidateService.createResultCSV(duplicatedEntriesMap);
            File csvOutputFile = new File("results.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            resultCSV.forEach(pw::println);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}