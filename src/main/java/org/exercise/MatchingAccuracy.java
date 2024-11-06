package org.exercise;

public enum MatchingAccuracy {
    SURE("SURE"), HIGH("HIGH"), MEDIUM("MEDIUM"), LOW("LOW"), NO_MATCH("NO_MATCH");

    private final String name;

    MatchingAccuracy(String name){
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

}
