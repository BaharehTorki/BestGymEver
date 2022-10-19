package se.nackademin.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Member implements Serializable {

    private String name;
    private String personalNumber;
    private LocalDate registrationDate;

    public Member(String name, String personalNumber, LocalDate registrationDate) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return name + "  |  " + personalNumber + "  |  " + registrationDate;
    }
}
