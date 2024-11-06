package org.exercise;

public class DuplicatedEntryBuilder {

    private String sourceId = "";
    private String matchId = "";
    private MatchingAccuracy accuracy = MatchingAccuracy.NO_MATCH;

    private DuplicatedEntryBuilder() {
    }

    public static DuplicatedEntryBuilder getInstance() {
        return new DuplicatedEntryBuilder();
    }

    public DuplicatedEntry build() {
        return new DuplicatedEntry(sourceId, matchId, accuracy);
    }

    public DuplicatedEntryBuilder withSourceId(String sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    public DuplicatedEntryBuilder withMatchId(String matchId) {
        this.matchId = matchId;
        return this;
    }

    public DuplicatedEntryBuilder withAccuracy(MatchingAccuracy accuracy) {
        this.accuracy = accuracy;
        return this;
    }
}
