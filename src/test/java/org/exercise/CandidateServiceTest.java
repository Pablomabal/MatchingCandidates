package org.exercise;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.exercise.MatchingAccuracy.*;

public class CandidateServiceTest {

    @Test
    public void resolveMatchingAccuracyNO_MATCH() {
        CandidateBuilder builder = CandidateBuilder.instance();
        var result = CandidateService.resolveMatchingAccuracy(builder.defaultCandidate(),
                builder.defaultCandidate());
        Assert.assertEquals(NO_MATCH, result);
    }

    @Test
    public void resolveMatchingAccuracySURE() {
        CandidateBuilder builder = CandidateBuilder.instance().withCandidateId("1")
                .withFirstName("a").withLastName("b").withEmail("a@b.c").withZipCode("1").withAddress("ad");

        var result = CandidateService.resolveMatchingAccuracy(builder.build(), builder.withCandidateId("2").build());
        Assert.assertEquals(SURE, result);
    }

    @Test
    public void resolveMatchingAccuracyHIGH() {
        CandidateBuilder builder = CandidateBuilder.instance().withEmail("a@b.c");
        var result = CandidateService.resolveMatchingAccuracy(builder.build(), builder.withCandidateId("1")
                .withFirstName("C").build());
        Assert.assertEquals(HIGH, result);
    }

    @Test
    public void resolveMatchingAccuracyMEDIUM() {
        CandidateBuilder builder = CandidateBuilder.instance().withFirstName("a").withLastName("b").withAddress("asd");
        var result = CandidateService.resolveMatchingAccuracy(builder.build(), builder.withCandidateId("2")
                .withEmail("asd@a.com").build());
        Assert.assertEquals(MEDIUM, result);
    }

    @Test
    public void resolveMatchingAccuracyLOW() {
        CandidateBuilder builder = CandidateBuilder.instance().withFirstName("a").withLastName("b");
        var result = CandidateService.resolveMatchingAccuracy(builder.build(), builder.withCandidateId("2")
                .withAddress("c").build());
        Assert.assertEquals(LOW, result);
    }

    @Test
    public void mapDuplicatedEntry() {
        CandidateBuilder builder = CandidateBuilder.instance().withCandidateId("1");
        var result = CandidateService.mapDuplicatedEntry(builder.build(), builder.withCandidateId("2").build());
        Assert.assertEquals("1", result.getSourceContactId());
        Assert.assertEquals("2", result.getMatchContactId());
        Assert.assertEquals(SURE, result.getAccuracy());
    }

    @Test
    public void getDuplicatedMapDuplicatedFound() {
        List<Candidate> candidates = new ArrayList<>();
        CandidateBuilder builder = CandidateBuilder.instance();
        candidates.add(builder.withCandidateId("1").withFirstName("a").withEmail("a@b.c").build());
        candidates.add(builder.withCandidateId("2").withFirstName("b").withEmail("a@b.c").build());
        var result = CandidateService.getDuplicatedMap(candidates);
        Assert.assertEquals(1, result.keySet().size());
        Assert.assertTrue(result.containsKey("1"));
        Assert.assertFalse(result.containsKey("2"));
    }

    @Test
    public void getDuplicatedMapDuplicatedNOTFound() {
        List<Candidate> candidates = new ArrayList<>();
        CandidateBuilder builder = CandidateBuilder.instance();
        candidates.add(builder.withCandidateId("1").withFirstName("a").withEmail("a@b.c").build());
        candidates.add(builder.withCandidateId("2").withFirstName("b").withEmail("a@bc.c").build());
        var result = CandidateService.getDuplicatedMap(candidates);
        Assert.assertEquals(0, result.keySet().size());
    }

    @Test
    public void createResultCSV() {
        Map<String, List<DuplicatedEntry>> resultsMap = new HashMap<>();
        var builder = DuplicatedEntryBuilder.getInstance().withAccuracy(HIGH).withMatchId("1").withSourceId("2");
        resultsMap.put("1",List.of(builder.build()));
        var csv = CandidateService.createResultCSV(resultsMap);
        Assert.assertEquals(2, csv.size());
        Assert.assertTrue(csv.get(1).contains("HIGH"));
    }


}