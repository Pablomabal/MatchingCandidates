package org.exercise;

import java.util.Objects;

public class Candidate {

    private String contactId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String zipCode;

    public Candidate(String contactId, String firstName, String lastName, String email, String zipCode, String address) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
    }


    public static Candidate mapFromData(String data) {
        String[] line = data.split(",", -1);
        return new Candidate(line[0], line[1], line[2], line[3], line[4], line[5]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate candidate)) return false;
        return Objects.equals(firstName, candidate.firstName) &&
                Objects.equals(lastName, candidate.lastName) &&
                Objects.equals(email, candidate.email) &&
                Objects.equals(address, candidate.address) &&
                Objects.equals(zipCode, candidate.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, address, zipCode);
    }

    public boolean equalName(String firstName, String lastName) {
        return this.firstName.equals(firstName) && this.lastName.equals(lastName);
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullAddress(){
        return address + " " + zipCode;
    }
}
