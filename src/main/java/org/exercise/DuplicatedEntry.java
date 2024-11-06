package org.exercise;

public class DuplicatedEntry {
    private String sourceContactId;
    private String matchContactId;
    private MatchingAccuracy accuracy;

    public DuplicatedEntry(String sourceContactId, String matchContactId, MatchingAccuracy accuracy) {
        this.sourceContactId = sourceContactId;
        this.matchContactId = matchContactId;
        this.accuracy = accuracy;
    }


    public String getSourceContactId() {
        return sourceContactId;
    }

    public void setSourceContactId(String sourceContactId) {
        this.sourceContactId = sourceContactId;
    }

    public String getMatchContactId() {
        return matchContactId;
    }
    public void setMatchContactId(String matchContactId) {
        this.matchContactId = matchContactId;
    }

    public MatchingAccuracy getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(MatchingAccuracy accuracy) {
        this.accuracy = accuracy;
    }
}
