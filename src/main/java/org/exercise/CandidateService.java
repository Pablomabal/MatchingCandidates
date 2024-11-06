package org.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.exercise.MatchingAccuracy.*;

public class CandidateService {

    public static MatchingAccuracy resolveMatchingAccuracy(Candidate candidate, Candidate target) {
        if(candidate.getContactId().equals(target.getContactId())){
            return NO_MATCH;
        }
        if (candidate.equals(target)) {
            return SURE;
        }
        if (!candidate.getEmail().isEmpty() && candidate.getEmail().equals(target.getEmail())) {
            return HIGH;
        }
        if (candidate.equalName(target.getFirstName(), target.getLastName())
                && !candidate.getAddress().isEmpty()
                && candidate.getAddress().equals(target.getAddress())) {
            return MEDIUM;
        }
        if (candidate.equalName(target.getFirstName(), target.getLastName())) {
            return LOW;
        }
        return NO_MATCH;
    }

    public static Map<String, List<DuplicatedEntry>> getDuplicatedMap(List<Candidate> candidates) {
        Map<String, List<DuplicatedEntry>> result = new HashMap<>();
        for (Candidate candidate : candidates) {
            List<DuplicatedEntry> collect = candidates.stream()
                    .filter(c -> (resolveMatchingAccuracy(candidate, c) != NO_MATCH && !result.containsKey(c.getContactId())))
                    .map(c -> mapDuplicatedEntry(candidate, c)).collect(Collectors.toList());
            if(!collect.isEmpty()){
                result.put(candidate.getContactId(), collect);
            }
        }

        return result;
    }


    public static DuplicatedEntry mapDuplicatedEntry(Candidate source, Candidate target) {
        return new DuplicatedEntry(source.getContactId(), target.getContactId(),
                resolveMatchingAccuracy(source, target));
    }

    public static List<String> createResultCSV(Map<String, List<DuplicatedEntry>> results) {
        List<String> csv = new ArrayList<>();
        csv.add(String.join(",", "contactId source", "contactId match", "Accuracy"));
        for (List<DuplicatedEntry> res : results.values()) {
            csv.addAll(res.stream()
                    .map(l -> String.join(",", l.getSourceContactId(), l.getMatchContactId(), l.getAccuracy().toString()))
                    .toList());
        }

        return csv;
    }
}
