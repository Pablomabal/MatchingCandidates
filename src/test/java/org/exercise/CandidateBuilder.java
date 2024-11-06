package org.exercise;

public class CandidateBuilder {

    private String id = "";
    private String email = "";
    private String firstName = "";
    private String lastName = "";
    private String address = "";
    private String zipCode = "";

    public static CandidateBuilder instance() {
        return new CandidateBuilder();
    }

    public Candidate build() {
        return new Candidate(id, firstName, lastName, email, zipCode, address);
    }

    public Candidate defaultCandidate() {
        return new Candidate("1", "a", "b", "a@b.c", "12", "asd");
    }

    public CandidateBuilder withCandidateId(String id) {
        this.id = id;
        return this;
    }

    public CandidateBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public CandidateBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CandidateBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CandidateBuilder withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public CandidateBuilder withAddress(String address) {
        this.address = address;
        return this;
    }
}
